
# QA Project

This is the final project for the Software Engineering bootcamp offered by [QA]. The project showcases my skills and knowledge gained during this time. The goal was to create a **Spring Boot API**, with utilisation of supporting tools, methodologies, and technologies, that encapsulates all fundamental and practical modules covered during training.

### Why are we doing this?

During our last week of the bootcamp we were given the task of completing a project that would demonstrate our skills and knowledge using:

  - Agile & Project Management (Git, Jira)
  - Databases & Cloud Fundamentals (Azure, MySQL)
  - Programming Fundamentals (Java)
  - API Development (Spring Boot)
  - Automated Testing (JUnit, Mockito)

### How I expected the challenge to go.

Initially the project seemed daunting and I was worried that I would not get it finished on time but breaking down tasks into manageable parts using [Jira] helped a lot.

### What went well? / What didn't go as planned?

Project setup such as database and table creation, implementing the repository, services and controllers went well.  

Testing did not go well and to complete it I had to do self-learning by reading articles on service, repository and controller testing using Mockito and JUnit. [Baeldung] is a good resource not only for testing but for all areas of Java and Spring. 

Creating custom controller queries was a little more challenging.


### Possible improvements for future revisions of the project.

Planned for improving this API is to include more database tables and join queries to provide more endpoints. I  plan to build a front end to consume these endpoints to allow for a full stack real-world application.


#### Screenshots showing your HTTPie requests and the output from the API.

![GET by id](https://imgur.com/heATWgT)

![GET all](https://imgur.com/CgEXzHt)


####  Screenshots of database to prove that data is being persisted.

![Database](https://imgur.com/CE5aMXf)


#### Screenshot of test results, including coverage report.

![Testing](https://imgur.com/PYoqQ1J)


####  API Endpoint Testing

The Spring Boot API is currently deployed to AWS Elastic Beanstalk and can be tested using a browser by going to the following links:

 - [GET all database table data] 
- [GET one database table entry by id]

More testing can be done using [Postman] or [HTTPie] to use other requests like post, put or delete using a JSON copy of a table entity in the body section and using **add**, **update** and **delete** as an endpoint and the respective HTTP method.

[GET all database table data]:http://voltcarhire-env.eba-sxer3vyq.eu-west-2.elasticbeanstalk.com/customers/all
[GET one database table entry by id]:http://voltcarhire-env.eba-sxer3vyq.eu-west-2.elasticbeanstalk.com/customers/1
[Postman]:https://www.postman.com/
[HttPie]:https://httpie.io/app
[Baeldung]:https://www.baeldung.com/
[Jira]:https://chriscarrqaproject.atlassian.net/jira/software/projects/QP/boards/1/backlog?selectedIssue=QP-11
[QA]:https://www.qa.com/
