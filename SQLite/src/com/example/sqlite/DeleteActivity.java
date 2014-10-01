package com.example.sqlite;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends ActionBarActivity {

	EditText etID;
	Button btnDelete, btnReset;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_delete);
	
	
		etID = (EditText) findViewById(R.id.etDeleteID);
		btnDelete = (Button) findViewById(R.id.btnDelete);
		
		btnDelete.setOnClickListener(new OnClickListener() {
	
		
		
			@Override
			public void onClick(View v) {
			String strid = etID.getText().toString().trim();
				
			if (strid.equals("")){
					etID.setError("required");
			}
				else
				{
					SQLite_DBAdapter adapter = new SQLite_DBAdapter(DeleteActivity.this);
					adapter.open();
					
					int delete = adapter.deleteUser(Integer.parseInt(strid));
					if (delete > 0)
						Toast.makeText(DeleteActivity.this, "User Deleted", Toast.LENGTH_LONG).show();
					else
						Toast.makeText(DeleteActivity.this, "User not Deleted", Toast.LENGTH_LONG).show();
					adapter.close();
				}
				
				
				
			}
		});
	
	
	}
}
