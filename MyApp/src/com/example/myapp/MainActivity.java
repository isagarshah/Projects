package com.example.myapp;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class MainActivity extends ActionBarActivity {

	EditText etUsername;
	Button btnContinue, btnAdd;
	SharedPreferences sharedpref;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnAdd = (Button) findViewById(R.id.btnAddMember);
		btnContinue = (Button) findViewById(R.id.btnContinue);
		sharedpref = getSharedPreferences("MySharedPref", MODE_PRIVATE);

		btnContinue.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				etUsername = (EditText) findViewById(R.id.etUsername);
				String user = etUsername.getText().toString().trim();
				
				if(user.contains("@"))
					{
						String cutEmail = user.substring(0, user.indexOf("@"));
						Editor editor = sharedpref.edit();
						editor.putString("email", cutEmail);
						editor.commit();
						
						
						doSomething();
					}
				

				// startActivity(new Intent(MainActivity.this, PasswordActivity.class));
				//doSomething();
				
				else {
					etUsername.setError("Please enter valid email address");
				
				}

				etUsername.setOnEditorActionListener(new OnEditorActionListener() {

							@Override
							public boolean onEditorAction(TextView v,
									int actionId, KeyEvent event) {

								if (actionId == EditorInfo.IME_ACTION_GO) {

									doSomething();

								}

								return false;
							}
						});

			}
		});

	}

	public void doSomething() {

		startActivity(new Intent(MainActivity.this, HomeActivity.class));

	}
	
	public void addMember (View v){
	startActivity(new Intent(MainActivity.this, AddMemberActivity.class));
	}
}