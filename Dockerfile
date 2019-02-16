FROM openjdk:8-jre
ADD /build/libs/gs-spring-boot-0.1.0.jar /cpo.jar
CMD ["java", "-jar", "cpo.jar"]
