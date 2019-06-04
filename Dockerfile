FROM tomcat:alpine

RUN ["rm", "-fr", "/usr/local/tomcat/webapps/DemoSpring01"]

COPY ./build/libs/DemoSpring01.war /usr/local/tomcat/webapps/DemoSpring01.war

COPY ./etc/helloconfig.xml /usr/local/tomcat/webapps/etc/helloconfig.xml

CMD ["catalina.sh", "run"]
EXPOSE 8080