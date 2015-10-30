package in.org.samhita.android.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;



import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import in.org.samhita.android.app.R;
public class UpdateListAdapter extends BaseAdapter{
	Context context;
	List<Update> items;
	TextView time,UpdateName,UpdateDesc;
	String diff="";
	long currenttime,updatetime,hours,minutes,days,seconds,difft;
	ImageView c;
	private int mLastPosition=-1;
	public UpdateListAdapter(Context context, List<Update> objects) {
		super();
		// TODO Auto-generated constructor stub
		this.context=context;
		this.items=objects;
		
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.update_list_item, parent, false);
		UpdateName= (TextView) rowView.findViewById(R.id.upname);
		UpdateDesc= (TextView) rowView.findViewById(R.id.updesc);
		time=(TextView) rowView.findViewById(R.id.uptime);
		UpdateName.setText(items.get(position).getUpdate());
		UpdateDesc.setText(items.get(position).getDesc());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
		Calendar c = Calendar.getInstance();
		try {
			Date dt = sdf.parse(items.get(position).getTime());
			currenttime=c.getTime().getTime();
			c.setTime(dt);
			 updatetime=c.getTime().getTime();
			difft = currenttime-updatetime;
			seconds = difft / 1000;
			minutes = seconds / 60;
			hours = minutes / 60;
			days = hours / 24;
			if(days>=1) 
			diff=""+days+"day(s) ago";
			else if(hours>1)
				diff=""+hours+"hrs ago";
			else 
				diff=""+minutes+"Mins ago";
			
			//Toast.makeText(context, diff, Toast.LENGTH_SHORT).show();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			Log.v("parse error","time problem");
			e.printStackTrace();
		}
		time.setText(diff);
	
		 TranslateAnimation animation = null;
	        if (position > mLastPosition) {
	            animation = new TranslateAnimation(
	                Animation.RELATIVE_TO_SELF,
	                0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
	                Animation.RELATIVE_TO_SELF, 1.0f,
	                Animation.RELATIVE_TO_SELF, 0.0f);

	            animation.setDuration(1000);
	            rowView.startAnimation(animation);
	            mLastPosition = position;
	        }
		return rowView;
	}
	/**
	 * @param args
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return items.size();
	}
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return items.get(position).getUpdate();
	}
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return Long.parseLong(items.get(position).getId());
	}
	

}
