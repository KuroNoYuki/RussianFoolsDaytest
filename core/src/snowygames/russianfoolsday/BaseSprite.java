package snowygames.russianfoolsday;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class BaseSprite {

    public final Vector2 pos = new Vector2();
    protected float width;
    protected float height;
    protected Texture texture;

    public BaseSprite(Texture texture) {
        this.texture = texture;
    }

    public Vector2 getPos() {
        return pos;
    }

    public  float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getLeft() {
        return pos.x - width / 2f;
    }

    public float getBottom() {
        return pos.y - height / 2f;
    }

    public void setHeight(float height){
        this.height = height;
    }

    public void setWidth(float width){
        this.width = width;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, getLeft(), getBottom(), width, height);
    }
}
