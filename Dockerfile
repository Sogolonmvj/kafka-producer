FROM openjdk:17
VOLUME /tmp
COPY target/*.jar producer.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/urandom", "-jar", "/producer.jar"]