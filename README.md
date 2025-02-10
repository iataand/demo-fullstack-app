# Demo fullstack app using React(Vite), Springboot and a docker container running a mongodb database.

## Requirements for running the project locally:
  * node
  * gradle or maven
  * docker

## To run the application:
1. ```docker compose up``` from ```./backend``` starts a docker container running the latest mongodb image
2. ```./gradle bootrun``` starts the backend
3. ```npm i && npm run dev``` from ```./frontend``` starts the React app
