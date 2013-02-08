package com.example.pathmatedraft;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button bnIngredients = (Button) findViewById(R.id.btnIngredients);
		Button bnRecipes = (Button) findViewById(R.id.btnRecipes);
		Button bnShoppingList = (Button) findViewById(R.id.btnShoppingList);
		Button bnCommon = (Button) findViewById(R.id.btnCommon);
		bnIngredients.setOnClickListener(this);
		bnRecipes.setOnClickListener(this);
		bnShoppingList.setOnClickListener(this);
		bnCommon.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
		case R.id.btnIngredients:
			Intent goIngredients = new Intent(MainActivity.this, IngredientMenuActivity.class);
			startActivity(goIngredients);
			break;
		case R.id.btnRecipes:
			Intent goRecipes = new Intent(MainActivity.this, ChooseRecipesActivity.class);
			startActivity(goRecipes);			
			break;
		case R.id.btnShoppingList:
			Intent goShoppingList = new Intent(MainActivity.this, ShoppingListActivity.class);
			startActivity(goShoppingList);
			break;
		case R.id.btnCommon:
			Intent goCommon = new Intent(MainActivity.this, CommonMenuActivity.class);
			startActivity(goCommon);
			break;
		}
		
	}



}
