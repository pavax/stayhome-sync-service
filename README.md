
##Sync Service


# Example

    ```
    curl -X POST "http://localhost:8080/api/business-entry/" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"categories\": [ \"A\", \"B\" ], \"delivery\": \"Bern, Köniz, Wabern, Liebefeld\", \"description\": \"Lorem Ipsum\", \"email\": \"test@example.com\", \"id\": \"1234\", \"name\": \"test company\", \"phone\": \"\", \"providerName\": \"datasource-xy\", \"website\": \"http://www.example.com\", \"zipCode\": \"3000\"}"
    ```

## Start Service using Docker

1. Clone the code from GitHub

    ```
    https://github.com/pavax/stayhome-sync-service.git
    ```

    This will create a "stayhome-sync-service" folder that will contain the project.

2. Run the docker-compose file
   
    ```
    cd stayhome-sync-service
    docker-compose -f docker-compose-local.yml up --build
    ```
 
  
3. Access the website at http://localhost:8080/swagger-ui.html.
