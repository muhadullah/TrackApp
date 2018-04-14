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


public class SkillsActivity extends Activity {

	private TextView title;
	private CheckBox checkbox1;
	private CheckBox checkbox2;
	private CheckBox shifting;
	private CheckBox checkbox4;
	private CheckBox checkbox5;
	private TextView textview1;
	private SeekBar seekbar3;
	private TextView textview2;
	private SeekBar seekbar2;
	private TextView textview3;
	private SeekBar seekbar4;
	private TextView textview4;
	private TextView textview5;





	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.skills);
		initialize();
		initializeLogic();
	}

	private void  initialize() {
		title = (TextView) findViewById(R.id.title);
		checkbox1 = (CheckBox) findViewById(R.id.checkbox1);
		checkbox2 = (CheckBox) findViewById(R.id.checkbox2);
		shifting = (CheckBox) findViewById(R.id.shifting);
		checkbox4 = (CheckBox) findViewById(R.id.checkbox4);
		checkbox5 = (CheckBox) findViewById(R.id.checkbox5);
		textview1 = (TextView) findViewById(R.id.textview1);
		seekbar3 = (SeekBar) findViewById(R.id.seekbar3);
		textview2 = (TextView) findViewById(R.id.textview2);
		seekbar2 = (SeekBar) findViewById(R.id.seekbar2);
		textview3 = (TextView) findViewById(R.id.textview3);
		seekbar4 = (SeekBar) findViewById(R.id.seekbar4);
		textview4 = (TextView) findViewById(R.id.textview4);
		textview5 = (TextView) findViewById(R.id.textview5);



	}

	private void  initializeLogic() {

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
