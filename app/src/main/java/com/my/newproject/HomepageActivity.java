package com.my.newproject;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.ClipboardManager;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.text.*;


public class HomepageActivity extends Activity {

	private TextView textview1;
	private Spinner spinner1;
	private Spinner spinner2;
	private Spinner spinner3;
	private Spinner spinner4;
	private Button button1;


	private ArrayList<String> menu = new ArrayList<String>();
	private ArrayList<String> profile = new ArrayList<String>();
	private ArrayList<String> Settings = new ArrayList<String>();
	private ArrayList<String> Friends = new ArrayList<String>();
	private ArrayList<String> calend = new ArrayList<String>();
	private ArrayList<String> selection = new ArrayList<String>();

	private Intent intent1 = new Intent();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homepage);
		initialize();
		initializeLogic();
	}

	private void  initialize() {
		textview1 = (TextView) findViewById(R.id.textview1);
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		spinner2 = (Spinner) findViewById(R.id.spinner2);
		spinner3 = (Spinner) findViewById(R.id.spinner3);
		spinner4 = (Spinner) findViewById(R.id.spinner4);
		button1 = (Button) findViewById(R.id.button1);



		spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView _parent, View _view, final int _position, long _id) { 

			}
			@Override
			public void onNothingSelected(AdapterView _parent) { 
			}
		});
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				selection.add(profile.get((int)(spinner1.getSelectedItemPosition())));
				if (selection.contains("Tracks")) {
					intent1.setClass(getApplicationContext(), TracksActivity.class);
					startActivity(intent1);
				}
				selection.clear();
				selection.add(profile.get((int)(spinner1.getSelectedItemPosition())));
				if (selection.contains("Garage")) {
					intent1.setClass(getApplicationContext(), GarageActivity.class);
					startActivity(intent1);
				}
				selection.clear();
			}
		});

	}

	private void  initializeLogic() {
		profile.add("My Profile:");
		profile.add("Tracks");
		profile.add("Garage");
		profile.add("Personal Stats");
		spinner1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, profile));
		calend.add("Calendar:");
		calend.add("Upcoming Events");
		calend.add("Event Log");
		spinner2.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, calend));
		Friends.add("Community:");
		Friends.add("Friends");
		spinner3.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, Friends));
		Settings.add("Settings:");
		spinner4.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, Settings));
	}






	// created automatically
	private void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}

	private int getLocationX(View _v) {
		 int _location[] = new int[2];
		 _v.getLocationInWindow(_location);
		 return _location[0];
	}

	private int getLocationY(View _v) {
		 int _location[] = new int[2];
		 _v.getLocationInWindow(_location);
		 return _location[1];
	}

	private int getRandom(int _minValue ,int _maxValue){
		Random random = new Random();
		return random.nextInt(_maxValue - _minValue + 1) + _minValue;
	}

	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
				_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}

	private float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}

	private int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}

	private int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}


}
