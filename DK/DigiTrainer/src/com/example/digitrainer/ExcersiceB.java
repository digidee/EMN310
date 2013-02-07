package com.example.digitrainer;


import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.widget.Toast;

public class ExcersiceB extends FragmentActivity implements ActionBar.TabListener{
	
	private static final String STATE_SELECTED_NAVIGATION_ITEM = "Navigation_item_selected";
	public final static String EXTRA_MESSAGE = "com.example.test.MESSAGE";
		
	//Intent intent = new Intent(this, Excersice.class);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Setting the layout
		setContentView(R.layout.activity_excersice_b);
		
		//Creating tabs when the program starts
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		//Adding new tabs
		actionBar.addTab(actionBar.newTab().setText("Overview").setTabListener(this));
		actionBar.addTab(actionBar.newTab().setText("Excersice A").setTabListener(this));
		actionBar.addTab(actionBar.newTab().setText("Excersice B").setTabListener(this));
	}
	
	//To ensure the program stays on the same tab after restore
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
            getActionBar().setSelectedNavigationItem(
                    savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
        }
    }

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}*/

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
	
	


	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		//Switch to the right tab
		switch(tab.getPosition()){
			case 0:  	
				OverView ov = new OverView();
				getSupportFragmentManager().beginTransaction().replace(R.id.container, ov).commit();
				Toast.makeText(this, "Clicked listfrag", Toast.LENGTH_SHORT).show();
			break;
			case 1:  	
				Excersice ex = new Excersice();
				getSupportFragmentManager().beginTransaction().replace(R.id.container, ex).commit();
				Toast.makeText(this, tab.getText().toString(), Toast.LENGTH_SHORT).show();
			break;
			case 2:  	
				Excersice2 re = new Excersice2();
				getSupportFragmentManager().beginTransaction().replace(R.id.container, re).commit();
				Toast.makeText(this, tab.getText().toString(), Toast.LENGTH_SHORT).show();
			break;
		}
			
		
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

}