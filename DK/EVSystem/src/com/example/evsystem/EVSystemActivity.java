package com.example.evsystem;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;


public class EVSystemActivity extends Activity implements ListFragment.OnItemSelectedListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_evsystem);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_evsystem, menu);
		return true;
	}
	
	@Override
	public void onItemSelected(String link) {
	    DetailFragment fragment = (DetailFragment) getFragmentManager()
	            .findFragmentById(R.id.detailFragment);
	        if (fragment != null && fragment.isInLayout()) {
	          fragment.setText(link);

	        } 
	  }

}
