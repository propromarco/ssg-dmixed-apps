package com.appspot.ssg.android.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.appspot.ssg.android.data.AndroidConstants;

public class ExceptionOccuredActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.error);
		final String errorMessage = getIntent().getStringExtra(AndroidConstants.ERROR_KEY);
		if(errorMessage!=null)
		{
			final TextView errorText = (TextView) findViewById(R.id.ErrorText);
			errorText
			.setText(errorMessage);
			final Button button = (Button) findViewById(R.id.ErrorSchliessenButton);
			button.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					finish();
				}
			});
		}
		else
		{
			finish();
		}
	}
}
