package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class LevelFour extends GameLevel {

    private Swimmer swimmer;
    static SolidFixture rampSolidFixture, rampSolidFixture2;
    static StaticBody harpBody, rampBody, rampBody2;
    StaticBody[] HarpLevelFourPrice = new StaticBody[20];
    static StaticBody[] stairway = new StaticBody[20];
    static StaticBody[] jumpStairway = new StaticBody[20];
    Walker[] DemonLevelFourEnemy = new Walker[20];
    private static SoundClip levelFourSound;
    static StaticBody underGround1, underGround2, underGround3, underGround4, underGround5;

    public LevelFour(Game game) {
        super(game);

            try {
                LevelThree.stopSound();
                levelFourSound = new SoundClip("data/levelFourSound.wav");
                levelFourSound.play();
                levelFourSound.loop();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }


        //optional: uncomment this to make a debugging view
       // JFrame debugView = new DebugViewer(this, 800, 600);

        //destroy ground inherited from GameLevel -- doesn't suit level four
        getGround().setPosition(new Vec2(0f, -57.5f));


        //swimmer, set starting position at stairway
        getSwimmer().setPosition(new Vec2(-40, 140f));

        // make suspended platforms down -- stairs at beginning of level
       for (int i = 0; i < 5; i++) {
            stairway[i] = new StaticBody(this, new BoxShape(4.5f, 1));
            stairway[i].setPosition(new Vec2(5f - (i * 11), 100f + (i * 8)));
            stairway[i].addImage(new BodyImage("data/cloud.png", 4));
        }

        //make ground and undergrounds for LevelFour
        underGround1 = new StaticBody(this, new BoxShape(49f, 0.5f));
        underGround1.setPosition(new Vec2(-13f, 88f));

        underGround2 = new StaticBody(this, new BoxShape(42f, 0.5f));
        underGround2.setPosition(new Vec2(-7f, 76f));

        underGround3 = new StaticBody(this, new BoxShape(42f, 0.5f));
        underGround3.setPosition(new Vec2(-7f, 64f));

        // make lifts
        UpAndDownLift surfboardLiftLevelFour1 = new UpAndDownLift(this, new Vec2(42f, 76f));

        UpAndDownLift surfboardLiftLevelFour2 = new UpAndDownLift(this, new Vec2(-55f, 64f));

        // make suspended ramp
        rampBody = new StaticBody(this);
        rampSolidFixture = new SolidFixture(rampBody, new BoxShape(25f, 0.5f));
        rampBody.setPosition(new Vec2(30f, 45f));
        rampBody.rotate(7f);

        underGround4 = new StaticBody(this, new BoxShape(42f, 0.5f));
        underGround4.setPosition(new Vec2(-7f, 25f));

        underGround5 = new StaticBody(this, new BoxShape(42f, 0.5f));
        underGround5.setPosition(new Vec2(-7f, 13f));

        // make lifts
        UpAndDownLift surfboardLiftLevelFour3 = new UpAndDownLift(this, new Vec2(-55f, 13f));

        // make suspended platforms
        for (int i = 0; i < 4; i++) {
            jumpStairway[i] = new StaticBody(this, new BoxShape(2.5f, 0.5f));
            jumpStairway[i].setPosition(new Vec2(38f + (7), -47.5f + (i * 20f)));
            jumpStairway[i].setAlwaysOutline(true);
        }

        for (int j = 0; j < 3; j++) {
            jumpStairway[j] = new StaticBody(this, new BoxShape(2.5f, 0.5f));
            jumpStairway[j].setPosition(new Vec2(38f + (17), -37.5f + (j * 20f)));
            jumpStairway[j].setAlwaysOutline(true);
        }

        // make suspended ramp
        rampBody2 = new StaticBody(this);
        rampSolidFixture2 = new SolidFixture(rampBody2, new BoxShape(25f, 0.5f));
        rampBody2.setPosition(new Vec2(90f, -40f));
        rampBody2.rotate(7f);

        // make prices (price in level four: harp)
        for (int j = 0; j < 3; j++) {
            HarpLevelFourPrice[j] = new Prices(this, game, new BoxShape(1.2f, 1.5f), new Vec2(35f + (20), -34.5f + (j * 20f)), new BodyImage("data/angel-harp.png", 4));
        }

        for (int j = 0; j < 4; j++) {
            HarpLevelFourPrice[j] = new Prices(this, game, new BoxShape(1.2f, 1.5f), new Vec2(-33f+ (j * 20f), 67f), new BodyImage("data/angel-harp.png", 4));
        }

        for (int j = 0; j < 4; j++) {
            HarpLevelFourPrice[j] = new Prices(this, game, new BoxShape(1.2f, 1.5f), new Vec2(-33f + (j * 20f), 79f), new BodyImage("data/angel-harp.png", 4));
        }

        for (int j = 0; j < 4; j++) {
            HarpLevelFourPrice[j] = new Prices(this, game, new BoxShape(1.2f, 1.5f), new Vec2(-33f + (j * 20f), 16f), new BodyImage("data/angel-harp.png", 4));
        }

        //make enemies (enemy in level four: demon)
        for (int j = 0; j < 4; j++) {
            DemonLevelFourEnemy[j] = new Enemies(this, game, new BoxShape(1, 2), 1, new Vec2(7f - (j * 11), 103f + (j * 8)), new BodyImage("data/demon.png", 6f), new BodyImage("data/demon.png", 6f));
        }

        for (int j = 0; j < 4; j++) {
            DemonLevelFourEnemy[j] = new Enemies(this, game, new BoxShape(1, 2), 2, new Vec2(0f - (j * 15), 35f), new BodyImage("data/demon.png", 6f), new BodyImage("data/demon.png", 6f));
        }

            //make level goal (level goal in level four: harp)
            harpBody = new StaticBody(this);
            PolygonShape harpTopShape = new PolygonShape(-3.57f, 6.54f, -3.33f, -3.66f, 1.05f, -3.6f, 4.38f, 5.46f, -3.57f, 6.54f);
            PolygonShape harpBottomShape = new PolygonShape(-3.9f, -3.75f, 0.93f, -3.72f, 0.93f, -6.57f, -4.08f, -6.6f, -4.08f, -3.78f);
            LevelGoal harp = new LevelGoal(harpBody, harpTopShape, harpBottomShape, new Vec2(115.5f, -19f), new BodyImage("data/harp.png", 15f));
        }

    public static void stopSound() {
        if (levelFourSound != null) {
            levelFourSound.stop();
        }
    }

    @Override
    public boolean levelComplete() {
        if (getSwimmer().getCollidedWithHarp())
            return true;
        else return false;
    }

    public static SoundClip getSound() {
        return levelFourSound;
    }

    @Override
    public String getLevelName(String levelFour) {
        return levelFour;
    }
}
