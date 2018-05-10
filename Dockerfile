FROM java:8
ADD /target/*.jar product-service.jar
ENTRYPOINT ["java","-jar","product-service.jar"]