FROM openjdk:18
EXPOSE 8083
COPY target/busBalancer-0.0.1-SNAPSHOT.jar /busbalancerdocker.jar
ENTRYPOINT ["java", "-jar", "/busbalancerdocker.jar"]