package com.example.pathmatedraft;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class IngredientMenuActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ingredient_main);
		
		Button btnAvbList = (Button) findViewById(R.id.btnAVIngredients);
		Button btnDsrList = (Button) findViewById(R.id.btnDSIngredients);
		btnAvbList.setOnClickListener(this);
		btnDsrList.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.btnAVIngredients:
			Intent gotoAvbList = new Intent(IngredientMenuActivity.this, AvailableIngredientActivity.class);
			startActivity(gotoAvbList);
			break;
		case R.id.btnDSIngredients:
			Intent gotoDsrList = new Intent(IngredientMenuActivity.this, DesiredIngredientActivity.class);
			startActivity(gotoDsrList);
			break;			
		}
	}
	

}
