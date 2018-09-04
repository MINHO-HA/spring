package com.name.git.vo;

public class MemberVO {

	private String MEM_ID;
	private String MEM_PW;
	private String MEM_NAME;
	private int MEM_AGE ;
	private String MEM_GENDER;
	private String MEM_SKINTYPE;
	
	public MemberVO(){
		
	}
	
	public MemberVO(String mEM_ID, String mEM_PW, String mEM_NAME, int mEM_AGE, String mEM_GENDER,
			String mEM_SKINTYPE) {
		MEM_ID = mEM_ID;
		MEM_PW = mEM_PW;
		MEM_NAME = mEM_NAME;
		MEM_AGE = mEM_AGE;
		MEM_GENDER = mEM_GENDER;
		MEM_SKINTYPE = mEM_SKINTYPE;
	}
	public String getMEM_ID() {
		return MEM_ID;
	}
	public void setMEM_ID(String mEM_ID) {
		MEM_ID = mEM_ID;
	}
	public String getMEM_PW() {
		return MEM_PW;
	}
	public void setMEM_PW(String mEM_PW) {
		MEM_PW = mEM_PW;
	}
	public String getMEM_NAME() {
		return MEM_NAME;
	}
	public void setMEM_NAME(String mEM_NAME) {
		MEM_NAME = mEM_NAME;
	}
	public int getMEM_AGE() {
		return MEM_AGE;
	}
	public void setMEM_AGE(int mEM_AGE) {
		MEM_AGE = mEM_AGE;
	}
	public String getMEM_GENDER() {
		return MEM_GENDER;
	}
	public void setMEM_GENDER(String mEM_GENDER) {
		MEM_GENDER = mEM_GENDER;
	}
	public String getMEM_SKINTYPE() {
		return MEM_SKINTYPE;
	}
	public void setMEM_SKINTYPE(String mEM_SKINTYPE) {
		MEM_SKINTYPE = mEM_SKINTYPE;
	}
	
	
	
}
