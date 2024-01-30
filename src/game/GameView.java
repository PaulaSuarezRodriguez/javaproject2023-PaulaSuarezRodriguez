package game;

import city.cs.engine.UserView;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {
    private Image background = new ImageIcon("data/beach.jpg").getImage();
    private Image background2 = new ImageIcon("data/antartica.png").getImage();
    private Image background3 = new ImageIcon("data/desert.png").getImage();
    private Image background4 = new ImageIcon("data/heaven.png").getImage();
    private Swimmer swimmer;
    private GameLevel world;
    Graphics2D g;
    static GameView gameView;
    Game game;

    public GameView(GameLevel world, int width, int height, boolean collisionWithCrab, boolean collisionWithPearl, Game game, GameView gameView) {
        super(world, width, height);
        this.swimmer = world.getSwimmer();
        this.game = game;
        this.gameView = gameView;
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        if (game.currentLevel instanceof LevelOne) {
            g.drawImage(background, 0, 0, 800, 600, this);
        } else if (game.currentLevel instanceof LevelTwo) {
            g.drawImage(background2, 0, 0, 800, 600, this);
        } else if (game.currentLevel instanceof LevelThree) {
            g.drawImage(background3, 0, 0, 800, 600, this);
        } else if (game.currentLevel instanceof LevelFour) {
            g.drawImage(background4, 0, 0, 800, 600, this);
        }
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        /************** Level one by defaut because of Milestone 1, not actually implemented for Level 1 **************/
        /* g.setFont(new Font("Comic Sans", 15, 20));
        g.setColor(Color.blue);
        g.drawString("Seaweed collected 🪸 = " + swimmer.getSeaweedCount(),10,50);
        g.drawString("Crabs destroyed 🦀 = " + swimmer.getCrabsDestroyedCount(),10,25);

        if (swimmer.getCollidedWithCrab()) {
            g.setFont(new Font("Comic Sans", 1, 100));
            g.setColor(Color.red);
            g.drawString("You lost!", 165, 375f);
        } */
        /**************************************************************************************************************/
    }
}

