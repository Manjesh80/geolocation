FROM openjdk:8
RUN mkdir -p /opt/ganesh/geolocation
ADD target/geolocation-0.0.1-SNAPSHOT.jar /opt/ganesh/geolocation/
EXPOSE 8080
CMD ["java", "-jar", "/opt/ganesh/geolocation/geolocation-0.0.1-SNAPSHOT.jar"]