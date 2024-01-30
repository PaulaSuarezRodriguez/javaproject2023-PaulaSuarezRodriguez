package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

import static game.LevelOne.levelOneSound;

public class LevelTwo extends GameLevel {
    static StaticBody doubleGround, doubleGround2, doubleGround3, iglooBody, icebergPlatform;
    private StaticBody[] stairway = new StaticBody[20];
    public static StaticBody[] IceAxePriceLevelTwo = new StaticBody[20];
    public static Walker[] penguin = new Walker[20];
    public static Walker[] walrus = new Walker[3];
    public static Enemies bear1;
    static SoundClip levelTwoSound;

    public LevelTwo(Game game) {
        super(game);

            try {
                //Commenting out call to method level one for when starting game at level two. Uncomment for definite version:
                LevelOne.stopSound();
                levelTwoSound = new SoundClip("data/levelTwoSound.wav");
                levelTwoSound.play();
                levelTwoSound.loop();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }

        //optional: uncomment this to make a debugging view
      //  JFrame debugView = new DebugViewer(this, 800, 600);

        //Swimmer set position on top of iceberg platform
        getSwimmer().setPosition(new Vec2(25f, -10.5f));

        //make initial iceberg platform
        icebergPlatform = new StaticBody(this, new BoxShape(5f, 2));
        icebergPlatform.addImage(new BodyImage("data/iceberg.png", 5f));
        icebergPlatform.setPosition(new Vec2(25f, -13f));

        //make double ground for walrus
        Shape shape = new BoxShape(63.5f, 0f);
        doubleGround = new StaticBody(this, shape);
        doubleGround.setPosition(new Vec2(0f, -28f));

        // make suspended platforms -- MAKE ICEBERGS!
        for (int i = 0; i < 10; i++) {
            stairway[i] = new StaticBody(this, new BoxShape(2.5f, 1));
            stairway[i].setPosition(new Vec2(5f - (7), 8.5f + (i * 20f)));
            stairway[i].addImage(new BodyImage("data/iceberg.png", 2.5f));
        }

        for (int j = 0; j < 10; j++) {
            stairway[j] = new StaticBody(this, new BoxShape(2.5f, 1));
            stairway[j].setPosition(new Vec2(5f + (7), -2f + (j * 20f)));
            stairway[j].addImage(new BodyImage("data/iceberg.png", 2.5f));
        }

        // make Prices -- MAKE ICE AXE!
        for (int x = 0; x < 10; x++) {
            IceAxePriceLevelTwo[x] = new Prices(this, game, new BoxShape(1.2f, 1.5f), new Vec2(5f + (7), 1f + (x * 20f)), new BodyImage("data/iceAxe.png", 4.5f));
        }

        // make Enemies –– MAKE PENGUINS!
        for (int j = 0; j < 5; j++) {
            penguin[j] = new Enemies(this, game, new BoxShape(1.5f, 3.5f), 2, new Vec2(-4, 13.5f + (j * 40)), new BodyImage("data/penguin_right.png", 7f), new BodyImage("data/penguin_right.png", 7f));
        }

        // make Enemies –– MAKE WALRUS!
        for (int j = 0; j < 3; j++) {
            walrus[j] = new Enemies(this, game, new BoxShape(2f, 2f), 15, new Vec2(-40 + (j * 30), -20f), new BodyImage("data/angry_walrus_right.png", 7f), new BodyImage("data/angry_walrus_left.png", 7f));
        }

        // make Enemies –– MAKE BEAR!
        bear1 = new Enemies(this, game, new BoxShape(5f, 3.25f), 60, new Vec2(-50f, -14f), new BodyImage("data/bear_right.png", 7f), new BodyImage("data/bear_left.png", 7f));

        //make level goal (level goal in level one: igloo)
        iglooBody = new StaticBody(this);
        PolygonShape iglooTopShape = new BoxShape(4, 4);
        PolygonShape iglooBottomShape = new BoxShape(4, 1);
        LevelGoal igloo = new LevelGoal(iglooBody, iglooTopShape, iglooBottomShape, new Vec2(12, 200f), new BodyImage("data/igloo.png", 8f));
    }

    public static void stopSound() {
        if (levelTwoSound != null) {
            levelTwoSound.stop();
        }
    }


    @Override
    public boolean levelComplete() {
        if (getSwimmer().getCollidedWithIgloo())
            return true;
        else return false;
    }

    public static SoundClip getSound() {
        return levelTwoSound;
    }

    @Override
    public String getLevelName(String levelOne) {
        return levelOne;
    }
}

