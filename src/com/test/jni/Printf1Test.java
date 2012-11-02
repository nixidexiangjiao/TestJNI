package com.test.jni;

public class Printf1Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Printf1 printf1 = new Printf1();
		int count = printf1.print(10, 4, 3.14);
		count += printf1.print(10, 4, count);
		System.out.println();
		for (int i = 0; i < count; i++) {
			System.out.println("-");
		}
		System.out.println();
	}

}
