package com.example.spellingsounds.persistence;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name="picture", id="id_picture")
public class Picture extends Model {

	@Column(name="picture_name")
	protected String pictureName;
	
	@Column(name="picture_descripcion")
	protected String pictureDescription;
	
	@Column(name="picture_base64")
	protected String pictureBase64;

	public String getPictureName() {
		return pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	public String getPictureDescription() {
		return pictureDescription;
	}

	public void setPictureDescription(String pictureDescription) {
		this.pictureDescription = pictureDescription;
	}

	public String getPictureBase64() {
		return pictureBase64;
	}

	public void setPictureBase64(String pictureBase64) {
		this.pictureBase64 = pictureBase64;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((pictureBase64 == null) ? 0 : pictureBase64.hashCode());
		result = prime
				* result
				+ ((pictureDescription == null) ? 0 : pictureDescription
						.hashCode());
		result = prime * result
				+ ((pictureName == null) ? 0 : pictureName.hashCode());
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
		Picture other = (Picture) obj;
		if (pictureBase64 == null) {
			if (other.pictureBase64 != null)
				return false;
		} else if (!pictureBase64.equals(other.pictureBase64))
			return false;
		if (pictureDescription == null) {
			if (other.pictureDescription != null)
				return false;
		} else if (!pictureDescription.equals(other.pictureDescription))
			return false;
		if (pictureName == null) {
			if (other.pictureName != null)
				return false;
		} else if (!pictureName.equals(other.pictureName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Picture [pictureName=" + pictureName + ", pictureDescription="
				+ pictureDescription + ", pictureBase64=" + pictureBase64 + "]";
	}
	
}
