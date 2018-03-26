package snowygames.russianfoolsday.Actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.sun.media.sound.RIFFInvalidDataException;

import snowygames.russianfoolsday.RussianFoolsDay;

/**
 * Created by eshas on 13.03.2018.
 */

public class ObjectHead {
    private Vector3 position;
    private float height,width;
    private Texture emptyhead;


    public ObjectHead(float x, float y){
        position = new Vector3(x,y,0);
        emptyhead = new Texture("Emptyheadcolored.png");
        height = emptyhead.getHeight();
        width = emptyhead.getWidth();
        height = 300;
        width = 300;
    }

    public Vector3 getPosition() {
        return position;
    }

    public float getHeight() {
        return height;
    }
    public void setPosition(int y){
        position.add(0,y,0);
        return;
    }
    public float getWidth() {
        return width;
    }

    public Texture getHead() {
        return emptyhead;
    }
    public void update(){
        while (position.y < RussianFoolsDay.HEIGHT){
            position.add(0, - Redcircle.SCALE,0);
            return;
        }
        if ((position.y)+height> RussianFoolsDay.HEIGHT) {
            emptyhead.dispose();
        }
    }
    public void dispose(){
        emptyhead.dispose();
    }

}
