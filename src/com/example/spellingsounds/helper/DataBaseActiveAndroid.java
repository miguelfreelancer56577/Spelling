/*
 * 
 * Source library: https://github.com/pardom/ActiveAndroid/wiki/Getting-started
 * 
 */

package com.example.spellingsounds.helper;

import com.activeandroid.ActiveAndroid;
import android.content.Context;
import android.util.Log;

public class DataBaseActiveAndroid {
	
	private final String log = DataBaseActiveAndroid.class.getSimpleName();
	
	 public DataBaseActiveAndroid(Context cxt){
		 Log.i(log, "initializing data base");
		 ActiveAndroid.initialize(cxt);
		 Log.i(log, "data base initialized");
	 }
	 
}
