package snowygames.russianfoolsday.Actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by eshas on 16.03.2018.
 */
@SuppressWarnings("WeakerAccess")
public class Matryoshkadown {
    private enum State{ IDLE , FLYING}
    private State state = State.IDLE;
    private final Vector2 pos = new Vector2();
    private final Vector2 posIdle;
    public static Vector2 v = new Vector2(0f,-380f);
    private float width = 250;
    private float height = 250;
    private Texture texture;

    public Matryoshkadown(Texture texture, Vector2 posIdle){
        this.texture = texture;
        this.posIdle = posIdle;
        setIdle();
    }
    public void setIdle(){
        pos.set(posIdle);
        state = State.IDLE;
    }
    public float getWidth(){return width;};
    public float getHeight(){return height;}
    public void setWidth(float width){this.width = width;}
    public void setHeight(float height){this.height = height;}
    public void setFlying(){state = State.FLYING;}
    public float getLeft(){
        return pos.x - width/2f;
    }
    public void setDown(){pos.y = pos.y -5f;}
    public float getBottom(){return pos.y - height/2f;}
    public float getTop(){return  pos.y + height/2;}
    public void update(float deltaTime,float worldDown){
        switch (state){
            case IDLE:
                break;
            case FLYING:
                pos.mulAdd(v, deltaTime);
                if (getTop()<worldDown) setIdle();
                break;
            default:
                throw new RuntimeException("Unknown state = " + state);

    }}
    public void draw(SpriteBatch batch){
        batch.draw(texture,getLeft(),getBottom(),width,height);
    }
}
