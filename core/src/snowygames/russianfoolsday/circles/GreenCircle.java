package snowygames.russianfoolsday.circles;

import com.badlogic.gdx.graphics.Texture;

public class GreenCircle extends Circle {

    public GreenCircle(Texture texture, float x, float y) {
        super(texture);
        pos.set(x, y);
        height = 160;
        width = 160;
    }
}
