# Week 05 Reflection

**Name:** Dylan Browne
**Date:** 06/18/2026

---

## Commits This Week

**Link:** https://github.com/DylanBrowneMetrostate/media-tracker-android/pull/11

---

## Code Review

**Reviewed:** *(pod mate's name)* Mai Nhia Vang
**Link to my review:** https://github.com/Maii2025/media-tracker-android/pull/5

### What I Looked At

I looked at all of the new files, looked over all of the files in the model and auth folder (and
briefly looked over the other files). I pointed out a few areas that I think could be improved. I
also pointed out where she did a better job of including files that I missed. I also pointed out
some areas that she wrote better code than I did. I also pointed out some changes that the 
professor made that I was unsure of the reason for.

### What I Noticed

One thing that I noticed is that she had a lot of files that I did not. Many of these files
I did not recall going over in class or seeing them in the latest commits, so I was unsure
of when they were added. (There was also one area that I did recognize, but I did not see it 
commited before then.) This is important for me, because if I had not seen these files, I 
would likely have run into unknown errors later. 

I also pointed out a few areas where I deemed that improvements could be made. One area is when 
she added "filter_comics" and "filter_albums" in the strings.xml file. My understanding is that 
these were only included temporarily to showcase scrolling in a previous week and comics 
and albums are not actually stored in the app. This is important to point out and fix because 
leaving it in suggests we should have those filters used when that is not actually the case.

Another area that seemed like it would cause problems is in the CreateUserResponse and 
CreateTokenResponse. My understanding is that the responses from the Api will have many more
fields than she provided. It is important to point this out because without all of the fields,
she will have issues of missing data.

Another area that seemed like it would cause problems is in the ApiService that only returned 
CreateUserResponse and CreateTokenResponse instead of Response<CreateUserResponse> and 
Response<CreateTokenResponse>, which I believe to be correct. It is important to point this out as
if my understanding is correct, the response won't come back from the Api correctly without this fix.

I pointed out some areas where I was confused about why these 
changes were made (specifically two areas where class is changed to data class within a sealed
class). I pointed it out because I would have found it helpful to get an explanation for that.
I saw that the professor made these changes in his commits but did not know why.

### Comments I Left

I left a lot of comments pointing out files that I completely missed. I mentioned how I did not
see when these files where commited or when we went over them in class. If I had not seen these
files, I would have likely run into errors later.

I also left some comments about areas that I believe could be improved. One of those areas is
in the lack of data in the CreateUserResponse and CreateTokenResponse. I believed that it was 
important to point out as the mismatch between the Api reference and the class fields leads
to a lot of the data from the Api reference being lost.

Another area that I pointed out potential issues is when she had the return values from the Api
being CreateUserResponse and CreateTokenResponse instead of Response<CreateUserResponse> and
Response<CreateTokenResponse>. In my understanding, the program has issues interpreting the Api
response without these change. This is important to fix in order to have proper registration and 
logging in.

One more are that I believed was incorrect was the inclusion of "filter_comics" and "filter_albums" 
in the strings.xml file. While not as important as the other two, my understanding is that
comics and albums are not tracked like that and the filters are not used. I pointed this out as
it can lead to some confusion later about whether comics and albums need to be implemented.

I also pointed out some changes that the professor made (along with both of us) that I did not
understand. Specifically in two places within sealed classes, objects where changed to data objects.
I thought it would be useful to get her perspective / understanding of why this was changed.

---

## One Thing I Understood More Deeply

One thing that I understood more deeply is the serialization and api calls. In week 3, I was having
the same issue that I spent most of today fixing and thought that it had something to do with
converting to JSON incorrectly. This week, I realized that it was probably related to issues with
including the plugin for the serialization (I am not sure how I included the plugin incorrectly
considering I copied and pasted the lines you told us to, unless there were two versions of lines
you provided and I used the wrong ones, or something like that) and eventually fixed it. However,
fixing this problem took up most of the pod time, leading me to falling behind. It did allow me to
better understand how a proper ConverterFactory is needed to convert the data as well as how the gson
(as I believe it was called) that we removed from the build would have been used to fill that purpose.
I also saw for the first time how the program sends and receives data from the api.

---

## One Thing I'm Still Confused About

One thing that I am still confused about is how to include the API_CLIENT_SECRET
and API_CLIENT_ID in the Build Config. They are set as null in the autogenerated file,
and I do not know how to change that. I temporarily hard coded in the values to test the
rest of the files. I am guessing that it is included somewhere in Android Studio to
include when running the app (not in a file) or possibly (though less likely) in some file
that is not added to GitHub.

---

## Anything Else *(optional)*

I fell a bit behind as I somehow had issues with the plugins from two weeks ago. 

Only me and Mai Nhia Vang showed up for this class period from our pod.

I feel like whenever you showcased something today, you have reorganized everything
into a vastly different state then what we have, making it difficult to follow along.

Are we supposed to be pulling your code from GitHub to our Android Studio?

I made two pull request (because I forgot to commit a file) and pull request
10 (the first one this week)
(https://github.com/DylanBrowneMetrostate/media-tracker-android/pull/10)
was the one my pod mate reviewed

---

## Rubric

*You don't need to self-assess — this is here so you know what I'm looking at.*

| Section | Points | Full Credit | Half Credit | No Credit |
|:---|:---:|:---|:---|:---|
| **Reflection** | 10 | Specific, honest responses to "More Deeply" and "Still Confused" sections. Shows genuine thinking — not just "I learned X." | Responses are present but vague or generic ("I got better at Compose"). | Missing or one-word answers. |
| **Code Review** | 10 | Specific observation about the code with explanation of why it matters (or a substantive positive comment). Link to review present and verified. | A question or comment that shows you read the code, but lacks explanation. | "Looks good!" or equivalent. Missing link. Review not found on GitHub. |
| **Total** | **20** | | | |

**A note on the code review score:** I check that the review actually exists on GitHub before grading. The written summary here and the GitHub comment should match. If the review isn't there, the written summary can't earn credit.
