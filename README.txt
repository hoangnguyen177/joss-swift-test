mvn clean compile assembly:single

copy joss-0.9.7.jar over
copy other jar files

java -classpath .:JossTest-1.0-SNAPSHOT.jar:joss-0.9.7.jar:httpcore-4.2.1.jar:httpclient-4.2.1.jar:slf4j-simple-1.6.4.jar:slf4j-api-1.7.2.jar:slf4j-simple-1.6.4.jar:commons-logging-1.2.jar:jackson-core-asl-1.9.7.jar:jackson-mapper-asl-1.9.7.jar:commons-lang-2.6.jar:commons-codec-1.10.jar edu.uq.test.JossTest