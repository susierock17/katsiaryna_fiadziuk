package com.epam.nb.entity;

import java.util.Date;

public class ImportantNote extends Note {
	
	private String sign;
	
	public ImportantNote() {
		super();
	}

	public ImportantNote(String note, Date date,String sign) {
		super(note, date);
		this.sign = sign;
	}

	
	
	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((sign == null) ? 0 : sign.hashCode());
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
		ImportantNote other = (ImportantNote) obj;
		if (sign == null) {
			if (other.sign != null)
				return false;
		} else if (!sign.equals(other.sign))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getClass().getName()+ " " + getSign() + " " + getNote()
				+ " " + getDate();
	}
	
	
	

}
