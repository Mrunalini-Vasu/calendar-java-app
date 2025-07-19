# Use Amazon Corretto JDK 17 image
FROM amazoncorretto:17

# Create app directory
WORKDIR /app

# Copy the Java source code to the container
COPY CalendarApp.java .

# Compile the Java file
RUN javac CalendarApp.java

# Run the Java program
CMD ["java", "CalendarApp"]
