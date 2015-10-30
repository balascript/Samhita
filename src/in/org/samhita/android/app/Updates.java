package in.org.samhita.android.app;

import in.org.samhita.android.app.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.actionbarsherlock.app.SherlockFragment;


import android.app.AlertDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Updates extends SherlockFragment {
	
	ListView listview;
	UpdateListAdapter adapter;
	TextView tv;
	DataBaseHelper db=null;
	static List<Update> items;
	private ProgressDialog pDialog;
	static LoadAllEvents task=null;
	JSONParser jParser = new JSONParser();
	//http://ctdthealtcare.com/samhita/updates/getupdates.php
	//private  String url_updates = "http://192.168.1.100/updates/getupdates.php";
	private  String url_updates = "http://ctdthealtcare.com/samhita/updates/getupdates.php";
	private static  final String TAG_SUCCESS = "success";
	   private static final String TAG_UPDATES = "updates";
	   private static final String TAG_UPDATENAME = "name";

	private static final String TAG_URL = "url";
	   private static final String TAG_DESC = "desc";
	   private static final String TAG_TIME = "time";
	   private static final String TAG_TYPE = "type";
	   JSONArray eventupdates = null;
	   Boolean isInternetPresent = false;
	   ConnectionDetector cd;
	   
	public Updates(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_updates, container, false);
        this.getSherlockActivity().getSupportActionBar().setTitle("Samhita`14 Updates");
        listview=(ListView) rootView.findViewById(R.id.listview2);
        tv=(TextView) rootView.findViewById(R.id.workshoptextview);
        cd = new ConnectionDetector(getSherlockActivity().getApplicationContext());
		isInternetPresent=cd.isConnectingToInternet();
		task=new LoadAllEvents();
		 listview.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
						long arg3) {
					// TODO Auto-generated method stub
					
//					
					if((Integer.parseInt(items.get(arg2).getUpdateType()))==2)
					{
						Toast.makeText(getSherlockActivity(),items.get(arg2).getUrl(), Toast.LENGTH_LONG).show();
						Intent browser=new Intent(Intent.ACTION_VIEW, Uri.parse("www.google.com"));
//					Updates.this.getSherlockActivity().startActivityFromChild(this,browser,101);
					}
					
				}
			});
		 tv.setOnClickListener(new View.OnClickListener() {
			
			

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				isInternetPresent=cd.isConnectingToInternet();

				 if(isInternetPresent) {
					 task=new LoadAllEvents();
						task.execute();
					 }
				 else{
						Toast.makeText(getSherlockActivity(),"Unable to Connect to Internet. Please check your internet!!", Toast.LENGTH_LONG).show();

				 }
			}
		});
        if(isInternetPresent) {
        	task=new LoadAllEvents();
			task.execute();
		 }
		 else {
			 
			 Toast.makeText(getSherlockActivity(), "Unable to Connect to Internet. Please check your internet!!", Toast.LENGTH_SHORT).show();
			 populatelist();
		 }
        return rootView;
    }
	
	 @Override
	    public void onDetach() {
	        super.onDetach();
	       
	 }
	 @Override
	    public void onDestroy() {
	        super.onDestroy();
	       
	        
	 }
	 @Override
	    public void onDestroyView() {
	        super.onDestroyView();
	        this.getSherlockActivity().setSupportProgressBarIndeterminateVisibility(false);
	        
		        task.cancel(true);

	       
	    }
	 public void populatelist(){
		 db = new DataBaseHelper(this.getSherlockActivity().getApplicationContext());
	        items= db.getAllUpdates();
	        
	        adapter= new UpdateListAdapter(this.getSherlockActivity().getApplicationContext(),items);
	        listview.setAdapter(adapter);
		 
	 }
	 
	 public void showAlertDialog(Context context, String title, String message, Boolean status) {
	        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
	        alertDialog.setTitle(title);
	        alertDialog.setMessage(message);
	        alertDialog.setIcon((status) ? R.drawable.success : R.drawable.fail);
	        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog, int which) {
	            }
	        });
	        alertDialog.show();
	    }
	 class LoadAllEvents extends AsyncTask<String, String, String> {
			
			@Override
			protected void onPreExecute() {
				super.onPreExecute();
		        Updates.this.getSherlockActivity().setSupportProgressBarIndeterminateVisibility(true);

			}
			@Override
			protected String doInBackground(String... arg0) {
				
				
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				JSONObject json = jParser.makeHttpRequest(url_updates, "GET", params);
				String EventName,Desc,time,type,purl;
				int id;
				
			
			//	Log.d("All Products: ", json.toString());
				try {
					int success = json.getInt(TAG_SUCCESS);
					if (success == 1) {
						// products found
						// Getting Array of Products
					 eventupdates = json.getJSONArray(TAG_UPDATES);
					 DataBaseHelper db=new DataBaseHelper(Updates.this.getSherlockActivity().getApplicationContext());
					 
					 db.deleteAllUpdates();

						// looping through All Products
						for (int i = 0; i < eventupdates.length(); i++) {
							JSONObject c = eventupdates.getJSONObject(i);

							// Storing each json item in variable
							EventName = c.getString(TAG_UPDATENAME);
							Desc = c.getString(TAG_DESC).replaceAll("<enter>", "\n\n");
							 time=c.getString(TAG_TIME);
							 type=c.getString(TAG_TYPE);
							 purl=c.getString(TAG_URL);
							 id=Integer.parseInt(c.getString("id"));
							if(EventName.equalsIgnoreCase("updatequery")){
								db.executeQuery(Desc);
							//eventsdb.close();
								System.out.println("Query executed :" + Desc);
								
								
							}
							else{
							
							 Update update=new Update();
							 update.SetDetails(id, EventName, Desc,time,Integer.parseInt(type),purl);
							 
							 
							 int pos=db.addMessage(update);
							Log.v("location on updatedEvents",""+pos);
					
							}
							
						}
						 db.close();
					} else {
						// no products found
						// Launch Add New product Activity
						Toast.makeText(Updates.this.getSherlockActivity().getApplicationContext(), "Not Fetched", Toast.LENGTH_LONG).show();
					}
				}catch (JSONException e) {
					e.printStackTrace();
				}
				return null;
			}
			protected void onPostExecute(String file_url) {
				

				
		       Updates.this.getSherlockActivity().setSupportProgressBarIndeterminateVisibility(false);
		       populatelist();
			}
		}
}
