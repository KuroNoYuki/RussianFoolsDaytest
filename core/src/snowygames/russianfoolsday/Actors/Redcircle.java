package snowygames.russianfoolsday.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import snowygames.russianfoolsday.Actors.Greencircle;
import java.util.Random;

import snowygames.russianfoolsday.RussianFoolsDay;

/**
 * Created by eshas on 08.03.2018.
 */

public class Redcircle {
    private enum State{IDLE, FLYING}
    private State state = State.IDLE;

    public static int SCALE ;
    private Vector3 position;
    private int width,height;
    private Texture redcircle;
    private Random random = new Random();
    int randomScale = random.nextInt(9) +4;
    private float downBarrier;


    public Redcircle(float x, float y){

        position = new Vector3(x,y,0);
        redcircle = new Texture("redcircle.png");
        position.x =(RussianFoolsDay.WIDTH /2);
        position.y = (RussianFoolsDay.HEIGHT/2);

        width = 480;
        height = 480;
        SCALE = -randomScale;
        setIdle();

    }

    public void setDownBarrier(float downBarrier) {
        this.downBarrier = downBarrier;
    }

    public void setIdle() {
        width = 480;
        height = 480;
        }
    public void setFlying(){state = State.FLYING;}
    public boolean isIdle(){
        if(state == State.IDLE){
            return true;
        }else {
        return false;}
    }

    public Texture getTextureRedcircle() {
        return redcircle;
    }
    public int getSCALE(){
        return SCALE;
    }

    public Vector3 getPosition() {
        return position;}
    public int getHeight(){
        return height;
    }
    public int getWidth() {
        return width;
    }

    public void update(float dt){
        switch (state){
            case IDLE:
                break;
            case FLYING:
            while (width > downBarrier){
                width = width + SCALE;
                height = height + SCALE;
                //position.add(width/2,height/2,0);
                return;
            }
            break;
            default:
                throw new RuntimeException("Unknown state = " + state);}



        /*
        width = redcircle.getWidth() - SCALE;
        height = redcircle.getHeight() - SCALE;
        */
        }


   public void dispose(){
        redcircle.dispose();
    }
    public void draw(SpriteBatch batch){
        batch.draw(redcircle,getPosition().x - (getWidth()/2),getPosition().y -( getHeight()/2),getWidth(),getHeight());
    }
}

