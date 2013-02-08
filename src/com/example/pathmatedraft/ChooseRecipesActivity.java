package com.example.pathmatedraft;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ChooseRecipesActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.choose_recipes);
		
		Button bnRP1 = (Button) findViewById(R.id.btnChooseRP1);
		bnRP1.setOnClickListener(this);
		Button bnRP2 = (Button) findViewById(R.id.btnChooseRP2);
		bnRP2.setOnClickListener(this);
		Button bnRP3 = (Button) findViewById(R.id.btnChooseRP3);
		bnRP3.setOnClickListener(this);
		Button bnRP4 = (Button) findViewById(R.id.btnChooseRP4);
		bnRP4.setOnClickListener(this);
		Button bnRP5 = (Button) findViewById(R.id.btnChooseRP5);
		bnRP5.setOnClickListener(this);	
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.btnChooseRP1:
			Intent gotoRecipe1 = new Intent(ChooseRecipesActivity.this, DetailRecipeActivity.class);
			startActivity(gotoRecipe1);
			break;
		case R.id.btnChooseRP2:
			Intent gotoRecipe2 = new Intent(ChooseRecipesActivity.this, DetailRecipeActivity.class);
			startActivity(gotoRecipe2);
			break;
		case R.id.btnChooseRP3:
			Intent gotoRecipe3 = new Intent(ChooseRecipesActivity.this, DetailRecipeActivity.class);
			startActivity(gotoRecipe3);
			break;
		case R.id.btnChooseRP4:
			Intent gotoRecipe4 = new Intent(ChooseRecipesActivity.this, DetailRecipeActivity.class);
			startActivity(gotoRecipe4);
			break;
		case R.id.btnChooseRP5:
			Intent gotoRecipe5 = new Intent(ChooseRecipesActivity.this, DetailRecipeActivity.class);
			startActivity(gotoRecipe5);
			break;
		}
		
	}
	
}
