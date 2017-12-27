package com.example.spellingsounds.persistence;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name="color_chart", id="id_color_chart")
public class ColorChart extends Model {
	
	@Column(name="char_number")
	protected int charNumber;
	
	@Column(name="char_name")
	protected String charName;
	
	@Column(name="char_description")
	protected String charDescription;
	
	@Column(name="picture_base64")
	protected String pictureBase64;

	public int getCharNumber() {
		return charNumber;
	}

	public String getPictureBase64() {
		return pictureBase64;
	}

	public void setPictureBase64(String pictureBase64) {
		this.pictureBase64 = pictureBase64;
	}

	public void setCharNumber(int charNumber) {
		this.charNumber = charNumber;
	}

	public String getCharName() {
		return charName;
	}

	public void setCharName(String charName) {
		this.charName = charName;
	}

	public String getCharDescription() {
		return charDescription;
	}

	public void setCharDescription(String charDescription) {
		this.charDescription = charDescription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((charDescription == null) ? 0 : charDescription.hashCode());
		result = prime * result
				+ ((charName == null) ? 0 : charName.hashCode());
		result = prime * result + charNumber;
		result = prime * result
				+ ((pictureBase64 == null) ? 0 : pictureBase64.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ColorChart other = (ColorChart) obj;
		if (charDescription == null) {
			if (other.charDescription != null)
				return false;
		} else if (!charDescription.equals(other.charDescription))
			return false;
		if (charName == null) {
			if (other.charName != null)
				return false;
		} else if (!charName.equals(other.charName))
			return false;
		if (charNumber != other.charNumber)
			return false;
		if (pictureBase64 == null) {
			if (other.pictureBase64 != null)
				return false;
		} else if (!pictureBase64.equals(other.pictureBase64))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ColorChart [charNumber=" + charNumber + ", charName="
				+ charName + ", charDescription=" + charDescription
				+ ", pictureBase64=" + pictureBase64 + "]";
	}
	
}
