# Weekly Reflection

Documenting how my week in Ent Java went. Sharing how much time I worked and a general overview of how things went: achievements and struggles.


### Week 1

**Time spent: 5 hours**

Tasks Completed:
* Set up my development environment
* Thought of a project idea
* Completed Act 1 & 2
* Completed Exercise 1
* Read over all course materials and watched week 1 videos
---
### Week 2
**Time spent: 5 hours**

Tasks Completed:
* Wrote elevator pitch for indie project
* Completed Acts 1-4
* Exercise #2 
* Watch all lecture videos

I ran into my first issue working in IntelliJ that involved using JSTL. I learned that I need to always use <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> instead of an include directive when working with JSTL in IntelliJ.

I also started looking at a few different services that could be used for OCR:
* AWS Textract: https://aws.amazon.com/textract/
* https://www.simpleocr.com/tag/best-ocr-software-for-handwriting/
---
### Week 3

**Time spent: 1/29/24- 3.5 hours**

Tasks Completed:
* Wrote user stories
* Created a design considerations document
* Completed initial flowchart for diamond-poems
* Ideas for error handling with OCR (Optical Character Recognition)

**Time spent: 1/30/24 -2.5 hours** 

Tasks Completed:
* Started adding jsp files to project directory with starter-code
* Completed wireframe for index, login and signup

Notes:
* I used Figma to complete the wireframes and pdf design documents.
It is a really fun tool to use for brainstorming and deigning page layout
* Research on how to use [bootstrap](https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/basic_app_embedded_tomcat/basic_app-tomcat-embedded.html)

**Time spent: 1/31/24 -2 hours**

Tasks Completed:
* Wireframes for editing and deleting poems, updates to index wireframe
* Watched course video lectures

**Time spent: 2/1/24 - 2 hours**

Tasks completed:
* Readings on JUnit and log4j
* Act 1 
* Started exercise 3

**Time spent 2/2/24 - 2 hours**

Tasks completed:
* Finished exercise 3 while watching demo video
---
### Week 4
**Time spent: 2/6/24 - 2.5 hours**

Tasks completed:
* Readings for week 4
* Started videos for week 4

**Time spent 2/7/24 - 3 hours**

Tasks completed:
* Finished up planning weekly tasks to complete my project by deadline
* Continued watching the videos for the week while following along in my own code base
* Started coding for my User class

**Time spent 2/8/24 - 3 hours**

Tasks completed:
* Continued with the videos for week 4
* Started coding for exercise 4
* Code for UserDao and UserDaoTest

**Time spent 2/9/24- 3 hours**

Tasks completed:
* Finished up exercise 4
* Finished up the week 4 videos

I got stuck for a bit when I created my test database and 
forgot to change my database.properties to the test database.


---

### Week 5

**Time spent 2/12/24- 1 hour**

Tasks completed:
* Readings for week 5

**Time spent 2/13/24- 2.5 hours** 

Tasks completed: 2 hours
* Started week 5 videos 
* Started the Poem class
* Designed the Poem table 

**Time spent 2/14/24- 2 hours**

Tasks completed:
* Refactored code to add user's email and birthdate.

I ran into an issue while refactoring the User class. 
It took me a couple of hours to get all unit tests passing again. 
I had mismatched instance variable @Column values for names that was 
making the tests fail. Lesson learned!

**Time spent 2/15/24- 3 hours**

Tasks completed:
* Added the poem table to the database
* Finished up the Poem class and added Hibernate annotations 
* Started PoemDao
* Tested out OCR in Textract (see images)-- Right now I think Textract will work better if used with the "line" analysis instead of word by word.

**Time spent 2/16/24- 3 hours**

Tasks completed:
* Created PoemDaoTest and wrote unit tests
* Added unit test to User when deleted-- I need to decide if I want the poems persisted or not when a user is deleted.
Right now my application is coded to cascade on delete. Might need to refactor this week.
* Finished week 5 videos 

**Time spent 2/17/24- 1.5 hours**

Tasks completed:
* Started adding servlet classes to handle searching and adding poems
* Started GenericDao class

---

### Week 6

**Time spent 2/20/24- 1.5 hour**

Tasks completed:
* Watched week 6 intro video
* Watched first AWS video and followed along with the setup. 
I was not able to get Diamond Poems working with Elastic Beanstalk

**Time spent 2/21/24- 1 hour**

Tasks completed:
* Attempted to get Diamond Poems up with Elastic Beanstalk. 
I believe I need to make a key pair and an instance profile to make this work and will try again tomorrow.

**Time spent 2/22/24- 1.5 hours** 

Tasks completed:
* Created a key pair and an instance profile for Diamond Poems
* Finally able to get Diamond Poems to work with Elastic Beanstalk http://diamond-poems-env.eba-nvxhqmzs.us-east-2.elasticbeanstalk.com/
* Worked along with video for database set up and redeploy

**Time spent 2/23/24- 4 hours**

Tasks completed:
* Met with Jennifer for a code review in Teams. We shared our individual projects to-date and plan on taking an issue out by Sunday with comments on code.
* Did research on Bootstrap CSS for my jsps
* Worked on index.jsp and search-results.jsp design and display
  [Index Display Progress](images/progressIndex1.png)
  [Search Display Progress](images/progressSearch1.png)

**Time spent 2/24/24- 1.5 hours**

Tasks completed:
* Did the code review for Jennifer's Campsite Reviewer application
* Did some more fussing with the CSS

---

### Week 7

**Time spent 2/26/24- 3.5 hours**

Tasks completed:
* Attended the meetup on UW-Madison campus for Women in Tech
* Started PowerPoint presentation on what I learned at the event

**2/27/24**
I spent the day preparing for and attending the on-campus career fair at Madison College

**2/28/24**
I spent the day researching and following up with employers from the career fair

**Time spent 3/1/24- 1 hour**

Tasks completed:
* Started videos and readings for week 7

**Time spent 3/2/24- 3 hours**

Tasks completed:
* Completed readings and videos for week 7 
* Completed the exercise for week 7 
* Installed Chocolatey on my Windows machine so able to use OpenSSL to generate a certificate

---

### Week 8

**Time spent 3/4/24- 2 hours**

Tasks completed:
* Worked on professional development PowerPoint presentation
* Completed feedback forms for peers professional development projects

**Time spent 3/5/24- 1.5 hour** 

Tasks completed:
* Started videos for week 8
* Looked at AWS documentation for Textract trying to figure out how to use API.
  [Textract documentation](https://docs.aws.amazon.com/pdfs/textract/latest/dg/textract-dg.pdf)

**Time spent 3/6/24- 2 hours**

Tasks completed:
* Started adding classes to Diamond Poems to use login/auth with AWS Cognito
* Finished week 8 videos and activities

**Time spent 3/7/24- 2 hours**

Tasks completed:
* Added dependencies for Cognito to my pom file because they were unresolved 
* Created a User Pool and App Client for Diamond Poems but so far have not been able to obtain login
* Started exercise for week 8, I will be using the PetStore API since I haven't quite figured out how to use Textract

**Time spent 3/9/24- 30 minutes**
 
Tasks completed:
* Finished up week 8 exercise 

*Time spent 3/10/24- 30 minutes**

Tasks completed:
* Filled out learning tracker


### Spring Break

**Time spent- 3/11-3/17/2024**

Tasks completed:
* Started poem-add jsp with genres, moods in a form
* Got Cognito working(ish) in Diamond Poems. There is a funky error happening with my token 
"not being available until HH:MM:SS" but the time given is the time I request/use the token. 
When I went into my computer's settings and updated the time to be universal, 
I stopped getting this error. I will need to investigate this more since that is not a permanent fix.

### Week 9

**Time spent 3/18/24- 45 minutes**

Tasks completed:
* Set meeting date/time with team for project work
* Watched week 9 videos

**Time spent 3/19/24- 1.5 hours**

Tasks completed: 
* Created and sent out Teams meeting for tomorrow
* Worked on week 9 activity 
* Did the week 9 readings

**Time spent 3/20/24 - 1 hour**

Tasks completed:
* First team meeting where we came up with an idea for our team project

**Time spent 3/21/24- 1.25 hours**
* Started working on the week 9 exercise but I keep getting a 404 error and have not been able to debug


**Time spent 3/23/24- 1 hour**

Tasks completed:
* Worked on project plan and resume for group project

**Time spent 3/24/24- 3 hours**
Tasks completed:
* Found examples in AWS documentation to work with [S3](https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/java_s3_code_examples.html)
and [Textract](https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/java_textract_code_examples.html) and Java
* Wrote code for an S3 and Textract class
* Continued reworking my database to add a genre and a poem_genre table and map with hibernate

---

### Week 10 

**Time spent 3/26/24 3 hours**

Tasks completed:
* Added logout ability by removing userName attribute from servlet context
* Set team meeting for tomorrow
* Did some reading up on JAX-RS and the methods available in the Jackson and Jersey. I found an ObjectMapper class that I will try to implement to get the week 9 exercise working.
* Some updates to the add poem form