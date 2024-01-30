package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class LevelGoal extends GhostlyFixture {
        static StaticBody goalBody;
        static Shape topShape, bottomShape;
        static Vec2 position;
        static BodyImage image;
    public LevelGoal(StaticBody goalBody, Shape topShape, Shape bottomShape, Vec2 position, BodyImage image) {
        super(goalBody, topShape);
        this.topShape = topShape;
        this.bottomShape = bottomShape;
        this.position = position;
        this.image = image;
        goalBody.setPosition(position);
        goalBody.addImage(image);
        SolidFixture bottom = new SolidFixture(goalBody, bottomShape);
    }
}
