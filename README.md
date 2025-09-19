# Java Snake Game

This is a classic Snake Game project developed in Java, with a focus on a modular and well-organized architecture. The main goal was to create a clean, maintainable application that demonstrates object-oriented programming (OOP) principles and software design.

## Game Features

* **Classic Gameplay:** The game follows the traditional Snake logic, where the snake grows by eating food and the game ends if it collides with the screen edges or its own body.
* **Dynamic Score:** The score is updated in real-time, displaying the player's current points.
* **Intuitive Interface:** A simple start screen with instructions and a "Game Over" screen to restart the game.
* **Controls:** The snake is controlled using the arrow keys (↑, ↓, ←, →).

---

## Project Structure

The project is divided into logical packages to ensure modularity and separation of concerns.

    
    src/
    └── br/
    └── com/
    └── snakegame/
    ├── core/          // Core game logic
    │   ├── GameState.java
    │   └── SnakeGame.java
    ├── graphics/      // GUI and rendering
    │   ├── GamePanel.java
    │   └── GameFrame.java
    ├── snake/         // Game entities (snake, food)
    │   ├── Direction.java
    │   ├── Food.java
    │   └── Snake.java
    └── Main.java      // Application entry point
    


### Package Details

* **`core`**: Contains the main game logic, such as the current state (`GameState`), the game loop, and collision detection. The `SnakeGame` class acts as the engine behind all the action.
* **`graphics`**: Responsible for the visual part of the game. `GameFrame` creates the main window, while `GamePanel` handles all the rendering of game elements (the snake, food, score, and menu/game-over screens).
* **`snake`**: Defines the game's entities. The `Snake` class manages the snake's movement and growth, `Food` handles the food's position, and `Direction` is an `enum` for movement directions.

---

## How to Run

1.  **Prerequisites:** Make sure you have the **Java Development Kit (JDK)** installed on your machine (version 8 or higher).
2.  **Clone the Repository:**
    ```bash
    git clone [https://github.com/your-username/your-repository.git](https://github.com/your-username/your-repository.git)
    cd your-repository
    ```
3.  **Compile and Execute:**
    Navigate to the `src` directory and use the `javac` command to compile the files, then the `java` command to run the main class.
    ```bash
    # Example compilation
    javac br/com/snakegame/Main.java

    # Example execution
    java br.com.snakegame.Main
    ```
    > **Tip:** For projects with multiple classes, it's recommended to use an IDE like IntelliJ IDEA, Eclipse, or VS Code to easily compile and run the project.

---

## Contribution

Feel free to open issues or pull requests if you have suggestions for improvements or find any bugs.

---

**Author:** Daniel(https://github.com/danieldelimax)
