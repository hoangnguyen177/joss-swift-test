mvn clean compile assembly:single

java -classpath .:JossTest-1.0-SNAPSHOT-jar-with-dependencies.jar edu.uq.test.JossTest
