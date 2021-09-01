

BEER APP DETAILS:

    - http://beerapp001snapshot-env-2.eba-rkwqzkgm.eu-central-1.elasticbeanstalk.com/api.beer.app/beers <br />
    - http://beerapp001snapshot-env-2.eba-rkwqzkgm.eu-central-1.elasticbeanstalk.com/#/beers <br />

Deploying the app:

   1. Build Angular frontend

       src/main/angular > npm install -g @angular/cli <br />
       src/main/angular > npm install <br />
       angularCli > ng build --prod <br />
    
       -> 'dist' folder is created (src/main/angular/webapp/beer-app/dist). <br />
       This contains another folder named as the angular app (beer-app) containing some html, js and css files. <br />

   1. Copy the files from dist/beer-app folder to backend <br />
   
      Copy the files from src/main/angular/webapp/beer-app/dist/beer-app into your backend /src/main/resources/public/ <br />

   2. Build the backend project <br />

      my-app > mvn clean <br />
      my-app > mvn install <br />

      -> generates target folder with my-app-0.0.1-SNAPSHOT.jar <br />

   3. Run the beer-app <br />

      beer-app.target > java -jar my-app-0.0.1-SNAPSHOT.jar <br />
   -> access app at http://localhost:8080/#/beers <br />

      backend - http://localhost:8080/api.beer.app/beers <br />
      frontend - http://localhost:8080/#/beers <br />


Running the app without building the jar: <br />
1. Backend: <br />
        - java <br />
        - run BeerAppApplication <br />
    
2. Frontend: <br />
        - angular <br />
        - before running app: <br />
            src/main/angular > npm install -g @angular/cli <br />
            src/main/angular > npm install <br />
        - run frontend app: <br />
            src/main/angular/webapp/beer-app/src/app > ng serve --open <br />

Logging: <br />
    - logs are saved in .logs folder <br />

Api documentation: <br />
    - run the spring boot application and browse http://localhost:8080/swagger-ui.html <br />

