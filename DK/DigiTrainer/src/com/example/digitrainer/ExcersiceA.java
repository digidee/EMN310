package com.example.digitrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.example.digitrainer.database.Comment;
import com.example.digitrainer.database.CommentsDataSource;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ExcersiceA extends ListActivity {

	private CommentsDataSource datasource;
	private List<Model> list = new ArrayList<Model>();
	private static final String LOG_TAG = "Digitrainer";

  
/** Called when the activity is first created. */

  public void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    
    datasource = new CommentsDataSource(this);
    datasource.open();

    List<Comment> values = datasource.getAllComments();
    
    //Setting header for the excersice list
    //Has to be decleared before setListAdapter
    View header = getLayoutInflater().inflate(R.layout.rowheader, null);
    View footer = getLayoutInflater().inflate(R.layout.rowfooter, null);
    ListView listView = getListView();
    listView.addHeaderView(header);
    listView.addFooterView(footer);
    
    
    // Create an array of Strings, that will be put to our ListActivity
  /* ArrayAdapter<Model> adapter = new InteractiveArrayAdapter(this,
        getModel());
    setListAdapter(adapter);*/
    
    ArrayAdapter<Comment> adapter = new ArrayAdapter<Comment>(this,
            R.layout.rowlayout, R.id.label, values);
        setListAdapter(adapter);
    

    
  }

  private List<Model> getModel() {
   
    list.add(get("Bench Press"));
    list.add(get("Squats"));
    list.add(get("Dips"));
    list.add(get("Pull Down"));
    list.add(get("French Press"));
    list.add(get("Abs"));
    // Initially select one of the items
    //list.get(1).setSelected(true);
    return list;
  }
  
  
  @Override
  protected void onListItemClick(ListView l, View v, int position, long id) {
    super.onListItemClick(l, v, position, id);
    
    Log.d( LOG_TAG, "Clicked Row" +  list.get(position-1).getName());
    
    TextView t =(TextView) v.findViewById(R.id.label);
    String keyword = t.getText().toString();
/*
    Toast to =Toast.makeText(this, "You selected: " + keyword, Toast.LENGTH_SHORT);
    to.setGravity(Gravity.BOTTOM, 0, 0);
    to.show();*/
    
    CheckBox cb = (CheckBox) v.findViewById( R.id.check );
    if( cb != null )
        cb.toggle();
    
    
    create_toast(keyword);
  }
  
  
	 public void create_toast(String display_text){
		 
	    /***************************
	     * Custom toast test
	     ***************************/
	    LayoutInflater inflater = getLayoutInflater();
	    View layout = inflater.inflate(R.layout.toast_layout,
	                                   (ViewGroup) findViewById(R.id.toast_layout_root));

	    TextView text = (TextView) layout.findViewById(R.id.text);
	    text.setText(display_text);

	    Toast toast = new Toast(getApplicationContext());
	    toast.setGravity(Gravity.BOTTOM, 0, 10);
	    toast.setDuration(Toast.LENGTH_SHORT);
	    toast.setView(layout);
	    toast.show();
	    
	    /*********************
	     * End Custom toast
	     *********************/

	 }
  
  

  private Model get(String s) {
    return new Model(s);
  }

} 