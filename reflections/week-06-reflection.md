# Week 06 Reflection

**Name:** Dylan Browne
**Date:** 06/25/2026

---

## Commits This Week

**Link:** https://github.com/DylanBrowneMetrostate/media-tracker-android/pull/14

---

## Code Review

**Reviewed:** *(pod mate's name)* Jacob Vigliotti
**Link to my review:** https://github.com/jacobvigliotti/media-tracker-android/pull/6

### What I Looked At

I looked over the files of the latest commit at the time (called: "Still working on getting
search working..."). I focused on mostly on files that were not in the GitHub reference commits.
While I think that those files could be useful if implemented proberly, I did not think they were
implemented properly. I also briefly looked over the modified files from previous weeks as well as
the files that were in the GitHub reference commits. Usually for those files there was nothing 
that I saw seemed that seemed incorrect, which means that I did not have much to comment on. My
review focused on what I think he could have done better.

### What I Noticed

One thing that I notice is that he implemented classes / interfaces that he did not end up using
(such as SearchRequest and SearchRepository). This is notable to me because he was implementing it
in a similar way to the other Repository interfaces and API calls with data classes. I was also 
working on implementing something in a similar way but scraped it before the end of class. He seemed
to abandon the idea part way through, but kept the classes / interfaces. This leaves interfaces that
are not implemented and data classes that are not used. I also recognized and pointed out an area in
that implementation that could cause problems if it is not changed. Specifically, the 
suspend fun search should probably have had more arguments or take the data class SearchRequest.
These matter because properly implementing these changes would make the code more robust but leaving
them implemented improperly leads to the code being more confusing and could potentially lead to 
duplicate code that do the same thing.

### Comments I Left

I pointed out areas where he left in unused code. He seemed to implement the functionalities of
that code in other files, but left in the unused coded. I pointed out that an implementation of
the functionalities of an interface that he made did not actually implement the interface (though
the suspend fun search was missing some of the arguments in the interface).

I also pointed out some issues that I believed could have come about if he had implemented the unused
code. I pointed out how the suspend fun search in SearchRepository had issues with its arguments and
two possible fixes. I also pointed out that one of the data objects in the 
sealed interface SearchResult seemed to be unneeded. The reason that I suggested all of the changes
that I mentioned so far (this paragraph and the previous one) is because I believe that implementing
at least part of the unused code could be useful. Even if he thinks that it would not be useful to
implement, having these sections pointed out for removal is still better than leaving them as is.

I also pointed out that the login screen does not have a default argument for showRegistrationSuccess.
I think that a default argument could be useful here so I pointed it out. I also believe that it would
be more readable if all variables with default arguments go before the variables without default
arguments, though I am not sure if that is the standard or not. 

---

## One Thing I Understood More Deeply

One thing that I understood more deeply is the difference between Column and LazyColumn. While we
had mentioned LazyColumn before, I was not sure what made it different that a regular Column. Now it
makes sense to me that a LazyColumn has better performance than a Column when there is a large number
of items in the Column because it can reuse resources that a Column needs to spend time garbage 
collecting. It does make me wonder why LazyColumn are not always used. Perhaps the performance / memory
is worse with suitably small Columns? If I were to explain it to someone I would show how a Column 
with thousands of items is slow to respond and show how a corresponding LazyColumn preforms better.
I would also explain how a LazyColumn reuses resources that a Column does not.

---

## One Thing I'm Still Confused About

One thing that I am still confused about is why the search results seem to not be working at the 
moment. I can navigate to the page with a search, but there are always no results. My pod mates
were also having this issue. Is there an issues connecting with the API? Does the API just have
no results for my search terms (seems unlikely since the SearchScreen shows results that I searched)?
Are the results not being saved properly? Something else? I don't know.

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
