package com.example.validateemail;

import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;


public class MainActivity extends ActionBarActivity {

Button btnGoToSMS, btnValidateEmail;
EditText etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 
etEmail = (EditText) findViewById(R.id.etEmailAddress);        
btnGoToSMS = (Button) findViewById(R.id.btnGoToSMS);
btnValidateEmail = (Button) findViewById(R.id.btnValidateEmail); 

btnValidateEmail.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		etEmail = (EditText) findViewById(R.id.etEmailAddress);        
		String checkEmail = etEmail.getText().toString();
		
		isValidEmail(checkEmail);
		Toast.makeText(MainActivity.this, "Email correct", Toast.LENGTH_SHORT).show();
		
		
	}
});

btnGoToSMS.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		startActivity(new Intent (MainActivity.this, SendSMSActivity.class));
		
	}
});
    
    }
    
    
    public final boolean isValidEmail(CharSequence target) {
  	  if (TextUtils.isEmpty(target)) {
  		Toast.makeText(MainActivity.this, "Email not valid", Toast.LENGTH_SHORT).show();
  	    return false;
  	    
  	  } else {
  		
  		  Toast.makeText(MainActivity.this, "Email not valid", Toast.LENGTH_SHORT).show();
  		  return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
  	   
  	   
  	  }
  	} 
    
  
}
    
