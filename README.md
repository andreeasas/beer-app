

Backend:
    - java
    - run BeerAppApplication

Frontend: 
    - angular
    - before running app:
        src/main/angular > npm install -g @angular/cli
        src/main/angular > npm install
    - run frontend app:
        src/main/angular > ng serve --open

Logging: 
    - used log4j2-spring -> logs are saved in .logs folder

Api documentation: 
    - run the spring boot application and browse http://localhost:8080/swagger-ui.html

Future plans: