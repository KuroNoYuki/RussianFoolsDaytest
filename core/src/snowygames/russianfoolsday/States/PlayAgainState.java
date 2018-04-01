package snowygames.russianfoolsday.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
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
    BitmapFont sound;
    BitmapFont yourScore;
    int score;
    BitmapFont message;
    BitmapFont bscore;
    String msgScore;
    String msgMsg;
    String msgBestScore;
   // GlyphLayout glyScore;
    //GlyphLayout glyMsg;
  //  GlyphLayout glyBestScore;
  //  private Vector3 touchPos;
  //  private Rectangle textureBounds;
    Table playAgainTable;

    public PlayAgainState(GameStateManager gsm, OrthographicCamera camera) {
        super(gsm, camera);
        background = new Texture("newBackGround.png");
        playBtn = new Texture("playbtn.png");
        balalaika = new Texture("balalaika.png");
       // camera.setToOrtho(false, RussianFoolsDay.WIDTH,RussianFoolsDay.HEIGHT);
        yourScore = new BitmapFont(Gdx.files.internal("newfont.fnt"));
        score = PlayState.getScore();
        //yourScore.setColor(0,0,1,1);
        Color color = yourScore.getColor();
        //yourScore.getData().setScale(2,2);
        message = new BitmapFont(Gdx.files.internal("newfont.fnt"));
        sound = new BitmapFont(Gdx.files.internal("sound.fnt"));
       // message.setColor(0,0,1,1);
       // message.getData().setScale(2,1.5f);
        bscore = new BitmapFont(Gdx.files.internal("newfont.fnt"));

        //bscore.setColor(0,0,1,1);
        //bscore.getData().setScale(1.5f,1.5f);
        //msgScore = new String("YOUR SCORE IS: ");
        //msgMsgOne = "You can do it better";
       // msgBestScore = new String("Your best score: ");
        //glyScore.setText(yourScore, "Ur score"+ score);
        //glyBestScore.setText(bscore, "Ur best score" + bestscore.getInteger("bestScore"));
        if (score<6){
            msgMsg = new String("You can do it better");
        }
        if (score >5 && score <15){
            msgMsg = new String("Nice one!");
        }
        if (score>14 && score < 30){
            msgMsg = new String("Well done!");
        }
        if (score>29){
            msgMsg = new String("A REAL HERO!!!");
        }
       // glyMsg.setText(message, msgMsg);
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
            soundSettings.set(RussianFoolsDay.width - 100, RussianFoolsDay.HEIGHT - 100, 100,100);
           /* if(soundSettings.contains(tmp.x,tmp.y)){
                if(RussianFoolsDay.isItPlaying() == true ){
                    RussianFoolsDay.startMusic()
                }
                if(RussianFoolsDay.Calm.isPlaying() == false){
                    RussianFoolsDay.Calm.play();sdd
                    RussianFoolsDay.Calm.setLooping(true);
           x     }
            }*/
            if(soundSettings.contains(touch.x,touch.y)){
                if (RussianFoolsDay.isItPlaying() == true){
                    RussianFoolsDay.offMusic();
                } else {RussianFoolsDay.startMusic();}
            }
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
        sb.draw(balalaika,RussianFoolsDay.width - 100, RussianFoolsDay.HEIGHT - 100,100,100);
        GlyphLayout glyScore = new GlyphLayout();
        glyScore.setText(yourScore, "Your score: "+ score);
        yourScore.draw(sb,glyScore,(RussianFoolsDay.width /2) - glyScore.width/2 ,RussianFoolsDay.HEIGHT / 1.25f);
       // message.draw(sb, glyMsg, (RussianFoolsDay.width /2) - glyMsg.width/2  ,550);
        GlyphLayout glyBestScore = new GlyphLayout();
        glyBestScore.setText(bscore, "Your best score: " + bestscore.getInteger("bestScore"));
        bscore.draw(sb,glyBestScore,(RussianFoolsDay.width /2) - glyBestScore.width/2  ,700);
        GlyphLayout glyMsg = new GlyphLayout();
        glyMsg.setText(message, msgMsg);
        message.draw(sb, glyMsg, (RussianFoolsDay.width /2) - glyMsg.width/2  ,550);
        GlyphLayout glySound = new GlyphLayout();
        glySound.setText(sound,"Sound");
        sound.draw(sb,glySound,RussianFoolsDay.width - 65, RussianFoolsDay.HEIGHT - 75);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
        yourScore.dispose();
    }
}
