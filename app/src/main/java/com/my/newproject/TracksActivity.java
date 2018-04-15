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


public class TracksActivity extends Activity {
	private Spinner spinner4;
	private Button button1;
	private ImageView imageview1;
	private TextView textview1;
	private TextView textview2;


	private ArrayList<String> list = new ArrayList<String>();
	private ArrayList<String> selection = new ArrayList<String>();

	private Intent intent1 = new Intent();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tracks);
		initialize();
		initializeLogic();
	}

	private void  initialize() {
		spinner4 = (Spinner) findViewById(R.id.spinner4);
		button1 = (Button) findViewById(R.id.button1);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview1 = (TextView) findViewById(R.id.textview1);
		textview2 = (TextView) findViewById(R.id.textview2);



		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				selection.add(list.get((int)(spinner4.getSelectedItemPosition())));
				showMessage(list.get((int)(spinner4.getSelectedItemPosition())));
				if (selection.contains("Putnam")) {
					imageview1.setImageResource(R.drawable.putnam);
				}
				if (selection.contains("Grattan")) {
					imageview1.setImageResource(R.drawable.grattan);
				}
				if (selection.contains("Gingerman")) {
					imageview1.setImageResource(R.drawable.ging);
				}
				selection.clear();
			}
		});

	}

	private void  initializeLogic() {
		list.add("Select a track:");
		list.add("Grattan");
		list.add("Gingerman");
		list.add("Putnam");
		spinner4.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, list));
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
