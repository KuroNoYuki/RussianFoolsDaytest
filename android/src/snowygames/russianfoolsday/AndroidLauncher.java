package snowygames.russianfoolsday;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import snowygames.russianfoolsday.RussianFoolsDay;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new RussianFoolsDay(), config);
		config.useAccelerometer = false;
		config.useCompass = false;
	}
}
