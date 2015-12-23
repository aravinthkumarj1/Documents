package com.android.gpiointerrup;

import android.app.Service;
import android.content.Intent;
import android.os.FileObserver;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;
import java.io.File;

public class GPIOListenerService extends Service{
	
	private FileObserver observer;
	private String TAG = "GPIOListenerService";

	@Override
 	public void onCreate() {
  		// TODO Auto-generated method stub
  		super.onCreate();
                Log.d(TAG, "GPIOListenerService is Start");
  		String filepath = android.os.Environment.getDataDirectory().getAbsolutePath()+"/gpiointerrupt.txt";
  		Log.d(TAG, "GPIOListenerService File Path = "+filepath);
 		 try { 
  			 File file = new File(filepath);
   			file.createNewFile();
  		}catch (Exception e) {
  		}
  
  		observer = new FileObserver(filepath) {
   
   		@Override
   		public void onEvent(int event, String path) {
   			 Toast.makeText(getApplicationContext(), "Event = "+event, Toast.LENGTH_SHORT).show();
   		}
  		};
 	}
	
	@Override
	public void onStart(Intent intent, int startId) {
		
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
