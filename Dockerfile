FROM selenium/standalone-chrome

VOLUME /tmp
ARG JAR_FILE=bddjar-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar


ADD protractor.sh /protractor.sh

WORKDIR /protractor
ENTRYPOINT ["/protractor.sh"]
