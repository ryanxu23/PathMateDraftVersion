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

public class EditIngredientActivity extends Activity implements OnClickListener {
	
	String name;
	String qty;
	TextView tx_name;
	EditText tx_qty;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_ingredient);
		
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    name = extras.getString("item_name");
		    qty = extras.getString("item_qty");
		    
		    tx_name = (TextView) findViewById(R.id.edEdtName);
		    tx_qty = (EditText) findViewById(R.id.edEdtQty);
		    
		    tx_name.setText(name);
		    tx_qty.setText(qty);
		    //Log.i("EditIngredientActivity", value);
		}
		
		Button btnSave = (Button) findViewById(R.id.btSaveEdit);
		btnSave.setOnClickListener(this);
		
		Button btnDelete = (Button) findViewById(R.id.btDeleteEdit);
		btnDelete.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
		case R.id.btSaveEdit:
			try{
				sqlAVBDB avbdb = new sqlAVBDB(this);
				String mQty = tx_qty.getText().toString();
				String mCtg = "unknown";  //TODO find a way to find out ctg automatically
				avbdb.open();
				avbdb.updateEntry(name, mQty, mCtg);
				avbdb.close();
			}catch (Exception e) {
				String error = e.toString();
				Log.i("EditIngredientActivity", error);
			}
			finish();
		
			break;
		case R.id.btDeleteEdit:
			try{
				sqlAVBDB avbdb = new sqlAVBDB(this);
				avbdb.open();
				avbdb.deleteEntry(name);
				//avbdb.deleteEntry(tx_name.getText().toString());
				avbdb.close();
			}catch (Exception e) {
				String error = e.toString();
				Log.i("EditIngredientActivity", error);
			}
			finish();
			break;
		}
		
		
	}
}
