package com.test.newproject;

public class BillingAmount {
	float total, temp, netDiscount, totalProductPrice, totalGroceryPrice;
	int otherArraySize, groceryArraySize, discountValue;
	private float groceryItemArray[];
	private float otherItemArray[];
	
	/**
	 * calculate actual payable amount by user
	 */

	public float generateBill() {
		GetData obj = GetData.getInstance();
		discountValue = obj.getDiscountValue();
		otherArraySize = obj.getOtherItemArray().length;
		groceryArraySize = obj.getGroceryItemArray().length;

		groceryItemArray = new float[groceryArraySize];
		otherItemArray = new float[otherArraySize];

		groceryItemArray = obj.getGroceryItemArray();
		otherItemArray = obj.getOtherItemArray();
		/**
		 * Calculate net payable amount by user.
		 */
		for (int i = 0; i < otherArraySize; i++) {
			totalProductPrice = totalProductPrice + otherItemArray[i];
		}
		for (int i = 0; i < groceryArraySize; i++) {
			totalGroceryPrice = totalGroceryPrice + groceryItemArray[i];
		}
		if (discountValue != 0) {
			temp = (totalProductPrice * discountValue) / 100;
			totalProductPrice = totalProductPrice - temp;
		}
		total = totalProductPrice + totalGroceryPrice;
		System.out.println("After percentage discount: $" + total);

		/**
		 * Calculate net amount user have to pay.
		 */
		int ones, tens;
		ones = (int) (total / 10);
		tens = ones / 10;
		netDiscount = tens * 5;
		total = total - netDiscount;
		System.out.println("Net payable amount is: $" + total);
		return total;
	}

}
