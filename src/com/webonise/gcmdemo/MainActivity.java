package com.webonise.gcmdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gcm.GCMRegistrar;

public class MainActivity extends Activity {

	public static final String SENDER_ID = "627043023384";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView textViewMessage = (TextView) findViewById(R.id.textViewMessage);
		GCMRegistrar.checkDevice(this);
		GCMRegistrar.checkManifest(this);
		final String regId = GCMRegistrar.getRegistrationId(this);
		if (regId.equals("")) {
			GCMRegistrar.register(this, SENDER_ID);
			Log.d("show", "New Registered id is " + regId);
			textViewMessage.setText("New Registered id is " + regId);
		} else {
			Log.d("show", "Already registered");
			textViewMessage.setText("Registration id : "+regId);
		}
	}
}