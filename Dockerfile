FROM openjdk:19-alpine
RUN mkdir app
ADD /target/mobile-automain-test-1.0-SNAPSHOT.jar /app/mobile-automain-test.jar
WORKDIR /app
ENTRYPOINT java -jar mobile-automain-test.jar
CMD java -Xms${JAVA_XMS:-512m} -Xmx${JAVA_XMX:-1024m} -jar /opt/${APP}