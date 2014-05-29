package jp.co.spookies.android.alarm;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AlarmActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bell);
		setVolumeControlStream(AudioManager.STREAM_ALARM);
		Animation animation = AnimationUtils.loadAnimation(this,
				R.anim.vibration);
		ImageView clock = (ImageView) findViewById(R.id.clock);
		clock.startAnimation(animation);
	}

	public void onClick(View view) {
		ImageView clock = (ImageView) findViewById(R.id.clock);
		clock.clearAnimation();
		stopService(new Intent(this, BellService.class));
	}
}
