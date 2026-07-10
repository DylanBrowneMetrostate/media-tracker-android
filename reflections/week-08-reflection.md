# Week 08 Reflection

**Name:** Dylan Browne
**Date:** 07/09/2026

---

## Commits This Week

**Link:** https://github.com/DylanBrowneMetrostate/media-tracker-android/pull/19

---

## Code Review

**Reviewed:** *(pod mate's name)* Jacob Vigliotti
**Link to my review:** https://github.com/jacobvigliotti/media-tracker-android/pull/9

### What I Looked At

I looked through all the code that in the "Working SEARCH and GET Media" commit except for the
gradle/libs.versions.toml and app/build.gradle.kts files. I focused on the areas that I believed
could be improved as well as the areas that he did better than me on. I pointed out areas where he
recreated a Media object from an already existing Media object. I pointed out areas where he should
add more details to the screen and an area where he should save details about the type of error.
I pointed out areas where he had better ideas for the code than me or better followed what we had
written before.

### What I Noticed

I noticed one area where he copied the body from the API into a new Media object. The issue that
I had with this is that the API already returns a Media object. Instead of coping that media object
into a new Media object it would be better to just return the original. This matters because it
is better to not repeat yourself unnecessarily in code. The way that it is written is harder to
understand then it needs to be.

Another issue that I found is that he did not return any of the error or message from the 404 
response from the media detail GET call. This means that there is no way to handle the unique errors
or display any unique message because that data is lost before it is used. This is an issue because
it prevents robust error handling.

The previous issue leads into the fact that the MediaDetailScreen only has a very barebones 
implementation for errors from the media detail GET call. Since no details where passed along, full
error handling is not possible. However, even beyond missing information, the screen is still not
very detailed and does not even have a back button. This is an issue because people who see the 
MediaDetailScreen from a bad media detail GET call will not have any information on what went wrong.
The formating is also different from the rest of the application.

I also noticed some areas where he did better than me. One of those areas is where he included a 
sealed interface for MediaResult. This is consistent with the other API calls and repositories. 
This is good to follow consistent practices. Another area that he did better than me is when he
included updating the media detail when the mediaId is updated in the setMediaId function. This is
useful because whenever the id is updated, the media detail should be as well. This matters because
it is important to be consistent and reduces possibilities for errors, respectively.

### Comments I Left

I left a comment pointing out that he copied data from one Media object to a new Media object when
he could have just returned the original object. I stated that he did not have to create a new
Media object. The reason that I suggested that is because creating the new Media object is unneeded
and makes the code harder to read. It also allows for easy to miss mistakes (though I did not see
any) such as mixing up variables (like title = original.author instead of original.title).

Another comment that I left pointed out that the MediaResult.Error did not include any of the 
code or message from the API. The code also did not distinguish between 404 errors and other
errors. The reason that I pointed this out is that not including those details prevents robust
error handling, as what went wrong is unclear. Adding in a dedicated 404 error and a generic other
error would allow for distinguishing the errors better.

Another comment pointed out that the MediaDetailScreen for a bad media detail GET call is lacking
detail. Because of the MediaResult. Error not returning any information, the details that could
be provided are limited, but even so, things like a back button, formating, and more detailed
text than just "No Media" would be useful. I suggested this because the screen seems incomplete and
missing a lot of detail, which looks unprofessional and should be fixed in my opinion.

I also pointed out where he did better than me. One of those areas is in the MediaDetailViewModel
where he loaded the media details from the API whenever he changed the mediaId. This is good 
because it helps prevent changing the mediaId but not changing the associated Media object. I also
complimented when he used a sealed interface called MediaResult to return the results of the API
call. I believe that this was a good idea that I should also implement because it stays consistent
with the previous repositories returning API return values.


---

## One Thing I Understood More Deeply

One thing that I understand more deeply is how to connect with the API. I had an issue for a number
of weeks where I did not know why the search bar would return no results from the API. I was not 
sure if I was using the wrong @ value (like @GET or @POST) or the response from the API. I was also
unsure if the annotation (I believe it is called) was correct. When we first got back from breakout
rooms and a student shared their screen, I realized that the API requests were included in Logcat.
The class is the first time I have worked with Logcat (that I recall) and I was either unaware or 
had forgotten that the request showed up there. However, when I realized that, I was able to 
somewhat easily find the error, I was getting a 401 error which after some work I realized was 
because I did not include the accessToken from logging in on the session. At a similar time (don't
recall if it was before or after) I got a better understanding of the API reference and noticed that
my @ value and annotations were correct, meaning I just had to include the accessToken. I would
explain it to someone else by talking about how you need to be logged in in order to see certain 
information and that it is important to prove to the API that the request has proper authorization.

---

## One Thing I'm Still Confused About

One thing that I am still confused about is why the API call only returns 200 code results for some
of the media. For example, the suggested media on the SearchScreen can't be found with the API
while the media from the SearchResultsScreen is found. I ran out of class time to test this out but,
I am guessing that the reason for this is that the ids from those screens are for the
FakeMediaRepository. I am guessing that there are no Media ids that are the same in the API, so
it cannot find any Media.

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
