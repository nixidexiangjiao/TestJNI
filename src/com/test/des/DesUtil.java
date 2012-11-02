package com.test.des;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.security.Key;

import javax.crypto.Cipher;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class DesUtil {

	/**
	 * @param str
	 * @param keyStr
	 * @param isEncrypt
	 *            true:加密 false:解密
	 * @return
	 * @throws Exception
	 */
	public String des(String str, String keyStr, boolean isEncrypt) throws Exception {
		String result = "";
		Key key = setPrivateKey(keyStr.getBytes());
		Cipher cipher = Cipher.getInstance("DES");
		if (isEncrypt) {
			BASE64Encoder base64en = new BASE64Encoder();
			byte[] strText = str.getBytes("UTF8");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] cipherText = cipher.doFinal(strText);
			result = base64en.encode(cipherText);
		} else {
			BASE64Decoder base64De = new BASE64Decoder();
			byte[] byteMing = null;
			byte[] byteMi = null;
			byteMi = base64De.decodeBuffer(str);
			cipher.init(Cipher.DECRYPT_MODE, key);
			byteMing = cipher.doFinal(byteMi);
			result = new String(byteMing, "UTF8");
		}
		return result;
	}

	/**
	 * @param str
	 * @param key
	 * @param isEncrypt
	 *            true:加密 false:解密
	 * @return
	 * @throws Exception
	 */
	public String des(String str, Key key, boolean isEncrypt) throws Exception {
		String result = "";
		Cipher cipher = Cipher.getInstance("DES");
		if (isEncrypt) {
			BASE64Encoder base64en = new BASE64Encoder();
			byte[] strText = str.getBytes("UTF8");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] cipherText = cipher.doFinal(strText);
			result = base64en.encode(cipherText);
		} else {
			BASE64Decoder base64De = new BASE64Decoder();
			byte[] byteMing = null;
			byte[] byteMi = null;
			byteMi = base64De.decodeBuffer(str);
			cipher.init(Cipher.DECRYPT_MODE, key);
			byteMing = cipher.doFinal(byteMi);
			result = new String(byteMing, "UTF8");
		}
		return result;
	}

	/*
	 * public String reverseDes(String str, String keyStr) throws Exception {
	 * BASE64Decoder base64De = new BASE64Decoder(); String strMing = ""; byte[]
	 * byteMing = null; byte[] byteMi = null; byteMi =
	 * base64De.decodeBuffer(str); Key key = setPrivateKey(keyStr.getBytes());
	 * Cipher cipher = Cipher.getInstance("DES");
	 * cipher.init(Cipher.DECRYPT_MODE, key); byteMing = cipher.doFinal(byteMi);
	 * strMing = new String(byteMing, "UTF8"); return strMing; }
	 * 
	 * public String reverseDes(String str, Key webkey) throws Exception {
	 * BASE64Decoder base64De = new BASE64Decoder(); String strMing = ""; byte[]
	 * byteMing = null; byte[] byteMi = null; byteMi =
	 * base64De.decodeBuffer(str); Key key = webkey; Cipher cipher =
	 * Cipher.getInstance("DES"); cipher.init(Cipher.DECRYPT_MODE, key);
	 * byteMing = cipher.doFinal(byteMi); strMing = new String(byteMing,
	 * "UTF8"); return strMing; }
	 */

	private Key setPrivateKey(byte[] keyBytes) throws Exception {
		byte[] arrA = keyBytes;
		byte[] arrB = new byte[8];
		// 将原始字节数组转换为8位
		for (int i = 0; i < arrB.length; i++) {
			if (i < arrA.length)
				arrB[i] = arrA[i];
			else
				arrB[i] = 0;
		}
		// 生成密钥
		Key key = new javax.crypto.spec.SecretKeySpec(arrB, "DES");
		return key;
	}

	// private Key getPrivateKey(byte[] keyBytes) throws Exception {
	// return setPrivateKey(keyBytes);
	// }

	/**
	 * @param keyMiStr
	 *            加密了的key字符串
	 * @return
	 * @throws Exception
	 */
	public Key getKey(String keyMiStr) throws Exception {
		Key key = null;
		ByteArrayInputStream bi = null;
		ObjectInputStream oi = null;
		BASE64Decoder base64De = new BASE64Decoder();
		try {
			bi = new ByteArrayInputStream(base64De.decodeBuffer(keyMiStr));
			oi = new ObjectInputStream(bi);
			key = (Key) oi.readObject();
		} catch (Exception e) {
			throw e;
		} finally {
			if (bi != null)
				bi.close();
			if (oi != null)
				oi.close();
		}
		return key;
	}
}
