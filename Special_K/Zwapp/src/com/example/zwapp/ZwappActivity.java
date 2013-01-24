package com.example.zwapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ZwappActivity extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zwapp);
		
		ListView listView = (ListView) findViewById(R.id.list);
		String[] users = new String[] { "DeeKay", "Special K", "Theresol", "ArntF", 
				"InvisibleMan", "TheBatSign", "R2D2" };
		
		ArrayAdapter<String> userlist = new ArrayAdapter<String>(this, 
				android.R.layout.simple_list_item_1, users);
		
		listView.setAdapter(userlist);
		
				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_zwapp, menu);
		return true;
	}

}