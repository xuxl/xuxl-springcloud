FROM java:8
VOLUME /tmp
VOLUME /target
ENV TZ "Asia/Shanghai"
ADD dockerfile.project.build.finalname.jar app.jar
EXPOSE 2001
ENV PARAMS=""
ENTRYPOINT ["sh","-c","java $PARAMS -Djava.security.egd=file:/dev/./urandom -jar /app.jar"]