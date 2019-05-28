#!/bin/bash
Xvfb :99 &
export DISPLAY=:99
java -jar /app.jar -g com.ibm.scw.cod.purchase classpath:feature -t @cod $@