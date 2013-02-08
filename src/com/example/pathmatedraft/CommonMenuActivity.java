package com.example.pathmatedraft;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CommonMenuActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.common_main);
		
		Button bnLogin = (Button) findViewById(R.id.btnLogin);
		Button bnPwd = (Button) findViewById(R.id.btnPwd);
		Button bnSettings = (Button) findViewById(R.id.btnSettings);
		
		bnLogin.setOnClickListener(this);
		bnPwd.setOnClickListener(this);
		bnSettings.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.btnLogin:
			Intent gotoLogin = new Intent(CommonMenuActivity.this, LoginActivity.class);
			startActivity(gotoLogin);
			break;
		case R.id.btnPwd:
			Intent gotoPwd = new Intent(CommonMenuActivity.this, ForgetPasswordActivity.class);
			startActivity(gotoPwd);
			break;
		case R.id.btnSettings:
			Intent gotoSet = new Intent(CommonMenuActivity.this, SettingsActivity.class);
			startActivity(gotoSet);
			break;
		}
	}
	

}
