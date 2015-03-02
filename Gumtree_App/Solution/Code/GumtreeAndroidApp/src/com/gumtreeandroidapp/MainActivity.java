package com.gumtreeandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button mButton;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mButton = (Button) this.findViewById(R.id.view_item);
        mButton.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this,  ViewItemActivity.class);
				startActivity(intent);
			}
		});
    }
}
