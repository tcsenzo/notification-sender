#!/bin/bash

# Defaults
NOTIFICATIONS_HEAP_OPTS=${NOTIFICATIONS_HEAP_OPTS:--Xms512m -Xmx512m -XX:MaxMetaspaceSize=256m}

exec java -Dfile.encoding=UTF-8 $NOTIFICATIONS_HEAP_OPTS -jar $NOTIFICATIONS_HOME/notifications.jar --spring.config.location=file:///opt/notifications/application.properties
