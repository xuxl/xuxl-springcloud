FROM java:8
VOLUME /tmp
VOLUME /target
ENV TZ "Asia/Shanghai"
ADD dockerfile.project.build.finalname.jar app.jar
EXPOSE 9411
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]