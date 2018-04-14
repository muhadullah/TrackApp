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


public class TuningActivity extends Activity {

	private ImageView imageview1;
	private ListView listview1;


	private ArrayList<String> menu = new ArrayList<String>();
	private ArrayList<String> selection = new ArrayList<String>();

	private SharedPreferences ssheet;
	private Intent in1 = new Intent();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tuning);
		initialize();
		initializeLogic();
	}

	private void  initialize() {
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		listview1 = (ListView) findViewById(R.id.listview1);

		ssheet = getSharedPreferences("setup_sheet_3.jpg", Activity.MODE_PRIVATE);


		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 

			}
		});
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView _parent, View _view, final int _position, long _id) { 
				selection.add(menu.get((int)(_position)));
				if (selection.contains("Suspension Worksheet")) {
					imageview1.setImageResource(R.drawable.setup_sheet_3);
				}
				selection.clear();
				selection.add(menu.get((int)(_position)));
				if (selection.contains("Suspension Recommendations")) {
					imageview1.setImageResource(R.drawable.susprecrotate);
				}
				selection.clear();
				selection.add(menu.get((int)(_position)));
				if (selection.contains("Gear Ratios")) {
					imageview1.setImageResource(R.drawable.gearing_calculator_image);
				}
				selection.clear();
				selection.add(menu.get((int)(_position)));
				if (selection.contains("Thrust")) {
					imageview1.setImageResource(R.drawable.thrust_chart_image);
				}
				selection.clear();
				selection.add(menu.get((int)(_position)));
				if (selection.contains("Suspension Histogram")) {
					imageview1.setImageResource(R.drawable.suspensionhistogram);
				}
				selection.clear();
			}
		});

	}

	private void  initializeLogic() {
		menu.add("Suspension Worksheet");
		menu.add("Suspension Recommendations");
		menu.add("Suspension Histogram");
		menu.add("Sag");
		menu.add("Thrust");
		menu.add("Gear Ratios");
		listview1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, menu));
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
