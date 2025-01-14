FROM openjdk:22-ea-19-oraclelinux8
COPY target/ipsearcher-0.0.1-SNAPSHOT.jar app/find-city.jar
ENTRYPOINT java -jar /app/find-city.jar