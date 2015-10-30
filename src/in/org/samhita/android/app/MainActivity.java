package in.org.samhita.android.app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.Window;
import in.org.samhita.android.app.R;






public class MainActivity extends SherlockFragmentActivity {

	
	DrawerLayout mDrawerLayout;
    ListView mDrawerList;
    ActionBarDrawerToggle mDrawerToggle;
    MenuListAdapter mMenuAdapter;
    String[] title;
    String[] subtitle;
    int[] icon;
    Fragment fgt=null;
    static Fragment cfgt=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		  requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.drawer_main);
		  getSupportActionBar().setHomeButtonEnabled(true);
	        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	        setSupportProgressBarIndeterminateVisibility(false);

	        title = new String[] { "Home","Workshops","Events","Updates","Settings","Query","Locate Us","Credits"};
	        icon = new int[] { R.drawable.ic_launcher,R.drawable.ic_workshop,R.drawable.ic_event_navi,R.drawable.ic_update,R.drawable.ic_settings_navi,R.drawable.ic_query_navi,R.drawable.ic_locate_navi,R.drawable.ic_credits};
	        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
	        mDrawerList = (ListView) findViewById(R.id.left_drawer);
	         mDrawerLayout.setDrawerShadow(R.drawable.abs__ic_clear,GravityCompat.END);
	         
	         
	  mMenuAdapter = new MenuListAdapter(this, title, subtitle, icon);
	     mDrawerList.setAdapter(mMenuAdapter);
	     mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
	     mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
	                R.drawable.ic_navigation_drawer, R.string.drawer_open,R.string.drawer_close) {
	 
	            public void onDrawerClosed(View view) {
	                // TODO Auto-generated method stub
	                super.onDrawerClosed(view);
	            }
	 
	            public void onDrawerOpened(View drawerView) {
	                // TODO Auto-generated method stub
	                super.onDrawerOpened(drawerView);
	            }
	        };
	        mDrawerLayout.setDrawerListener(mDrawerToggle);
	        
	        if (savedInstanceState == null) {
	            selectItem(0);
	        }
	        
	        Intent intent = getIntent();
	        boolean isOpenFromUpdate=intent.getBooleanExtra("OpenFromNotif", false);
	        if(isOpenFromUpdate){
	        	
	        	selectItem(2);
	        }
	    	mDrawerLayout.openDrawer(mDrawerList);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		//menu.add(0, 12, 0, "MENU").setIcon(R.drawable.ic_drawer);
		 menu.add(0, 12, 0, "MENU")
		 
         .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
		return true;
	}
	   @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	 
	        if (item.getItemId() == android.R.id.home || item.getItemId()==12) {
	 
	            if (mDrawerLayout.isDrawerOpen(mDrawerList)) {
	                mDrawerLayout.closeDrawer(mDrawerList);
	            } else {
	                mDrawerLayout.openDrawer(mDrawerList);
	            }
	        }
	 
	        return super.onOptionsItemSelected(item);
	    }
	   
	   private class DrawerItemClickListener implements
       ListView.OnItemClickListener {
   @Override
   public void onItemClick(AdapterView<?> parent, View view, int position,
           long id) {
       selectItem(position);
   			}
	   }
	   private void selectItem(int position) {
		   
		   FragmentManager fmg=getSupportFragmentManager();
	        FragmentTransaction ft = fmg.beginTransaction();
	        
	        // Locate Position
	        
	        switch (position) {
	        // "Home","Events","Updates","Query","Locate Us","Credits"

	        case 0:
	        	if(!(cfgt instanceof HomeFragment)){
	        	fgt=new HomeFragment();
	           // ft.replace(R.id.content_frame, fgt);
	        	mDrawerList.setItemChecked(position, true);
		        mDrawerLayout.closeDrawer(mDrawerList);
		        cfgt=fgt;
	        	change(ft,fgt);
	        	}
	            break;
	        case 1:
	        	if(!(cfgt instanceof Workshops)){
	        		fgt=new Workshops();
	        		mDrawerList.setItemChecked(position, true);
			        mDrawerLayout.closeDrawer(mDrawerList);
			        cfgt=fgt;
	        		change(ft,fgt);
	        	}
	        	
	            break;
	        case 2:
	        	if(!(cfgt instanceof Events)){
	        		fgt=new Events();
	        		mDrawerList.setItemChecked(position, true);
			        mDrawerLayout.closeDrawer(mDrawerList);
			        cfgt=fgt;
	        		change(ft,fgt);
	        	}
	        	
	            break;
	        case 3:
	        	if(!(cfgt instanceof Updates)){
	        	fgt=new Updates();
	        	mDrawerList.setItemChecked(position, true);
		        mDrawerLayout.closeDrawer(mDrawerList);
		        cfgt=fgt;
	        	change(ft,fgt);
	        	}
	            break;
	        case 4:
	        	
	        	Intent settings=new Intent(this.getApplicationContext(),Settings.class);
	        	mDrawerList.setItemChecked(position,false);
		        mDrawerLayout.closeDrawer(mDrawerList);
		       	startActivity(settings);
		       	
		        overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
	            break;
	        case 5:
	        	if(!(cfgt instanceof Query)) {
	        	fgt=new Query();
	        	mDrawerList.setItemChecked(position, true);
		        mDrawerLayout.closeDrawer(mDrawerList);
		        cfgt=fgt;
	        	change(ft,fgt);
	        	}
	            break;
	        case 6:
	        	
	        	
		        mDrawerLayout.closeDrawer(mDrawerList);
		        double latitude = 12.947621;
		        double longitude = 80.140272;
		        String label = "MIT Anna University, CHENNAI";
		        String uriBegin = "geo:" + latitude + "," + longitude;
		        String query = latitude + "," + longitude + "(" + label + ")";
		        String encodedQuery = Uri.encode(query);
		        String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
		        Uri uri = Uri.parse(uriString);
		        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri);
		        startActivity(intent);
		        overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
	            break;
	        case 7:
	        	if(!(cfgt instanceof Credits)) {
	        	fgt=new Credits();
	        	mDrawerList.setItemChecked(position, true);
		        mDrawerLayout.closeDrawer(mDrawerList);
		        cfgt=fgt;
	        	change(ft,fgt);
	        	}
	            break;
	       
	        
	        }
	        mDrawerLayout.closeDrawer(mDrawerList);
	        
	        
	    }
	   private void change(FragmentTransaction ft, Fragment fgt) {
			
		   ft.setCustomAnimations(android.R.anim.fade_in,android.R.anim.slide_out_right,android.R.anim.fade_out,android.R.anim.slide_in_left);

	        ft.replace(R.id.content_frame, fgt);
	       
	        ft.commit();
	}

	@Override
	    protected void onPostCreate(Bundle savedInstanceState) {
	        super.onPostCreate(savedInstanceState);
	        // Sync the toggle state after onRestoreInstanceState has occurred.
	        mDrawerToggle.syncState();
	    }
	 
	    @Override
	    public void onConfigurationChanged(Configuration newConfig) {
	        super.onConfigurationChanged(newConfig);
	        // Pass any configuration change to the drawer toggles
	        mDrawerToggle.onConfigurationChanged(newConfig);
	    }
	    @Override
	    public boolean onKeyDown(int keyCode, KeyEvent event) {
	        //Handle the back button
	        if(keyCode == KeyEvent.KEYCODE_BACK) {
	            //Ask the user if they want to quit
	            new AlertDialog.Builder(this)
	            .setIcon(android.R.drawable.ic_dialog_alert)
	            .setTitle("Exit")
	            .setMessage("You can explore more through Navigation menu. Do you really want to exit?")
	            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

	                @Override
	                public void onClick(DialogInterface dialog, int which) {

	                    //Stop the activity
	                    MainActivity.this.finish();    
	                }

	            })
	            .setNegativeButton("Explore more",new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						mDrawerLayout.openDrawer(mDrawerList);
						
					}
				})
	            .show();

	            return true;
	        }
	        else {
	            return super.onKeyDown(keyCode, event);
	        }

	    }
//	    @Override
//	    public void onBackPressed(){
////	    	
//	    	if (!mDrawerLayout.isDrawerOpen(mDrawerList))
//	    	 mDrawerLayout.openDrawer(mDrawerList);
//	    	else
//	    		{
//	    		
//	    		this.finish();
//	    		}
//	    	
//	    }
}
