package in.org.samhita.android.app;



import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class WorkshopImageAdapter extends BaseAdapter {
	private Context mContext;
	
	// Keep all Images in array
	public Integer[] mThumbIds = {
			R.drawable.androidicon,R.drawable.matlabicon,R.drawable.pervasiveicon	};

	private int minwidth;

	private int maxwidth;
	
	// Constructor
	public WorkshopImageAdapter(Context c){
		mContext = c;
	}

	@Override
	public int getCount() {
		return mThumbIds.length;
	}

	@Override
	public Object getItem(int position) {
		return mThumbIds[position];
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {			
		LayoutInflater inflator =(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View boxview=inflator.inflate(R.layout.singlebox, parent, false);
		// boxview.setBackgroundResource(mThumbIds[position]);
		
		ImageView imageView = (ImageView)boxview.findViewById(R.id.eventImage);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setAdjustViewBounds(true);
        
        return boxview;
	}

}
