package com.example.customview;

import com.example.customview.SundyService.MyBinder;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button _button = (Button) findViewById(R.id.servicebutton);
        _button.setOnClickListener(new OnClickListener(){
        Intent mIntent = new Intent(MainActivity.this,SundyService.class);
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startService(mIntent);
			}   
       });
        
        Button buttonB = (Button) findViewById(R.id.buttonstop);
        buttonB.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mIntent = new Intent(MainActivity.this,SundyService.class);
				stopService(mIntent);
			}   
       });
        
        Button _buttonBind = (Button) findViewById(R.id.ButtonBinder);
        _buttonBind.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mIntent = new Intent(MainActivity.this,SundyService.class);
			    bindService(mIntent, conn, Service.BIND_AUTO_CREATE);
          }
       });
    }
    
			
    private ServiceConnection conn = new ServiceConnection(){
    	public void onServiceDisconnected(ComponentName name) {
    		
    	};
    	public void onServiceConnected(ComponentName name, IBinder service) {
    		   String mMyname=((MyBinder)service).hellowWorld("sundy");
    		   Toast.makeText(MainActivity.this,mMyname , 3000).show();
    	};
    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
