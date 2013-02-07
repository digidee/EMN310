package com.example.digitrainer;


import java.util.List;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class InteractiveArrayAdapter extends ArrayAdapter<Model> {
	
  private final List<Model> list;
  private final Activity context;
  private static final String LOG_TAG = "Digitrainer";
  private ExcersiceA ea;

  public InteractiveArrayAdapter(Activity context, List<Model> list) {
    super(context, R.layout.rowbuttonlayout, list);
    this.context = context;
    this.list = list;
  }

  static class ViewHolder {
    protected TextView text;
    protected CheckBox checkbox;
  }
  
  public void toastMe(){
	  ExcersiceA ea = new ExcersiceA();
	  ea.create_toast("moo");
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View view = null;
   
    if (convertView == null) {
      LayoutInflater inflator = context.getLayoutInflater();
      view = inflator.inflate(R.layout.rowbuttonlayout, null);
      final ViewHolder viewHolder = new ViewHolder();
      viewHolder.text = (TextView) view.findViewById(R.id.label);
      viewHolder.checkbox = (CheckBox) view.findViewById(R.id.check);
      viewHolder.checkbox
          .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                boolean isChecked) {
              Model element = (Model) viewHolder.checkbox
                  .getTag();
              element.setSelected(buttonView.isChecked());
            }
           
            
          });
      view.setTag(viewHolder);
      viewHolder.checkbox.setTag(list.get(position));
    } else {
      view = convertView;
      ((ViewHolder) view.getTag()).checkbox.setTag(list.get(position));
    }
    ViewHolder holder = (ViewHolder) view.getTag();
    holder.text.setText(list.get(position).getName());
    holder.checkbox.setChecked(list.get(position).isSelected());
    Log.d( LOG_TAG, "View" + position);
    
    
    
    return view;
  }
} 