package com.android.gpiotest;


import android.util.gpioctrl;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;



public class GPIOjnitest extends Activity {
    
     gpioctrl gp ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gpiojnitest);
        gp = new gpioctrl();
    }

    public void on(View v)
    {
       gp.gpio_on();
    }
    
    public void off(View v)
    {
       gp.gpio_off();
    }

}
