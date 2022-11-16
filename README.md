## Executing the tests
To run the sample project, you can either just run the `CucumberTestSuite` test runner class, or run either `mvn verify` or `gradle test` from the command line.

By default, the tests will run using Chrome. You can run them in Firefox by overriding the `driver` system property, e.g.
```json
$ mvn clean verify -Ddriver=firefox
```
Or
```json
$ gradle clean test -Pdriver=firefox
```

The test results will be recorded in the `target/site/serenity` directory.
# ssh to box
ssh ubuntu@10.21.33.145
# password
password: rxm8Z6JbwfwCw38
username: admin
Jenkins
/usr/lib/systemd/system/jenkins.service

command to start jenkins 
 cd to war location fromm above file and
 java -jar jenkins.war --httpPort=9090 &


reference for api test
https://github.com/cvenkatreddy/restassured-serenity-cucumber/blob/master/pom.xml
https://serenity-bdd.github.io/theserenitybook/latest/serenity-rest.html
  https://github.com/serenity-bdd/serenity-rest-starter/blob/master/pom.xml

https://serenity-bdd.github.io/theserenitybook/latest/serenity-screenplay-rest.html


#GraphQL
https://applitools.com/blog/writing-tests-graphql-apis-rest-assured/

