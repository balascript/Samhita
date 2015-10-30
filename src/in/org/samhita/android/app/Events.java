package in.org.samhita.android.app;


import java.util.ArrayList;
import java.util.List;

import com.actionbarsherlock.app.SherlockFragment;


import android.app.Fragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import in.org.samhita.android.app.R;

public class Events extends SherlockFragment {
	
	static ListView listview;
	static ListAdapter adapter;
	TextView tv;
	static DataBaseHelper db=null;
	static List<Event> items;
	public Events(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
      View rootView = inflater.inflate(R.layout.fragment_events, container,false);
      this.getSherlockActivity().getSupportActionBar().setTitle("Events");
      
      listview=(ListView) rootView.findViewById(R.id.listview1);
      tv=(TextView)rootView.findViewById(R.id.AD1);
      tv.setText("Buhari Hotel");
      tv.setVisibility(View.GONE);
      
      tv.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Toast.makeText(getSherlockActivity(),"Welcome to Buhari Hotel", Toast.LENGTH_LONG).show();

			
		}
	});
      
      db = new DataBaseHelper(this.getSherlockActivity().getApplicationContext());
    items= db.getAllEvents();
     
      adapter= new ListAdapter(this.getSherlockActivity().getApplicationContext(),items);
      listview.setAdapter(adapter);
      listview.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			//Toast.makeText(getSherlockActivity(),items.get(arg2).getEventName(), Toast.LENGTH_LONG).show();
//			fgt=new DetailFragment();
			Intent i = new Intent(getSherlockActivity().getApplicationContext(),EventActivity.class);
			i.putExtra("eid",items.get(arg2).getId() );
			i.putExtra("type","event" );
			startActivity(i);
			getSherlockActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
//			change(ft, fgt);
			
		}
	});
      
      
        
         
        return rootView;
    }
	 
	
	 @Override
	    public void onDetach() {
	        super.onDetach();
	 }
	 @Override
	    public void onDestroyView() {
	        super.onDestroyView();
	       
	    }
	 
}
