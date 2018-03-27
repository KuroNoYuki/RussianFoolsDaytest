package snowygames.russianfoolsday.Actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

import snowygames.russianfoolsday.RussianFoolsDay;
import snowygames.russianfoolsday.circles.Redcircle;

import static snowygames.russianfoolsday.RussianFoolsDay.WIDTH;

/**
 * Created by eshas on 26.03.2018.
 */

public class PoolRedCircle {

    private Texture texture;
    private final ArrayList<Redcircle> free = new ArrayList<snowygames.russianfoolsday.circles.Redcircle>();

    public PoolRedCircle(Texture texture) {
        this.texture = texture;
    }

    public Redcircle get(){
        if(free.isEmpty()){
            return new Redcircle(texture, (WIDTH / 2), (RussianFoolsDay.HEIGHT / 2));
        } else {
            return free.remove((free.size() - 1));

        }
    }
    public float getHeight(){
        return this.getHeight();
    }
    public void draw(SpriteBatch batch){
        this.draw(batch);
    }
    public void update(float dt){
        this.update(dt);
    }
    public void dispose(){
        this.dispose();
    }
    public void free(snowygames.russianfoolsday.circles.Redcircle obj){
        free.add(obj);
    }


}
