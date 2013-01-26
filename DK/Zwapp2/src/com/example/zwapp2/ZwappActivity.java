package com.example.zwapp2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;


import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;
import android.widget.Chronometer;
import android.os.SystemClock;

public class ZwappActivity extends ExpandableListActivity{
	

	
	Chronometer mChronometer;
	
	
	
	private static final String LOG_TAG = "DeeKay";
	
	static final String sharingEVs[] =
		{
		"DeeKay", "Special_K", "Theresol", "Anon"
		};
	
	static final String shareInfo[][] = 
		{
			//DeeKay
			{
				"Battery Status:","90%",
				"Proximity:","50 Meters",
				"Car Type:","Tesla Model S, Black"
			},
			//Special_K
			{
				"Battery Status:","70%",
				"Proximity:","250 Meters",
				"Car Type:","Nissan Leaf, Blue"
			},
			//Theresol
			{
				"Battery Status:","60%",
				"Proximity:","500 Meters",
				"Car Type:","Smart ED, Green"
			},
			//Anon
			{
				"Battery Status:","50%",
				"Proximity:","1000 Meters",
				"Car Type:","Buddy, White",
				"Connect:", "Timer: 00:00" 
			}
		};
	
	

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zwapp);
		

		
	    
	     final Button testButton = (Button) findViewById(R.id.shareButton);
	     testButton.setOnClickListener(new View.OnClickListener() {
	    	 boolean isSharing=false;
	    	 TextView t = (TextView)findViewById(R.id.usershare);	
	    	 
	         @Override
	         public void onClick(View v) {
	  	    	   if(!isSharing){
	  			    	testButton.setText("Unshare");
	  			    	testButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.unshare_custom_button));
	  			       	isSharing=true;
	  			       	t.setText("is sharing");
	  			       	Log.d( LOG_TAG, "Clicked Share" );
	  			     // 
	  			     }
	  			     else
	  			     {
	  			    	 testButton.setText("Share");
	  			    	testButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.custom_button));
	  			    	 isSharing=false;
	  			    	t.setText("");	
	  			    //	
	  			     }
	    	     }
	         });
	     

		
		SimpleExpandableListAdapter expListAdapter = new SimpleExpandableListAdapter(
				this,
				createGroupList(),	
				R.layout.sharecar,	
				new String[] { "driverName" },	
				new int[] { R.id.childname },		
				createChildList(),	
				R.layout.shareinfo,
				new String[] { "driverInfo", "info" },	
				new int[] { R.id.childname, R.id.info }	
			);
		setListAdapter( expListAdapter );	


	}

	public void  onContentChanged  () {
		super.onContentChanged();
		Log.d( LOG_TAG, "onContentChanged" );
	}

	
 
	  public boolean onChildClick(
	            ExpandableListView parent, 
	            View v, 
	            int groupPosition,
	            int childPosition,
	            long id) {
	       Log.d( LOG_TAG, "onChildClick: "+childPosition );
	        CheckBox cb = (CheckBox)v.findViewById( R.id.check1 );
	        if( cb != null )
	            cb.toggle();
	        return false;
	    }
	  
	  
	
    public void  onGroupExpand  (int groupPosition) {
        Log.d( LOG_TAG,"onGroupExpand: "+groupPosition );
        mChronometer = (Chronometer) findViewById(R.id.chronometer+0);
		final Button connectButton = (Button) findViewById(R.id.connectButton+0);
		connectButton.setOnClickListener(new View.OnClickListener(){
			boolean isConnected = false;
			public void onClick(View v){
				if (isConnected){
					connectButton.setText("Disconnect");
					isConnected=false;
					connectButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.disconnect_custom_button));
					mChronometer.start();
					View b = findViewById(R.id.chronometer);
					b.setVisibility(View.VISIBLE);
					View b2 = findViewById(R.id.chcon);
					b2.setVisibility(View.VISIBLE);
				}
				else{
					connectButton.setText("Connect");
					isConnected=true;
					connectButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.connect_custom_button));
					mChronometer.setBase(SystemClock.elapsedRealtime());
					View b = findViewById(R.id.chronometer);
					b.setVisibility(View.GONE);
					View b2 = findViewById(R.id.chcon);
					b2.setVisibility(View.GONE);
				}
				
			}
		});
			
    }
    
    
    

   	private List createGroupList() {
   		ArrayList result = new ArrayList();
   		for( int i = 0 ; i < sharingEVs.length ; ++i ) {
   			HashMap m = new HashMap();
   			m.put( "driverName",sharingEVs[i] );
   			result.add( m );
   		}
   		return (List)result;
   	}
    
    
    
     private List createChildList() {
    	 ArrayList result = new ArrayList();
    	 for( int i = 0 ; i < shareInfo.length ; ++i ) {
    		 // Second-level lists
    		 ArrayList secList = new ArrayList();
    		 for( int n = 0 ; n < shareInfo[i].length ; n += 2 ) {
    			 HashMap child = new HashMap();
    			 child.put( "driverInfo", shareInfo[i][n] );
    			 child.put( "info", shareInfo[i][n+1] );
    			 secList.add( child );
    		 }

    		 result.add( secList );
    	 }
    	 return result;
     }
    
     
     
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_zwapp, menu);
		return true;
	}

}
