package in.org.samhita.android.app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import in.org.samhita.android.app.R;




public class HomeFragment extends SherlockFragment {
	RelativeLayout top;
	TextView left,right;
	Button w,f,up;
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		//Log.v("FRAGMENT", "Came till here ");
      View rootView = inflater.inflate(R.layout.fragment_home, container, false);
      this.getSherlockActivity().getSupportActionBar().setTitle("Samhita`14 Home");
  	DisplayMetrics displayMetrics = new DisplayMetrics();
    WindowManager wm = (WindowManager) this.getSherlockActivity().getApplicationContext().getSystemService(Context.WINDOW_SERVICE); // the results will be higher than using the activity context object or the getWindowManager() shortcut
    wm.getDefaultDisplay().getMetrics(displayMetrics);
    int screenWidth = displayMetrics.widthPixels;
    int screenHeight = displayMetrics.heightPixels;
    w=(Button) rootView.findViewById(R.id.btn_website);
    f=(Button) rootView.findViewById(R.id.btn_like);
    up=(Button) rootView.findViewById(R.id.btn_update);
    w.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			FragmentManager fmg=HomeFragment.this.getSherlockActivity().getSupportFragmentManager();
	        FragmentTransaction ft = fmg.beginTransaction();
	       
	        Fragment fgt=new Workshops();
	        ft.setCustomAnimations(android.R.anim.fade_in,android.R.anim.slide_out_right,android.R.anim.fade_out,android.R.anim.slide_in_left);
	        MainActivity.cfgt=fgt;
	        ft.replace(R.id.content_frame, fgt);
	       
	        ft.commit();
			
		}
	});
 f.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("http://facebook.com/samhitamit"));
			startActivity(browser);
			
		}
	});
 up.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			FragmentManager fmg=HomeFragment.this.getSherlockActivity().getSupportFragmentManager();
	        FragmentTransaction ft = fmg.beginTransaction();
	       
	        Fragment fgt=new Updates();
	        ft.setCustomAnimations(android.R.anim.fade_in,android.R.anim.slide_out_right,android.R.anim.fade_out,android.R.anim.slide_in_left);
	        MainActivity.cfgt=fgt;
	        ft.replace(R.id.content_frame, fgt);
	       
	        ft.commit();
			
		}
	});
    top=(RelativeLayout)  rootView.findViewById(R.id.topimageslider);
    
      ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.view_pager);
//      LayoutParams params = (LayoutParams) top.getLayoutParams();
//      if(screenWidth>screenHeight)
//      params.height = 2*screenHeight/3;
//      else
//    	  params.height = 8*screenHeight/11;
      ImagePagerAdapter adapter = new ImagePagerAdapter();
      viewPager.setAdapter(adapter);
         
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

	 private class ImagePagerAdapter extends PagerAdapter {
		    private int[] mImages = new int[] {
		        R.drawable.home,
		       
		       		    };

		    @Override
		    public int getCount() {
		      return mImages.length;
		    }

		    @Override
		    public boolean isViewFromObject(View view, Object object) {
		      return view == ((ImageView) object);
		    }

		    @Override
		    public Object instantiateItem(ViewGroup container, int position) {
		      Context context = HomeFragment.this.getSherlockActivity().getApplicationContext();
		      ImageView imageView = new ImageView(context);
		      int padding = context.getResources().getDimensionPixelSize(
		          R.dimen.padding_medium);
		      imageView.setPadding(padding, padding, padding, padding);
		      imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
		      imageView.setImageResource(mImages[position]);
		      ((ViewPager) container).addView(imageView, 0);
		      return imageView;
		    }

		    @Override
		    public void destroyItem(ViewGroup container, int position, Object object) {
		      ((ViewPager) container).removeView((ImageView) object);
		    }
		  }
}
