package com.epam.nb.entity;

import java.util.Date;

public class PictureNote extends Note{
	
	private String picture;

	public PictureNote(String note, Date date,String picture) {
		super(note, date);
		this.picture = picture;
	}

	public PictureNote() {
		super();
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((picture == null) ? 0 : picture.hashCode());
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
		PictureNote other = (PictureNote) obj;
		if (picture == null) {
			if (other.picture != null)
				return false;
		} else if (!picture.equals(other.picture))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getClass().getName() + " "
				+ getPicture() + " " + getNote() + " "
				+ getDate();
	}
	
	
	
	

}
