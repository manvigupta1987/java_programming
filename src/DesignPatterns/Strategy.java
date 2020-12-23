package DesignPatterns;

//Structural Design Pattern

// It is used when we have multiple algorithm for a task and client decides the actual implementation to be used at run time.
// One of the best example of strategy pattern is Collections.sort() method that takes Comparator parameter. Based on the different implementation of comparator
// interface the objects are getting sorted in different ways.

//In computer programming, the strategy pattern (also known as the policy pattern) is a software design pattern that enables an algorithm’s behavior to be selected at runtime. The strategy pattern
//
//defines a family of algorithms,
//encapsulates each algorithm, and
//makes the algorithms interchangeable within that family.”


// Read This : https://www.geeksforgeeks.org/strategy-pattern-set-1/?ref=rp
// Suppose we are building a game “Street Fighter”. For simplicity assume that a character may have four moves that is kick, punch, roll and jump. Every character
// has kick and punch moves, but roll and jump are optional. How would you model your classes?

// So, in strategy pattern, we use composition instead of inheritence.

public class Strategy {
    public static void main(String[] args) {
        // Create some behavior first.
        JumpBehavior shortJump = new ShortJump();
        JumpBehavior longJump = new LongJump();

        KickBehavior lightningKick = new LightningKick();
        // Fighter Ken
        Fighter ken = new Ken(lightningKick, longJump);
        ken.display();
        ken.punch();
        ken.roll();
        ken.kick();
        ken.jump();

        //Change Behavior dynamically
        ken.setJumpBehavior(shortJump);
        ken.jump();
    }
}

abstract class Fighter {
    KickBehavior kickBehavior;
    JumpBehavior jumpBehavior;

    Fighter(KickBehavior kickBehavior, JumpBehavior jumpBehavior) {
        this.kickBehavior = kickBehavior;
        this.jumpBehavior = jumpBehavior;
    }

    public void punch() {
        System.out.println("Default Punch");
    }

    public void roll() {
        System.out.println("Default roll");
    }

    public void jump() {
        jumpBehavior.jump();
    }

    public void kick() {
        kickBehavior.kick();
    }

    public void setKickBehavior(KickBehavior kickBehavior) {
        this.kickBehavior = kickBehavior;
    }

    public void setJumpBehavior(JumpBehavior jumpBehavior) {
        this.jumpBehavior = jumpBehavior;
    }

    abstract void display();
}

interface KickBehavior {
    void kick();
}

class LightningKick implements  KickBehavior {
    @Override
    public void kick() {
        System.out.println("Lightning Kick");
    }
}

class TornadoKick implements  KickBehavior {
    @Override
    public void kick() {
        System.out.println("Toranodo Kick");
    }
}

interface JumpBehavior {
    void jump();
}

class ShortJump implements JumpBehavior {
    @Override
    public void jump() {
        System.out.println("Short Jump");
    }
}

class LongJump implements JumpBehavior {
    @Override
    public void jump() {
        System.out.println("Long Jump");
    }
}

// Characters :

class Ryu extends Fighter {

    Ryu(KickBehavior kickBehavior, JumpBehavior jumpBehavior) {
        super(kickBehavior, jumpBehavior);
    }
    @Override
    void display() {
        System.out.println("Ryu");
    }
}

class Ken extends Fighter {

    Ken(KickBehavior kickBehavior, JumpBehavior jumpBehavior) {
        super(kickBehavior, jumpBehavior);
    }
    @Override
    void display() {
        System.out.println("Ken");
    }
}

class ChunLi extends Fighter {

    ChunLi(KickBehavior kickBehavior, JumpBehavior jumpBehavior) {
        super(kickBehavior, jumpBehavior);
    }
    @Override
    void display() {
        System.out.println("ChunLi");
    }
}




