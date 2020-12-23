package DesignPatterns;

// Structural Design Pattern

//Template method design pattern is to define an algorithm as a skeleton of operations and leave the details to be implemented by the child classes.
// The overall structure and sequence of the algorithm is preserved by the parent class.

// We are going to create a Game abstract class defining operations with a template method set to be final so that it cannot be overridden.
// Cricket and Football are concrete classes that extend Game and override its methods.

public class TemplatePattern {
    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }
}

abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    //Template method. It should not be overridden.
    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }
}

class Cricket extends Game {

    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started! Enjoy.");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }
}

class Football extends Game {
    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started! Enjoy.");
    }

    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }
}

