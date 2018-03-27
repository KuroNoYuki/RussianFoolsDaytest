package snowygames.russianfoolsday.circles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class Greencircle extends snowygames.russianfoolsday.circles.Circle {
   /* private Vector3 position;
    private float width,height;*/
    private Texture greencircle;

    public Greencircle (float x,float y){
        position = new Vector3(x,y,0);
        greencircle = new Texture("greening.png");
        //position.x =(RussianFoolsDay.WIDTH /2);
        //position.y = (RussianFoolsDay.HEIGHT/2);

        height = 160;
        width = height;
    }
    public void dispose(){
        greencircle.dispose();
    }

    /*public Vector3 getPosition() {
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
    }*/

    public Texture getTextureGreencircle() {
        return greencircle;
    }
}
