package snowygames.russianfoolsday.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Timer;

import java.util.Iterator;

import snowygames.russianfoolsday.Actors.Greencircle;
import snowygames.russianfoolsday.Actors.Matryoshka;
import snowygames.russianfoolsday.Actors.Matryoshkadown;
import snowygames.russianfoolsday.Actors.ObjectHead;
import snowygames.russianfoolsday.Actors.Redcircle;
import snowygames.russianfoolsday.Actors.Redcirclepool;
import snowygames.russianfoolsday.RussianFoolsDay;

import static snowygames.russianfoolsday.RussianFoolsDay.WIDTH;


/**
 * Created by eshas on 08.03.2018.
 */

public class PlayState extends State {
    private Redcircle[] redcirc = new Redcircle[5];
    private Redcircle redcirctwo;
    private Greencircle greencirc;
    public static Preferences bestscore;
    public static int SCORE;
    BitmapFont yourScore;
    boolean shit;
    boolean newshit;
    private final Vector2 worldCenter = new Vector2(RussianFoolsDay.WIDTH/2f,RussianFoolsDay.HEIGHT/2f);
    private final int worldTop = RussianFoolsDay.HEIGHT - 1;
    private final int worldDown = 1;
    private Texture textureEmptyHead;
    private final Matryoshka[] heads = new Matryoshka[7];
    private int currentHead;
    private int currentDown;
    private Vector2 headPlace = new Vector2(worldCenter.x ,worldCenter.y + 120);
    private Texture textureEmptyDown;
    private final Matryoshkadown[] downs = new Matryoshkadown[7];
    private Vector2 downPlace = new Vector2(worldCenter.x,headPlace.y - 287);
    private static BitmapFont bscore;
   // private Texture redcircle;
    private Array<Redcircle> redcircles;
    private Redcirclepool redpool = new Redcirclepool();
    private float downheight;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        //redcircle = new Texture("redcircle.png");
        textureEmptyHead = new Texture("Emptyheadcolored.png");
        textureEmptyDown = new Texture("Emptydowncolored.png");
        //redcirc[1] = new Redcircle(redcircle,(WIDTH /2),(RussianFoolsDay.HEIGHT/2));
        camera.setToOrtho(false, WIDTH,RussianFoolsDay.HEIGHT);
        greencirc = new Greencircle((WIDTH /2),(RussianFoolsDay.HEIGHT/2));
        SCORE = 0;
        yourScore = new BitmapFont();
        yourScore.setColor(1,0.2f,0,1);
        bestscore = Gdx.app.getPreferences("RussianFoolsDayscore");
        bscore = new BitmapFont();
        bscore.setColor(1,0.2f,0,1);
        for (int i = 0; i < heads.length; i++){
            heads[i] = new Matryoshka(textureEmptyHead,headPlace);
        }
        for (int i = 0; i < downs.length; i++){
            downs[i] = new Matryoshkadown(textureEmptyDown,downPlace);
        }
        redcirc[1] = new Redcircle((WIDTH / 2), (RussianFoolsDay.HEIGHT / 2));
        redcirc[1].setDownBarrier(greencirc.getHeight() * 5 / 8);
        redcirctwo = redpool.get();
        redcirc[1].setFlying();
    }

    @Override
    public void handleinput() {
        if (Gdx.input.justTouched()) {
            //for (Redcircle redcircle: redcircles){redcircle.get}
            for (int i = 0; i<redcirc.length; i++){
                if (redcirc[i]!= null){
                    forcurrentredcirc();
                    if (downheight < greencirc.getHeight()) {
                        redcirc[i].setIdle();
                        //if ( i==1)redcirc[i] = new Redcircle((WIDTH / 2), (RussianFoolsDay.HEIGHT / 2));
                        SCORE++;
                       if (SCORE % 5 == 0) {
                           redcirc[2] = new Redcircle((WIDTH / 2), (RussianFoolsDay.HEIGHT / 2));
                           redcirc[2].setDownBarrier(greencirc.getHeight() * 5 / 8);
                           redcirc[2].setFlying();
                       }



                       if (greencirc.getHeight() > 80) {
                           greencirc.setWidth(greencirc.getWidth() - 10);
                           greencirc.setHeight(greencirc.getHeight() - 10);
                        }
                       if (++currentHead == heads.length - 1) currentHead = 0;
                       foregroundHead(currentHead);
                       heads[heads.length - 1].setFlying();
                      if (++currentDown == downs.length - 1) currentDown = 0;
                      foregroundDown(currentDown);
                      downs[downs.length - 1].setFlying();
                }
                //if(redcirc[1].getHeight() >= greencirc.getHeight()){

                else{   Gdx.input.vibrate(200);
                        gsm.push(new PlayAgainState(gsm));
                    }}}}

            /*if (redcirc[2].getHeight() < greencirc.getHeight()) {
                redcirc[2].dispose();
                //redcirc[1] = new Redcircle((WIDTH / 2), (RussianFoolsDay.HEIGHT / 2));
                SCORE++;
                   /* if (SCORE % 5 == 0) {
                        redcirc[2] = new Redcircle((WIDTH / 2), (RussianFoolsDay.HEIGHT / 2));
                    }*/

                /*if (Greencircle.getHeight() > 80) {
                    Greencircle.setWidth(Greencircle.getWidth() - 5);
                    Greencircle.setHeight(Greencircle.getHeight() - 5);
                }
                if (++currentHead == heads.length - 1) currentHead = 0;
                foregroundHead(currentHead);
                heads[heads.length - 1].setFlying();
                if (++currentDown == downs.length - 1) currentDown = 0;
                foregroundDown(currentDown);
                downs[downs.length - 1].setFlying();
            }
            if(redcirc[2].getHeight() >= greencirc.getHeight()){
                Gdx.input.vibrate(200);
                gsm.push(new PlayAgainState(gsm));
            }*/
            }


    public void forcurrentredcirc(){
        if(redcirc[2]!= null){
            if (redcirc[1].getHeight()> redcirc[2].getHeight()){
                downheight = redcirc[2].getHeight();
            }
            else {
                downheight = redcirc[1].getHeight();
            }
        }
    }


    public void foregroundHead(int i){
        int lastHead = heads.length - 1;
        if (i == lastHead) return;
        Matryoshka head = heads[lastHead];
        heads[lastHead] = heads[i];
        heads[i] = head;
    }
    public void foregroundDown(int i){
        int lastDown = downs.length - 1;
        if (i == lastDown) return;
        Matryoshkadown down = downs[lastDown];
        downs[lastDown] = downs[i];
        downs[i] = down;
    }
    public static int getScore() {
        int score = SCORE;
        return score;
    }
    @Override
    public void update(float dt) {
        /*if(redcirc[1].isIdle() == true ){
            redcirc[1].setFlying();
        }*/
        for(int i = 0; i< redcirc.length; i++){
        if(redcirc[i]!= null) redcirc[1].update(dt);}

        handleinput();
        for(int i = 0; i < heads.length; i++){
            heads[i].update(dt,worldTop);
        }
        for(int i = 0; i < downs.length; i++){
            downs[i].update(dt,worldDown);
        }
        if (bestscore.getInteger("bestScore")<SCORE){
            bestscore.putInteger("bestScore",SCORE);
            bestscore.flush();
        }


        if(redcirc[1].getHeight()<45) {

           // gsm.push(new PlayAgainState(gsm));
            //Gdx.input.vibrate(200);
        }

    }

    @Override
    public void render(SpriteBatch sb) {

        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        Color color = sb.getColor();
        for(int i = 0; i < heads.length; i++)heads[i].draw(sb);
        for(int i = 0; i < downs.length;i++) downs[i].draw(sb);
        float oldAlpha = color.a;
        float scaleone = 0.8f;
        color.a = oldAlpha * scaleone;
        sb.setColor(color);
        //redcirctwo.draw(sb);
        sb.draw(greencirc.getTextureGreencircle(),greencirc.getPosition().x - (greencirc.getWidth()/2),greencirc.getPosition().y -( greencirc.getHeight()/2),greencirc.getWidth(),greencirc.getHeight());
        color.a =oldAlpha;
        sb.setColor(color);
        //redcirctwo.draw(sb);
        for(int i = 0; i< redcirc.length; i++){
        if (redcirc[i]!= null)redcirc[i].draw(sb);
        }
        //redcirc[2].draw(sb);
        //redcirctwo.draw(sb);
        //sb.draw(redcirc.getRedcircle(),redcirc.getPosition().x - (redcirc.getWidth()/2),redcirc.getPosition().y -( redcirc.getHeight()/2),redcirc.getWidth(),redcirc.getHeight());
        yourScore.draw(sb,"Your Score "+SCORE,20,RussianFoolsDay.HEIGHT - 40);
        bscore.draw(sb,"Your best score: "+bestscore.getInteger("bestScore"),20,RussianFoolsDay.HEIGHT - 70);
        sb.end();
}

    @Override
    public void dispose() {
        //redcircle.dispose();
        greencirc.dispose();
        yourScore.dispose();
        textureEmptyHead.dispose();
        textureEmptyDown.dispose();
    }
}
