# Use the official Tomcat image as the base
FROM tomcat:9.0

# Copy the WAR file to the webapps directory of Tomcat
COPY target/java-form-app.war /opt/tomcat-production/webapps/

# Expose the port
EXPOSE 8082

# Start Tomcat
CMD ["catalina.sh", "run"]

