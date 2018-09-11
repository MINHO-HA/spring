package com.name.git.vo;

public class SelectedVO {

	private int SEL_ID;
	private int ITEM_ID;
	private String MEM_ID;
	
	public SelectedVO() {
		
	}
	
	public SelectedVO(int sEL_ID, int iTEM_ID, String mEM_ID) {
		SEL_ID = sEL_ID;
		ITEM_ID = iTEM_ID;
		MEM_ID = mEM_ID;
	}

	public int getSEL_ID() {
		return SEL_ID;
	}

	public void setSEL_ID(int sEL_ID) {
		SEL_ID = sEL_ID;
	}

	public int getITEM_ID() {
		return ITEM_ID;
	}

	public void setITEM_ID(int iTEM_ID) {
		ITEM_ID = iTEM_ID;
	}

	public String getMEM_ID() {
		return MEM_ID;
	}

	public void setMEM_ID(String mEM_ID) {
		MEM_ID = mEM_ID;
	}
	
}
