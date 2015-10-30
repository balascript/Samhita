package in.org.samhita.android.app;

import com.actionbarsherlock.app.SherlockFragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
public class Workshops extends SherlockFragment {

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
		 View rootView = inflater.inflate(R.layout.fragment_workshop, container, false);
	        this.getSherlockActivity().getSupportActionBar().setTitle("Workshops");
	        GridView gridView = (GridView) rootView.findViewById(R.id.grid_view_workshops);
	        gridView.setAdapter(new WorkshopImageAdapter(this.getSherlockActivity().getApplicationContext()));
	        gridView.setOnItemClickListener(new OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
					Intent i = new Intent(getSherlockActivity().getApplicationContext(),EventActivity.class);
					i.putExtra("eid",""+(arg2+1) );
					i.putExtra("type","workshop" );
					startActivity(i);
					getSherlockActivity().overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
					
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
