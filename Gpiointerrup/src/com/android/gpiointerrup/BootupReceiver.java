package com.android.gpiointerrup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BootupReceiver extends BroadcastReceiver {
	
	private String TAG = "BootupReceiver";
	
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d(TAG, "BootupReceiver Called");
		intent = new Intent(context.getApplicationContext(), GPIOListenerService.class);
        context.startService(intent);
	}
}
