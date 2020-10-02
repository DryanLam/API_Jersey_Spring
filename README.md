For master
http://localhost:7000/api/books

$ maven spring-boot:run
$ maven clean packages
$ java -jar <name>.jar
>> java -jar Spring-Rest-Jersey-1.0.0-SNAPSHOT.jar



Issue:
1. Can NOT register by package due to Jersey issue. 
    Fixed: Use Reflections to create a scan method register each class

2. Reflections can NOT scan sub-class.
    The major difference between version 0.9.11 and 0.9.12 is that in 0.9.12 Guava dependency was removed in favor of Java 8 Streams API.
    Fixed: Add true to getTypesAnnotatedWith(Path.class, true)