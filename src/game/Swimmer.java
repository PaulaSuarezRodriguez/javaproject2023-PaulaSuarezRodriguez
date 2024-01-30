package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Swimmer extends Walker {
    private static Shape swimmerShape = new PolygonShape(-1.85f, 0.25f, -1.25f, 1.89f, -0.58f, 2.35f, 0.63f, 2.02f, 1.27f, 0.1f, 1.22f, -1.9f, -0.69f, -2.56f, -1.28f, -2.35f, -1.85f, 0.25f);
    private static BodyImage swimmerImage = new BodyImage("data/swimmer-left.png", 7);

    //Level one fields
    private int pricesCount = 0;
    private int crabsDestroyedCount = 0;
    private int collidedWithPearlCount = 0;
    private boolean collidedWithCrab;
    private boolean collidedWithPearl;



    //Level two fields
    private int bearsDestroyedCount = 0;
    private int collidedWithIglooCount = 0;
    private boolean collidedWithBear;
    private boolean collidedWithIgloo;



    //Level three fields
    private int collidedWithDesertFlowerCount = 0;
    private boolean collidedWithDesertFlower;



    //Level four fields
    private int collidedWithHarpCount = 0;
    private boolean collidedWithHarp;


    public Swimmer(GameLevel gameLevel) {
        super(gameLevel, swimmerShape);
        this.addImage(swimmerImage);
        this.setPosition(new Vec2(25f, -14f));
    }

    //LevelOne methods for counting or registering Swimmer collisions
    public void setPricesCount(int pricesCount) {
        this.pricesCount = pricesCount;

        //print message when a new seaweed is collected
        System.out.println("You have gained one more point: Prices collected = " + pricesCount);
    }

    public int getPricesCount() {
        return pricesCount;
    }

    public void setCollidedWithPearlCount(int collidedWithPearlCount) {
        this.collidedWithPearlCount = collidedWithPearlCount;

        //print message when pearl is collided with
        System.out.println("You have collided with a pearl: Level 1 is complete!");
    }

    public int getCollidedWithPearlCount() {
        return collidedWithPearlCount;
    }

    public void setCrabsDestroyedCount(int crabsDestroyedCount) {
        this.crabsDestroyedCount = crabsDestroyedCount;

        //print message when crab is destroyed
        System.out.println("You have gained one more point: Crab destroyed = " + crabsDestroyedCount);
    }

    public int getCrabsDestroyedCount() {
        return crabsDestroyedCount;
    }

    public boolean setCollidedWithCrab(boolean collidedWithCrab) {
        this.collidedWithCrab = collidedWithCrab;
        return collidedWithCrab;
    }

    public boolean getCollidedWithCrab() {
        return collidedWithCrab;
    }

    public boolean setCollidedWithPearl(boolean collidedWithPearl) {
        this.collidedWithPearl = collidedWithPearl;
        //return collidedWithPearl;
        return collidedWithPearl;
    }

    public boolean getCollidedWithPearl() {
        System.out.println("Collided with pearl");
        return collidedWithPearl;
    }



    //LevelTwo methods for counting or registering Swimmer collisions
    public void setCollidedWithIglooCount(int collidedWithIglooCount) {
        this.collidedWithIglooCount = collidedWithIglooCount;

        //print message when the igloo is collided with
        System.out.println("You have collided with an igloo: Level 2 is complete!");
    }

    public int getCollidedWithIglooCount() {
        return collidedWithIglooCount;
    }

    public void setBearsDestroyedCount(int BearsDestroyedCount) {
        this.bearsDestroyedCount = bearsDestroyedCount;

        //print message when bear is destroyed
        System.out.println("You have gained one more point: Bear destroyed = " + bearsDestroyedCount);
    }

    public int getBearsDestroyedCount() {
        return bearsDestroyedCount;
    }

    public boolean setCollidedWithBear(boolean collidedWithBear) {
        this.collidedWithBear = collidedWithBear;
        return collidedWithBear;
    }

    public boolean getCollidedWithBear() {
        return collidedWithBear;
    }

    public boolean setCollidedWithIgloo(boolean collidedWithIgloo) {
        this.collidedWithIgloo = collidedWithIgloo;
        return collidedWithIgloo;
    }

    public boolean getCollidedWithIgloo() {
        System.out.println("Collided with igloo");
        return collidedWithIgloo;
    }



    //LevelThree methods for counting or registering Swimmer collisions
    public void setCollidedWithDesertFlowerCount(int collidedWithDesertFlowerCount) {
        this.collidedWithDesertFlowerCount = collidedWithDesertFlowerCount;

        //print message when a desert flower is collided with
        System.out.println("You have collided with a desert flower: Level 3 is complete!");
    }

    public int getCollidedWithDesertFlowerCount() {
        return collidedWithDesertFlowerCount;
    }


    public boolean setCollidedWithDesertFlower(boolean collidedWithDesertFlower) {
        this.collidedWithDesertFlower = collidedWithDesertFlower;
        //return collidedWithPearl;
        return collidedWithDesertFlower;
    }

    public boolean getCollidedWithDesertFlower() {
        System.out.println("Collided with desert flower");
        return collidedWithDesertFlower;
    }



    //LevelFour methods for counting or registering Swimmer collisions
    public void setCollidedWithHarpCount(int collidedWithHarpCount) {
        this.collidedWithHarpCount = collidedWithHarpCount;

        //print message when the harp is collided with
        System.out.println("You have collided with a harp: Level 4 is complete!");
    }

    public int getCollidedWithHarpCount() {
        return collidedWithHarpCount;
    }


    public boolean setCollidedWithHarp(boolean collidedWithHarp) {
        this.collidedWithHarp = collidedWithHarp;
        return collidedWithHarp;
    }

    public boolean getCollidedWithHarp() {
        System.out.println("Collided with harp");
        return collidedWithHarp;
    }
}
