package snowygames.russianfoolsday.States;

/**
 * Created by eshas on 07.03.2018.
 */
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

import snowygames.russianfoolsday.RussianFoolsDay;

public abstract class State {

    protected Vector3 mouse;
    protected GameStateManager gsm;
    protected final OrthographicCamera camera;

    public State(GameStateManager gsm, OrthographicCamera camera){
        this.gsm = gsm;
        this.camera = camera;
        mouse = new Vector3();
    }
    public abstract void handleinput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();

}
