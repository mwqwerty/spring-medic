FROM maven:3.5.2-jdk-8-alpine AS BUILD_IMAGE
RUN rm -r /tmp/
COPY pom.xml /tmp/
COPY src /tmp/src/
COPY .git /tmp/.git
WORKDIR /tmp/
RUN mvn -Pdev clean install package

FROM openjdk:8-alpine
COPY --from=BUILD_IMAGE /tmp/targt/SpringBootSecond*.jar ./springbootsecond.jar
ENTRYPOINT ["/usr/bin/jav"]
CMD ["-jar","/springbootsecond.jar"]
VOLUME /var/lib/springbootsecond/config-repo
EXPOSE 8080