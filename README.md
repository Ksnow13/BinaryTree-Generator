 Binary Search Trees
--------------------------------------------------------------------------------------------------------------------------------
Simple java program that allows you to generate/store/view binary trees in json format. 
This project uses MySQL Workbench,and program can also run with a Docker Container.
--------------------------------------------------------------------------------------------------------------------------------
How To Work the Program:

 - First Have MySQL Workbench running a local instance and create a database called finalsprint_soloproject_db
   OR name it anything you want as long as your change the name in the application.properties and docker-compose.yml files.
   
 - Once your created your database, run the file called RestServiceApplication
 - When you run the program all the tables and relationship will be created in your MySQL database automatically.

 - Once you started the server you can go to your browser and type http://localhost:8080/
 - Press enter numbers and start creating trees!
 - All trees created will be store to the database

--------------------------------------------------------------------------------------------------------------------------------
HOW TO RUN WITH DOCKER CONTAINER

- Have Docker installed on your machine.
- Have the project opened in your environment then go to the terminal.
- type: docker build -t my_docker_container .
- After running that, type docker-compose up
- Once you enter that command the container should be up and running.
- The API and website should now be accessible at http://localhost:8080

