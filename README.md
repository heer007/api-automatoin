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

#Fix for CORS issue in JENKINS
System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "")
System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "default-src 'self'; style-src 'self' 'unsafe-inline';")
System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "default-src * 'unsafe-inline' 'unsafe-eval'; script-src * 'unsafe-inline' 'unsafe-eval'; connect-src * 'unsafe-inline'; img-src * data: blob: 'unsafe-inline'; frame-src *; style-src * 'unsafe-inline';")

#urls
https://api.testnet.zestbloom.com/ion/graphql
https://www.notion.so/58e287c772904cc8b12ba8ba877a7eab?v=e01243163f334d87a17dbbcc7160b982       
https://ion.testnet.zestbloom.com/docs#/assets/get_assets_assets__network___get 


#Image Search code
curl --request GET \
--url 'https://zestbloom-image-search-api.p.rapidapi.com/v1/search?limit=32&q=sauce&network=algo&showNsfw=false' \
--header 'X-RapidAPI-Host: zestbloom-image-search-api.p.rapidapi.com' \
--header 'X-RapidAPI-Key: 2db187e986msh875835bb365f226p1ef17ajsn593a61a2f032'
=======
#zestbloom search api
curl --request GET \
--url 'https://zestbloom-image-search-api.p.rapidapi.com/v1/search?limit=32&q=sauce&network=algo&showNsfw=false' \
--header 'X-RapidAPI-Host: zestbloom-image-search-api.p.rapidapi.com' \
--header 'X-RapidAPI-Key: 2db187e986msh875835bb365f226p1ef17ajsn593a61a2f032'

# Search API web page
https://rapidapi.com/zestbloom-inc-zestbloom-inc-default/api/zestbloom-image-search-api
