package book.lab.com.app_preferenceactivity;

import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends PreferenceActivity {
	private Context context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		context = this;
		FragmentTransaction ft = 
				getFragmentManager().beginTransaction();
		ft.replace(android.R.id.content, 
				new MyPreferenceFragment()).commit();
	}
	public class MyPreferenceFragment extends PreferenceFragment {
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			addPreferencesFromResource(R.xml.preference);

			// 監聽[安全模式]
			Preference pref = findPreference("apply_safemode");
			pref.setOnPreferenceChangeListener(
					new OnPreferenceChangeListener() {
				@Override
				public boolean onPreferenceChange(Preference p,
						Object newValue) {
					Toast.makeText(context,
							p.getKey() + ":" + newValue,
							Toast.LENGTH_SHORT).show();
					return true;
				}
			});
		}
	}
}


/*
 // 監聽[安全模式]
            Preference pref = findPreference("apply_bg");
            pref.setOnPreferenceChangeListener(
                    new OnPreferenceChangeListener() {
                        @Override
                        public boolean onPreferenceChange(Preference p,
                                                          Object newValue) {
                            //Log.v("mytag",p.getKey()+"---" +newValue);
                            Toast.makeText(context,
                                    p.getKey() + ":" + newValue,
                                    Toast.LENGTH_SHORT).show();

                            WallpaperManager wm = WallpaperManager.getInstance(getApplicationContext());
                            try {
                                if (newValue.toString().equals("winter")) {
                                    wm.setResource((int) R.drawable.winter);
                                } else {
                                    wm.setResource((int) R.drawable.desert);
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            return true;
                        }
                    })

*/
