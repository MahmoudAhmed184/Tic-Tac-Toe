# Tic Tac Toe Game

- This is a simple implementation of the classic Tic Tac Toe game in Java.

## Table of Contents
1. [Overview](#overview)
2. [Features](#features)
3. [Structure](#structure)
4. [Getting Started](#getting-started)
5. [Usage](#usage)
6. [Contributing](#contributing)

## Overview

- This is a simple implementation of the classic Tic Tac Toe game in Java. It currently offers two or more players gameplay with board representation, turn management, and game evaluation.

## Features

- Two or more players gameplay
- Board of any size
- Board representation and display
- Player turns and move validation
- Game evaluation to determine the winner

## Structure

- The game is divided into four classes located in the `com.tictactoe.game` package:

    1. `Board`: This class represents the game board. It has methods to display the board, update the board with a player's move, check if a move is valid, reset the board, check if there is move left, and check if there is a winning move.
    2. `Player`: This class represents a player. It has methods to get the player's name and symbol, and make a move on the board.
    3. `GameUtils`: This is a utility class with methods to get player details.
    4. `GameManager`: This class represents the game itself. It has methods to start the game, initialize players, switch player turns, and evaluate the game.

## Getting Started

### Prerequisites

- Java Runtime Environment (JRE) 11 or later

### Installation

1. Clone the repository:

```sh
git clone https://github.com/MahmoudAhmed184/Tic-Tac-Toe.git
```

2. Open the project in your preferred IDE (e.g., Visual Studio Code).
3. Open the `Main.java` file.
4. Run the `Main.java` class to start the game (consult your IDE's specific instructions for running Java programs).

## Usage

- The game will prompt you for player names and guide you through turns. 

## Contributing

- Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.