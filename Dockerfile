FROM tomcat:alpine

RUN ["rm", "-fr", "/usr/local/tomcat/webapps/DemoSpring01"]
RUN ["mkdir", "/usr/local/tomcat/webapps/DemoSpring01"]
RUN ["mkdir", "/usr/local/tomcat/webapps/DemoSpring01/etc"]
COPY ../etc/helloconfig.xml /usr/local/tomcat/webapps/DemoSpring01/etc/helloconfig.xml
COPY ./build/libs/DemoSpring01.war /usr/local/tomcat/webapps/DemoSpring01.war

CMD ["catalina.sh", "run"]
EXPOSE 8080