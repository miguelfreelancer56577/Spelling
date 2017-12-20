package com.example.spellingsounds.persistence;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name="color_chart_sound", id="id_color_chart_sound")
public class ColorChartSounds extends Model {
	
	@Column(name="id_color_chart")
	protected ColorChart colorchart;
	
	@Column(name="id_picture")
	protected Picture picture;
	
}
