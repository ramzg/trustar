# TruSTAR coding challenge

Build the project:
```
$ git clone git@github.com:ramzg/trustar.git
$ cd <local-repo-path>
$ mvn clean install
...
...
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building true-star-coding-exercise 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO]
...
...
[INFO] Installing <path>/true-star-coding-exercise-1.0-SNAPSHOT-jar-with-dependencies.jar to 
<path>/.m2/repository/com/trustar/coding/challenge/true-star-coding-exercise/1.0-SNAPSHOT/true-star-coding-exercise-1.0-SNAPSHOT-jar-with-dependencies.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 14.604 s
[INFO] Finished at: 2018-08-05T23:06:42-07:00
[INFO] Final Memory: 25M/83M
[INFO] ------------------------------------------------------------------------
```
Execute the jar file:
```
$ java -jar <path>/true-star-coding-exercise-1.0-SNAPSHOT-jar-with-dependencies.jar [[[[1],2,[3]],[[1,2,[3],6],4]],[[1,2,[3]],4]]

Nested Integer: [[[[1],2,[3]],[[1,2,[3],6],4]],[[1,2,[3]],4]]
Flattened List: [1, 2, 3, 1, 2, 3, 6, 4, 1, 2, 3, 4]
```
