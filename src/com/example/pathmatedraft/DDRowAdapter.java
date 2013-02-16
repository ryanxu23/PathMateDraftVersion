package com.example.pathmatedraft;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DDRowAdapter extends ArrayAdapter<DDRow>{

	Context context; 
    int layoutResourceId;    
    DDRow data[] = null;
	
	public DDRowAdapter(Context context, int layoutResourceId, DDRow[] data) {
		super(context, layoutResourceId, data);
		this.context = context;
		this.layoutResourceId = layoutResourceId;
		this.data = data;
	}
	
	
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        DDRowHolder holder = null;
        
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            
            holder = new DDRowHolder();
            holder.imgIcon = (ImageView)row.findViewById(R.id.img_icon);
            holder.txtTitle = (TextView)row.findViewById(R.id.del_sp_item);
            
            row.setTag(holder);
        }
        else
        {
            holder = (DDRowHolder)row.getTag();
        }
        
        DDRow ddrow = data[position];
        holder.txtTitle.setText(ddrow.title);
        holder.imgIcon.setImageResource(ddrow.icon);
        
        return row;
    }
    
    static class DDRowHolder
    {
        ImageView imgIcon;
        TextView txtTitle;
    }

	
}
