# Set the base image to java8
FROM vixns/java8

MAINTAINER Leonardo Wolter <leocwolter@gmail.com>

# Define environment variables
ENV NOTIFICATIONS_HOME=/opt/notifications

# Add artifacts
ADD build/notifications.jar $NOTIFICATIONS_HOME/notifications.jar
ADD build/application.properties $NOTIFICATIONS_HOME/application.properties
ADD run.sh $NOTIFICATIONS_HOME/run.sh

# Main command
ENTRYPOINT $NOTIFICATIONS_HOME/run.sh