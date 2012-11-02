package com.test.jni;
class HelloWorld 
{
    public native void displayHelloWorld();
    static {
        System.loadLibrary("Share-C");
    }
    
    public static void main(String[] args) {
        new HelloWorld().displayHelloWorld();
    }
}
