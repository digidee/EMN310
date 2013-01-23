package com.example.evsystem;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ListFragment extends Fragment {
  
  private OnItemSelectedListener listener;
  
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_evsystem_overview,
        container, false);
    
    Button button = (Button) view.findViewById(R.id.button1);
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
    	  updateChargingStations();
      }
    });
    
    Button button2 = (Button) view.findViewById(R.id.button2);
    button2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
    	  updateEVFriends();
      }
    });
    
    
    Button button3 = (Button) view.findViewById(R.id.button3);
    button3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
    	  updateBattery();
      }
    });
    
    
    
    return view;
  }

  public interface OnItemSelectedListener {
      public void onItemSelected(String link);
    }
  
  @Override
    public void onAttach(Activity activity) {
      super.onAttach(activity);
      if (activity instanceof OnItemSelectedListener) {
        listener = (OnItemSelectedListener) activity;
      } else {
        throw new ClassCastException(activity.toString()
            + " must implemenet MyListFragment.OnItemSelectedListener");
      }
    }
   
	 // May also be triggered from the Activity
	 public void updateChargingStations() {
	    // Create fake data
	    String chargingStations = getString(R.string.charging_stations);
	    // Send data to Activity
	    listener.onItemSelected(chargingStations);
	  }
  
	 //May also be triggered from the Activity
	 public void updateEVFriends() {
	   // Create fake data
	   String evFriends = getString(R.string.ev_friends);
	   // Send data to Activity
	   listener.onItemSelected(evFriends);
	 }
 
	//May also be triggered from the Activity
	public void updateBattery() {
	  // Create fake data
	  String batteryStatus = getString(R.string.battery);
	  // Send data to Activity
	  listener.onItemSelected(batteryStatus);
	}
  
  
  
} 