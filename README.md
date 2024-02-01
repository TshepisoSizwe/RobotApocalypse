# RobotApocalypse

# My Spring Boot Api

Welcome to the documentation for My Spring boot API.
The API facilitates:

Saving survivors with personal details like name, age, gender, ID, last location, and inventory resources (Water, Food, Medication, Ammunition).
Updating survivor location with latitude/longitude.
Flagging survivors as infected based on at least 3 infected survivors within the same location(longitude,latitude).
Connecting to the Robot CPU system for displaying Flying and land robots' locations. Additionally, it provides reports on infected and non-infected survivors' percentages, along with lists of infected survivors, non-infected survivors, and robots..

## Table of Contents
- [Getting Started](#getting-started)
- [Endpoints](#endpoints)



## Getting Started

1. Download and open project with your choice of IDE.

2. Build project to download dependencies.

3. Use the following URL to access database via browser.
  http://localhost:8080/h2-console to access H2


4. Ensure JDBC URL is set to jdbc:h2:mem:zombies    

5. 	Select table to check connectivity. 
6. You may use Postman to make use of exposed end points


## Endpoints

### /api/robot

- `GET` /api/robots/   :   Test access to end point.
- `GET`/api/robots/all-robots   :   Retrieves all robots.


### /api/Survivor

- `GET` api/survivors/   :   Test access to end point.
- `GET` api/survivors/all-survivors   :   Get all the survivors.
- `POST` api/survivors/save-survivor   :  Create a new survivor.
- `GET` api/survivors/survivor/survivorId   :   Get a survivor with a given survivorId.
- `PUT` api/survivors/survivor/{id}/location   :   Update a survivor location given survivorId.
- `PUT` Api/survivors/{survivorId}/updateInfectionStatus   : Update the next survivor infection status within the same location if atleast 3 survivors are infected using given survivorId.
  
- `PUT` api/survivors/survivor/survivorId/flag-survivor   :  Flag survivor as infected with given survivorId.
- `GET` api/survivors/survivors/infected    :   Get all survivors that are infected.
- `GET` api/survivors/survivors/uninfected   :   Get all survivors that are not infected.
- `GET` api/survivors/infected-percentager    :   Calculate percentage of infected survivors.
- `GET` api/survivors/non-infected-percentage    :  Calculate percentage of infected survivors.
                                              



