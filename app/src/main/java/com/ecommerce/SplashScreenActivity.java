package com.ecommerce;

import android.Manifest;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.ecommerce.database.DBHelper;
import com.ecommerce.permission.PermissionResultCallback;
import com.ecommerce.permission.PermissionUtils;

import java.util.ArrayList;


public class SplashScreenActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback,PermissionResultCallback {


    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 4000;
    /**
     * The thread to process splash screen events
     */
    private Thread mSplashThread;

    /** Called when the activity is first created. */

    ArrayList<String> permissions=new ArrayList<>();
    PermissionUtils permissionUtils;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();

         dbHelper =new DBHelper(getApplicationContext());
       // permissionUtils=new PermissionUtils(getApplicationContext(),this);
        //permissionUtils.check_permission(getPermissions(),"Explain here why the app needs permissions",1);
        mSplashThread =  new Thread(){
            @Override
            public void run(){
                try {
                    synchronized(this){
                        // Wait given period of time or exit on touch
                        this.wait(SPLASH_DISPLAY_LENGTH);
                        Log.d("Splash Screen", "SplashActivity start");
                    }
                }
                catch(InterruptedException ex){
                }
                finish();
                // Run next activity
                Intent intent = new Intent();
                if(dbHelper.numberOfRows()>0) {
                    intent.setClass(SplashScreenActivity.this, MainActivity.class);
                }else{
                    intent.setClass(SplashScreenActivity.this, LoginActivity.class);

                }
                startActivity(intent);


                //stop();
            }
        };
        mSplashThread.start();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    @Override
    public void PermissionGranted(int request_code)
    {

        // The thread to wait for splash screen events
        mSplashThread =  new Thread(){
            @Override
            public void run(){
                try {
                    synchronized(this){
                        // Wait given period of time or exit on touch
                        this.wait(SPLASH_DISPLAY_LENGTH);
                        Log.d("Splash Screen", "SplashActivity start");
                    }
                }
                catch(InterruptedException ex){
                }
                finish();
                // Run next activity
                Intent intent = new Intent();
                intent.setClass(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
                //stop();
            }
        };

        mSplashThread.start();

    }

    @Override
    public void PartialPermissionGranted(int request_code, ArrayList<String> granted_permissions) {

        Toast.makeText(this,"-Partial lPERMISSION GRANTED -",Toast.LENGTH_LONG).show();
        Log.i("PERMISSION","GRANTED");
    }

    @Override
    public void PermissionDenied(int request_code) {

        Toast.makeText(this,"-PERMISSION DENIED -",Toast.LENGTH_LONG).show();
       // Log.i("PERMISSION","DENIED");
    }

    @Override
    public void NeverAskAgain(int request_code)
    {
        Toast.makeText(this,"-NeverAskAgain -",Toast.LENGTH_LONG).show();
     //   Log.i("PERMISSION","NeverAskAgain");
    }

    /**
     * Processes splash screen touch events
     */
  /*  @Override
    public boolean onTouchEvent(MotionEvent evt)
    {
        if(evt.getAction() == MotionEvent.ACTION_DOWN)
        {
            synchronized(mSplashThread){
                mSplashThread.notifyAll();
            }
        }
        return true;
    }*/


  private ArrayList<String> getPermissions()
  {
      ArrayList<String> permissions=new ArrayList<>();
      permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
      permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
      return permissions;

  }
}