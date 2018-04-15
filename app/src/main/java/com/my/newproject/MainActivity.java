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

import com.google.firebase.auth.FirebaseAuth;

import java.util.*;
import java.text.*;


public class MainActivity extends Activity {
	private TextView title;
	private TextView login;
	private Button enter;
	private TextView textview1;
	private Button loginPage;


	private ArrayList<String> tracklist = new ArrayList<String>();

	private Intent intent1 = new Intent();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initialize();
		initializeLogic();
	}

	private void  initialize() {
		title = (TextView) findViewById(R.id.title);
		login = (TextView) findViewById(R.id.login);
		enter = (Button) findViewById(R.id.enter);
		textview1 = (TextView) findViewById(R.id.textview1);
		loginPage = (Button) findViewById(R.id.loginPage);


		loginPage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				intent1.setClass(getApplicationContext(), LoginActivity2.class);
				//intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent1);
			}

		 });

		enter.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				intent1.setClass(getApplicationContext(), HomepageActivity.class);
				intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
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
