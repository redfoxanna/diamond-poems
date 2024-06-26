# Diamond Poem Archives

---

## Problem Statement

At the beginning of our weekly Thursday game night, my friends and I often kick things off with a warm-up we've coined "Diamond Poems." It's a collaborative poem writing exercise where each person contributes one line at a time on scraps of paper, with only the previous line visible. This unique format leads to the creation of hilarious, creative, and sometimes thought-provoking poems.
But, as the night winds down, these poetic masterpieces face an uncertain fate – they're scattered, misplaced, and often lost to the night. Well, almost all of them, because there's this one friend (*ahem* Brooke!) who manages to collect and safeguard them all.

Enter my project idea: envision a Java application that would interface with an Optical Character Recognition (OCR) API. This would transform the images of our handwritten Diamond Poems into searchable text. Now, no longer will these poetic gems be lost to the passage of time. They're immortalized, ready to be easily retrieved whenever the waves of nostalgia hit.

Examples of a diamond poem:

[Diamond poem *cute* example](images/poem1.jpg)

[Diamond poem *sweet* example](images/poem2.jpg)

[Diamond poem *dark* example](images/poem3.jpg)

[Diamond poem *profane* example](images/poem4.jpg)

Diamond Poems (the writing exercise) is inspired by:
[Diamonte Poems Wikipedia](https://en.wikipedia.org/wiki/Diamante_poem#:~:text=A%20diamante%20poem%2C%20or%20diamond,%3A%20The%20Diamante%20(1969))

What is OCR?
[OCR Wikipedia](https://en.wikipedia.org/wiki/Optical_character_recognition)

---
### Project Technologies/Techniques

* Security/Authentication
    * AWS Cognito
* Database
    * MySQL 8.0.22
* ORM Framework
    * Hibernate 5
* Dependency Management
    * Maven
* Web Services consumed using Java
    * AWS Textract
    * AWS S3
* CSS
    * Bootstrap 3.3.7
* Logging
    * Log4J2
* Hosting
    * AWS Elastic Beanstalk
* Independent Research Topic/s
    * CI tools in AWS
    * OCR API
* Unit Testing
    * JUnit 5 tests to achieve 80%+ code coverage
* IDE: IntelliJ IDEA

---

### Design
* [Screen Design](DesignDocuments/Wireframes)
* [Design Considerations](DesignDocuments/design-considerations.pdf)
* [Application Flow](DesignDocuments/diamond-poems-flowchart.pdf)
* [Database Design](DesignDocuments/ERD.png)

### Project Planning
* [User Stories](DesignDocuments/user-stories.md)
* [Error Handing OCR](DesignDocuments/error-handling.pdf)
* [Tasks](DesignDocuments/project-plan.md)

### Documentation of progress, reflections, and time spent on this project
* [Weekly Refelection](WeeklyReflection.md)
