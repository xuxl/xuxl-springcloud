FROM java:8
VOLUME /tmp
ADD dockerfile.project.build.finalname.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 1001
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
