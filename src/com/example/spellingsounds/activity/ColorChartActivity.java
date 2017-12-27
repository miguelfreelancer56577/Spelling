package com.example.spellingsounds.activity;

import com.example.spellingsounds.R;
import com.example.spellingsounds.R.id;
import com.example.spellingsounds.R.layout;
import com.example.spellingsounds.helper.DataBaseActiveAndroid;
import com.example.spellingsounds.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout.LayoutParams;
import android.widget.TextView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class ColorChartActivity extends Activity {
	
	private final String log = ColorChartActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_color_chart);

//		final View controlsView = findViewById(R.id.fullscreen_content_controls);
		final ScrollView contentView = (ScrollView) findViewById(R.id.fullscreen_content);
		
		DataBaseActiveAndroid db = new DataBaseActiveAndroid(this);
		
//		main container for each item into it 
		
		Log.i(log, "Creating main container.");
		
		final LinearLayout mainContainer = new LinearLayout(this);
		
		mainContainer.setOrientation(LinearLayout.VERTICAL);
		
		mainContainer.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		
		mainContainer.setKeepScreenOn(true);
		
		Log.i(log, "Main container created.");
		
		int count=0;
		
//		create the first container item
		
		Log.i(log, "Creating firts item container");
		
		LinearLayout itemContainer = new LinearLayout(this);
		
		itemContainer.setOrientation(LinearLayout.HORIZONTAL);
		
		itemContainer.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		
		Log.i(log, "Item container created");
		
//		create 20 item for every sound.
		
		for (int i = 1; i <= 3; i++) {
			
			if( count == 2 ){
				
				Log.i(log, "Adding item container to the main container");
				
				mainContainer.addView(itemContainer);
				
				Log.i(log, "Item container added to the main container");
				
				Log.i(log, "Creating another item container");
				
				itemContainer = new LinearLayout(this);
				
				itemContainer.setOrientation(LinearLayout.HORIZONTAL);
				
				itemContainer.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				
				Log.i(log, "Item container created");
				
				count = 0;
				
			}
			
			Log.i(log, "Creating item with id: " + i);
			
			TextView item = (TextView) getLayoutInflater().inflate(R.layout.item_color_chart, null);
			
			Log.i(log, "Setting params.");
			LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, 100, 1);
			
			item.setLayoutParams(layoutParams);
			
			itemContainer.addView(item);
			
			item.setId(i);
			
			item.setText(i + "");
			
			item.setOnTouchListener(itemTouchListener);
			
			Log.i(log, "item with id " + i + " was created.");
			
			count++;
				
		}
		
		Log.i(log, "adding all content to the view.");
		
		contentView.addView(mainContainer);
		
		Log.i(log, "Content added successfully.");

	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);

	}
	
	 View.OnTouchListener itemTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
        	
        	Intent i = new Intent(ColorChartActivity.this, ColorChartDetailActivity.class);
        	
        	Log.i(log, "calling chart detail with id: " + view.getId());
        	
        	i.putExtra("char_number", view.getId());
        	
        	startActivity(i);
        	
            return false;
        }
    };


}
