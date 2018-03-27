package snowygames.russianfoolsday.circles;

import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

import snowygames.russianfoolsday.RussianFoolsDay;

public class Redcircle extends Circle {

    private enum State {IDLE, FLYING}

    private State state = State.IDLE;
    public static int SCALE;
    private Random random = new Random();
    int randomScale = random.nextInt(9) + 4;
    private float downBarrier;
    private float secondBarrier;

    public Redcircle(Texture texture, float x, float y) {
        super(texture);
        pos.set(x, y);
        pos.x = RussianFoolsDay.WIDTH / 2;
        pos.y = RussianFoolsDay.HEIGHT / 2;

        width = 480;
        height = 480;
        SCALE = -randomScale;
        setIdle();
    }

    public void setDownBarrier(float downBarrier) {
        this.downBarrier = downBarrier;
    }

    public void setSecondBarrier(float secondBarrier) {
        this.secondBarrier = secondBarrier;
    }

    public float getSecondBarrier() {
        return secondBarrier;
    }

    public void setIdle() {
        width = 480;
        height = 480;
    }

    public void setFlying() {
        state = State.FLYING;
    }

    public boolean isIdle() {
        if (state == State.IDLE) {
            return true;
        } else {
            return false;
        }
    }

    public void update(float dt) {
        switch (state) {
            case IDLE:
                break;
            case FLYING:
                while (width > downBarrier) {
                    width = width + SCALE;
                    height = height + SCALE;
                    //position.add(width/2,height/2,0);
                    return;
                }
                break;
            default:
                throw new RuntimeException("Unknown state = " + state);
        }



        /*
        width = redcircle.getWidth() - SCALE;
        height = redcircle.getHeight() - SCALE;
        */
    }
}

