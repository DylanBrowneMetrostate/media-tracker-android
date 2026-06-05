# Week 03 Reflection

**Name:** Dylan Browne
**Date:** 06/04/2026

---

## Commits This Week

<!-- Paste a link to your commits for this week. The easiest way: go to your repo on GitHub,
     click "commits", and copy the URL after filtering by your name or branch. -->

**Link:**https://github.com/DylanBrowneMetrostate/media-tracker-android/pull/5

---

## Code Review

<!-- Every week you leave a review on a pod mate's pull request. Fill in both parts below.
     Part 1 is the link — I will verify the review exists on GitHub.
     Part 2 is your written assessment — what you actually looked at and what you found. -->

**Reviewed:** *(pod mate's name)* Jacob Vigliotti
**Link to my review:** https://github.com/jacobvigliotti/media-tracker-android/pull/3

### What I Looked At

<!-- Walk through the code you reviewed. What was the PR trying to do? Which files or
     functions did you focus on? -->
I looked at all of the updated files except for the libs.versions.toml, build.gradle.kts
and smart_display.xml files (I also did not look at the reflection). I focused on the similarities
that we both did but was different than what was directly shown in class as well as the differences 
between what I did and what he did.

### What I Noticed

<!-- Be specific. Did you spot a potential bug? A pattern that could cause problems? Something
     done well that you want to call out? "I looked at the ViewModel and everything seemed fine"
     is not specific enough. Name the thing you noticed and explain why it matters. -->
I noticed that he also used the OutlinedTextField instead of (I believe it was called) TextField,
which more closely matches the wireframe as compared to what was directly mentioned. I also noticed
(though did not make post a comment about it) that he used the strings.xml file to place his strings
instead of hard coding them into the file. I also noticed some areas that seemed to be directly copied
from the login screen's OutlinedTextField that may not be relevant for this screen (such as 
KeyboardType.Email probably not being useful for the non-email text fields and 
onNext = { focusManager.moveFocus(FocusDirection.Down) } which seems to be incorrect for the 
final text field). I also noticed that he put the clientId in a better spot then I did.
These matter because some of them are pointing out what he did well and other parts are pointing
out potential problems.

### Comments I Left

<!-- Briefly summarize the comments you left on the PR. If you left a positive comment,
     say what it was. If you left a suggestion, say what you suggested and why. -->
I left some positive comments mentioning where he did something better than me (better placement 
of clientId) and where what he entered matched the wireframe better than what was directly shown 
in class (OutlinedTextField instead of (I believe it was called) TextField). I also pointed out
some areas that seemed to have unneeded or possibly incorrect information, such as having
KeyboardType.Email as part of the text field for non-email text fields. Another area is where
he had "onNext = { focusManager.moveFocus(FocusDirection.Down) }" when it seemed to already
be at the bottom of the screen (and the login screen had a different value in that location).

---

## One Thing I Understood More Deeply

<!-- Be specific. Don't write "I learned about ViewModels." Write what specifically clicked —
     what was confusing before, what made it make sense, and how you'd explain it to someone else.
     There are no wrong answers here. -->
One thing that I understood more deeply is how to set up a screen. One aspect of this that I learned
completely is how to get an image from a svg file and import it into the project (where it is converted
to an xml file). I also got a better understanding of how an icon can be included in the page and how
a tint can be added to not have to have many identical images with the only difference being
the colors of the image. I also got a better understanding of how OutlinedTextField work, though
there are still many details about the exact workings of all of the parameters. Before, I had no
idea how to get an image properly imported into the project and had a more shallow understanding of
how the various tools such as Image and OutlinedTextField worked in order to set up a page. Going
over these details in class and when coding helped me to get a better understanding.

---

## One Thing I'm Still Confused About

<!-- Be honest. This is the most useful part of the reflection for me — it tells me where to
     spend more time in class. You will not lose points for being confused. -->
I am still confused about how to create a user request. When I try to do so, I get
an error about how the arguments for the Body request is illegal ("Unable to create @Body converter 
for class edu.metrostate.ics342.mediatracker.data.model.CreateUserRequest (parameter #1)").
It seems to me that this issue is because the CreateUserRequest is not being converted
to JSON properly, but why that is or how to fix it is not clear to me. I would
also not be surprised if it is a compliantly different reason that I am getting that error.
I ran out of time to be able to fix this error.

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
