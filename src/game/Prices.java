package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Prices extends StaticBody {
    private static SoundClip pricesCollectionSound;
    private static Game game;
    private static Shape shape;
    private static Vec2 position;
    private static BodyImage image;

    static{
        try {
            pricesCollectionSound = new SoundClip("data/marioCoin.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    public Prices(GameLevel world, Game game, Shape shape, Vec2 position, BodyImage image) {
        super(world, shape);
        this.game = game;
        this.position = position;
        this.image = image;
        this.setPosition(position);
        this.addImage(image);
    }

    @Override
    public void destroy(){
        System.out.println("marioCoin sound");
        pricesCollectionSound.play();
        super.destroy();
    }

}
