package snowygames.russianfoolsday.Actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

import snowygames.russianfoolsday.RussianFoolsDay;

/**
 * Created by eshas on 27.03.2018.
 */

public class Circle {
    protected Vector3 position;
    protected float width,height;



    public Vector3 getPosition() {
        return position;
    }

    public  float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
    public void setHeight(float newHeight){
        height =newHeight;
    }
    public void setWidth(float newWidth){
        width = newWidth;
    }

}
