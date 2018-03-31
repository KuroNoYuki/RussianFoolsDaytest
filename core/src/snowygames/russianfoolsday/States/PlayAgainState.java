package snowygames.russianfoolsday.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import snowygames.russianfoolsday.RussianFoolsDay;

import static snowygames.russianfoolsday.States.PlayState.bestscore;

/**
 * Created by eshas on 10.03.2018.
 */

public class PlayAgainState extends State {
    private Texture background;
    private Texture playBtn;
    private Texture balalaika;
    BitmapFont yourScore;
    int score;
    BitmapFont message;
    BitmapFont bscore;
  //  private Vector3 touchPos;
  //  private Rectangle textureBounds;
    Table playAgainTable;

    public PlayAgainState(GameStateManager gsm, OrthographicCamera camera) {
        super(gsm, camera);
        background = new Texture("newBackGround.png");
        playBtn = new Texture("playbtn.png");
        balalaika = new Texture("balalaika.png");
       // camera.setToOrtho(false, RussianFoolsDay.WIDTH,RussianFoolsDay.HEIGHT);
        yourScore = new BitmapFont();
        score = PlayState.getScore();
        yourScore.setColor(0,0,1,1);
        Color color = yourScore.getColor();
        yourScore.getData().setScale(2,2);
        message = new BitmapFont();
        message.setColor(0,0,1,1);
        message.getData().setScale(2,1.5f);
        bscore = new BitmapFont();
        bscore.setColor(0,0,1,1);
        bscore.getData().setScale(1.5f,1.5f);

    }
    private final Vector3 touch = new Vector3();
    private final Rectangle textureBounds = new Rectangle();
    private final Rectangle soundSettings = new Rectangle();
    @Override
    public void handleinput() {
        if(Gdx.input.justTouched()) {
            touch.set(Gdx.input.getX(),Gdx.input.getY(),0);
            camera.unproject(touch);
            textureBounds.set((RussianFoolsDay.width /2) - (playBtn.getWidth()/2),RussianFoolsDay.HEIGHT / 2, playBtn.getWidth(),playBtn.getHeight());
            soundSettings.set(100, RussianFoolsDay.HEIGHT - 100, 50,50);
           /* if(soundSettings.contains(tmp.x,tmp.y)){
                if(RussianFoolsDay.isItPlaying() == true ){
                    RussianFoolsDay.startMusic()
                }
                if(RussianFoolsDay.Calm.isPlaying() == false){
                    RussianFoolsDay.Calm.play();
                    RussianFoolsDay.Calm.setLooping(true);
           x     }
            }*/
            if (textureBounds.contains(touch.x, touch.y)) {
                gsm.set(new PlayState(gsm, camera));
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
        sb.draw(background, 0,0, bgWidth,bgHeight);
        sb.draw(playBtn,(RussianFoolsDay.width /2) - (playBtn.getWidth()/2),RussianFoolsDay.HEIGHT / 2);
        sb.draw(balalaika,100, RussianFoolsDay.HEIGHT - 100,50,50);
        yourScore.draw(sb,"YOUR SCORE IS: " + PlayState.getScore(),(RussianFoolsDay.width /2) - (playBtn.getWidth()/2) - 60 ,RussianFoolsDay.HEIGHT / 1.25f);
        if (score<6){
            message.draw(sb, "You can do it better", (RussianFoolsDay.width /2) - (playBtn.getWidth()/2) - 70 ,550);
        }
        if (score >5 && score <15){
            message.draw(sb, "Well done Senpai!", (RussianFoolsDay.width /2) - (playBtn.getWidth()/2) - 55 ,550);
        }
        if (score>14){
            message.draw(sb, "Nice one!", (RussianFoolsDay.width /2) - (playBtn.getWidth()/2)+ 20  ,550);
        }
        bscore.draw(sb,"Your best score: " + bestscore.getInteger("bestScore"),(RussianFoolsDay.width /2) - (playBtn.getWidth()/2)+20  ,700);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
        yourScore.dispose();
    }
}
