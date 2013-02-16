package com.example.pathmatedraft;

import android.app.Activity;
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

public class DesiredIngredientActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.desired_ingredients);

		ListView dsrList = (ListView) findViewById(R.id.avb_list);
		String dsrIngredients[] = { "Bananen", "Cola", "Ice-cream", "Kuchen", "Schokolade"};
		ArrayAdapter<String> adapt = new ArrayAdapter<String>(this, R.layout.menu_item, dsrIngredients);
		dsrList.setAdapter(adapt);
		
		Button bnAddIngredient = (Button) findViewById(R.id.btnSmallAdd);
		bnAddIngredient.setOnClickListener(this);
		Button bnEditIngredient = (Button) findViewById(R.id.btnSmallEdit);
		bnEditIngredient.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.btnSmallAdd:
			Intent gotoAdd = new Intent(DesiredIngredientActivity.this, AddDsrIngredientActivity.class);
			startActivity(gotoAdd);
			break;
		case R.id.btnSmallEdit:
			Intent gotoEdit = new Intent(DesiredIngredientActivity.this, DeleteDesiredIngredientActivity.class);
			startActivity(gotoEdit);
			break;			
		}
		
	}

}
