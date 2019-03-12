# UnitOptimisationApi
UnitOptimisationApi 

Unint Optimization project help to solve unit optimisation problem.

Based on java 8 and Springboot framework, project provide two different algorithms to solve problem
recursive and iterative. 

**Run**

* Clone repository to local machine then execute **./gradlew build** to build project.
* Project executable could be run as java on local machine or using **docker** (gradle tasks).
* To run inside  docker container use  **./gradlew  clean build startDocker** 
* To stop docker container use **./gradlew stopDocker**
* Project could be run locally **./gradlew  clean build && java -jar build/libs/gs-spring-boot-0.1.0.jar**
* Run ./gradlew test for tests.


*Project exposed to 8080 port as docker and as local build.*

Available two different API for different algorithm execution types /recursiveStrategy and /iterativeStrategy

curl -X POST \
  http://localhost:8080/recursiveStrategy \
  -H 'Content-Type: application/json' \
  -H 'cache-control: no-cache' \
  -d '{"rooms": [35, 21, 17], "senior": 10,"junior": 6 }'


curl -X POST \
  http://localhost:8080/iterativeStrategy \
  -H 'Content-Type: application/json' \
  -H 'cache-control: no-cache' \
  -d '{"rooms": [35, 21, 17], "senior": 10, "junior": 6 }'
	
	
Response available as JsonObject 
[
    {
        "senior": 3,
        "junior": 1
    },
    {
        "senior": 1,
        "junior": 2
    },
    {
        "senior": 2,
        "junior": 0
    }
]	
	
	
	
	
	
	
	
