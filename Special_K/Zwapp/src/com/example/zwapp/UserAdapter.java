package com.example.zwapp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class UserAdapter extends ArrayAdapter<String> {
	private final Context context;
	private final String[] values;
	
	public UserAdapter(Context context, String[] values) {
		super(context, R.layout.activity_zwapp, values);
		this.context = context;
		this.values = values;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.activity_zwapp, parent, false);
		TextView textView = (TextView) rowView.findViewById(R.id.user);
		textView.setText(values[position]);
		
		String s = values[position];
		if (s.startsWith("DeeKay") || s.startsWith("Keegil") || s.startsWith("Theresol")) {
			textView.setBackgroundColor(Color.GREEN);
		} else {
			textView.setBackgroundColor(Color.RED);
		}
		
		return rowView;
	}
}
