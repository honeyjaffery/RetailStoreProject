package com.test.retailproject.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.test.newproject.BillingAmount;
import com.test.newproject.GetData;
import com.test.newproject.GetItemDetails;
import com.test.newproject.RetailStoreMain;

public class RetailTest {
	BillingAmount test1 = new BillingAmount();
	RetailStoreMain test2 = new RetailStoreMain();
	GetItemDetails test3 = new GetItemDetails();
	GetData test4 = new GetData();

	/**
	 * To test total item entered by user
	 */
	@Test
	public void Test1() {
		test3.itemDetails(3);
		int result = test4.getGroceryItemArray().length;
		assertEquals(3, result);
	}

	/**
	 * In case of employee user is allowed 30% of discount
	 */
	@Test
	public void Test2() {

		test2.setDiscount(1, test4, 0);
		int result = test4.getDiscountValue();
		assertEquals(30, result);
	}

	/**
	 * In case of affilated user is allowed 10% of discount
	 */
	@Test
	public void Test3() {

		test2.setDiscount(2, test4, 0);
		int result = test4.getDiscountValue();
		assertEquals(10, result);
	}

	/**
	 * In case of other user is allowed 5% of discount and he is our customer
	 * from more than 2 year
	 */
	@Test
	public void Test4() {

		test2.setDiscount(3, test4, 3);
		int result = test4.getDiscountValue();
		assertEquals(5, result);
	}

	/**
	 * To test net payable by user; if user is employee user and total item
	 * purchased by user is 3. 1. Grocery 500$ (Input should be: 1 500) 2.
	 * Grocery 1000$ (Input should be: 1 1000) 3. Other Product 150$ (Input
	 * should be:2 150) Expected output: 1525$
	 */
	@Test
	public void Test5() {
		test2.setDiscount(1, test4, 0);
		test3.itemDetails(3);
		int result = (int) test1.generateBill();
		assertEquals(1525, result);
	}

	/**
	 * To test net payable by user; if user is affilated user and total item
	 * purchased by user is 3. 1. Grocery 500$ (Input should be: 1 500) 2.
	 * Grocery 1000$ (Input should be: 1 1000) 3. Other Product 150$ (Input
	 * should be:2 150) Expected output: 1555$
	 */
	@Test
	public void Test6() {
		test2.setDiscount(2, test4, 0);
		test3.itemDetails(3);
		int result = (int) test1.generateBill();
		assertEquals(1555, result);
	}

	/**
	 * To test net payable by user; if user is other user and he is our customer
	 * from past 1 years and total item purchased by user is 3. 1. Grocery 500$
	 * (Input should be: 1 500) 2. Grocery 1000$ (Input should be: 1 1000) 3.
	 * Other Product 150$ (Input should be:2 150) Expected output: 1570$
	 */
	@Test
	public void Test7() {
		test2.setDiscount(3, test4, 1);
		test3.itemDetails(3);
		int result = (int) test1.generateBill();
		assertEquals(1570, result);
	}

	/**
	 * To test net payable by user; if user is other user and he is our customer
	 * from past 3 years and total item purchased by user is 3. 1. Grocery 500$
	 * (Input should be: 1 500) 2. Grocery 1000$ (Input should be: 1 1000) 3.
	 * Other Product 150$ (Input should be:2 200) Expected output: 1610$
	 */
	@Test
	public void Test8() {
		test2.setDiscount(3, test4, 3);
		test3.itemDetails(3);
		int result = (int) test1.generateBill();
		assertEquals(1610, result);
	}
}