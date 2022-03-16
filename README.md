# Vintrace Coding Challenge
## Joshua Sommerfeld

This is literally my first ever Kotlin project. Feedback is certainly welcome. I hope it doesn't suck.

## Limitations
Given this was my first project, and I have other coding challenges and pressures on my time, I've delivered as much as I can in a reasonable time-frame.
This in total, including educating myself on Kotlin, Springboot and Gradle has taken my ~3 hours.
I'd obviously like to include more exhaustive tests and the rest of the endpoints, but given they're all variations on the same theme, I thought this was reasonable while also being respectful of my time.

## Setup
This Kotlin project is built via gradle targeting Java 11.
You'll need to install Java 11 to ensure this project runs.
I chose Java 11 because it's what I had, 17 could have been viable.

## Commands
Running the service
```
./gradlew bootRun
```

Running the tests:
```
./gradlew test
```

## Architecture Decision Register

### File System
I've utilised a modified MVC style framework:

* vintracecodingchallenge
  * /controllers
    * Methods that control the method chains required for single endpoint functionality
    * Handles HTTP responses other than 200 through spring exceptions
  * /fs
    * All methods related to file system integration
    * Instead of having a `utils` directory, I prefer to have meaningful package names
  * /handlers
    * Pure mathematical functions, such as aggregation calculation for the breakdown endpoints
  * models
    * Pure data models
  * VintraceCodingChallengeApplication
    * Main method, runs the server from here

### Resources
I decided to put the json files in resources for ease of access, realistically this would be a DB in a non-challenge environment.

### Functional
I've attempted to write this in a functional style, with integrative "side-effects" handled separately from anything that could be made purely mathematical.
The goal being to increase the ease of testing, as seen by BreakdownYearHandlerTest.
No mocking required, just get the math done.
