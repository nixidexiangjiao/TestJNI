package com.test.jni;

public class Printf1 {
	public native int print(int width, int precision, double x);
	static {
        System.loadLibrary("ShareC++");
    }
}
