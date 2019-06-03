FROM tomcat:alpine

RUN ["rm", "-fr", "/usr/local/tomcat/webapps/ROOT"]
COPY ./build/libs/DemoSpring01.war /usr/local/tomcat/webapps/ROOT.war

CMD ["catalina.sh", "run"]
EXPOSE 8080