package snowygames.russianfoolsday.circles;

import com.badlogic.gdx.graphics.Texture;

import snowygames.russianfoolsday.BaseSprite;

public class YellowCircle extends BaseSprite {

    public YellowCircle(Texture texture, float x, float y) {
        super(texture);
        pos.set(x, y);
        height = 160;
        width = 160;
    }
}
