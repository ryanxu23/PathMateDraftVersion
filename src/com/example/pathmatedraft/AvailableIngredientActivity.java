package com.example.pathmatedraft;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class AvailableIngredientActivity extends Activity implements OnClickListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.available_ingredients);
		
		ListView avbList = (ListView) findViewById(R.id.avb_list);
		String avbIngredients[] = { "Bananen", "Butter", "Currypaste", "Karotten", "Kokomilch", "Langkornreis", "Maizena", "Mehl", "Pfeffer", "Salz", "Wasser", "Zwiebel"};
		ArrayAdapter<String> adapt = new ArrayAdapter<String>(this, R.layout.menu_item, avbIngredients);
		avbList.setAdapter(adapt);
		
		Button bnAddIngredient = (Button) findViewById(R.id.btnSmallAdd);
		bnAddIngredient.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.btnSmallAdd:
			Intent gotoAdd = new Intent(AvailableIngredientActivity.this, AddIngredientActivity.class);
			startActivity(gotoAdd);
			break;
			
		}
		
	}
	

}