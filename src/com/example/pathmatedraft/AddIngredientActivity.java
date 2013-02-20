package com.example.pathmatedraft;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddIngredientActivity extends Activity implements OnClickListener {

	EditText name;
	EditText qty;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_ingredient);
		
		name = (EditText) findViewById(R.id.edAvbName);
		qty = (EditText) findViewById(R.id.edAvbQty);
		Button btnAdd = (Button) findViewById(R.id.btAdd);
		btnAdd.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
		case R.id.btAdd:
			try {
				String n = name.getText().toString();
				String q = qty.getText().toString();
				//TODO: get category from some dictionaries
				String c = "unknown";				
				sqlAVBDB avbdb = new sqlAVBDB(this);
				avbdb.open();
				
				if (avbdb.findEntry(n)){
					
					try{
						avbdb.deleteEntry(n);
					}catch (Exception e) {
						String error = e.toString();
						Log.i("AddIngredientActivity", error);
					}
				}
				
				avbdb.createEntry(n, q, c);		
				avbdb.close();

			} catch (Exception e) {
				String error = e.toString();
				Log.i("AddIngredientActivity", error);
			}
			
			finish();
			break;
		}
		
	}
}
