package edu.metrostate.ics342.mediatracker.ui.library

import androidx.compose.foundation.background
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import edu.metrostate.ics342.mediatracker.data.model.LibraryItem
import edu.metrostate.ics342.mediatracker.data.model.LibraryStatus
import edu.metrostate.ics342.mediatracker.data.model.creatorCredit
import edu.metrostate.ics342.mediatracker.R
import edu.metrostate.ics342.mediatracker.theme.Finished
import edu.metrostate.ics342.mediatracker.theme.FinishedContainer
import edu.metrostate.ics342.mediatracker.theme.InProgress
import edu.metrostate.ics342.mediatracker.theme.InProgressContainer
import edu.metrostate.ics342.mediatracker.theme.MovieContainer
import edu.metrostate.ics342.mediatracker.theme.OnMovieContainer
import edu.metrostate.ics342.mediatracker.theme.WantTo
import edu.metrostate.ics342.mediatracker.theme.WantToContainer
import edu.metrostate.ics342.mediatracker.ui.search.MediaTypeFilterChips

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LibraryScreen(
    onMediaClick: (Int) -> Unit,
    viewModel: LibraryViewModel = viewModel()
) {
    val items     by viewModel.libraryItems.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    val selectedStatus by viewModel.filterState.collectAsState()
    var selectedType   by remember { mutableStateOf("all") }

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(title = { Text(stringResource(R.string.library_title)) })

        MediaTypeFilterChips(
            selectedType = selectedType,
            onTypeSelect = {type -> selectedType = type},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
            )
        /*
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .horizontalScroll(state = rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            listOf(
                "all"   to R.string.filter_all,
                "book"  to R.string.filter_books,
                "movie" to R.string.filter_movies,
                "show"  to R.string.filter_shows
            )
                .forEach { (key, labelRes) ->
                    FilterChip(
                        selected = selectedType == key,
                        onClick  = { selectedType = key },
                        label    = { Text(stringResource(labelRes)) },
                        colors   = FilterChipDefaults.filterChipColors().copy(
                            //containerColor = MaterialTheme.colorScheme.surfaceContainer,
                            //labelColor = MaterialTheme.colorScheme.surface,
                            selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                            selectedLabelColor = MaterialTheme.colorScheme.primary,
                        ),
                        shape    = RoundedCornerShape(8.dp)
                    )
                }
        }

         */

        SingleChoiceSegmentedButtonRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp)
        ) {
            LibraryStatus.entries.forEachIndexed { index, status ->
                SegmentedButton(
                    shape    = SegmentedButtonDefaults.itemShape(
                        index = index, count = LibraryStatus.entries.size
                    ),
                    selected = selectedStatus == status,
                    onClick  = { viewModel.updateFilter(status) },
                    label    = { Text(stringResource(status.labelRes)) },
                    colors   = SegmentedButtonDefaults.colors().copy(
                        activeContainerColor = MaterialTheme.colorScheme.primaryContainer,
                        activeContentColor = MaterialTheme.colorScheme.primary,
                    )
                )
            }
        }

        HorizontalDivider(modifier = Modifier.padding(top = 8.dp))

        if (isLoading) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
            return@Column
        }

        val filteredItems = items
            .filter { it.status == selectedStatus }
            .filter { selectedType == "all" || it.media!!.mediaType == selectedType }

        if (filteredItems.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize().padding(32.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    stringResource(R.string.library_empty),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )
            }
            return@Column
        }

        Text(
            if (filteredItems.size == 1) stringResource(R.string.library_item_count, filteredItems.size)
            else stringResource(R.string.library_items_count, filteredItems.size),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            style    = MaterialTheme.typography.labelMedium,
            color    = MaterialTheme.colorScheme.onSurfaceVariant
        )

        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(filteredItems, key = { it.mediaId!! }) { item ->
                LibraryItemCard(
                    item           = item,
                    onClick        = { onMediaClick(item.mediaId!!) },
                    onRemove       = { viewModel.removeItem(item.mediaId!!) },
                    onStatusChange = { newStatus -> viewModel.updateStatus(item.mediaId!!, newStatus) }
                )
            }
        }
    }
}

@Composable
private fun LibraryItemCard(
    item: LibraryItem,
    onClick: () -> Unit,
    onRemove: () -> Unit,
    onStatusChange: (LibraryStatus) -> Unit
) {
    var menuExpanded by remember { mutableStateOf(false) }
    var statusDialogVisible by remember { mutableStateOf(false) }

    if (statusDialogVisible) {
        AlertDialog(
            onDismissRequest = { statusDialogVisible = false },
            title = { Text(stringResource(R.string.action_change_status)) },
            text = {
                Column {
                    LibraryStatus.values().forEach { s ->
                        TextButton(
                            onClick  = { onStatusChange(s); statusDialogVisible = false },
                            modifier = Modifier.fillMaxWidth()
                        ) { Text(stringResource(s.labelRes)) }
                    }
                }
            },
            confirmButton = {},
            dismissButton = {
                TextButton(onClick = { statusDialogVisible = false }) { Text(stringResource(R.string.settings_cancel_button)) }
            }
        )
    }

    Card(
        modifier  = Modifier.fillMaxWidth().clickable { onClick() },
        shape     = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    ) {
        Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            val containerColor = when (item.media!!.mediaType) {
                "book"  -> MaterialTheme.colorScheme.primaryContainer
                "movie" -> MovieContainer
                else    -> MaterialTheme.colorScheme.tertiaryContainer
            }
            val iconTint = when (item.media.mediaType) {
                "book"  -> MaterialTheme.colorScheme.onPrimaryContainer
                "movie" -> OnMovieContainer
                else    -> MaterialTheme.colorScheme.tertiary
            }
            Box(
                modifier = Modifier
                    .size(64.dp, 90.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(containerColor),
                contentAlignment = Alignment.Center
            ) {
                if (item.media.coverUrl != null) {
                    AsyncImage(
                        model = item.media.coverUrl,
                        contentDescription = item.media.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                } else {
                    Icon(
                        painter = painterResource(
                            when (item.media.mediaType) {
                                "book" -> R.drawable.menu_book_24px
                                "movie" -> R.drawable.movie_24px
                                else -> R.drawable.tv_24px
                            }
                        ),
                        contentDescription = item.media.title,
                        modifier = Modifier.size(32.dp),
                        tint = iconTint
                    )
                }
            }

            Spacer(Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(item.media.title, style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.SemiBold, maxLines = 2)
                Spacer(Modifier.height(2.dp))
                Text(item.media.creatorCredit(LocalContext.current),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant)
                Spacer(Modifier.height(6.dp))

                val chipContainerColor = when (item.status!!.labelRes) {
                    LibraryStatus.WANT_TO.labelRes -> WantToContainer
                    LibraryStatus.IN_PROGRESS.labelRes -> InProgressContainer
                    LibraryStatus.FINISHED.labelRes -> FinishedContainer
                    else -> MaterialTheme.colorScheme.surfaceVariant
                }
                val labelColor = when (item.status.labelRes) {
                    LibraryStatus.WANT_TO.labelRes -> WantTo
                    LibraryStatus.IN_PROGRESS.labelRes -> InProgress
                    LibraryStatus.FINISHED.labelRes -> Finished
                    else -> MaterialTheme.colorScheme.onSurfaceVariant
                }
                SuggestionChip(
                    onClick = { statusDialogVisible = true },
                    label   = {
                        Text(
                            stringResource(item.status.labelRes),
                            style = MaterialTheme.typography.labelSmall,
                        )
                    },
                    colors = SuggestionChipDefaults.suggestionChipColors(
                        containerColor                  = chipContainerColor,
                        labelColor                      = labelColor,
                    )
                )
            }

            Box {
                IconButton(onClick = { menuExpanded = true }) {
                    Icon(Icons.Outlined.MoreVert, stringResource(R.string.action_more_options))
                }
                DropdownMenu(
                    expanded         = menuExpanded,
                    onDismissRequest = { menuExpanded = false }
                ) {
                    DropdownMenuItem(
                        text    = { Text(stringResource(R.string.action_change_status)) },
                        onClick = { menuExpanded = false; statusDialogVisible = true }
                    )
                    DropdownMenuItem(
                        text    = { Text(stringResource(R.string.action_remove_from_library),
                            color = MaterialTheme.colorScheme.error) },
                        onClick = { menuExpanded = false; onRemove() }
                    )
                }
            }
        }
    }
}
