package com.example.spellingsounds.persistence;

import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "lesson", id="id_lesson")
public class Lesson extends Model{
	
	@Column(name="lesson_number")
	private int lessonNumber;
	
	@Column(name = "lesson_name")
	protected String lessonName;
	
	@Column(name="lesson_description")
	protected String lessonDescription;
	
	@Column(name="id_level")
	protected Level level;
	
	protected List<Word> words;

	public List<Word> getWords() {
		return getMany(Word.class, "id_lesson");
	}

	public void setWords(List<Word> words) {
		this.words = words;
	}

	public int getLessonNumber() {
		return lessonNumber;
	}

	public void setLessonNumber(int lessonNumber) {
		this.lessonNumber = lessonNumber;
	}

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	public String getLessonDescription() {
		return lessonDescription;
	}

	public void setLessonDescription(String lessonDescription) {
		this.lessonDescription = lessonDescription;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((lessonDescription == null) ? 0 : lessonDescription
						.hashCode());
		result = prime * result
				+ ((lessonName == null) ? 0 : lessonName.hashCode());
		result = prime * result + lessonNumber;
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lesson other = (Lesson) obj;
		if (lessonDescription == null) {
			if (other.lessonDescription != null)
				return false;
		} else if (!lessonDescription.equals(other.lessonDescription))
			return false;
		if (lessonName == null) {
			if (other.lessonName != null)
				return false;
		} else if (!lessonName.equals(other.lessonName))
			return false;
		if (lessonNumber != other.lessonNumber)
			return false;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lesson [lessonNumber=" + lessonNumber + ", lessonName="
				+ lessonName + ", lessonDescription=" + lessonDescription
				+ ", level=" + level + "]";
	}
	
}
