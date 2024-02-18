FROM openjdk:17-alpine
MAINTAINER Tamra
EXPOSE 4200
ENV Tamra_PROPERTIES_LOCATION=/
# COPY ./target/classes/tamra-datatypes.json /
CMD ["echo", "Executable service to docker"]
COPY ./target/tamra-java-0.0.1-SNAPSHOT.jar /
CMD ["echo", "Running Application..."]
WORKDIR /
RUN chmod +x tamra-java-0.0.1-SNAPSHOT.jar
 # "-Tamra.properties.location=${Tamra_PROPERTIES_LOCATION}",
  CMD ["java", "-jar",  "./tamra-java-0.0.1-SNAPSHOT.jar"]




