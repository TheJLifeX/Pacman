# Pacman

Pacman World, PacmanAgent, Depth-First Search, Breadth-first search, Uniform Cost Search( Dijkstra ), Best-first search, A* Search .

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them


#### - [Eclipse JAVA JEE](https://www.eclipse.org/downloads/packages/release/2018-09/r/eclipse-ide-java-ee-developers)

#### - [Java SE Runtime](https://www.oracle.com/technetwork/java/javase/downloads/index.html)


Installing
--
- Clone the project.
- Import the pacman project in eclipse.
```
File → Import... → General → Existing Projects into Workspace.
Select the pacman file.
```
- Config the pacman agent.
```
Project → Properties → Java Build Path → Libraries → AddJARS… → PacmanAgent → Server.jar
( add if not already set )
```
- Start the server ( pacman world )
```
Select the Server.jar file in your package explorer and select in the menu
Run -> Run as -> Java Application
```
- Start the client ( pacman agent )
```
Select the MyAgent.java file in your package explorer and select in the menu
Run -> Run as -> Java Application
```
- Start the game
```
In the Pacman Window
click on the 'Start game' button
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc

