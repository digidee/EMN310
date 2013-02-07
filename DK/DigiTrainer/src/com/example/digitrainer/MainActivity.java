package com.example.digitrainer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.digitrainer.database.TestDatabaseActivity;;

public class MainActivity extends Activity {
	
	Button excersice;
	Button progress;
	Button register;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		excersice = (Button) findViewById(R.id.excersice_a);
		progress = (Button) findViewById(R.id.excersice_b);
		register = (Button) findViewById(R.id.registervalues);
		
		excersice.setOnClickListener(excersice_handler);
		progress.setOnClickListener(progress_handler);
		register.setOnClickListener(register_handler);
		
		
	}
	
	private View.OnClickListener excersice_handler = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			 //Toast.makeText(MainActivity.this, "Excersice!", Toast.LENGTH_LONG).show();
			 Intent i = new Intent(MainActivity.this, ExcersiceA.class);
			 startActivity(i);
			
		}
	};

	private View.OnClickListener progress_handler = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			//Toast.makeText(MainActivity.this, "Progress!", Toast.LENGTH_LONG).show();
			Intent i = new Intent(MainActivity.this, ExcersiceB.class);
			startActivity(i);
			
		}
	};
	
	private View.OnClickListener register_handler = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			//Toast.makeText(MainActivity.this, "Progress!", Toast.LENGTH_LONG).show();
			Intent i = new Intent(MainActivity.this, TestDatabaseActivity.class);
			startActivity(i);
			
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
