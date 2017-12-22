FROM maven:3-jdk-8

VOLUME /root/.m2/repository
VOLUME /data/app

WORKDIR /data/app

EXPOSE 80

ENV MAVEN_OPTS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000

ENTRYPOINT ["mvn"]

CMD ["spring-boot:run"]
