package in.org.samhita.android.app;



import com.actionbarsherlock.app.SherlockFragment;



import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class Credits extends SherlockFragment {
	
	Button send;
	SmsManager sms;
	EditText msg;
	TextView tv;
	public Credits(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_credits, container, false);
        this.getSherlockActivity().getSupportActionBar().setTitle("Credits & Sponsors");
        GridView gridView = (GridView) rootView.findViewById(R.id.grid_view_credits);
        // Instance of ImageAdapter Class
		gridView.setAdapter(new ImageAdapter(this.getSherlockActivity().getApplicationContext()));
		msg = (EditText) rootView.findViewById(R.id.feedBackText);
        msg.clearFocus();
        send=(Button)rootView.findViewById(R.id.sendButton);
        tv=(TextView) rootView.findViewById(R.id.giveFeedBack);
        tv.setText("Please give us your Valuble FeedBack!\nBalakrishnan, Dev Team, ITA");
		send.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				 
	    		    sms = SmsManager.getDefault();
					
			       if(sms!=null){
			    	   if(!msg.getText().toString().equals("")) {
			    		   showAlertDialog(Credits.this.getSherlockActivity(),"Sending SMS","Thanks for your concern! We will consider your feedback for sure! \nStandard SMS Charges apply. Dont worry if you have Booster pack !",true);
					
			    	   }
			    	   else
			    		   Toast.makeText(Credits.this.getSherlockActivity(), "Type something and press Send",Toast.LENGTH_SHORT).show();
			       }
			       else
			    	   Toast.makeText(Credits.this.getSherlockActivity(), "Error Occured",Toast.LENGTH_SHORT).show();
				
			        
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
	 public void showAlertDialog(Context context, String title, String message, Boolean status) {
	        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
	 
	        // Setting Dialog Title
	        alertDialog.setTitle(title);
	 
	        // Setting Dialog Message
	        alertDialog.setMessage(message);
	 
	        // Setting alert dialog icon
	        alertDialog.setIcon((status) ? R.drawable.success : R.drawable.fail);
	 
	        // Setting OK Button
	       alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

	    	   public void onClick(DialogInterface arg0, int arg1) {
	    	   // do something when the OK button is clicked
	    		   sms.sendTextMessage("+919677767721", null,"TODEVTEAM:"+msg.getText().toString() , null, null);
					
					msg.setText("");
	    	   }});
	       
	       alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
	           
	    	   public void onClick(DialogInterface arg0, int arg1) {
	    	   // do something when the Cancel button is clicked
	    	   }});
	 
	        // Showing Alert Message
	        alertDialog.show();
	    }
}
