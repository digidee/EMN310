package com.example.freespot;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ParkingLog extends ListFragment {
	
	private String[] values;
	

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    

    
	values = new String[] { "Test", "Test" };
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
        R.layout.rowlayout, R.id.label, values);    
    
    setListAdapter(adapter);

  }

  	

  
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	    return inflater.inflate(R.layout.fragment_moneylog, container, false);
		
	}

	@Override
	public void onListItemClick(ListView list, View v, int position, long id) {
		/**
		 * Toast message will be shown when you click any list element
		 */
	/*	Toast.makeText(getActivity(), getListView().getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();

		ImageView imageView = (ImageView) v.findViewById(R.id.icon);
	    
	    Button fail = (Button) v.findViewById(R.id.win);
	    fail.setText("moos");
	    
	    Button win = (Button) v.findViewById(R.id.fail);
	    win.setText("moos1");
	   
	      imageView.setImageResource(R.drawable.ok);*/
	    
	}

} 