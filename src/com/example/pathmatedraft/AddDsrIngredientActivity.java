package com.example.pathmatedraft;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class AddDsrIngredientActivity extends Activity implements OnClickListener{

	TextView dsrName;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_dsr_ingredient);
		
		Button dbtSaveDSRIng = (Button) findViewById(R.id.btAddDsrIng);
		dbtSaveDSRIng.setOnClickListener(this);
		dsrName = (TextView) findViewById(R.id.edAvbDsrName);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
		case R.id.btAddDsrIng:
			try {
				String n = dsrName.getText().toString();
				//TODO Check whether we need it
				String c = "unknown";				
				sqlDSRDB dsrdb = new sqlDSRDB(this);
				dsrdb.open();
				
				if (dsrdb.findEntry(n)){
					
					try{
						dsrdb.deleteEntry(n);
					}catch (Exception e) {
						String error = e.toString();
						Log.i("AddIngredientActivity", error);
					}
				}
				
				dsrdb.createEntry(n, c);		
				dsrdb.close();

			} catch (Exception e) {
				String error = e.toString();
				Log.i("AddIngredientActivity", error);
			}
			
			finish();
		}
	}
}
