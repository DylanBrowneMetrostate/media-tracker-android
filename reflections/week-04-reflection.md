# Week 04 Reflection

**Name:** Dylan Browne
**Date:** 06/11/2026

---

## Commits This Week

**Link:** https://github.com/DylanBrowneMetrostate/media-tracker-android/pull/7

---

## Code Review

**Reviewed:** *(pod mate's name)* Jacob Vigliotti
**Link to my review:** https://github.com/jacobvigliotti/media-tracker-android/pull/4

### What I Looked At

I looked through all of the code that was included (not counting the reflection). I tried
to point out what I thought was done well or areas that could be improved. I did not comment
on areas that I commented on last week that he changed. I focused most on the RegisterViewModel
and RegisterScreen, though one of the comments that I left in the LoginScreen would also
be relevant in the RegisterScreen (the comment about the bold text) and since I already mentioned
the comment, I did not repeat it.

### What I Noticed

I noticed that he did not include the ScrollState on the modifier for the Column on the RegisterScreen.
I think this was just an oversight because he did import the ScrollState, but failed to create the 
variable or do anything else with the imported ScrollState. This matters because (if I am understanding
correctly) without the ScrollState attached to the Column, people with smaller devices or who can
otherwise not have the entire Column on screen at once will be unable to scroll to the bottom of the
screen and will have more trouble registering. I also pointed out some areas that he did
better than me. He also updated the LoginScreen, which is something that I should also get to.
In our pod, we were talking about how the text for the title of the screen was not bolded. He seemed 
to have found a way to fix that. These things matter because it brings the application closer to 
the wireframe. He also used a when statement where I used a series of if statements that made the 
code look much cleaner. This matters because writing clean code is easier to read. I also noticed that
he changed the color in the theme (though I forgot to leave a comment on at first and only added
it in latter). This seems to like it will have more broad reaching impacts and seems like on non-ideal
way to fix the difference in color of the RegisterScreen's title, so I pointed it out.

### Comments I Left

I left comments pointing out some issues (and potential issues) that I saw as well as some areas 
that he did well. One issue that I saw was that he did not include the ScrollState in the Column
for the RegisterScreen (or create a variable for a ScrollState). This means that the Column will 
have issues scrolling for the users that need that, so it is best to include it, especially since
the Column is so large. One potential issue that I notice (though I forgot to comment on it at 
first and had to make a second review to include the comment) is that he changed the theme color
to something else, which seems like a more extreme change than is necessary. It seemed to me that
the text that was used (the header of the RegisterScreen) should just not use the theme color 
instead of changing the theme color. It is possible that he changed the theme color for some other
reason, though the color of the theme header is the issue that we talked about in our pod. One thing 
that I pointed out that he did well was to update the LoginScreen with the relevant changes to the
RegisterScreen (such as adding the icon and bolding text). Another thing that he changed was adding 
"fontWeight = FontWeight.Bold" which seems like it would bold the text (which was something that we
mentioned in our pods needed to be fixed). Another thing that he did well is using a "when" statement
instead of the "if" statements that I used, his looks much cleaner.

---

## One Thing I Understood More Deeply

One thing that I understood more deeply is how to use the "when" statements (though unfortunately
this understanding was too late for me to include in my code for this week). I was unaware of 
how kotlin handled situations where java would use "switch" statements, but using the "when" 
statement for a broader range of conditions seems much more useful. While I was pretty sure that
kotlin would have something like a "switch" statement, I was unaware of how it worked or that it
would be broad enough to use for situations with more general conditions. I feel like a lot of the
other things that we talked about I already mostly understood from last week.

---

## One Thing I'm Still Confused About

I feel like I mostly understand what we talked about this week. One thing that I am still confused
about in general is about how to connect with the API and how we are getting responses back from it.
I have not yet fixed the error mentioned in the last reflection and even if I had, it is unclear
to me how we would interpret the responses from the API, weather it is something done manually or
automatically. I think that we will talk about this more next week.

---

## Anything Else *(optional)*

Part way through the second pod section, my computer froze and then crashed, but I came
back as soon as I could.

For week 2, you put "Reflection −1" in "Points deducted", but -2 points as the grade.

For week 3, you put 9/10 for two sections, but I saw no explanation about why I lost points.
I would appreciate if you could explain how I could improve my work.

---

## Rubric

*You don't need to self-assess — this is here so you know what I'm looking at.*

| Section | Points | Full Credit | Half Credit | No Credit |
|:---|:---:|:---|:---|:---|
| **Reflection** | 10 | Specific, honest responses to "More Deeply" and "Still Confused" sections. Shows genuine thinking — not just "I learned X." | Responses are present but vague or generic ("I got better at Compose"). | Missing or one-word answers. |
| **Code Review** | 10 | Specific observation about the code with explanation of why it matters (or a substantive positive comment). Link to review present and verified. | A question or comment that shows you read the code, but lacks explanation. | "Looks good!" or equivalent. Missing link. Review not found on GitHub. |
| **Total** | **20** | | | |

**A note on the code review score:** I check that the review actually exists on GitHub before grading. The written summary here and the GitHub comment should match. If the review isn't there, the written summary can't earn credit.
