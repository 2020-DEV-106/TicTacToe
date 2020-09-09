# Tic Tac Toe Game
 This kata is developed in Java programming language by following TDD (Test Driven Development) approach.

# Rules
 The rules are described below :

 - X always goes first.
 - Players cannot play on a played position.
 - Players alternate placing X’s and O’s on the board until either:
 	- One player has three in a row, horizontally, vertically or diagonally
 	- All nine squares are filled.
 - If a player is able to draw three X’s or three O’s in a row, that player wins.
 - If all nine squares are filled and neither player has three in a row, the game is a draw.

# Prerequisite
 ~~~
 Java 1.8+
 Maven 3.6.3+
 JUnit 4.11+
 Mockito 1.10.19+
 ~~~
# Guidelines to pass input values when playing the game
~~~
1) The inputs should contain only whole numbers and a space.
2) The inputs should be in the format of <row number> followed by a <space> followed by <column number>.
3) The row number and column number are in the range 0 to 2.
4) Some Invalid inputs examples for your reference (-1 2), (4 0), ( 1), (12).
5) Please do not enter already played position again.
~~~
# Set up application
## IDE
~~~
1) Clone the repository https://github.com/2020-DEV-106/TicTacToe.git
2) Add as Maven project
3) Select Project SDK as JDK 1.8
~~~
## Command prompt
~~~
1) Clone repository from GIT 'https://github.com/2020-DEV-106/TicTacToe.git'
2) Run `mvn clean install`
~~~
# Steps to run the test cases in eclipse IDE
~~~
1) Download project as zip file and unzip it to a folder. 
2) In eclipse IDE, go to File menu -> Import -> Existing Maven Project -> Next -> 
   Browse to the folder in above step and import
3) Then, Right click project in Project Explorer window and 
   select Run As -> Maven install
4) Once above steps done open <b>GameTestSuite</b> class and right click  
   file and choose Run As -> JUnit Test
~~~
# Steps to run the application in command prompt
~~~
After successful maven build
Goto <ProjectDirectory>\target\classes and execute below command

java -classpath .\ com.tdd.kata.GameRunner 
Press Enter
Follow the instructions printed and provide the row and column values until the game ends!!