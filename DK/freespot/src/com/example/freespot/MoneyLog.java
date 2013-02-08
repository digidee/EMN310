package com.example.freespot;

import com.example.digitrainer.R;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class MoneyLog extends ListFragment {
	
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
		Toast.makeText(getActivity(), getListView().getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();

		ImageView imageView = (ImageView) v.findViewById(R.id.icon);
	    
	    Button win = (Button) v.findViewById(R.id.win);
	    win.setText("moos");
	    
	   
	      imageView.setImageResource(R.drawable.ok);
	    
	}

} 