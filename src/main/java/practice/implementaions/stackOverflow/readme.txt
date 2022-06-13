Design a question-answer platform for developers. (Social media platform) where users can ask any tech related questions [Similar to stackoverflow].
Some features to build for example -
a) Signup, Signin , Session Handling etc.
b) Posting of questions, answers, comments.
c) Upvoting / Downvoting.
d) Subscribing to some topic / question / answer.
e) Some filtering based on the parameters passed. etc

Requirements :
- Any Non member can search and view questions
- Only Member can post question/answer, comment, upvote/down vote
- For Filtering - Tag should be added while posting question

Extra Requirements:
- System should be able to identify hot tags
- Badges to members for posting answers and help community
- Blocking of members - with n no of down votes by admin
- unblocking of members - with n no of up votes by admin
- sending notification and badges by system


Actors:
-Admin
-System
-Member
-Guest

Entities:
-Question
-Answer
-Comment
-Tag
-User -->(Member, Guest, Admin, System)
-Badge
-Account
-Notification

Enum:
-Question status (OPEN, CLOSED, ON_HOLD, DELETED)
-Account Status  (ACTIVE, INACTIVE, BLOCKED)




