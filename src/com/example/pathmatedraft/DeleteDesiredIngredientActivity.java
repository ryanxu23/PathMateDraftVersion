package com.example.pathmatedraft;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class DeleteDesiredIngredientActivity extends Activity implements OnClickListener {

	private static final int DIALOG_ALERT = 10;
	Context context=this;
	ListView dsrList;
	DDRowAdapter adapt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.delete_desired_ingredients);


		dsrList = (ListView) findViewById(R.id.d_dsr_list);	
		
		sqlDSRDB dsrdb = new sqlDSRDB(this);
		dsrdb.open();
		final DDRow[] row_data = dsrdb.getAllEntriesForDelete();
		Log.i("DesiredIngredientActivity", "get delete entry success");
		dsrdb.close();

		
		/*
		final DDRow row_data[] = new DDRow[]{
			new DDRow(R.drawable.delete, "Bananen"),
			new DDRow(R.drawable.delete, "Cola"),
			new DDRow(R.drawable.delete, "Ice-cream"),
			new DDRow(R.drawable.delete, "Kuchen"),
			new DDRow(R.drawable.delete, "Schokolade"),
		};	
		*/
		
		//ArrayAdapter<String> adapt = new ArrayAdapter<String>(this, R.layout.delete_row_item, row_data);
		adapt = new DDRowAdapter(this, R.layout.delete_row_item, row_data);
		dsrList.setAdapter(adapt);
		
		dsrList.setOnItemClickListener(new OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, final int position, long index) {
            	String bb = String.valueOf(position);
            	Log.i("DeleteDesiredIngredientActivity",bb);       
            	
            	
            	AlertDialog.Builder builder = new AlertDialog.Builder(context);  
            	builder.setMessage("Are you sure you want to delete " + row_data[position].title + "?")  
            	       .setCancelable(false)  
            	       .setPositiveButton("Yes", new DialogInterface.OnClickListener() {  
            	           public void onClick(DialogInterface dialog, int id) { 
            	        	   	// delete entry
            	        	   	try {
	            	       			sqlDSRDB dsrdb = new sqlDSRDB(DeleteDesiredIngredientActivity.this);
	            	       			dsrdb.open();
	            	       			
	            	       			dsrdb.deleteEntry(row_data[position].title);
	            	       			Log.i("DesiredIngredientActivity", "get entry success");
	            	       			dsrdb.close();
	            	       		} catch (Exception e) {
	            	       			String error = e.toString();
	            	       			Log.i("DesiredIngredientActivity", error);
	            	       		}
            	        	   	
            	        	   	// refresh view
            	        	   	dsrList = (ListView) findViewById(R.id.d_dsr_list);	
            	        		
            	        		sqlDSRDB dsrdb = new sqlDSRDB(DeleteDesiredIngredientActivity.this);
            	        		dsrdb.open();
            	        		final DDRow[] row_data = dsrdb.getAllEntriesForDelete();
            	        		Log.i("DesiredIngredientActivity", "get delete entry success");
            	        		dsrdb.close();
            	        		adapt = new DDRowAdapter(DeleteDesiredIngredientActivity.this, R.layout.delete_row_item, row_data);
            	        		dsrList.setAdapter(adapt);
            	        	   	
            	        		Button bnAddIngredient = (Button) findViewById(R.id.btnSmallDone);
            	        		bnAddIngredient.setOnClickListener(DeleteDesiredIngredientActivity.this);
            	        		
            	        	   	
            	                dialog.cancel(); 
            	           }  
            	       })  
            	       .setNegativeButton("No", new DialogInterface.OnClickListener() {  
            	           public void onClick(DialogInterface dialog, int id) {  
            	                dialog.cancel();  
            	           }  
            	       });  
            	AlertDialog alert = builder.create(); 
            	alert.show();  
            	  
            	
            }
		});
		
		
		
		Button bnAddIngredient = (Button) findViewById(R.id.btnSmallDone);
		bnAddIngredient.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.btnSmallDone:
			//Intent gotoAdd = new Intent(DeleteDesiredIngredientActivity.this, AddDsrIngredientActivity.class);
			//startActivity(gotoAdd);
			finish();
			break;
			
		}
		
	}
	

}
