# Week 02 Reflection

**Name:** Dylan Browne
**Date:** 05/28/2026

---

## Commits This Week

<!-- Paste a link to your commits for this week. The easiest way: go to your repo on GitHub,
     click "commits", and copy the URL after filtering by your name or branch. -->

**Link:** https://github.com/DylanBrowneMetrostate/media-tracker-android/pull/3

---

## Code Review

<!-- Every week you leave a review on a pod mate's pull request. Fill in both parts below.
     Part 1 is the link — I will verify the review exists on GitHub.
     Part 2 is your written assessment — what you actually looked at and what you found. -->

**Reviewed:** *(pod mate's name)* Jacob Vigliotti
**Link to my review:** https://github.com/jacobvigliotti/media-tracker-android/pull/2

### What I Looked At

<!-- Walk through the code you reviewed. What was the PR trying to do? Which files or
     functions did you focus on? -->

I looked through all of the lines of code that were changed (there are not very many)
and focused on the areas that were outside my expectations. Specifically, a line of code
that was not consistent with what we talked about in class (though we talked about it in 
our group, as well a seemingly extra section of code from one of the bug fixes.

### What I Noticed

<!-- Be specific. Did you spot a potential bug? A pattern that could cause problems? Something
     done well that you want to call out? "I looked at the ViewModel and everything seemed fine"
     is not specific enough. Name the thing you noticed and explain why it matters. -->

I noticed that most of the code that was commited was what we talked about in class.
There was one line of code that I saw that we talked about in our group as a potential solution
to the bug that was not used as the solution (changing remember to rememberSavable). I am not 
sure what differences that this effect would have on the state of the app, so I pointed it out.

### Comments I Left

<!-- Briefly summarize the comments you left on the PR. If you left a positive comment,
     say what it was. If you left a suggestion, say what you suggested and why. -->

I pointed out where the code that he wrote was different than what we talked about in class.
This solution likely impacts the code in a way that is different then the solution that we talked
about in class. Possibly by saving the state of the selectedType val even in areas where it
should not be saved (like leaving and reentering the page) though I did not have time to test it.
I also pointed out an area of code that we wrote in class that seemed to be longer then needed 
(the "== true" seemed like it is not needed) though that could be necessary, and I am just unaware.
I thought that it would be a useful thing to know, regardless of weather it is actually excess or if
I was incorrect, and it is necessary.

---

## One Thing I Understood More Deeply

<!-- Be specific. Don't write "I learned about ViewModels." Write what specifically clicked —
     what was confusing before, what made it make sense, and how you'd explain it to someone else.
     There are no wrong answers here. -->

The biggest thing that I understood more deeply from this class session is about how NavGraphs work.
I learned about how MediaTrackerNavGraph defines where each screen can route to by the Android 
navigation controller. I also learned a bit more about how the routes for navigation are defined,
with a string Route corresponding to a composable with a screen.

---

## One Thing I'm Still Confused About

<!-- Be honest. This is the most useful part of the reflection for me — it tells me where to
     spend more time in class. You will not lose points for being confused. -->

One thing that I am still confused about is the various rules about how Android works.
For example, when changing the screen, there current activity is dropped and a
new composable is created. What values are saved between the activity being dropped
and what are saved? Why does exiting a screen behave differently for saving data
then turning the screen? Things like that are what I am still confused about.

---

## Anything Else *(optional)*

<!-- Did you help a pod mate work through something? Did you discover something cool or frustrating?
     Did something from a previous week finally click? This is a good place to put it. -->

---

## Rubric

*You don't need to self-assess — this is here so you know what I'm looking at.*

| Section | Points | Full Credit | Half Credit | No Credit |
|:---|:---:|:---|:---|:---|
| **Reflection** | 10 | Specific, honest responses to "More Deeply" and "Still Confused" sections. Shows genuine thinking — not just "I learned X." | Responses are present but vague or generic ("I got better at Compose"). | Missing or one-word answers. |
| **Code Review** | 10 | Specific observation about the code with explanation of why it matters (or a substantive positive comment). Link to review present and verified. | A question or comment that shows you read the code, but lacks explanation. | "Looks good!" or equivalent. Missing link. Review not found on GitHub. |
| **Total** | **20** | | | |

**A note on the code review score:** I check that the review actually exists on GitHub before grading. The written summary here and the GitHub comment should match. If the review isn't there, the written summary can't earn credit.
