# Week 01 Reflection

**Name:** Dylan Browne
**Date:** 5/21/2026

---

## Commits This Week

<!-- Paste a link to your commits for this week. The easiest way: go to your repo on GitHub,
     click "commits", and copy the URL after filtering by your name or branch. -->

**Link:** https://github.com/DylanBrowneMetrostate/media-tracker-android/commit/ba57280c3dc1c22e4c83badede8a164588398243

---

## Code Review

<!-- Every week you leave a review on a pod mate's pull request. Fill in both parts below.
     Part 1 is the link — I will verify the review exists on GitHub.
     Part 2 is your written assessment — what you actually looked at and what you found. -->

**Reviewed:** *(pod mate's name)* Jacob Vigliotti
**Link to my review:** https://github.com/jacobvigliotti/media-tracker-android/pull/1

### What I Looked At

<!-- Walk through the code you reviewed. What was the PR trying to do? Which files or
     functions did you focus on? -->
They changed the theme of the screen to match the colors in the wireframe.

### What I Noticed

<!-- Be specific. Did you spot a potential bug? A pattern that could cause problems? Something
     done well that you want to call out? "I looked at the ViewModel and everything seemed fine"
     is not specific enough. Name the thing you noticed and explain why it matters. -->
Unlike me, they had "MediaTrackerTheme()" instead of "MediaTrackerTheme" (no parenthesis). 
My Android studio marked it as "Unnecessary parentheses in function call with lambda" so I removed it.
I think that it is useful to only include necessary parts of code, so I pointed it out.

### Comments I Left

<!-- Briefly summarize the comments you left on the PR. If you left a positive comment,
     say what it was. If you left a suggestion, say what you suggested and why. -->
I pointed out where they included an unnecessary parentheses. 
I think that it is useful to only include necessary parts of code, so I pointed it out.

---

## One Thing I Understood More Deeply

<!-- Be specific. Don't write "I learned about ViewModels." Write what specifically clicked —
     what was confusing before, what made it make sense, and how you'd explain it to someone else.
     There are no wrong answers here. -->
One thing that I understood more deeply is how themes can be used to quickly change up the 
look and feel of an application. We just needed to change what theme was being used when the
app was launched (the theme is defined in another section of code) and the login screen colors changed.
While we did not see other pages of the application, they would presumably also change to match the colors.

--- 

## One Thing I'm Still Confused About

<!-- Be honest. This is the most useful part of the reflection for me — it tells me where to
     spend more time in class. You will not lose points for being confused. -->
I am still having issues with getting the application to run on the emulator. I will spend time
outside of class to make sure that it works before next class period. When I try to run the app,
I get a number of different errors, including having the emulator not connect and having the app
start to run before immediately stoping. I think it has something to do with not setting up 
something correctly.

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
