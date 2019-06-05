FROM tomcat:alpine

COPY ./etc/helloconfig.xml /usr/local/etc/helloconfig.xml

RUN ["rm", "-fr", "/usr/local/tomcat/webapps/DemoSpring01"]

COPY ./build/libs/DemoSpring01.war /usr/local/tomcat/webapps/DemoSpring01.war

CMD ["catalina.sh", "run"]
EXPOSE 8080