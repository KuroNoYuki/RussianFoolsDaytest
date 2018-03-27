package snowygames.russianfoolsday.Actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by eshas on 27.03.2018.
 */

public class Yellowcircle extends Circle {
    private Texture yellowcircle;
    public Yellowcircle (float x , float y){
        position = new Vector3(x,y,0);
        yellowcircle = new Texture("Yellowcircle.png");
        height = 160;
        width = 160;
    }
    public void dispose(){
        yellowcircle.dispose();
    }
    public Texture getTextureYellowcircle(){
        return yellowcircle;
    }

}
