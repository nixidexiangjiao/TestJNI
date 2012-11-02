package com.test.des;

import java.lang.reflect.Method;
import java.security.Key;

public class DesTest {

	static {
		System.loadLibrary("TmsCheckLimited");
	}

	public static native String DevOrResStr(DesUtil util, String methodname,
			String mingStr, String keyStr, boolean isEncrypt);

	public static native String DevOrResStr(DesUtil util, String methodname,
			String mingStr, Key key, boolean isEncrypt);

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println(System.getProperty("java.library.path"));
		
		DesUtil desUtil = new DesUtil();
		String desMethodName = getMethodsName(desUtil.getClass(), new Class[] {
				String.class, String.class, boolean.class });
//		String keyMiStr = "rO0ABXNyAB9qYXZheC5jcnlwdG8uc3BlYy5TZWNyZXRLZXlTcGVjW0cLZuIwYU0CAAJMAAlhbGdv\ncml0aG10ABJMamF2YS9sYW5nL1N0cmluZztbAANrZXl0AAJbQnhwdAADREVTdXIAAltCrPMX+AYI\nVOACAAB4cAAAAAgwMXlrOTY5NA==";
//		Key key = desUtil.getKey(keyMiStr);
		String key = "yksetms9";
		String miStr = DevOrResStr(desUtil, desMethodName, "testtest", key, true);
		System.out.println(miStr);

		String mingStr = DevOrResStr(desUtil, desMethodName, miStr, key, false);
		System.out.println(mingStr);
	}

	public static String getMethodsName(Class cl, Class[] parameterTypes) {
		String result = "";
		Method[] methods = cl.getDeclaredMethods();// 返回一个包含方法对象的数组
		for (Method m : methods)// 循环该类的每个方法
		{
			Class retType = m.getReturnType();// 该方法的返回类型，
			String name = m.getName();// 获得方法名

			Class[] paramTypes = m.getParameterTypes();// 获得一个方法参数数组（getparameterTypes用于返回一个描述参数类型的Class对象数组）

			if (parameterTypes.length == paramTypes.length) {
				boolean isFind = true;
				for (int j = 0; j < paramTypes.length; j++) {
					if (paramTypes[j] != parameterTypes[j]) {
						isFind = false;
						break;
					}
				}
				if (isFind) {
					result = name;
					break;
				}
			}
		}
		return result;
	}
}
