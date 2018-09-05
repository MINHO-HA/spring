package com.name.git.vo;

public class MemberVO {

	private String MEM_ID;
	private String MEM_PW;
	private String MEM_NAME;
	private int MEM_AGE;
	private String MEM_EMAIL;
	private String GENDER_ID;
	private String SKINTYPE_ID;
	private String MEM_STATE;
	
	public MemberVO(){
		
	}

	public MemberVO(String mEM_ID, String mEM_PW, String mEM_NAME, int mEM_AGE, String mEM_EMAIL, String gENDER_ID,
			String sKINTYPE_ID, String mEM_STATE) {
		MEM_ID = mEM_ID;
		MEM_PW = mEM_PW;
		MEM_NAME = mEM_NAME;
		MEM_AGE = mEM_AGE;
		MEM_EMAIL = mEM_EMAIL;
		GENDER_ID = gENDER_ID;
		SKINTYPE_ID = sKINTYPE_ID;
		MEM_STATE = mEM_STATE;
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

	public String getMEM_EMAIL() {
		return MEM_EMAIL;
	}

	public void setMEM_EMAIL(String mEM_EMAIL) {
		MEM_EMAIL = mEM_EMAIL;
	}

	public String getGENDER_ID() {
		return GENDER_ID;
	}

	public void setGENDER_ID(String gENDER_ID) {
		GENDER_ID = gENDER_ID;
	}

	public String getSKINTYPE_ID() {
		return SKINTYPE_ID;
	}

	public void setSKINTYPE_ID(String sKINTYPE_ID) {
		SKINTYPE_ID = sKINTYPE_ID;
	}

	public String getMEM_STATE() {
		return MEM_STATE;
	}

	public void setMEM_STATE(String mEM_STATE) {
		MEM_STATE = mEM_STATE;
	}
	
}
