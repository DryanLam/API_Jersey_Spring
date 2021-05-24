http://localhost:7000/api/books

$ maven spring-boot:run
$ maven clean packages
$ java -jar <name>.jar
>> java -jar Spring-Rest-Jersey-1.0.0-SNAPSHOT.jar

JACOCO
For TCP mode:
#1-server
java -javaagent:src/main/resources/jacoco/lib/jacocoagent.jar=address=*,port=36320,includes=com.sample.dl.*,output=tcpserver -jar target/Spring-Rest-Jersey-1.0.0-SNAPSHOT.jar


#2- Create jacoco-it.exec from tcpserver
java -jar src/main/resources/jacoco/lib/jacococli.jar dump --address localhost --port 36320 --destfile target/jacoco-it.exec

3 # Generate html report
java -jar src/main/resources/jacoco/lib/jacococli.jar report target/jacoco-it.exec --classfiles target/classes/com --sourcefiles src/main/java/ --html target/jacoco-report

For local file mode:
#1-file
java -javaagent:src/main/resources/jacoco/lib/jacocoagent.jar=address=*,port=36320,destfile=D:/test/jacoco-it.exec,dumponexit=true,includes=com.sample.dl.*,classdumpdir=D:/test/jacoco-dump/ -jar target/Spring-Rest-Jersey-1.0.0-SNAPSHOT.jar


java -jar src/main/resources/jacoco/lib/jacococli.jar report D:/test/jacoco-it.exec --classfiles target/classes/com --sourcefiles src/main/java/ --html target/jacoco-report


Issue:
1. Can NOT register by package due to Jersey issue. 
    Fixed: Use Reflections to create a scan method register each class

2. Reflections can NOT scan sub-class.
    The major difference between version 0.9.11 and 0.9.12 is that in 0.9.12 Guava dependency was removed in favor of Java 8 Streams API.
    Fixed: Add true to getTypesAnnotatedWith(Path.class, true)


IMPACT-ANALYSIS-MONGODB
 groovy -Dmongodb.host impactDetection.groovy