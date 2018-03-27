package snowygames.russianfoolsday.Actors;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

import snowygames.russianfoolsday.RussianFoolsDay;

import static snowygames.russianfoolsday.RussianFoolsDay.WIDTH;

/**
 * Created by eshas on 26.03.2018.
 */

public class Redcirclepool {
    private final ArrayList<Redcircle> free = new ArrayList<Redcircle>();

    public Redcircle get(){
        if(free.isEmpty()){
            return new Redcircle((WIDTH / 2), (RussianFoolsDay.HEIGHT / 2));
        }else {
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
    public void free(Redcircle obj){
        free.add(obj);
    }


}