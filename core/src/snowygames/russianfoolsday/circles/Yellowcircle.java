package snowygames.russianfoolsday.circles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class Yellowcircle extends snowygames.russianfoolsday.circles.Circle {
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
