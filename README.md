# Ryanair test:

This project consist on an example to know how to test a feature on Ryanair websites.

## Getting Started

Clone the project and open it on Intellij  as Maven proyect.


### Prerequisites

-Intellij or similar
-Maven 2+
-JDK 6+
-Chrome Browser
-Chrome Driver (https://sites.google.com/a/chromium.org/chromedriver/)
-Selenium Server (http://www.seleniumhq.org/download/)

## Windows configuration

Once all the required tools are installed:

* create two new system variables:
    * JAVA\_HOME e.g.: JAVA\_HOME=C:\Program Files\Java\jdk1.7.0\_10
    * M2\_HOME e.g.: M2\_HOME=C:\Program Files\apache-maven-3.0.5

## Linux configuration

Is similar to Windows one.
Simply make sure that:
* JAVA\_HOME and M2\_HOME system variables are properly set.

## Mac configuration

Same thing as with Windows and Linux
You need to make sure that:
* JAVA\_HOME and M2\_HOME are set accordingly


### Installing

*Selenium server:

Create a folder and add inside the files:

-selenium-server-standalone-3.5.3.jar
-chromedriver.exe

For Windows you can create a Seleniumserver.bat file to be simple to run the server. The file should containt:
"java -jar selenium-server-standalone-3.5.3.jar"
Or you can run the server with the same command in a console.

*How to setup the project:
From the console or from the IDE, you have to generate resources for the proyect with this command
"mvn generate-resources"

To compile the project you should write in a console or from de IDE:
"mvn clean install"


###Running all the stories in IDE 

* Right-click on the RyanairTest class, select "Run 'RyanairTest'

This will run the build and (after a minute or so) Chrome will open and run your tests against the Ryanair website


## Viewing the results

To check the report you should go to:

Path where you have cloned the conde following "/WebRyanair/target/jbehave/view/"

for example:

C:/Users/YOUUSER/IdeaProjects/WebRyanair/target/jbehave/view/reports.html

Inside you can find the information about the test and you can click on the html link for more details for example on ryan_air_test.html
 
### And coding style tests

I have used to differents dates to run two scenarios

Feature: Test Ryanair Page

Scenario Outline: I want to test the error message when credit card number is wrong

Given I make a booking from <from> to <to> on <date> for <numAdult> adults and <numChild> child
When I pay for booking with card details <cardNumber> month <month> year <year> cvs <cvs>
Then I should get payment declined message <message>


Examples:
| from | to  | date       | numAdult | numChild | cardNumber          | month | year | cvs | message                |
| DUB  | SXF | 12/23/2017 | 2        | 1        | 5555 5555 5555 5554 | 10    | 2018 | 265 | Card number is invalid |
| DUB  | SXF | 01/16/2018 | 2        | 1        | 5555 5555 5555 5556 | 10    | 2018 | 265 | Card number is invalid |


## Authors

* Vicente Plasencia 

## Final notes:

- I have used "Thread.sleep" because I have some problems waiting for loading some components
- This proyect was develpoment on Windows and for Chrome, but should be fine to run on Mac


