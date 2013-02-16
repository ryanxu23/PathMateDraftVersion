package com.example.pathmatedraft;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class EditIngredientActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_ingredient);
		
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    String name = extras.getString("item_name");
		    String qty = extras.getString("item_qty");
		    
		    EditText tx_name = (EditText) findViewById(R.id.edEdtName);
		    EditText tx_qty = (EditText) findViewById(R.id.edEdtQty);
		    
		    tx_name.setText(name);
		    tx_qty.setText(qty);
		    //Log.i("EditIngredientActivity", value);
		}
	}
}
