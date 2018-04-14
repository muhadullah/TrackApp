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


public class MyprofileActivity extends Activity {

	private Button tracks;
	private Button garage;
	private Button friends;
	private Button stats;
	private Button skills;
	private ImageView imageview1;



	private Intent intent1 = new Intent();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.myprofile);
		initialize();
		initializeLogic();
	}

	private void  initialize() {
		tracks = (Button) findViewById(R.id.tracks);
		garage = (Button) findViewById(R.id.garage);
		friends = (Button) findViewById(R.id.friends);
		stats = (Button) findViewById(R.id.stats);
		skills = (Button) findViewById(R.id.skills);
		imageview1 = (ImageView) findViewById(R.id.imageview1);



		tracks.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				intent1.setClass(getApplicationContext(), TracksActivity.class);
				intent1.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(intent1);
			}
		});
		garage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				intent1.setClass(getApplicationContext(), GarageActivity.class);
				intent1.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(intent1);
			}
		});
		friends.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 

			}
		});
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 

			}
		});
		stats.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 

			}
		});
		skills.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				intent1.setClass(getApplicationContext(), SkillsActivity.class);
				intent1.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(intent1);
			}
		});

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
