# Sandbox use case - Early Warning
# Data Ingestion Service
Microservice which is responsible for fetching the threats from the 3rd party data vendors.
Once the data is received, it's processed and published to threat service, via Information Mediator.
For testing the Early Warning system, check the user service for credentials:

# Tech stack
Microservice is using the following: <br>
Java 17, Spring Boot, Kafka pub/sub, Docker/Helm charts for deployment.

# Note
In order to test the Early Warning system, make sure to run the rest of the services and frontend.