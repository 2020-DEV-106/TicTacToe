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
~~~