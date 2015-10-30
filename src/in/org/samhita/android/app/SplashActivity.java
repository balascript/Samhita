package in.org.samhita.android.app;

import static in.org.samhita.android.app.CommonUtilities.DISPLAY_MESSAGE_ACTION;
import static in.org.samhita.android.app.CommonUtilities.EXTRA_MESSAGE;
import static in.org.samhita.android.app.CommonUtilities.SENDER_ID;


import com.actionbarsherlock.app.SherlockActivity;
import com.google.android.gcm.GCMRegistrar;
import in.org.samhita.android.app.R;



import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RelativeLayout.LayoutParams;

public class SplashActivity extends SherlockActivity {

	// Asyntask
	AsyncTask<Void, Void, Void> mRegisterTask;
	
	// Alert dialog manager
	AlertDialogManager alert = new AlertDialogManager();
	private static final int TIME = 3 * 1000;// 4 seconds
	
	// Connection detector
	ConnectionDetector cd;
	
	public static String name;
	public static String email;
	ProgressBar pb;
	boolean isRegisteredon;

	private TextView lblMessage;
	SharedPreferences sharedPreferences;

	private SherlockActivity rootView;

	private RelativeLayout top;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		DisplayMetrics displayMetrics = new DisplayMetrics();
	    WindowManager wm = (WindowManager) this.getApplicationContext().getSystemService(Context.WINDOW_SERVICE); // the results will be higher than using the activity context object or the getWindowManager() shortcut
	    wm.getDefaultDisplay().getMetrics(displayMetrics);
	    int screenWidth = displayMetrics.widthPixels;
	    int screenHeight = displayMetrics.heightPixels;
	    top=(RelativeLayout) findViewById(R.id.loadinglayout);
	  
		//lblMessage = (TextView) findViewById(R.id.label1);
	    LayoutParams params = (LayoutParams) top.getLayoutParams();
	    if(screenWidth>screenHeight)
	        params.height = 2*screenHeight/4;
	        else
	      	  params.height = 2*screenHeight/5;
	   
		cd = new ConnectionDetector(getApplicationContext());
		pb= (ProgressBar) findViewById(R.id.progressBar1);
		sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
		isRegisteredon = sharedPreferences.getBoolean("REG", false);
		if(isRegisteredon){
			//skip activity
			pb.setProgress(45);
			skipActivity();
		}
		else{
			gcmReg();
			skipActivity();
		}

		
		
				}
	private void skipActivity() {
		// TODO Auto-generated method stub

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				pb.setProgress(80);
				Intent intent = new Intent(SplashActivity.this,
						MainActivity.class);
				startActivity(intent);
				SplashActivity.this.finish();
				overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
			}
		}, TIME);
		
		new Handler().postDelayed(new Runnable() {
			  @Override
			  public void run() {
			         } 
			    }, TIME);

		
	}
	void gcmReg(){
		// Check if Internet present
				if (!cd.isConnectingToInternet()) {
					// Internet Connection is not present
					alert.showAlertDialog(this,
							"Internet Connection Error",
							"Please connect to working Internet connection", false);
					// stop executing code by return
					return;
				}
				
				// Getting name, email from intent
				Intent i = getIntent();
				
				name = "Bala";
				email = "TEST";		
				
				// Make sure the device has the proper dependencies.
				GCMRegistrar.checkDevice(this);

				// Make sure the manifest was properly set - comment out this line
				// while developing the app, then uncomment it when it's ready.
				GCMRegistrar.checkManifest(this);

				registerReceiver(mHandleMessageReceiver, new IntentFilter(
						DISPLAY_MESSAGE_ACTION));
				
				// Get GCM registration id
				final String regId = GCMRegistrar.getRegistrationId(this);
				// Check if regid already presents
						if (regId.equals("")) {
							// Registration is not present, register now with GCM			
							GCMRegistrar.register(this, SENDER_ID);
						}else {
							if (GCMRegistrar.isRegisteredOnServer(this)) {
								// Skips registration.				
								//Toast.makeText(getApplicationContext(), "Already registered with GCM", Toast.LENGTH_LONG).show();
							} else{
							// Try to register again, but not in the UI thread.
							// It's also necessary to cancel the thread onDestroy(),
							// hence the use of AsyncTask instead of a raw thread.
							final Context context = this;
							mRegisterTask = new AsyncTask<Void, Void, Void>() {

								@Override
								protected Void doInBackground(Void... params) {
									// Register on our server
									// On server creates a new user
									ServerUtilities.register(context, name, email, regId);
									return null;
								}

								@Override
								protected void onPostExecute(Void result) {
									mRegisterTask = null;
								}

							};
							mRegisterTask.execute(null, null, null);
						}
						}
			}
	private final BroadcastReceiver mHandleMessageReceiver = new BroadcastReceiver() {
		private int value =0;

		@Override
		public void onReceive(Context context, Intent intent) {
			String newMessage = intent.getExtras().getString(EXTRA_MESSAGE);
			// Waking up mobile if it is sleeping
			WakeLocker.acquire(getApplicationContext());
			
			/**
			 * Take appropriate action on this message
			 * depending upon your app requirement
			 * For now i am just displaying it on the screen
			 * */
			
			// Showing received message
			//lblMessage.append(newMessage + "\n");
			pb.setProgress(value +20);
			value+=20;
			Editor editor = sharedPreferences.edit();
			
			        editor.putBoolean("REG", true);
			
			        editor.commit();

			//Toast.makeText(getApplicationContext(), "New Message: " + newMessage, Toast.LENGTH_LONG).show();
			
			// Releasing wake lock
			WakeLocker.release();
		}
	};
	
	@Override
	protected void onDestroy() {
		if (mRegisterTask != null) {
			mRegisterTask.cancel(true);
		}
		try {
			unregisterReceiver(mHandleMessageReceiver);
			GCMRegistrar.onDestroy(this);
		} catch (Exception e) {
			//Log.e("UnRegister Receiver Error", "> " + e.getMessage());
		}
		super.onDestroy();
	}
	}

	


