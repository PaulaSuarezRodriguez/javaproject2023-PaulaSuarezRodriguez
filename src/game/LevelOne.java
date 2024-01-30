package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

public class LevelOne extends GameLevel {
    static StaticBody pearlBody;
    static Enemies crab1;
    StaticBody[] SeaweedPriceLevelOne = new StaticBody[20];
    StaticBody[] stairway = new StaticBody[20];
    static SoundClip levelOneSound;

    public LevelOne(Game game) {
        super(game);
        try {
            levelOneSound = new SoundClip("data/levelOneSound.wav");
            levelOneSound.play();
            levelOneSound.loop();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        //optional: uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(this, 800, 600);

        // make surfboard lift (first platform)
        UpAndDownLift surfboardLift = new UpAndDownLift(this, new Vec2(15, -10));
        surfboardLift.addImage(new BodyImage("data/surfboard.png", 10));

        // make suspended platforms
        for (int i = 0; i < 5; i++) {
            stairway[i] = new StaticBody(this, new BoxShape(4.5f, 1));
            stairway[i].setPosition(new Vec2(2f - (i * 11), 7f + (i * 8)));
            stairway[i].addImage(new BodyImage("data/surfboard.png", 10));
        }

        // make prices (price in level one: seaweed)
        for (int j = 0; j < 3; j++) {
            SeaweedPriceLevelOne[j] = new Prices(this, game, new BoxShape(1.2f, 1.5f), new Vec2(2.75f - (j * 22), 11f + (j * 16)), new BodyImage("data/seaweed.png", 4));
        }

        //make enemies (enemy in level one: crab)
        crab1 = new Enemies(this, game, new CircleShape(1.5f), 80, new Vec2(-60f, -14f), new BodyImage("data/crab.png", 3.5f), new BodyImage("data/crab.png", 3.5f));

        //make level goal (level goal in level one: pearl)
        pearlBody = new StaticBody(this);
        PolygonShape pearlTopShape = new PolygonShape(-2.47f, -1.04f, -4.81f, 2.1f, -0.01f, 4.92f, 4.75f, 1.9f, 2.49f, -1.04f);
        PolygonShape pearlBottomShape = new PolygonShape(-2.57f, -1.04f, -4.39f, -2.5f, -2.59f, -4.34f, -0.03f, -5.0f, 2.73f, -4.28f, 4.35f, -2.52f, 2.53f, -1.04f);
        LevelGoal pearl = new LevelGoal(pearlBody, pearlTopShape, pearlBottomShape, new Vec2(-53, 47f), new BodyImage("data/pearl.png", 10));
    }

    public static void stopSound() {
        levelOneSound.stop();
    }

    @Override
    public boolean levelComplete() {
        if (getSwimmer().getCollidedWithPearl())
            return true;
        else return false;
    }


    public static SoundClip getSound() {
        return levelOneSound;
    }


    @Override
    public String getLevelName(String levelOne) {
        return levelOne;
    }
}


