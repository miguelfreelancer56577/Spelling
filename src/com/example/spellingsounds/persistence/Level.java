package com.example.spellingsounds.persistence;

import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "level", id="id_level")
public class Level extends Model {
	
	@Column(name="level_number")
	private int levelNumber;
	
	@Column(name = "level_name")
	protected String levelName;
	
	@Column(name="level_description")
	protected String levelDescription;
	
	protected List<Lesson> lessons;

	public int getLevelNumber() {
		return levelNumber;
	}

	public void setLevelNumber(int levelNumber) {
		this.levelNumber = levelNumber;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getLevelDescription() {
		return levelDescription;
	}

	public void setLevelDescription(String levelDescription) {
		this.levelDescription = levelDescription;
	}

	public List<Lesson> getLessons() {
		return getMany(Lesson.class, "id_level" );
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((lessons == null) ? 0 : lessons.hashCode());
		result = prime
				* result
				+ ((levelDescription == null) ? 0 : levelDescription.hashCode());
		result = prime * result
				+ ((levelName == null) ? 0 : levelName.hashCode());
		result = prime * result + levelNumber;
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
		Level other = (Level) obj;
		if (lessons == null) {
			if (other.lessons != null)
				return false;
		} else if (!lessons.equals(other.lessons))
			return false;
		if (levelDescription == null) {
			if (other.levelDescription != null)
				return false;
		} else if (!levelDescription.equals(other.levelDescription))
			return false;
		if (levelName == null) {
			if (other.levelName != null)
				return false;
		} else if (!levelName.equals(other.levelName))
			return false;
		if (levelNumber != other.levelNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Level [levelNumber=" + levelNumber + ", levelName=" + levelName
				+ ", levelDescription=" + levelDescription + ", lessons="
				+ lessons + "]";
	}
	
}
