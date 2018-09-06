package com.name.git.vo;

public class ItemVO {

	private int ITEM_ID;
	private String ITEM_NAME;
	private String ITEM_BRAND;
	private String ITEM_CATEGORY;
	
	public ItemVO(){
		
	}
	
	public ItemVO(int iTEM_ID, String iTEM_NAME, String iTEM_BRAND, String iTEM_CATEGORY) {
		ITEM_ID = iTEM_ID;
		ITEM_NAME = iTEM_NAME;
		ITEM_BRAND = iTEM_BRAND;
		ITEM_CATEGORY = iTEM_CATEGORY;
	}
	
	public int getITEM_ID() {
		return ITEM_ID;
	}
	public void setITEM_ID(int iTEM_ID) {
		ITEM_ID = iTEM_ID;
	}
	public String getITEM_NAME() {
		return ITEM_NAME;
	}
	public void setITEM_NAME(String iTEM_NAME) {
		ITEM_NAME = iTEM_NAME;
	}
	public String getITEM_BRAND() {
		return ITEM_BRAND;
	}
	public void setITEM_BRAND(String iTEM_BRAND) {
		ITEM_BRAND = iTEM_BRAND;
	}
	public String getITEM_CATEGORY() {
		return ITEM_CATEGORY;
	}
	public void setITEM_CATEGORY(String iTEM_CATEGORY) {
		ITEM_CATEGORY = iTEM_CATEGORY;
	}
	
	
}
