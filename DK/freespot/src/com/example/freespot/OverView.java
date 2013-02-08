package com.example.freespot;


import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.digitrainer.R;

public class OverView extends ListFragment {
	
	/**
	 * Array with strings to show in list
	 */
	private String dataArray[];
	ProgressBar pb;
	
	public OverView() {
		
		/*
		dataArray = new String[] {
				"One",
				"Two",
				"Three",
		};
		*/
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		/**
		 * ListAdapter will get info from dataArray and put it to the list
		 */
		//ListAdapter listAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, dataArray);
		//setListAdapter(listAdapter);
		
		
	      
	}

	
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_overview, container, false);
		 pb = (ProgressBar) v.findViewById(R.id.pgbAwardProgress);

		 pb.setVisibility(View.VISIBLE);
         pb.setMax(100);
         pb.setProgress(60);
         pb.setIndeterminate(false);

         return v;
	}
	
	
	/*
	 * public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

             View V = inflater.inflate(R.layout.testclassfragment, container, false);
             ImageView imageView = (ImageView)V.findViewById(R.id.my_image);

             return V;
    }
	 * 
	 * 
	 * */
	
	
	
	/*
	@Override
	public void onListItemClick(ListView list, View v, int position, long id) {
		/**
		 * Toast message will be shown when you click any list element
		 */
	/*	Toast.makeText(getActivity(), getListView().getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
	}*/
}
