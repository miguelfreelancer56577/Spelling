package com.example.spellingsounds.util;

import org.apache.commons.codec.binary.StringUtils;

import com.example.spellingsounds.R;

import android.content.Context;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.TextView;

public class FormValidator extends TextValidator{
	
	Context cxt;

	public FormValidator(Context cxt, TextView textView) {
		super(textView);
		this.cxt = cxt;
	}

	@Override
	public boolean validate(TextView textView) {
		AndroidUtils.nonEmpty(cxt,(EditText)textView, cxt.getString(R.string.required_msg));
		return false;
	}



}
