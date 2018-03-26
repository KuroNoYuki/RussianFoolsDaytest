package snowygames.russianfoolsday.Actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

import snowygames.russianfoolsday.RussianFoolsDay;

/**
 * Created by eshas on 13.03.2018.
 */

public class ObjectDown {
    private Vector3 position;
    private float height,width;
    private Texture emptydown;


    public ObjectDown(float x, float y){
        position = new Vector3(x,y,0);
        emptydown = new Texture("Emptyheadcolored.png");
        height = emptydown.getHeight();
        width = emptydown.getWidth();
        height = 300;
        width = 300;
    }

    public Vector3 getPosition() {
        return position;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    public Texture getHead() {
        return emptydown;
    }
    public void update(float dt){
        while (position.y < RussianFoolsDay.HEIGHT){
            position.add(0, Redcircle.SCALE,0);
        }
    }
    public void dispose(){
        emptydown.dispose();
    }

}
