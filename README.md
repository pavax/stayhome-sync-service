
##Sync Service


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
