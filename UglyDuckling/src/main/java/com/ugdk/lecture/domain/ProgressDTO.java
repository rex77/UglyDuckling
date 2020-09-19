package com.ugdk.lecture.domain;

import java.sql.Timestamp;

public class ProgressDTO {
	@Override
	public String toString() {
		return "ProgressDTO [idx=" + idx + ", unitId=" + unitId + ", contentId=" + contentId + ", memberId=" + memberId
				+ ", score=" + score + ", date=" + date + "]";
	}
	int idx;
	int unitId;
	int contentId;
	String memberId;
	int score;
	Timestamp date;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getUnitId() {
		return unitId;
	}
	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
}
