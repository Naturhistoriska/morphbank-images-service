FROM openjdk:8-jdk-alpine

COPY target/morphbankImageService-thorntail.jar /usr/src/myapp/
WORKDIR /usr/src/myapp


ENTRYPOINT [""]
EXPOSE 8080
CMD ["java", "-jar", "morphbankImageService-thorntail.jar", "-Sinitdata"]
