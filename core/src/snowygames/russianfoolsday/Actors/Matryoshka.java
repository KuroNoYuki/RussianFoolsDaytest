package snowygames.russianfoolsday.Actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import snowygames.russianfoolsday.BaseSprite;


public class Matryoshka extends BaseSprite {

    private enum State{ IDLE , FLYING}
    private State state;
    private final Vector2 posIdle = new Vector2();
    private final Vector2 v = new Vector2(0f, 380f);

    public Matryoshka(Texture texture, Vector2 posIdle){
        super(texture);
        this.texture = texture;
        this.posIdle.set(posIdle);
        width = 250;
        height = 250;
        pos.set(posIdle);
        state = State.IDLE;
    }

    public void setFlying(){
        state = State.FLYING;
    }

    public void setDown(){
        pos.y = pos.y -5f;
    }

    public void update(float deltaTime,float worldTop){
        switch (state){
            case IDLE:
                break;
            case FLYING:
                pos.mulAdd(v, deltaTime);
                if (getBottom()>worldTop) {
                    pos.set(posIdle);
                    state = State.IDLE;
                }
                break;
            default:
                throw new RuntimeException("Unknown state = " + state);
        }
    }
}
