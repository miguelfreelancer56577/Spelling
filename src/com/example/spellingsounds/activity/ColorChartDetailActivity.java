package com.example.spellingsounds.activity;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import com.example.spellingsounds.R;
import com.example.spellingsounds.R.id;
import com.example.spellingsounds.R.layout;
import com.example.spellingsounds.persistence.ColorChart;
import com.example.spellingsounds.util.SystemUiHider;
import com.example.spellingsounds.util.ImageTool;
import com.mangelt.image.base64.util.Convertor;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class ColorChartDetailActivity extends Activity {
	/**
	 * Whether or not the system UI should be auto-hidden after
	 * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
	 */
	private static final boolean AUTO_HIDE = true;

	/**
	 * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
	 * user interaction before hiding the system UI.
	 */
	private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

	/**
	 * If set, will toggle the system UI visibility upon interaction. Otherwise,
	 * will show the system UI visibility upon interaction.
	 */
	private static final boolean TOGGLE_ON_CLICK = true;

	/**
	 * The flags to pass to {@link SystemUiHider#getInstance}.
	 */
	private static final int HIDER_FLAGS = SystemUiHider.FLAG_HIDE_NAVIGATION;

	/**
	 * The instance of the {@link SystemUiHider} for this activity.
	 */
	private SystemUiHider mSystemUiHider;

	// number of the chart to load
	int charNumber;

	// reference to the image of the sound
	ImageView image_chart_img;

	// utilities object
	ImageTool tool;
	
	private ColorChart colorChart;

	private final String log = ColorChartDetailActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_color_chart_detail);

		final View controlsView = findViewById(R.id.fullscreen_content_controls);
		final View contentView = findViewById(R.id.fullscreen_content);
		
		colorChart = new ColorChart();

		// get image component
		image_chart_img = (ImageView) findViewById(R.id.image_chart_img);

		// object of utilities
		tool = new ImageTool(this);

		Log.i(log, "getting char number.");

		Intent intent = getIntent();

		charNumber = intent.getIntExtra("char_number", 0);

		Log.i(log, "char number got: " + charNumber);

		// Set up an instance of SystemUiHider to control the system UI for
		// this activity.
		mSystemUiHider = SystemUiHider.getInstance(this, contentView,
				HIDER_FLAGS);
		mSystemUiHider.setup();
		mSystemUiHider
				.setOnVisibilityChangeListener(new SystemUiHider.OnVisibilityChangeListener() {
					// Cached values.
					int mControlsHeight;
					int mShortAnimTime;

					@Override
					@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
					public void onVisibilityChange(boolean visible) {
						if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
							// If the ViewPropertyAnimator API is available
							// (Honeycomb MR2 and later), use it to animate the
							// in-layout UI controls at the bottom of the
							// screen.
							if (mControlsHeight == 0) {
								mControlsHeight = controlsView.getHeight();
							}
							if (mShortAnimTime == 0) {
								mShortAnimTime = getResources().getInteger(
										android.R.integer.config_shortAnimTime);
							}
							controlsView
									.animate()
									.translationY(visible ? 0 : mControlsHeight)
									.setDuration(mShortAnimTime);
						} else {
							// If the ViewPropertyAnimator APIs aren't
							// available, simply show or hide the in-layout UI
							// controls.
							controlsView.setVisibility(visible ? View.VISIBLE
									: View.GONE);
						}

						if (visible && AUTO_HIDE) {
							// Schedule a hide().
							delayedHide(AUTO_HIDE_DELAY_MILLIS);
						}
					}
				});

		// Set up the user interaction to manually show or hide the system UI.
		contentView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (TOGGLE_ON_CLICK) {
					mSystemUiHider.toggle();
				} else {
					mSystemUiHider.show();
				}
			}
		});

		// operation to save the record
		findViewById(R.id.save_button).setOnTouchListener(mSaveTouchListener);

		// event to select a image
		image_chart_img.setOnTouchListener(mLoadTouchListener);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);

		// Trigger the initial hide() shortly after the activity has been
		// created, to briefly hint to the user that UI controls
		// are available.
		delayedHide(100);
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (requestCode == 1 && resultCode == RESULT_OK) {

			Uri selectedImageUri = data.getData();
			
			String path = tool.getPath(selectedImageUri);
			
			File file = new File(path);
			
			try {
				colorChart.setPictureBase64(Convertor.toBase64HtmlImageFormFile(file));
			} catch (IOException e) {
				Log.e(log, e.getMessage());
			} catch (Exception e) {
				Log.e(log, e.getMessage());
			}
			
			image_chart_img.setImageURI(selectedImageUri);

			Toast.makeText(this, "File loaded successfully.",
					Toast.LENGTH_SHORT).show();

		}
	}

	/**
	 * Touch listener to use for in-layout UI controls to delay hiding the
	 * system UI. This is to prevent the jarring behavior of controls going away
	 * while interacting with activity UI.
	 */
	View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
		@Override
		public boolean onTouch(View view, MotionEvent motionEvent) {
			if (AUTO_HIDE) {
				delayedHide(AUTO_HIDE_DELAY_MILLIS);
			}
			return false;
		}
	};

	View.OnTouchListener mSaveTouchListener = new View.OnTouchListener() {
		@Override
		public boolean onTouch(View view, MotionEvent motionEvent) {

			final TextView nameChart = (TextView) findViewById(R.id.name_chart_txt);

			final TextView descriptionChart = (TextView) findViewById(R.id.description_chart_txt);

			final ImageView imageChart = (ImageView) findViewById(R.id.image_chart_img);

			colorChart.setCharNumber(charNumber);

			colorChart.setCharName(nameChart.getText().toString());

			colorChart.setCharDescription(descriptionChart.getText().toString());

			return false;
		}
	};

	// action to execute after to touch the image
	View.OnTouchListener mLoadTouchListener = new View.OnTouchListener() {
		@Override
		public boolean onTouch(View view, MotionEvent motionEvent) {

			Intent intent = new Intent();

			intent.setType("image/*");
			
			intent.setAction(Intent.ACTION_GET_CONTENT);
//
			startActivityForResult(Intent.createChooser(intent, "Complete action using"), 1);
			
			return false;
		}
	};

	Handler mHideHandler = new Handler();
	Runnable mHideRunnable = new Runnable() {
		@Override
		public void run() {
			mSystemUiHider.hide();
		}
	};

	/**
	 * Schedules a call to hide() in [delay] milliseconds, canceling any
	 * previously scheduled calls.
	 */
	private void delayedHide(int delayMillis) {
		mHideHandler.removeCallbacks(mHideRunnable);
		mHideHandler.postDelayed(mHideRunnable, delayMillis);
	}
}
