package com.test.newproject;

public class GetData {

	static int discountValue;

	static float groceryItemArray[];
	static float otherItemArray[];

	private static GetData myObj;

	public GetData() {

	}
	public static GetData getInstance() {
		if (myObj == null) {
			myObj = new GetData();
		}
		return myObj;
	}

	public int getDiscountValue() {
		return discountValue;
	}

	public void setDiscountValue(int disValue) {
		discountValue = disValue;
	}

	public float[] getGroceryItemArray() {
		return groceryItemArray;
	}

	public void setGroceryItemArray(float[] grocryItemArray2) {
		groceryItemArray = grocryItemArray2;
	}

	public float[] getOtherItemArray() {
		return otherItemArray;
	}

	public void setOtherItemArray(float[] othrItemArray) {
		otherItemArray = othrItemArray;
	}


}
