package com.test.newproject;

import java.util.Scanner;

public class GetItemDetails {
	private float groceryItemArray[];
	private float otherItemArray[];

	public void itemDetails(int totalitem) {
		int itemType, j = 0, k = 0;
		float price;
		GetData obj = GetData.getInstance();
		Scanner sc = new Scanner(System.in);
		groceryItemArray = new float[totalitem];
		otherItemArray = new float[totalitem];
		System.out
				.println("Enter the item type and its price.\n Type 1 for grocery item and\n 2 for other items.\n For Example: 1 500 \n Its means item is grocery and its price is 500$");
		for (int i = 1; i <= totalitem; i++) {
			System.out.println("Enter item type and its price");
			itemType = sc.nextInt();
			price = sc.nextFloat();

			if (itemType == 1) {
				groceryItemArray[j] = price;
				j++;
			} else if (itemType == 2) {
				otherItemArray[k] = price;
				k++;
			} else {
				System.out.println("Invalid item type. Please enter again");
				i = i - 1;
			}

		}
		obj.setOtherItemArray(otherItemArray);
		obj.setGroceryItemArray(groceryItemArray);
	}

}
