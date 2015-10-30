package in.org.samhita.android.app;

import java.util.List;

import com.actionbarsherlock.app.SherlockFragment;
import in.org.samhita.android.app.R;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;

public class Query extends SherlockFragment {
	Spinner spin;
    List<Event> list;
    TextView header,subheader;
    Button go,call;
	public Query(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_query, container, false);
        this.getSherlockActivity().getSupportActionBar().setTitle("Query Section");
         header=(TextView) rootView.findViewById(R.id.queryHeader);
         go= (Button) rootView.findViewById(R.id.qbutn);
         call= (Button) rootView.findViewById(R.id.qcbutton);
         subheader=(TextView) rootView.findViewById(R.id.querySubHeader);
         header.setText("Welcome to Query Section");
         subheader.setText("Choose an event from the below list to ask query!\n Standard SMS Charges and call Charges apply");
        spin=(Spinner) rootView.findViewById(R.id.eventSpinner);
        DataBaseHelper db= new DataBaseHelper(this.getSherlockActivity().getApplicationContext());
       list= db.getAllEvents();
        
        ListAdapter adapter= new ListAdapter(this.getSherlockActivity().getApplicationContext(),list);

       
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				String label = Query.this.list.get(arg2).getEventName();

				// Showing selected spinner item
				Toast.makeText(arg0.getContext(), "selected Event " + label,
						Toast.LENGTH_LONG).show();

				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
        	
        });
        go.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String phone=Query.this.list.get(Query.this.spin.getSelectedItemPosition()).getPhone();
				Toast.makeText(Query.this.getSherlockActivity().getApplicationContext(), "Opening SMS window to :"+phone,Toast.LENGTH_SHORT).show();
				Uri uri = Uri.parse("smsto:"+ phone);  
				Intent intent = new Intent(Intent.ACTION_SENDTO, uri);  
				intent.putExtra("sms_body", "Ask your Queries regarding "+ Query.this.list.get(Query.this.spin.getSelectedItemPosition()).getEventName()+":\n");    
				startActivityForResult(intent, 5);
				
			}
		});
        call.setOnClickListener(new View.OnClickListener() {
        	private Intent callintent;

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String phone=Query.this.list.get(Query.this.spin.getSelectedItemPosition()).getPhone();

				Toast.makeText(Query.this.getSherlockActivity().getApplicationContext(),"Calling Event Organizer:"+ phone,Toast.LENGTH_SHORT).show();
				callintent= new Intent(Intent.ACTION_CALL);
				callintent.setData(Uri.parse("tel:" +phone));
				startActivity(callintent);
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
