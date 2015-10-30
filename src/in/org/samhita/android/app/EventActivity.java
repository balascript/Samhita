package in.org.samhita.android.app;

import com.actionbarsherlock.app.SherlockActivity;

import android.net.Uri;
import android.os.Bundle;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RelativeLayout.LayoutParams;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.ShareActionProvider;

import in.org.samhita.android.app.R;
@SuppressLint("NewApi")
public class EventActivity extends SherlockActivity {

	
	RelativeLayout top,book;
    ImageView call,sms,eventbig;
    Button Book,share;
    TextView desc,title,time,phone,organizer;
    DataBaseHelper db;
	//int[] icon = new int[] {R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5,R.drawable.s6,R.drawable.s7,R.drawable.s8,R.drawable.s9,R.drawable.s10,R.drawable.s11,R.drawable.s12,R.drawable.s13,R.drawable.s14,R.drawable.s15,R.drawable.s16,R.drawable.s17,R.drawable.s18,R.drawable.s19,R.drawable.s20,R.drawable.s21,R.drawable.s22,R.drawable.s23,R.drawable.s24,R.drawable.s25,R.drawable.s26,R.drawable.s27,R.drawable.s28};
	int[] bicon = new int[] {R.drawable.b1,R.drawable.b2,R.drawable.b3,R.drawable.b4,R.drawable.b5,R.drawable.b6,R.drawable.b7,R.drawable.b8,R.drawable.b9,R.drawable.b10,R.drawable.b11,R.drawable.b12,R.drawable.b13,R.drawable.b14,R.drawable.b15,R.drawable.b16,R.drawable.b17,R.drawable.b18,R.drawable.b19,R.drawable.b20,R.drawable.b21,R.drawable.b22,R.drawable.b23,R.drawable.b24,R.drawable.b25,R.drawable.b26,R.drawable.b27,R.drawable.b28};
	int[] wicon = new int[]{ R.drawable.ws1,R.drawable.ws2,R.drawable.ws3};
	private ScrollView scr;
	private Menu menu;
	private int item;
	static Event e;
	String id="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_fragment);
		
		DisplayMetrics displayMetrics = new DisplayMetrics();
	     WindowManager wm = (WindowManager) this.getApplicationContext().getSystemService(Context.WINDOW_SERVICE); // the results will be higher than using the activity context object or the getWindowManager() shortcut
	     wm.getDefaultDisplay().getMetrics(displayMetrics);
	     int screenWidth = displayMetrics.widthPixels;
	     int screenHeight = displayMetrics.heightPixels;
     top=(RelativeLayout)  findViewById(R.id.insidelayout);
     book=(RelativeLayout)  findViewById(R.id.booklayout);
     title=(TextView)findViewById(R.id.eventTitle);
     desc=(TextView)findViewById(R.id.eventDesc);
     time=(TextView)findViewById(R.id.eventTime);
     phone=(TextView)findViewById(R.id.phoneNumber);
     share=(Button)findViewById(R.id.devicebutton);
     Book=(Button)findViewById(R.id.paybutton);
     organizer=(TextView)findViewById(R.id.organizer);
     call=(ImageView) findViewById(R.id.smsButton);
     sms=(ImageView) findViewById(R.id.callButton);
     
     eventbig=(ImageView) findViewById(R.id.eventCover);
     call.getLayoutParams().width=screenWidth/3;
     sms.getLayoutParams().width=screenWidth/3;
    getSupportActionBar().setHomeButtonEnabled(true);
     getSupportActionBar().setDisplayHomeAsUpEnabled(true);
     Intent i=getIntent();
     id=i.getStringExtra("eid");
     String type=i.getStringExtra("type");
     scr=(ScrollView)findViewById(R.id.scroller);
     scr.computeScroll();
     
     db= new DataBaseHelper(getApplicationContext());
     if(type.equals("event")){
    	 book.setVisibility(View.GONE);
    	 e= db.getEvent(Integer.parseInt(id));
    	 db.close();//need to check this with samsung,htc
    	 eventbig.setImageResource(bicon[Integer.parseInt(id)-1]);
    	 item=0;
    	 invalidateOptionsMenu();
     }
     else{
    	 e= db.getWorkshop(Integer.parseInt(id));
    	 db.close();//need to check this with samsung,htc
    	 eventbig.setImageResource(wicon[Integer.parseInt(id)-1]);
    	 item=1;
    	 invalidateOptionsMenu();

    	 Book.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// check for registration here
				Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse(e.getEventURl()));
				startActivity(browser);
				
			}
		});
    	share.setOnClickListener(new View.OnClickListener() {
 			
 			@Override
 			public void onClick(View v) {
 				// check for registration here
 				
 				 Dialog dialog = new Dialog(EventActivity.this);
 				 dialog.setCancelable(true);
 				 dialog.setCanceledOnTouchOutside(true);
 				int[] wsicon = new int[]{ R.drawable.ws1qr,R.drawable.ws2qr,R.drawable.ws3qr};
                dialog.setContentView(R.layout.dialog_layout);
                dialog.setTitle("Share directly...");  
                
                ImageView qr= (ImageView) dialog.findViewById(R.id.qrcode1);
              qr.setImageResource(wsicon[Integer.parseInt(id)-1]);
               TextView url=(TextView)dialog.findViewById(R.id.wsurl);
                url.setText(e.getEventURl());
                
                dialog.show();
 				
 			}
 		});
     }
     
     title.setText(e.getEventName());
     desc.setText(e.getDesc());
     SpannableString spanString = new SpannableString(e.getTime());
     spanString.setSpan(new UnderlineSpan(), 0, spanString.length(), 0);
     time.setText(spanString);
     organizer.setText(e.getOrganizer());
     phone.setText(e.getPhone());
     
     
getSupportActionBar().setTitle(e.getEventName());
     
   	  
   	  call.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(EventActivity.this,"Long Press call", Toast.LENGTH_SHORT).show();
				
			}
			
			
		});
   	  sms.setOnClickListener(new View.OnClickListener() {
 			
 			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
 				Toast.makeText(EventActivity.this,"Long Press SMS", Toast.LENGTH_SHORT).show();

			}
 		});
   	  call.setOnLongClickListener(new View.OnLongClickListener() {
			
			private Intent callintent;

			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stub
				//Toast.makeText(getApplicationContext(),"Calling Event Organizer:"+ phone.getText().toString(),Toast.LENGTH_SHORT).show();
				callintent= new Intent(Intent.ACTION_CALL);
				callintent.setData(Uri.parse("tel:" +phone.getText().toString()));
				startActivity(callintent);
				return false;
			}
		});
   	  sms.setOnLongClickListener(new View.OnLongClickListener() {
 			
 			@Override
 			public boolean onLongClick(View v) {
 				// TODO Auto-generated method stub
 				Toast.makeText(getApplicationContext(), "Opening SMS window to :"+organizer.getText().toString(),Toast.LENGTH_SHORT).show();
				Uri uri = Uri.parse("smsto:"+ phone.getText().toString());  
				Intent intent = new Intent(Intent.ACTION_SENDTO, uri);  
				intent.putExtra("sms_body", "Ask your Queries regarding "+ title.getText().toString()+":\n");    
				startActivity(intent);
 				return false;
 			}
 		});
   	
     
    
     LayoutParams params = (LayoutParams) top.getLayoutParams();
     params.height = screenHeight/3;
    
     
       
	}
	private Intent createShareIntent() {
		 Intent I= new Intent(Intent.ACTION_SEND);
		    I.setType("text/plain");
		    I.putExtra(android.content.Intent.EXTRA_TEXT, "Register for Samhita`14 "+e.getEventName() +" @ "+e.getEventURl());

		   return I;
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.event, menu);
		if(item==1)
		{
		 getSupportMenuInflater().inflate(R.menu.share_action_provider, menu);

	 	    // Set file with share history to the provider and set the share intent.
	 	    MenuItem item = menu.findItem(R.id.menu_item_share_action_provider);
	 	    ShareActionProvider provider = (ShareActionProvider) item.getActionProvider();
	 	                  provider.setShareHistoryFileName(ShareActionProvider.DEFAULT_SHARE_HISTORY_FILE_NAME);
	 	    // Note that you can set/change the intent any time,
	 	    // say when the user has selected an image.
	 	    provider.setShareIntent(createShareIntent());
		}
	    return true;
		
	}
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
 
        if (item.getItemId() == android.R.id.home ) {
        	overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
           this.finish();
        }
 
        return super.onOptionsItemSelected(item);
    }
}
