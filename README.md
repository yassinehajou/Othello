# Othello Game Project

## Table of Contents
- [Description](#description)
- [Rules](#rules)
  - [Game Example](#game-example)
- [Features](#features)
- [Development](#development)
  - [Prerequisites](#prerequisites)
  - [Getting Started](#getting-started)
- [Running The Code](#running-the-code)
- [Code Structure](#code-structure)
- [Demonstrated Skills](#demonstrated-skills)

## Description
Welcome to the Othello Game Project! This is a fully functional console-based version of the classic board game Othello (also known as Reversi), developed in Java. This project showcases key programming concepts such as object-oriented design, game logic implementation, and file I/O operations. The game allows players to compete against each other by making strategic moves, flipping their opponent's pieces, and ultimately aiming to have the most pieces on the board when the game ends.

The game supports different starting positions, including the traditional Othello setup and several offset variations, giving players a fresh twist on the classic gameplay. Additionally, the game offers options to save and load progress, enabling players to continue their match at any time.

## Rules

- Game Objective: The goal of Othello is to have more of your pieces on the board than your opponent by the end of the game.
- Board Setup: The game is played on an 8x8 board. Players take turns placing their pieces, starting with two black and two white pieces in the center of the board in a diagonal formation.
- Player Turns: Players take turns placing one piece on the board in an empty square. The placed piece must sandwich one or more of the opponent’s pieces between two of the player’s own pieces, either horizontally, vertically, or diagonally.
- Flipping Pieces: When a valid move is made, all of the opponent’s pieces that are sandwiched between the placed piece and another piece of the current player are flipped to the current player’s color.
- No Valid Move: If a player has no valid moves, they must pass their turn to the opponent.
- End of Game: The game ends when neither player can make a valid move, usually when the board is full. The player with the most pieces of their color on the board wins. If both players have the same number of pieces, the game ends in a tie.

### Game Example
Starting Board:

<img width="111" alt="image" src="https://github.com/user-attachments/assets/0cb3452b-2ee6-48a8-a553-432563933eb2"> 

First Play by "B" to flip "W" between the two "B" pieces:

<img width="112" alt="image" src="https://github.com/user-attachments/assets/98c61cb4-db8a-4f7b-993b-c98fb4de5bab">

Second Play by "W" to flip "B" between the two "W" pieces:

<img width="113" alt="image" src="https://github.com/user-attachments/assets/7ff5b06f-a5e6-4e75-8f24-b3007b6eeaa6">

Third Play by "B" to flip the two "W" (diagonal+horizontal)

<img width="113" alt="image" src="https://github.com/user-attachments/assets/376946a2-5fcd-4066-8085-c33e658c6036">

## Features

- Customizable Starting Positions: Choose between the standard Othello setup or one of four offset positions for a varied gameplay experience.
- Player Interaction: Supports two-player gameplay with an intuitive command-line interface.
- Move Validation: Ensures that all moves are legal according to Othello rules before they are made.
- Automatic Piece Flipping: Pieces are automatically flipped when valid moves are made, streamlining gameplay.
- Save and Load Game: Save your game to a file and load it later to continue playing from where you left off.
- Game Over Detection: Automatically detects when the game is over and announces the winner or if the game ends in a tie.

## Development
### Prerequisites

To run this project, you need to have the following installed on your machine:
- Java Development Kit (JDK): Version 8 or later.

### Getting Started

1. Download the Project:
  - Click the green "Code" button at the top of this repository.
  - Select "Download ZIP" and extract the contents to a directory of your choice.    
2. Compile the Project:
- Open your terminal or command prompt.
- Navigate to the directory where you extracted the project files.
- Compile the Java files using the following command:
  ```
  javac Main.java 
  ```
3. Run the game:
- After compiling, start the game by running:
  ```
  java Main
  ```
## Running The Code
When you launch the game, you will be presented with the main menu, where you can:

- Start a New Game: Begin a fresh game by entering the names of the players and choosing your preferred starting position.
- Load a Saved Game: Resume a previously saved game by specifying the filename.
- Quit: Exit the game.

During the game, you can:

- Make Moves: Enter board positions using standard A1 notation to place your pieces.
- Save Progress: Save the current game state to a file, allowing you to load and continue later.
- Concede: Concede the game if you believe victory is unattainable.
- End Turn: Automatically switches turns between players, ensuring a smooth gameplay experience.

## Code Structure

- Main.java: The entry point of the application. It handles the game menu and initializes the game.  
- Game.java: Manages game flow, including player setup, board initialization, and turn management.
- Board.java: Handles the main game logic, including move validation, piece flipping, game state management, and saving/loading functionality.
- Player.java: Represents each player, storing their name and assigned piece (Black or White).
- Position.java: Represents each board position, with derived classes implementing game-specific logic for move validation and piece flipping.
- PlayablePosition.java: Extends Position to implement Othello-specific logic, including legal move checking and piece flipping.

## Demonstrated Skills

This project demonstrates a wide range of software engineering skills, including:

- Object-Oriented Design: The codebase is structured using OOP principles, with clear separation of concerns across different classes.
- Game Logic Implementation: The Othello rules are accurately implemented, including move validation, piece flipping, and game-over detection.
- File I/O Operations: The game state can be saved to and loaded from a file, demonstrating proficiency in handling file operations in Java.
- User Interface Development: The game features a simple yet effective command-line interface, allowing for user interaction and input.
