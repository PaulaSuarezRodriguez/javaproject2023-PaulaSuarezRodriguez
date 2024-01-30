package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

public class Enemies extends Walker implements StepListener {
    public static Vec2 position;
    private BodyImage rightImage, leftImage;
    private Game game;
    private final float SPEED = 4f;
    private float left, right;
    private int range = 2;


    public Enemies(GameLevel world, Game game, Shape shape, int range, Vec2 position, BodyImage rightImage, BodyImage leftImage) {
        super(world, shape);
        this.game = game;
        this.range = range;
        this.position = position;
        this.rightImage = rightImage;
        this.leftImage = leftImage;
        this.setPosition(position);
        this.addImage(rightImage);
        world.addStepListener(this);
        startWalking(SPEED);
    }

    @Override
    public void setPosition(Vec2 position) {
        super.setPosition(position);
        left = position.x;
        right = position.x + range;
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if (getPosition().x > right) {
            removeAllImages();
            this.addImage(leftImage);
            startWalking(-SPEED);
            for (int i = 0; i < 3; i++) {
                if (game.currentLevel instanceof LevelTwo) {
                    game.currentLevel.getWalrus(i).jump(15);
                }
            }
        }

            if (getPosition().x < left) {
                removeAllImages();
                this.addImage(rightImage);
                startWalking(SPEED);
                for (int i = 0; i < 3; i++) {
                    if (game.currentLevel instanceof LevelTwo) {
                        game.currentLevel.getWalrus(i).jump(15);
                    }
                }
            }
        }

        @Override
        public void postStep (StepEvent stepEvent){

        }
    }