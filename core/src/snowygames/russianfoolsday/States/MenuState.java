package snowygames.russianfoolsday.States;

/**
 * Created by eshas on 07.03.2018.
 */
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import snowygames.russianfoolsday.RussianFoolsDay;

public class MenuState extends State {
    private Texture background;
    private Texture playBtn;
    //private Rectangle textureBounds;
    //private Vector3 tmp;
    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("bg.png");
        playBtn = new Texture("playbtn.png");
        camera.setToOrtho(false, RussianFoolsDay.WIDTH,RussianFoolsDay.HEIGHT);
        //textureBounds = new Rectangle(RussianFoolsDay.WIDTH/2 - playBtn.getWidth()/2,RussianFoolsDay.HEIGHT / 2, playBtn.getWidth(),playBtn.getHeight());
    }

    @Override
    public void handleinput() {
        if(Gdx.input.justTouched()) {
            Vector3 tmp=new Vector3(Gdx.input.getX(),Gdx.input.getY(),0);
            camera.unproject(tmp);
            Rectangle textureBounds=new Rectangle((RussianFoolsDay.WIDTH/2) - (playBtn.getWidth()/2),RussianFoolsDay.HEIGHT / 2, playBtn.getWidth(),playBtn.getHeight());
            if (textureBounds.contains(tmp.x, tmp.y)) {
                gsm.set(new PlayState(gsm));
            }
        }
    }

    @Override
    public void update(float dt) {
        handleinput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(background, 0,0, RussianFoolsDay.WIDTH,RussianFoolsDay.HEIGHT);
        sb.draw(playBtn,(RussianFoolsDay.WIDTH/2) - (playBtn.getWidth()/2),RussianFoolsDay.HEIGHT / 2);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
    }
}
