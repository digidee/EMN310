package com.example.zwapp;

import android.content.Context;
import android.widget.ArrayAdapter;

public class UserAdapter extends ArrayAdapter<String> {
	private final Context context;
	private final String[] values;
	
	public UserAdapter(Context context, String[] values) {
		super(context, R.layout.activity_zwapp, values);
		this.context = context;
		this.values = values;
		
	}
}
