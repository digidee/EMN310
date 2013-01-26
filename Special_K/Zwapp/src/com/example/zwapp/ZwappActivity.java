package com.example.zwapp;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;

/* public class ZwappActivity extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zwapp);
		
		ListView listView = (ListView) findViewById(R.id.list);
		String[] users = new String[] { "DeeKay", "Special K", "Theresol", "ArntF", 
				"InvisibleMan", "TheBatSign", "R2D2" };
		
		ArrayAdapter<String> userlist = new ArrayAdapter<String>(this, 
				android.R.layout.simple_list_item_1, users);
		
		listView.setAdapter(userlist); 
	} */

public class ZwappActivity extends ListActivity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String[] users = new String[] { "DeeKay", "Keegil", "Theresol", "ArntF", 
				"InvisibleMan", "TheBatSign", "R2D2" };
		UserAdapter adapter = new UserAdapter(this, users);
		setListAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_zwapp, menu);
		return true;
	}

}