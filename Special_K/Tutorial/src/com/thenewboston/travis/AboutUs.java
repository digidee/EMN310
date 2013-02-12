package com.thenewboston.travis;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class AboutUs extends Activity {
	
	TextView textAbout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		textAbout = (TextView) findViewById(R.id.tvTroll);
		SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		boolean troll = getPrefs.getBoolean("checkbox", true);
		if (troll == true) {
			textAbout.setText("trolololololololololo");
		} else if (troll == false) {
			textAbout.setText("lololololololololololo");
		}
	}

}
