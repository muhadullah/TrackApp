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


public class GarageActivity extends Activity {

	private Spinner spinner1;
	private ListView listview1;
	private TextView textview4;


	private ArrayList<String> menu = new ArrayList<String>();
	private ArrayList<String> spinner = new ArrayList<String>();
	private ArrayList<String> selection = new ArrayList<String>();

	private Intent int1 = new Intent();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.garage);
		initialize();
		initializeLogic();
	}

	private void  initialize() {
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		listview1 = (ListView) findViewById(R.id.listview1);
		textview4 = (TextView) findViewById(R.id.textview4);



		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView _parent, View _view, final int _position, long _id) { 
				selection.add(menu.get((int)(_position)));
				if (selection.contains("Tuning / Settings")) {
					int1.setClass(getApplicationContext(), TuningActivity.class);
					startActivity(int1);
				}
				selection.clear();
			}
		});

	}

	private void  initializeLogic() {
		menu.add("Tuning / Settings");
		menu.add("Factory Specs");
		menu.add("Personal Stats");
		listview1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, menu));
		spinner.add("Select a Bike:");
		spinner.add("1998 Kawasaki ZX6R");
		spinner.add("2008 Kawasaki ZZR 600");
		spinner.add("2006 Yamaha R6");
		spinner1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, spinner));
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
