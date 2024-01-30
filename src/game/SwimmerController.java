package game;

import city.cs.engine.Body;
import city.cs.engine.BodyImage;
import city.cs.engine.SoundClip;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class SwimmerController implements KeyListener, java.awt.event.KeyListener {
    private String levelName;
    private Swimmer swimmer;
    Game game;

    String filename;
    GameLevel currentLevel;

    public SwimmerController(Swimmer swimmer, Game game, GameLevel curretLevel, String levelName) {
        this.swimmer = swimmer;
        this.game = game;
        this.currentLevel = curretLevel;
        this.levelName = levelName;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent event) {
        int code = event.getKeyCode();
        // other key commands omitted
        if (code == KeyEvent.VK_LEFT && game.currentLevel instanceof LevelOne) {
            swimmer.startWalking(-5);
            swimmer.removeAllImages();
            swimmer.addImage(new BodyImage("data/swimmer-left.png", 7));

        } else if (code == KeyEvent.VK_RIGHT && game.currentLevel instanceof LevelOne) {
            swimmer.startWalking(5);
            swimmer.removeAllImages();
            swimmer.addImage(new BodyImage("data/swimmer-right.png", 7));

        } else if ((code == KeyEvent.VK_UP) && (game.currentLevel instanceof LevelOne)) {
            swimmer.jump(25);
            swimmer.applyForce(new Vec2(9, 9));
            swimmer.setGravityScale(3f);


        } else if (code == KeyEvent.VK_LEFT && game.currentLevel instanceof LevelTwo) {
            swimmer.startWalking(-7.5f);
            swimmer.removeAllImages();
            swimmer.addImage(new BodyImage("data/swimmer-left.png", 7));

        } else if (code == KeyEvent.VK_RIGHT && game.currentLevel instanceof LevelTwo) {
            swimmer.startWalking(7.5f);
            swimmer.removeAllImages();
            swimmer.addImage(new BodyImage("data/swimmer-right.png", 7));

        } else if ((code == KeyEvent.VK_UP) && (game.currentLevel instanceof LevelTwo)) {
            swimmer.jump(25);
            swimmer.applyForce(new Vec2(9, 9));
            swimmer.setGravityScale(2.5f);


        } else if (code == KeyEvent.VK_LEFT && game.currentLevel instanceof LevelThree) {
            swimmer.startWalking(-7.5f);
            swimmer.removeAllImages();
            swimmer.addImage(new BodyImage("data/swimmer-left.png", 7));

        } else if (code == KeyEvent.VK_RIGHT && game.currentLevel instanceof LevelThree) {
            swimmer.startWalking(7.5f);
            swimmer.removeAllImages();
            swimmer.addImage(new BodyImage("data/swimmer-right.png", 7));

        } else if ((code == KeyEvent.VK_UP) && (game.currentLevel instanceof LevelThree)) {
            swimmer.jump(25);
            swimmer.applyForce(new Vec2(9, 9));
            swimmer.setGravityScale(3f);


        } else if (code == KeyEvent.VK_LEFT && game.currentLevel instanceof LevelFour) {
            swimmer.startWalking(-7.5f);
            swimmer.removeAllImages();
            swimmer.addImage(new BodyImage("data/swimmer-left.png", 7));

        } else if (code == KeyEvent.VK_RIGHT && game.currentLevel instanceof LevelFour) {
            swimmer.startWalking(7.5f);
            swimmer.removeAllImages();
            swimmer.addImage(new BodyImage("data/swimmer-right.png", 7));

        } else if ((code == KeyEvent.VK_UP) && (game.currentLevel instanceof LevelFour)) {
            swimmer.jump(25);
            swimmer.applyForce(new Vec2(9, 9));
            swimmer.setGravityScale(3f);
        }
    }

    @Override
    public void keyReleased(KeyEvent event) {
        int code = event.getKeyCode();
        // other key commands omitted
        if ((code == KeyEvent.VK_LEFT || code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_DOWN) && (game.currentLevel instanceof LevelOne || game.currentLevel instanceof LevelTwo || game.currentLevel instanceof LevelThree || game.currentLevel instanceof LevelFour)) {
            swimmer.stopWalking();
        }
    }

    public void updateSwimmer(Swimmer newSwimmer) {
        swimmer = newSwimmer;
    }
}