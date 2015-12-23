package com.android.gpiointerrup;

import android.util.gpiointerrup;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.util.Log;
import android.os.FileObserver;
import java.io.File;


public class GPIOjninterrup extends Activity 
{

private FileObserver observer, obser;
String TAG = "GPIOINT";
ToggleButton a;
TextView textview;
String msg;
gpiointerrup gp;
boolean value;
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gpiojnitest);

//  	String path = android.os.Environment.getDataDirectory().getAbsolutePath()+"/gpio";
//  	Log.d(TAG, "GPIOListenerService File Path = "+path);
	File file = new File("/sys/class/gpio/gpio6");
 	 try { 
   		file.createNewFile();
  	}catch (Exception e) {
		Log.d(TAG, "Exception");
  	}
  	 Log.d(TAG,"Observer value--1  =  "+file);

  	observer = new FileObserver("/sys/class/gpio/gpio6", FileObserver.CREATE) {
   //	Log.d(TAG,"Observer value %d =  \n"+observer);
	@Override
   	public void onEvent(int event, String path) {
   		Toast.makeText(getApplicationContext(), "Event = "+"/data/data/com.android.gpiointerrup/gpio", Toast.LENGTH_SHORT).show();
		 Log.d(TAG, event + " "+ "/data/data/com.android.gpiointerrup/gpio");
	 	 Log.d(TAG,"Observer ##value--1 %d =  \n"+path);
	}
  	};
		observer.startWatching();
        a=(ToggleButton)findViewById(R.id.toggle);
        textview=(TextView)findViewById(R.id.textview);
       	gp = new gpiointerrup();

        a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() 
	 {
		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) 
		{
		  Log.d(TAG,"Observer value--2 %d =  \n");
		String filepath = android.os.Environment.getDataDirectory().getAbsolutePath()+"/gpio4Interrupt.txt";
  		Log.d("GPIOINTERRPT", "GPIOListenerService File Path = "+filepath);
	        File file = new File("/data/data/com.android.gpiointerrup/gpio4Interrupt.txt");
         try {
                file.createNewFile();
                Log.d(TAG, "step 2 : File Created Done");
        }catch (Exception e) {
                Log.d(TAG, "Exception");
        }
        obser = new FileObserver("/data/data/com.android.gpiointerrup/gpio4Interrupt.txt") {
     //   Log.d(TAG,"Observer interrupt  value %d =  \n"+observer);
        @Override
        public void onEvent(int event, String path) {
                Toast.makeText(getApplicationContext(), "Event = "+event, Toast.LENGTH_SHORT).show();
          Log.d(TAG,"Observer Interrupt value--1 %d =  \n"+obser);
        }
        };


		// TODO Auto-generated method stub
		if(isChecked)
		{
		Log.d(TAG,"Observer Interrupt value--2 %d =  \n"+value);
		showtoast("on");
		msg("Connection is Interrupted");				
		}
		else
		{
		showtoast("off");
        	msg("Connection is Not Interrupted");
		}
		}
	});

	value=gp.gpio_inter_in();
	if(value)
	{
	a.setChecked(true);
	}			
	else
	{
	a.setChecked(false);
	}
   }

   public void msg(String msg)
   {
	this.msg=msg;
	textview.setText(msg);
   }

    public void showtoast(String msg)
    {
    	Toast.makeText(getApplicationContext(), "msg", Toast.LENGTH_SHORT).show();
    }   
}
