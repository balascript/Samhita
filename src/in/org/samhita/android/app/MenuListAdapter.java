package in.org.samhita.android.app;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import in.org.samhita.android.app.R;
 
public class MenuListAdapter extends BaseAdapter {
 
    // Declare Variables
    Context context;
    String[] mTitle;
    String[] mSubTitle;
    int[] mIcon;
    LayoutInflater inflater;
    private int mLastPosition=-1;
 
    public MenuListAdapter(Context context, String[] title, String[] subtitle,
            int[] icon) {
        this.context = context;
        this.mTitle = title;
        this.mSubTitle = subtitle;
        this.mIcon = icon;
    }
 
    @Override
    public int getCount() {
        return mTitle.length;
    }
 
    @Override
    public Object getItem(int position) {
        return mTitle[position];
    }
 
    @Override
    public long getItemId(int position) {
        return position;
    }
 
    public View getView(int position, View convertView, ViewGroup parent) {
        // Declare Variables
        TextView txtTitle;
        TextView txtSubTitle;
        ImageView imgIcon;
        LinearLayout l;
 
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.drawer_list_item, parent,
                false);
 
        // Locate the TextViews in drawer_list_item.xml
        l=(LinearLayout) itemView.findViewById(R.id.linearwhole);
       // l.setBackgroundColor(Color.CYAN);
        txtTitle = (TextView) itemView.findViewById(R.id.title);
        
        
 
        // Locate the ImageView in drawer_list_item.xml
        imgIcon = (ImageView) itemView.findViewById(R.id.icon);
 
        // Set the results into TextViews
        txtTitle.setText(mTitle[position]);
        txtTitle.setTextColor(Color.WHITE);
     
 
        // Set the results into ImageView
        imgIcon.setImageResource(mIcon[position]);
        TranslateAnimation animation = null;
        if (position > mLastPosition) {
            animation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.0f);

            animation.setDuration(1000);
            itemView.startAnimation(animation);
            mLastPosition = position;
        }
 
        return itemView;
    }
 
}
