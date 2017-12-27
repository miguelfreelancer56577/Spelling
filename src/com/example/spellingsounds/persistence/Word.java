package com.example.spellingsounds.persistence;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name="word", id="id_word")
public class Word extends Model {

	@Column(name="word_name")
	String wordName;
	
	@Column(name="wordDescription")
	String wordDescription;
	
	@Column(name="picture_base64")
	protected String pictureBase64;
	
	@Column(name="id_lesson")
	protected Lesson lesson;

	public String getWordName() {
		return wordName;
	}

	public String getPictureBase64() {
		return pictureBase64;
	}

	public void setPictureBase64(String pictureBase64) {
		this.pictureBase64 = pictureBase64;
	}

	public void setWordName(String wordName) {
		this.wordName = wordName;
	}

	public String getWordDescription() {
		return wordDescription;
	}

	public void setWordDescription(String wordDescription) {
		this.wordDescription = wordDescription;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((lesson == null) ? 0 : lesson.hashCode());
		result = prime * result
				+ ((pictureBase64 == null) ? 0 : pictureBase64.hashCode());
		result = prime * result
				+ ((wordDescription == null) ? 0 : wordDescription.hashCode());
		result = prime * result
				+ ((wordName == null) ? 0 : wordName.hashCode());
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
		Word other = (Word) obj;
		if (lesson == null) {
			if (other.lesson != null)
				return false;
		} else if (!lesson.equals(other.lesson))
			return false;
		if (pictureBase64 == null) {
			if (other.pictureBase64 != null)
				return false;
		} else if (!pictureBase64.equals(other.pictureBase64))
			return false;
		if (wordDescription == null) {
			if (other.wordDescription != null)
				return false;
		} else if (!wordDescription.equals(other.wordDescription))
			return false;
		if (wordName == null) {
			if (other.wordName != null)
				return false;
		} else if (!wordName.equals(other.wordName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Word [wordName=" + wordName + ", wordDescription="
				+ wordDescription + ", pictureBase64=" + pictureBase64
				+ ", lesson=" + lesson + "]";
	}
	
}
