package snowygames.russianfoolsday.States;

/**
 * Created by eshas on 07.03.2018.
 */
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import snowygames.russianfoolsday.RussianFoolsDay;

public class MenuState extends State {

    private Texture background;
    private Texture playBtn;
    private final Rectangle textureBounds = new Rectangle();
    private final Vector3 touch = new Vector3();
    private BitmapFont rusfool;
    BitmapFont sound;
    private final Rectangle soundSettings = new Rectangle();
    private Texture balalaika;

    public MenuState(GameStateManager gsm, OrthographicCamera camera) {
        super(gsm, camera);
        background = new Texture("newBackGround.png");
        playBtn = new Texture("playbtn.png");
        balalaika = new Texture("balalaika.png");
        sound = new BitmapFont(Gdx.files.internal("sound.fnt"));
        rusfool = new BitmapFont(Gdx.files.internal("rusfoolsday.fnt"));
        //camera.setToOrtho(false, RussianFoolsDay.WIDTH/2,RussianFoolsDay.HEIGHT/2);
        //textureBounds = new Rectangle(RussianFoolsDay.WIDTH/2 - playBtn.getWidth()/2,RussianFoolsDay.HEIGHT / 2, playBtn.getWidth(),playBtn.getHeight());
    }

    @Override
    public void handleinput() {
        if(Gdx.input.justTouched()) {
            touch.set(Gdx.input.getX(),Gdx.input.getY(),0);
            camera.unproject(touch);

            textureBounds.set(RussianFoolsDay.width / 2f - playBtn.getWidth() / 2f, RussianFoolsDay.HEIGHT / 2f, playBtn.getWidth(), playBtn.getHeight());
            if (textureBounds.contains(touch.x, touch.y)) {
                gsm.set(new PlayState(gsm, camera));
            }
            soundSettings.set(RussianFoolsDay.width - 100, RussianFoolsDay.HEIGHT - 100, 100,100);
            if(soundSettings.contains(touch.x,touch.y)){
                if (RussianFoolsDay.isItPlaying() == true){
                    RussianFoolsDay.offMusic();
                } else {RussianFoolsDay.startMusic();}
            }
        }
    }

    @Override
    public void update(float dt) {
        handleinput();
    }

    @Override
    public void render(SpriteBatch sb) {
        //sb.setProjectionMatrix(camera.combined);
        sb.begin();
        float bgWidth = RussianFoolsDay.width;
        float bgHeight = bgWidth / (background.getWidth() / (float) background.getHeight());
        sb.draw(background, 0,0, bgWidth, bgHeight);
        sb.draw(playBtn,(RussianFoolsDay.width /2) - (playBtn.getWidth()/2), RussianFoolsDay.HEIGHT / 2);
        sb.draw(balalaika,RussianFoolsDay.width - 100, RussianFoolsDay.HEIGHT - 100,100,100);

        GlyphLayout glySound = new GlyphLayout();
        glySound.setText(sound,"Sound");
        sound.draw(sb,glySound,RussianFoolsDay.width - 65, RussianFoolsDay.HEIGHT - 75);
        GlyphLayout glyRusfool = new GlyphLayout();
        glyRusfool.setText(rusfool, "RUSSIAN FOOL'S DAY");
        rusfool.draw(sb, glyRusfool, RussianFoolsDay.width/2 - glyRusfool.width/2, (RussianFoolsDay.HEIGHT/2 + 250) );
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
    }
}
