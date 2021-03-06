package com.example.pathmatedraft;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ShoppingListActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shopping_list);
		
		ListView spList = (ListView) findViewById(R.id.sp_list);
		ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
		
		// TODO: need a for loop for generation
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("ingredient", "Backpulver");
		map.put("quantity", "3");
		mylist.add(map);
		map = new HashMap<String, String>();
		map.put("ingredient", "Birnen");
		map.put("quantity", "100g");
		mylist.add(map);
		map = new HashMap<String, String>();
		map.put("ingredient", "Curry");
		map.put("quantity", "1-2EL");
		mylist.add(map);
		map = new HashMap<String, String>();
		map.put("ingredient", "Eier");
		map.put("quantity", "3");
		mylist.add(map);
		map = new HashMap<String, String>();
		map.put("ingredient", "Gurke");
		map.put("quantity", "0.5");
		mylist.add(map);
		map = new HashMap<String, String>();
		map.put("ingredient", "Karotten");
		map.put("quantity", "150g");
		mylist.add(map);
		map = new HashMap<String, String>();
		map.put("ingredient", "Kiwi");
		map.put("quantity", "100g");
		mylist.add(map);
		map = new HashMap<String, String>();
		map.put("ingredient", "Kokosmilch");
		map.put("quantity", "2.5dl");
		mylist.add(map);
		map = new HashMap<String, String>();
		map.put("ingredient", "Langkornreis");
		map.put("quantity", "250g");
		mylist.add(map);
		map = new HashMap<String, String>();
		map.put("ingredient", "Lattich");
		map.put("quantity", "0.25");
		mylist.add(map);
		map = new HashMap<String, String>();
		map.put("ingredient", "Mehl");
		map.put("quantity", "250g");
		mylist.add(map);
		map = new HashMap<String, String>();
		map.put("ingredient", "Pfeffer");
		map.put("quantity", "wenig");
		mylist.add(map);
		map = new HashMap<String, String>();
		map.put("ingredient", "Puderzucker");
		map.put("quantity", "200g");
		mylist.add(map);
		map = new HashMap<String, String>();
		map.put("ingredient", "Rahm");
		map.put("quantity", "1.5 dl");
		mylist.add(map);
		map = new HashMap<String, String>();
		map.put("ingredient", "Tomaten");
		map.put("quantity", "2");
		mylist.add(map);
		map = new HashMap<String, String>();
		map.put("ingredient", "Zitronen");
		map.put("quantity", "2");
		mylist.add(map);
		
		SimpleAdapter mSPlist = new SimpleAdapter(this, mylist, R.layout.row_item,
	    new String[] {"ingredient", "quantity"}, new int[] {R.id.sp_item, R.id.sp_qty});
		spList.setAdapter(mSPlist);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	 
	

}
