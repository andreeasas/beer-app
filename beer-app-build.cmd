

echo Script to build beer-app

@REM  1. Build Angular frontend

echo Build Angular frontend
cd src/main/angular/webapp/beer-app
ng build
@REM TODO make second step wait until ng build id done

@REM  2. Copy Angular files from dist/beer-app folder to backend

echo Copy Angular files from dist/beer-app folder to backend
cd ../../../../../
cd src/main/resources/
mkdir public
cd public
del "*.*" /s /f /q
copy "../../angular/webapp/beer-app/dist/beer-app/" *.*

@REM  3. Build and run backend project

cd ../../../../
rmdir target /s /q
mvn clean
mvn install







