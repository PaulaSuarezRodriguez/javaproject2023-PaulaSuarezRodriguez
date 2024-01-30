package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

public abstract class GameLevel extends World {
    private static StaticBody ground;
    private Swimmer swimmer;
    private Enemies walrus1, walrus2, walrus3;

    public GameLevel(Game game){

        //make a ground platform
        Shape shape = new BoxShape(70f, 0f);
        ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -16f));

        //make the walls
     /*   Shape wallShape = new BoxShape(0f, 60);
        StaticBody leftWall = new StaticBody(this, wallShape);
        leftWall.setPosition(new Vec2(-63f, 34));
        StaticBody rightWall = new StaticBody(this, wallShape);
        rightWall.setPosition(new Vec2(50f, 34)); */

        // Creation of Swimmer object (character)
        swimmer = new Swimmer(this);

        // Creation of pickup objects/prices
        SwimmerCollisions seaweedPickup = new SwimmerCollisions(swimmer, this, game);
        swimmer.addCollisionListener(seaweedPickup);
    }

    //Getter method for swimmer (object from Swimmer class)
    public Swimmer getSwimmer(){return swimmer;}

    //Getter method for ground platform
    public StaticBody getGround(){return GameLevel.ground;}

    //Getter method for crab (object from Enemies class), level 1
    public Enemies getCrab1(){return LevelOne.crab1;}

    //Getter method for pearl (object from LevelGoal class), level 1
    public StaticBody getPearlBody(){return LevelOne.pearlBody;}

    //Getter method for bear1 (object from Enemies class), level 2
    public Enemies getBear1(){return LevelTwo.bear1;}

    //Getter method for penguins 1 to 5 (object from Enemies class), level 2
    public Walker getPenguin(int j){return LevelTwo.penguin[j];}

    //Getter method for walrus 1 to 3 (object from Enemies class), level 2
    public Walker getWalrus(int i){return LevelTwo.walrus[i];}

    //Getter method for IceAxe (object from Price class), level 2
    public StaticBody getIceAxe1(){return LevelTwo.IceAxePriceLevelTwo[0];}

    //Getter method for igloo (object from LevelGoal class), level 2
    public StaticBody getIglooBody(){return LevelTwo.iglooBody;}


    //Getter method for snakes (object from Enemies class), level 3
    public Walker getSnake1(int i){return LevelThree.snake1[i];}
    public Walker getSnake2(int j){return LevelThree.snake2[j];}
    public Walker getSnake3(int k){return LevelThree.snake3[k];}


    //Getter method for desert flower (object from LevelGoal class), level 3
    public StaticBody getDesertFlowerBody(){return LevelThree.desertFlowerBody;}

    //Getter method for harp (object from LevelGoal class), level 4
    public StaticBody getHarpBody(){return LevelFour.harpBody;}


    //Method determining when to move on to next level
    public abstract boolean levelComplete();

    public abstract String getLevelName(String level);
}
