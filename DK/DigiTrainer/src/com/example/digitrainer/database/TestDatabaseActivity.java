package com.example.digitrainer.database;

import java.util.List;

import com.example.digitrainer.MainActivity;
import com.example.digitrainer.R;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class TestDatabaseActivity extends ListActivity {
  private CommentsDataSource datasource;
  Button win;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.databasemain);

    datasource = new CommentsDataSource(this);
    datasource.open();

    List<Comment> values = datasource.getAllComments();

    // Use the SimpleCursorAdapter to show the
    // elements in a ListView
    ArrayAdapter<Comment> adapter = new ArrayAdapter<Comment>(this,
        R.layout.rowlayout, R.id.label, values);
    setListAdapter(adapter);
  }

  // Will be called via the onClick attribute
  // of the buttons in main.xml
  public void onClick(View view) {
    @SuppressWarnings("unchecked")
    ArrayAdapter<Comment> adapter = (ArrayAdapter<Comment>) getListAdapter();
    Comment comment = null;
    
    
    switch (view.getId()) {
    case R.id.add:
      //String[] comments = new String[] { "Cool", "Very nice", "Hate it" };
      //int nextInt = new Random().nextInt(3);
      
      TextView newexc = (TextView) findViewById(R.id.new_excersice);
      String excer = newexc.getText().toString();
      
      if (!excer.contentEquals("")){
    	// Save the new comment to the database
    	comment = datasource.createComment(excer);
      	adapter.add(comment);  
      }
      break;
    case R.id.delete:
      if (getListAdapter().getCount() > 0) {
        comment = (Comment) getListAdapter().getItem(0);
        datasource.deleteComment(comment);
        adapter.remove(comment);
      }
      break;
    }
    adapter.notifyDataSetChanged();
    

    
  }
  
  
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
	    win = (Button) v.findViewById(R.id.win);
	    win.setOnClickListener(delete_handler);

	}
	
	
	private View.OnClickListener delete_handler = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			//Toast.makeText(MainActivity.this, "Progress!", Toast.LENGTH_LONG).show();
			win.setText("moos1");
			
		}
	};

  @Override
  protected void onResume() {
    datasource.open();
    super.onResume();
  }

  @Override
  protected void onPause() {
    datasource.close();
    super.onPause();
  }

} 