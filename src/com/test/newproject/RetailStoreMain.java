package com.test.newproject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RetailStoreMain {
	private static boolean isUserInvalid = false;

	public static void main(String args[]) {
		int usr, item;
		float custYear=0;
		RetailStoreMain objMain;
		GetData obj = new GetData();
		try {
			objMain = new RetailStoreMain();
			System.out
					.println("Enter the type of User.\n Press 1 for Employee.\n Press 2 for Affilated user.\n Press 3 for Other user");
			Scanner sc = new Scanner(System.in);
			usr = sc.nextInt();
			if (usr == 3) {
				System.out
						.println("Enter the number of years since user is our customer. ");
				custYear = sc.nextFloat();
			}
			objMain.setDiscount(usr, obj,custYear);
			
			if (!isUserInvalid) {
				
				System.out
						.println("Enter the total number of items user purchased ");
				item = sc.nextInt();
				if (item > 0) {
					GetItemDetails objItem = new GetItemDetails();
					objItem.itemDetails(item);
					BillingAmount obj1 = new BillingAmount();
					obj1.generateBill();
				} else
					System.out
							.println("Total number of items should be greater than 0.");

			} else {
				System.out.println("Invalid user type");
			}

		} catch (InputMismatchException e) {
			System.out.println("Please enter integer number!!");
		}

	}

	public void setDiscount(int usrType,GetData obj, float year) {
		switch (usrType) {
		case 1:
			obj.setDiscountValue(30);
			break;
		case 2:
			obj.setDiscountValue(10);
			break;
		case 3:
			if (year >= 2)
				obj.setDiscountValue(5);
			else
				obj.setDiscountValue(0);

			break;
		default:
			System.out.println("Invalid user");
			isUserInvalid = true;
			break;
		}
	}

}
