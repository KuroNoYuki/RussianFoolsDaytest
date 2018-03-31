package snowygames.russianfoolsday;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import snowygames.russianfoolsday.States.GameStateManager;
import snowygames.russianfoolsday.States.MenuState;
import snowygames.russianfoolsday.States.PlayState;
import snowygames.russianfoolsday.States.PlayAgainState;

public class RussianFoolsDay extends ApplicationAdapter {
	public static final int WIDTH = 480;
	public OrthographicCamera camera;
	public static final int HEIGHT = 800;
	//public static final String TITLE = "Russain Fools' Day";
	private GameStateManager gsm;
	private SpriteBatch batch;
	private static Music Calm;
	public static float worldHeight = 16;
	public static float worldWidth;
	int screenHeight;
	int screenWidth;

	@Override
	public void create () {
	    batch = new SpriteBatch();
	    camera = new OrthographicCamera();
		gsm = new GameStateManager();
		Gdx.gl.glClearColor(0, 0.2f, 0.5f, 1);
		gsm.push(new MenuState(gsm));
		Calm = Gdx.audio.newMusic(Gdx.files.internal("Calm.mp3"));
		Calm.setLooping(true);
		Calm.play();

	}

	public static boolean isItPlaying(){
		if(Calm.isPlaying() == true){
			return true;
		}else return false;
	}
	public void offMusic(){
		Calm.pause();
	}
	public void startMusic(){
		Calm.setLooping(true);
		Calm.play();
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);

	}

	@Override
	public void resize(int screenHeight,int screenWidth){

		worldWidth = worldHeight *(screenHeight / screenWidth);
		camera.setToOrtho(false,WIDTH,HEIGHT);
		camera.update();

	}



	@Override
	public void dispose () {
		Calm.dispose();
		batch.dispose();

	}}

