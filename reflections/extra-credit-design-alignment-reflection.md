# Extra Credit Reflection — Design Alignment

*See `extra-credit-design-alignment.md` for submission requirements and the full assignment description.*

**Name:** Dylan Browne
**Date:** 07/02/2026

---

## The Audit

*Before touching any code, compare your running app to the wireframes screen by screen. List what you found — be specific about which screen, which component, and what was different. "The colors were off" is not specific. "The active chip on the Search screen was using amber instead of primary container (#E0E0FF)" is specific.*

*List at least five concrete differences you found:*

1. The SuggestionChip showing the Want To / In Progress / Finished badge used
the default colors instead of the color and container color pair for the specific badge.
2. The corners of the SearchScreen searchbar are not round when they are supposed to be. The
end of the search bar is almost if not completely supposed to be a
semicircle while the current searchbar is a rectangle (or very close to one).
3. The BottomNav bar is supposed to follow the blue color scheme but
is instead a red or orange color for the selected tab.
4. The size of the MediaTracker text in the LoginScreen and RegisterScreen
is too small.
5. The middle tab (library tab) on the BottomNavBar uses the wrong icon.
It should be a page on top of something when it is actually an open
book.

---

## What You Changed

*Walk through the changes you made. For each area of the design system, describe what the code looked like before and what you changed it to. Reference specific files and Composables.*

### Color System

Color.kt was previously missing the colors for Want To, In Progress, and Finished as well
as the colors for their containers. I added in those colors. It also had incorrect values
for a number of different colors, including Primary, PrimaryContainer, among others.
The colors that were modified where already wired into theme while the  Want To, In Progress, 
and Finished (and their containers) were not wired into the MaterialTheme. I did not
wire these new colors into the MaterialTheme as they are only used in one spot
(on the LibraryScreen) and none of the options that I could find seamed to be the correct fit. 
Since this seems similar to how the MovieContainer and OnMovieContainer was used,
and they were not wired into the theme, this seemed like the correct choice.

### Typography

I did not understand what weights in the material3.Typography corresponded with the
weights in the rubric and any changes I made seemed to make things worse, so I did
not change much with the Typography.

### Buttons

The tonal buttons needed to be fixed. They were showing up as if they were 
filled buttons because they were labeled in the same way as the filled buttons.
The filled buttons seemed to already use the correct colors by default, though in
case I am missing the nuances between colors, I updated all the filled buttons 
as well. (Some of the colors are hard for me to tell the difference in the wireframe,
such as the Want To colors vs the tonal button colors). Most of the Outlined Buttons
also needed work in order to show the primary color text. One exception to the normal
primary color text for the Outlined Button is in the SettingsScreen which does not
use the primary color but the error color.

### Text Fields

I changed the shape of all OutlinedTextFields to the RoundedCornerShape(8.dp)
(except for the OutlinedTextFields for the searchbars in SearchScreen and 
SearchResultsScreen which had RoundedCornerShape(28.dp)). I also changed the color
of the focusedBorderColor to be equal to the primary color. I did this for both the
SearchScreen and SearchResultsScreen searchbars and the other OutlinedTextFields
though the wireframe and rubric / instructions did not make it clear one way or
the other if the searchbars (for SearchScreen and SearchResultsScreen) also 
needed that color.

### Other Components

FilterChips:
The FilterChips originally used an auburn / red color when it was
supposed to use the primaryContainer color. The inactive color was also
incorrect, with the container and label supposed to be surface and outline
according to the instructions.

Cards:
The size of the elevation and the roundness of the corners for the Cards
where changed for some of them. The elevation increased from 1.dp to 2.dp
for all the cards while the MediaResultCard had its shape change from
RoundedCornerShape(8.dp) to RoundedCornerShape(12.dp).

BottomNavBar:
The BottomNavBar originally used an auburn / red color when it was
supposed to use the primaryContainer color for the indicator
and the primary color for the label. The inactive color was also
incorrect, with the container and label supposed to be onSurfaceVariant
according to the instructions.

Status Badges:
The original status badges just used the default colors for a SuggestionChip.
The badges are supposed to use a different value of labelColor and containerColor
for each of the labels (Want To, In Progress, and Finished). I updated the 
badges to use the correct colors.

---

## What Was Hard

*Describe the most technically challenging part of this work. Don't write "it was confusing." Explain specifically what confused you, what you tried, and what helped you figure it out. If something in the Jetpack Compose theming system surprised you, describe it.*
Figuring out how the instructions corresponded with the project was the most difficult part.
For example, in they Typography section, the style ( \[Display\],
/ H1 \[H2, H3\], \[Body\], \[Label / Caption\] ) did not seem to line up with
the material3.Typography styles available. Also, figuring out the different names
for the different composable variable (like FilterChip using labelColor vs 
Button using contentColor) and how that relates to the instructions.
Also trying to clear up unclear (to me) instructions like using
"primary background" (does that mean to use the "Background", "Primary",
or "PrimaryContainer"?) for the filled buttons. I managed to figure most
of this out by comparing the results to the wireframe (though I still
do not understand the Typography section).

---

## What You Understand Now

*What do you understand about Jetpack Compose theming — `MaterialTheme`, `colorScheme`, `typography`, component defaults — that you didn't fully grasp before this assignment? Be specific enough that you could explain it to a pod mate who hasn't done this yet.*
One thing that I understand better is component defaults. The various
Composables will use default values unless you specify. I have got
the biggest improvement in understanding for the default colors.
A component will, by default, use the default colors for that
component which may be different from other components defaults. These
colors are taken from the MaterialTheme. For example, the primary
color for a labelColor in one component may be 
MaterialTheme.colorScheme.primary while another component 
may use MaterialTheme.colorScheme.secondary for their
labelColor (or equivalent) default color. The defaults are defined
internally so it is not possible to change, for example, all buttons
to use contentColor = MaterialTheme.colorScheme.tertiaryContainer or 
something like that. It is possible to define your own button that
changes the color and use that button instead.

---

## Self-Assessment

*Look at the rubric (`extra-credit-design-alignment-rubric.md`) and estimate your own score for each section. Be honest — this does not affect your grade, but it shows me whether you read the rubric carefully.*

| Section | Possible | My Estimate |
|:---|:---:|:---:|
| Color System | 13 | |
| Typography | 5 | |
| Component Styling | 15 | |
| Navigation & Cards | 5 | |
| Reflection | 12 | |
| **Total** | **50** | |

Self-Assessment:
Color: 13/13
Typography: 0/5
Component Styling: 15/15
Navigation & Cards: 5/5
Reflection: 6/12

*One thing I think I did well:*
I think that I implemented the color scheme correctly in the 
areas requested by the instructions.

*One thing I know I left incomplete or could have done better:*
I know that I did not do the Typography correctly
