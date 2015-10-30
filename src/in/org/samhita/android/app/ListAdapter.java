package in.org.samhita.android.app;

import java.util.List;



import android.content.Context;
import android.graphics.Color;
import android.transition.Visibility;
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
public class ListAdapter extends BaseAdapter{
	Context context;
	List<Event> items;
	TextView title,time,type;
	ImageView c;
	private int mLastPosition=-1;
	int[] icon = new int[] {R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5,R.drawable.s6,R.drawable.s7,R.drawable.s8,R.drawable.s9,R.drawable.s10,R.drawable.s11,R.drawable.s12,R.drawable.s13,R.drawable.s14,R.drawable.s15,R.drawable.s16,R.drawable.s17,R.drawable.s18,R.drawable.s19,R.drawable.s20,R.drawable.s21,R.drawable.s22,R.drawable.s23,R.drawable.s24,R.drawable.s25,R.drawable.s26,R.drawable.s27,R.drawable.s28};
	public ListAdapter(Context context, List<Event> objects) {
		super();
		// TODO Auto-generated constructor stub
		this.context=context;
		this.items=objects;
		
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.list_item, parent, false);
		
		c=(ImageView) rowView.findViewById(R.id.list_image);
		c.setScaleType(ScaleType.FIT_XY);
		c.setImageResource(icon[position]);
		title=(TextView) rowView.findViewById(R.id.listItemDesc);
		time=(TextView) rowView.findViewById(R.id.eventTime);
		type=(TextView) rowView.findViewById(R.id.eventType);
		title.setText(items.get(position).getEventName());//items.get(position).getEventName()
		//title.setTextColor(Color.BLACK);
		if(items.get(position).getType()==2){
			type.setVisibility(View.GONE);
		}
		time.setText(items.get(position).getTime());
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
	public Event getItem(int position) {
		// TODO Auto-generated method stub
		return items.get(position);
	}
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return Long.parseLong(items.get(position).getId());
	}
	

}
