package edu.metrostate.ics342.mediatracker.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.outlined.StarHalf
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.ui.Modifier
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import edu.metrostate.ics342.mediatracker.R
import edu.metrostate.ics342.mediatracker.data.FakeMediaRepository.mediaList
import edu.metrostate.ics342.mediatracker.data.model.Media
import edu.metrostate.ics342.mediatracker.data.model.creatorCredit
import edu.metrostate.ics342.mediatracker.theme.MovieContainer
import edu.metrostate.ics342.mediatracker.theme.OnMovieContainer
import androidx.compose.runtime.collectAsState

import androidx.lifecycle.viewmodel.compose.viewModel


// ── STUB — Students build this in Week 7 ─────────────────────────────────────
//
// Week 7 task: Build the Media Detail screen.
//   1. Receive mediaId from the navigation argument (typed Int — see NavGraph).
//   2. Call GET /media/{mediaId} to load full details.
//   3. Display: cover image, title, creator credit, metadata grid, genre chips,
//      average rating, description, and a library status control.
//   4. Display the reviews list from GET /reviews?mediaId={id}.
//   5. Handle loading and error states (full-screen — no half-built screens).
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MediaDetailScreen(
    mediaId: Int,
    onNavigateBack: () -> Unit,
    onWriteReview: (Int) -> Unit,
    viewModel: MediaDetailViewModel = viewModel()
) {
    LaunchedEffect(mediaId) {
        viewModel.setMediaId(mediaId)
    }

    val media: Media? = viewModel.media.collectAsState().value

    if (media != null) {
        Column {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TopAppBar(
                    navigationIcon = {
                        IconButton(onClick = onNavigateBack) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Localized description"
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { /* do something */ }) {
                            Icon(
                                imageVector = Icons.Outlined.MoreVert,
                                contentDescription = "Localized description"
                            )
                        }
                    },
                    title = {
                        Text("")
                    }
                )


                val containerColor = when (media.mediaType) {
                    "book" -> MaterialTheme.colorScheme.primaryContainer
                    "movie" -> MovieContainer
                    else -> MaterialTheme.colorScheme.tertiaryContainer
                }
                val iconTint = when (media.mediaType) {
                    "book" -> MaterialTheme.colorScheme.onPrimaryContainer
                    "movie" -> OnMovieContainer
                    else -> MaterialTheme.colorScheme.tertiary
                }

                Box(
                    modifier = Modifier
                        .size(128.dp, 180.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(containerColor),
                    contentAlignment = Alignment.Center
                ) {
                    if (media.coverUrl != null) {
                        AsyncImage(
                            model = media.coverUrl,
                            contentDescription = media.title,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    } else {
                        Icon(
                            painter = painterResource(
                                when (media.mediaType) {
                                    "book" -> R.drawable.menu_book_24px
                                    "movie" -> R.drawable.movie_24px
                                    else -> R.drawable.tv_24px
                                }
                            ),
                            contentDescription = media.title,
                            modifier = Modifier.size(48.dp),
                            tint = iconTint
                        )
                    }
                }

                Text(media.title)
                Text(media.creatorCredit(LocalContext.current))

                if (media.ratingCount > 0) {
                    Row {
                        for (i in 1..5) {
                            Icon(
                                imageVector = when {
                                    media.averageRating > i -> Icons.Filled.Star
                                    media.averageRating > i - 0.5F -> Icons.AutoMirrored.Outlined.StarHalf
                                    else -> Icons.Outlined.StarOutline
                                },
                                contentDescription = "Localized description"
                            )
                        }
                        Text("" + media.averageRating)
                        Text("(" + media.ratingCount + ")")
                    }
                } else {
                    Text("No ratings yet")
                }

                Row {
                    Button(
                        onClick = { viewModel.toggleInLibrary("want_to") },
                        modifier = Modifier
                            .fillMaxWidth(0.5F)
                            .padding(
                                top = 4.dp,
                                bottom = 4.dp,
                                start = 4.dp,
                                end = 2.dp
                            ),
                    ) {
                        Text("+ Want To")
                    }
                    OutlinedButton(
                        onClick = { viewModel.save()},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                top = 4.dp,
                                bottom = 4.dp,
                                start = 2.dp,
                                end = 4.dp
                            ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.onPrimary,
                            contentColor = MaterialTheme.colorScheme.primary,
                        ),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Icon(
                            painter = painterResource(
                                R.drawable.favorite_24px
                            ),
                            contentDescription = "Localized description"
                        )

                        Text(" Save")
                    }

                }


            }
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                Text("About")
                Text(
                    when {
                        media.description.isNullOrEmpty() -> "No Description"
                        else -> media.description
                    }
                )
            }

            Row {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.33333334F)
                        .padding(start = 8.dp, end = 4.dp, top = 8.dp, bottom = 8.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(MaterialTheme.colorScheme.primaryContainer),
                    contentAlignment = Alignment.Center,
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Year")
                        Text("" + media.publishedYear)
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.5F)
                        .padding(start = 4.dp, end = 4.dp, top = 8.dp, bottom = 8.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(MaterialTheme.colorScheme.primaryContainer),
                    contentAlignment = Alignment.Center,
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        val b1 = when (media.mediaType) {
                            "book" -> "Pages"
                            "movie" -> "Runtime"
                            "show" -> "Episodes"
                            else -> "Unknown"
                        }
                        val b2 = when (media.mediaType) {
                            "book" -> media.pageCount
                            "movie" -> media.runtimeMinutes
                            "show" -> media.episodeCount
                            else -> "Media"
                        }
                        Text(b1)
                        Text("" + b2)
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 4.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(MaterialTheme.colorScheme.primaryContainer),
                    contentAlignment = Alignment.Center,
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Genre")
                        Text(media.genres[0])
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text("Reviews (" + media.reviewCount + ")")
                Text(
                    "+ Write Review",
                    modifier = Modifier
                        .clickable(onClick = { onWriteReview(mediaId) }),
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.End,
                )
            }
        }

    } else {
        Column {
        Text("Media not found.")
        Text("ID: " + viewModel.mediaId.collectAsState().value)
            }
    }
}
