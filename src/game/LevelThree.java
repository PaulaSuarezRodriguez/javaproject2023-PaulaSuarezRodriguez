package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

public class LevelThree extends GameLevel {
    public static StaticBody[] waterBottle = new StaticBody[20];
    public static Walker[] snake1 = new Walker[4];
    public static Walker[] snake2 = new Walker[4];
    public static Walker[] snake3 = new Walker[4];
    static StaticBody ground, underGround1, underGround2, underGround3, rampBody;
    static UpAndDownLift surfboardLiftLevelThree, surfboardLiftLevelThree2, surfboardLiftLevelThree3;
    static StaticBody desertFlowerBody;
    static SolidFixture rampSolidFixture;
    StaticBody[] stairway = new StaticBody[20];
    private static SoundClip levelThreeSound;

    public LevelThree(Game game) {
        super(game);

            try {
                LevelTwo.stopSound();
                levelThreeSound = new SoundClip("data/levelThreeSound.wav");
                levelThreeSound.play();
                levelThreeSound.loop();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }

        //optional: uncomment this to make a debugging view
      //  JFrame debugView = new DebugViewer(this, 800, 600);

        //swimmer, set starting position at underground 2
        getSwimmer().setPosition(new Vec2(37f, -50f));

        //destroy ground inherited from GameLevel -- doesn't suit level three
        getGround().destroy();

        //make ground and undergrounds for LevelThree
        ground = new StaticBody(this, new BoxShape(50f, 0.5f));
        ground.setPosition(new Vec2(1f, -16f));

        underGround1 = new StaticBody(this, new BoxShape(42f, 0.5f));
        underGround1.setPosition(new Vec2(-7f, -28f));

        underGround2 = new StaticBody(this, new BoxShape(42f, 0.5f));
        underGround2.setPosition(new Vec2(-7f, -40f));

        underGround3 = new StaticBody(this, new BoxShape(50f, 0.5f));
        underGround3.setPosition(new Vec2(1f, -52f));


        // make lifts
        UpAndDownLift surfboardLiftLevelThree = new UpAndDownLift(this, new Vec2(-55f, -28f));

        UpAndDownLift surfboardLiftLevelThree2 = new UpAndDownLift(this, new Vec2(42f, -40f));

        UpAndDownLift surfboardLiftLevelThree3 = new UpAndDownLift(this, new Vec2(-55f, -52f));

        // make suspended platforms -- MAKE STAIRWAY OF DESERT ROCKS!
        for (int i = 0; i < 5; i++) {
            stairway[i] = new StaticBody(this, new BoxShape(2.5f, 1));
            stairway[i].setPosition(new Vec2(-35 + (i * 10f), -6f + (i * 10f)));
            stairway[i].addImage(new BodyImage("data/desert-rock.png", 3.5f));
        }

        // make suspended ramp
        rampBody = new StaticBody(this);
        rampSolidFixture = new SolidFixture(rampBody, new BoxShape(25f, 0.5f));
        rampBody.setPosition(new Vec2(-25f, 55f));
        rampBody.rotate(-7f);

        // make Prices -- MAKE WATER BOTTLES!
        for (int i = 0; i < 4; i++) {
            waterBottle[i] = new Prices(this, game, new BoxShape(1.2f, 2f), new Vec2(-45f + (i * 10), -49 + (i * 12f)), new BodyImage("data/waterBottle.png", 5f));
        }

        for (int i = 0; i < 4; i++) {
            waterBottle[i] = new Prices(this, game, new BoxShape(1.2f, 2f), new Vec2(-25f + (i * 10), -49 + (i * 12f)), new BodyImage("data/waterBottle.png", 5f));
        }

        for (int i = 0; i < 4; i++) {
            waterBottle[i] = new Prices(this, game, new BoxShape(1.2f, 2f), new Vec2(-5f + (i * 10), -49 + (i * 12f)), new BodyImage("data/waterBottle.png", 5f));
        }


        // make Enemies -- MAKE SNAKES!
        for (int i = 0; i < 3; i++) {
            snake1[i] = new Enemies(this, game, new BoxShape(1.2f, 2f), 2, new Vec2(-40f + (i * 10), -43 + (i * 12f)), new BodyImage("data/snake-right.png", 5f), new BodyImage("data/snake-left.png", 5f));
            snake1[i].setGravityScale(0);
        }

        for (int j = 0; j < 3; j++) {
            snake2[j] = new Enemies(this, game, new BoxShape(1.2f, 2f), 2, new Vec2(-20f + (j * 10), -43 + (j * 12f)), new BodyImage("data/snake-right.png", 5f), new BodyImage("data/snake-left.png", 5f));
            snake2[j].setGravityScale(0);
        }

        for (int k = 0; k < 3; k++) {
            snake3[k] = new Enemies(this, game, new BoxShape(1.2f, 2f), 2, new Vec2(0f + (k * 10), -43 + (k * 12f)), new BodyImage("data/snake-right.png", 5f), new BodyImage("data/snake-left.png", 5f));
            snake3[k].setGravityScale(0);
        }


        //make level goal (level goal in level three: desert flower)
        desertFlowerBody = new StaticBody(this);
        PolygonShape desertFlowerTopShape = new PolygonShape(4.56f,-0.08f, -4.38f,-0.1f, -0.22f,4.1f, 4.56f,-0.08f);
        PolygonShape desertFlowerBottomShape = new PolygonShape(-4.36f,-0.4f, 4.56f,-0.3f, 0.12f,-4.08f, -4.36f,-0.4f);
        LevelGoal desertFlower = new LevelGoal(desertFlowerBody, desertFlowerTopShape, desertFlowerBottomShape, new Vec2(-50f, 70f), new BodyImage("data/desertFlower.png", 15f));
    }


    public static void stopSound() {
        if (levelThreeSound != null) {
            levelThreeSound.stop();
        }
    }

    @Override
    public boolean levelComplete() {
        if (getSwimmer().getCollidedWithDesertFlower())
            return true;
        else return false;
    }


    public static SoundClip getSound() {
        return levelThreeSound;
    }

    @Override
    public String getLevelName(String levelThree) {
        return levelThree;
    }
}

