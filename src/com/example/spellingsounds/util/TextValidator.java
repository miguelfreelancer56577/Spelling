package com.example.spellingsounds.util;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.TextView;

abstract class TextValidator implements TextWatcher, OnFocusChangeListener  {
	
    private final TextView textView;

	 public TextValidator(TextView textView) {
	        this.textView = textView;
	    }

	    public abstract boolean validate(TextView textView);

	    @Override
	    final public void afterTextChanged(Editable s) {
	    	validate(textView);
	    }

	    @Override
	    final public void beforeTextChanged(CharSequence s, int start, int count, int after) { /* Don't care */ }

	    @Override
	    final public void onTextChanged(CharSequence s, int start, int before, int count) { /* Don't care */ }
	    
	    @Override
		public void onFocusChange(View textView, boolean hasFocus) {

			if(!hasFocus)
				validate((TextView) textView);
			
		}
	
}
