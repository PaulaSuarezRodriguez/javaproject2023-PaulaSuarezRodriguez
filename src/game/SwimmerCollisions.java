package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import org.jbox2d.common.Vec2;

public class SwimmerCollisions implements CollisionListener {
    private static Swimmer swimmer;
    private GameLevel gameLevel;
    private Game game;

    private boolean hitPearl = false;

    public SwimmerCollisions(Swimmer swimmer, GameLevel gameLevel, Game game) {
        this.swimmer = swimmer;
        this.gameLevel = gameLevel;
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        //LevelOne:
        //LevelOne collision and pickup of Price object (seaweed)
        if (e.getOtherBody() instanceof Prices && game.currentLevel instanceof LevelOne) {
            swimmer.setPricesCount(swimmer.getPricesCount() + 1);
            e.getOtherBody().destroy();
        }

        //LevelOne collision with Enemies object (crab1)
        else if (e.getOtherBody() instanceof Enemies && game.currentLevel instanceof LevelOne) {
            swimmer.setCollidedWithCrab(true);
            swimmer.setPosition(new Vec2(25f, -14f));
        }

        //LevelOne collision with LevelGoal object (pearl)
        else if (e.getOtherBody().equals(game.currentLevel.getPearlBody()) && game.currentLevel instanceof LevelOne) {
            swimmer.setCollidedWithPearlCount(swimmer.getCollidedWithPearlCount() + 1);
            swimmer.setCollidedWithPearl(true);
            System.out.println(swimmer.getCollidedWithPearl());
            gameLevel.levelComplete();
            if (!hitPearl) {
                hitPearl = true;
                game.goToNextLevel();
            }
        }


        //LevelTwo:
        //LevelTwo collision and pickup of Price object (ice axe)
        if (e.getOtherBody() instanceof Prices && game.currentLevel instanceof LevelTwo) {
            swimmer.setPricesCount(swimmer.getPricesCount() + 1);
            e.getOtherBody().destroy();
        }

        //LevelTwo collision with Enemies object (bear) or ground
        else if ((e.getOtherBody().equals(game.currentLevel.getBear1()) || e.getOtherBody().equals(game.currentLevel.getGround())) && game.currentLevel instanceof LevelTwo) {
            swimmer.setCollidedWithBear(true);
            swimmer.setPosition(new Vec2(25f, -10.5f));
        }

        //LevelTwo collision with Enemies object (penguin) or ground
        for (int j = 0; j < 5; j++) {
            if ((e.getOtherBody().equals(game.currentLevel.getPenguin(j)) || e.getOtherBody().equals(game.currentLevel.getGround())) && game.currentLevel instanceof LevelTwo) {
                gameLevel.getPenguin(j).setPosition(new Vec2(-3, 13.5f + (j * 40)));
            }
        }

        //LevelTwo collision with LevelGoal object (igloo)
        if (e.getOtherBody().equals(game.currentLevel.getIglooBody()) && game.currentLevel instanceof LevelTwo) {
            swimmer.setCollidedWithIglooCount(swimmer.getCollidedWithIglooCount() + 1);
            swimmer.setCollidedWithIgloo(true);
            System.out.println(swimmer.getCollidedWithIgloo());
            gameLevel.levelComplete();
            game.goToNextLevel();
        }


        //LevelThree:
        //LevelThree collision and pickup of Price object (water bottle)
        if (e.getOtherBody() instanceof Prices && game.currentLevel instanceof LevelThree) {
            swimmer.setPricesCount(swimmer.getPricesCount() + 1);
            e.getOtherBody().destroy();
        }

        //LevelThree collision with Enemies object (snake)
        for (int i = 0; i < 3; i++) {
            if ((e.getOtherBody().equals(game.currentLevel.getSnake1(i)) || e.getOtherBody().equals(game.currentLevel.getGround())) && game.currentLevel instanceof LevelThree) {
                gameLevel.getSnake1(i).setPosition(new Vec2(-40f + (i * 10), -50 + (i * 12f)));
                swimmer.setPosition(new Vec2(37f, -50f));
            }
        }
        for (int j = 0; j < 3; j++) {
            if ((e.getOtherBody().equals(game.currentLevel.getSnake2(j)) || e.getOtherBody().equals(game.currentLevel.getGround())) && game.currentLevel instanceof LevelThree) {
                gameLevel.getSnake2(j).setPosition(new Vec2(-20f + (j * 10), -50 + (j * 12f)));
                swimmer.setPosition(new Vec2(37f, -50f));
            }
        }
        for (int k = 0; k < 3; k++) {
            if ((e.getOtherBody().equals(game.currentLevel.getSnake3(k)) || e.getOtherBody().equals(game.currentLevel.getGround())) && game.currentLevel instanceof LevelThree) {
                gameLevel.getSnake3(k).setPosition(new Vec2(0f + (k * 10), -50 + (k * 12f)));
                swimmer.setPosition(new Vec2(37f, -50f));
            }
        }

        //LevelThree collision with LevelGoal object (desert flower)
        if (e.getOtherBody().equals(game.currentLevel.getDesertFlowerBody()) && game.currentLevel instanceof LevelThree) {
            swimmer.setCollidedWithDesertFlowerCount(swimmer.getCollidedWithDesertFlowerCount() + 1);
            swimmer.setCollidedWithDesertFlower(true);
            System.out.println(swimmer.getCollidedWithDesertFlower());
            gameLevel.levelComplete();
            game.goToNextLevel();
        }


        //LevelFour:
        //LevelFour collision and pickup of Price object (angel harp)
        if (e.getOtherBody() instanceof Prices && game.currentLevel instanceof LevelFour) {
            swimmer.setPricesCount(swimmer.getPricesCount() + 1);
            e.getOtherBody().destroy();
        }

        //LevelFour collision with Enemies object (demon)
        else if (e.getOtherBody() instanceof Enemies && game.currentLevel instanceof LevelFour) {
            // swimmer.setCollidedWithDemon(true);
            swimmer.setPosition(new Vec2(-40, 140f));
        }

        //LevelFour collision with LevelGoal object (harp)
        else if (e.getOtherBody().equals(game.currentLevel.getHarpBody()) && game.currentLevel instanceof LevelFour) {
            swimmer.setCollidedWithHarpCount(swimmer.getCollidedWithHarpCount() + 1);
            swimmer.setCollidedWithHarp(true);
            System.out.println(swimmer.getCollidedWithHarp());
        }
    }
}