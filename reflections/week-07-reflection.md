# Week 07 Reflection

**Name:** Dylan Browne
**Date:** 07/02/2026

---

## Commits This Week

<!-- Paste a link to your commits for this week. The easiest way: go to your repo on GitHub,
     click "commits", and copy the URL after filtering by your name or branch. -->

**Link:** https://github.com/DylanBrowneMetrostate/media-tracker-android/pull/17

---

## Code Review

**Reviewed:** *(pod mate's name)* Jacob Vigliotti
**Link to my review:** https://github.com/jacobvigliotti/media-tracker-android/pull/7

### What I Looked At

I looked over all the file from the "80% completion of MediaDetailScreen" commit.
Some of the things (the fastLoad in the LoginScreen, MovieContainer and OnMovieContainer in
Colors, and the files tv_24px.xml, menu_book_24px.xml, and movie_24px.xml) were from previous
weeks that he caught up on this week. I shared the code that I used in previous weeks
with him (for fastLoad and the movie colors). I also shared my implementation of the
url image handler (which I copied from the LibraryScreen file, though I believe that I modified
it in previous weeks, though I could be wrong about that). He did not seem to use it though.
He shared with the group the TopAppBar section (though he seemed to work on it more after that,
while I focused on other things during the pod session). I focused on the parts that were not 
from previous weeks and that I had not seen before, focusing on the MediaDetailScreen (excluding
his reflection). I pointed out areas that he did better than me and areas that he could improve on.

### What I Noticed

One major thing that I noticed is that he often made components with the assumption that the screen
would display a book. For example, having an InfoBox with "Pages", which is only relevant for books.
There was no replacement code for "Episodes" or "Runtime" (or some other alternative) for shows
or movies. Also, the data in the InfoBoxes was hardcoded in instead of taken from the media 
example. Something similar happened when he only included a text box for media.author and nothing
similar for directors or creators (or some equivalent). I also noticed areas where he did better 
than me, such as consistently including colors and Typograph, better content descriptions, 
actually using strings.xml, including spacers, and a better bar with the review number and review 
button. There were also areas where he missed things, often symbols like a plus, a heart, or half
stars. I also included things that I think might be better, but may not be incorrect, such as
a better implementation of getting example media or an explanation stating when media does
not have descriptions. He was also missing some arguments from the media class as well as
using the wrong icons for the alternate to the url.

### Comments I Left

I pointed out areas that he did better than me. These include when he used spacers, better content
descriptors for some icons, a better implementation of a Row with review number on one side and
a "+ Write Review" button on the other, more inclusion of Color and typography style, and using 
strings.xml.

I also pointed out some areas where he could improve. One of those areas was that he seemed to
be building the screen specifically for books and there were a number of areas where no alternative
for movies or shows where provided. (Such as a field for authors but no option for directors or
creators). Also, there was an area where an error would be thrown if the media did not have an 
author (aka if it was not a book). I pointed out all the times that I noticed that. This is 
important because the page will break or have missing data for non book media as it is 
implemented.

Another area that he could improve is where he was missing details. He often missed icons on
buttons and also missed the half a star symbol for the review. He also used the wrong icons for
the url alternative. He was also missing data in the Media data class (pageCount and isbn for 
books; seasonCount and episodeCount for shows; runtimeMinutes for movies; and reviewCount for
all of them). This is important because implementing these changes will better match the ui to the
wire frame. For the missing data in the Media data class, it is needed to update to get all the
needed data from the api calls.

There were also a few areas where he hardcoded data that I pointed out. Once he hardcoded a color
outside of Color.kt and another time he directly hardcoded data that should have come from the 
media val (once for all three of the InfoBoxes). Hardcoding the color is bad because it will not
change with updated MaterialTheme while hardcoding the data is bad because it will be incorrect
for essentially all pieces of media.

I also pointed out some suggestions that I had that were not essential. One of them was to take 
the media directly from FakeMediaRepository.mediaList instead of hardcoding it. Another was to
give the user an indication when a piece of media does not have a description. These are suggested
in order to speed up the testing of the screen or to better inform the user of the application 
about the given media respectively.

---

## One Thing I Understood More Deeply

I better learned how to create a screen, especially with the alignment of items within the
components. I was having trouble at first trying to get the first set of items (before the about 
section) in the center of the screen and the rest of the items to be left of the screen. And also,
in the Year, Pages, and Genre boxes, I had trouble getting the Column centered in regard to the Box
as well the Text centered in regard to the Column. It seems obvious now but, I needed both the Box
and the Column to have their contents centered. It made sense by spending time working through it 
and seeing how the alignment for the Box alone as well as the alignment for the Column alone 
affected the alignment of the Text. I would describe it to someone else by talking about how each
component are their own separate scope and explain how the most broad scope's alignment must allow
for the more narrow scope to fit.

---

## One Thing I'm Still Confused About

I am still confused about what some of the buttons on the screen are supposed to do. For example,
what should the three dots in the top right do? While the "+ Want To" button seems like it should
save the book to the library as a "Want to", what does the "Save" button do? Also, is the "Genre"
Box supposed to be clickable to filter by genre? Also, not all the genres of the book are shown
in the "Genre" Box. Is it supposed to show some specific genre? Are the genres supposed to change?

---

## Anything Else *(optional)*

---

## Rubric

*You don't need to self-assess — this is here so you know what I'm looking at.*

| Section | Points | Full Credit | Half Credit | No Credit |
|:---|:---:|:---|:---|:---|
| **Reflection** | 10 | Specific, honest responses to "More Deeply" and "Still Confused" sections. Shows genuine thinking — not just "I learned X." | Responses are present but vague or generic ("I got better at Compose"). | Missing or one-word answers. |
| **Code Review** | 10 | Specific observation about the code with explanation of why it matters (or a substantive positive comment). Link to review present and verified. | A question or comment that shows you read the code, but lacks explanation. | "Looks good!" or equivalent. Missing link. Review not found on GitHub. |
| **Total** | **20** | | | |

**A note on the code review score:** I check that the review actually exists on GitHub before grading. The written summary here and the GitHub comment should match. If the review isn't there, the written summary can't earn credit.
