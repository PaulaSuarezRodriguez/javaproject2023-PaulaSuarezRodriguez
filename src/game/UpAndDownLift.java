package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

  public class UpAndDownLift extends StaticBody implements StepListener {
        private Vec2 startPosition;
        private float top, bottom, positionOfX;
        private float delta;

        public UpAndDownLift(GameLevel world, Vec2 startPosition) {
            super(world, new BoxShape(4, 0.5f));
            this.startPosition = startPosition;
            this.setPosition(startPosition);
            positionOfX = startPosition.x;
            bottom = startPosition.y;
            top = startPosition.y+13f;
            delta=0.08f;
            world.addStepListener(this);
        }

        @Override
        public void preStep(StepEvent stepEvent) {
            if (getPosition().y < bottom) {
                this.setPosition(startPosition);
                delta *= -1;
            }
            if (getPosition().y > top) {
                delta *= -1;
            }
            this.setPosition(new Vec2(positionOfX, this.getPosition().y + delta));
        }
            @Override
            public void postStep(StepEvent stepEvent){

            }
        }




