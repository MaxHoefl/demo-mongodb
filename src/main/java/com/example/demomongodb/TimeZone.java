package com.example.demomongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "timezones")
public class TimeZone
{
	@Id private long id;
	
	private String tz;
	
	private int offset;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTz() {
		return tz;
	}

	public void setTz(String tz) {
		this.tz = tz;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	@Override
	public String toString() {
		return "TimeZone [id=" + id + ", tz=" + tz + ", offset=" + offset + "]";
	}
}
