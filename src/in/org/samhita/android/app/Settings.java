package in.org.samhita.android.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.preference.RingtonePreference;

import com.actionbarsherlock.app.SherlockPreferenceActivity;
import com.actionbarsherlock.view.MenuItem;
import android.preference.Preference.OnPreferenceChangeListener;
import in.org.samhita.android.app.R;



public class Settings extends SherlockPreferenceActivity {
	/**
	 * Determines whether to always show the simplified settings UI, where
	 * settings are presented in a single list. When false, settings are shown
	 * as a master/detail two-pane view on tablets. When true, a single pane is
	 * shown on tablets.
	 */
	RingtonePreference notifsoundpref;
	@SuppressWarnings("deprecation")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            notifsoundpref= (RingtonePreference) this.findPreference("notifsound"); 
            notifsoundpref.setOnPreferenceChangeListener(new OnPreferenceChangeListener(){

				@Override
				public boolean onPreferenceChange(Preference preference,
						Object newValue) {
					// TODO Auto-generated method stub
					SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
					Editor editor = prefs.edit();
					editor.putBoolean("soundset", false);
					editor.commit();
					return true;
				}
            	
            });
            
            
	}
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
 
        if (item.getItemId() == android.R.id.home ) {
 
           this.finish();
        }
 
        return super.onOptionsItemSelected(item);
    }

	
	
}
