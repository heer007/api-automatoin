#mvn clean verify  serenity:aggregate -Dwebdriver.remote.url=http://localhost:4444/wd/hub -Dwebdriver.remote.driver=chrome  -Dwebdriver.driver=chrome -Pserenity
#mvn serenity:aggregate -Dwebdriver.driver=chrome -Pserenity
mvn clean verify


echo done
