package no.hvl.dat110.util;

/**
 * project 3
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

	private static BigInteger hashint;

	public static BigInteger hashOf(String entity) {

		// Task: Hash a given string using MD5 and return the result as a BigInteger.

		// we use MD5 with 128 bits digest
		MessageDigest md = null;

		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// compute the hash of the input 'entity'

		byte[] digest = md.digest(entity.getBytes());

		// convert the hash into hex format

		String hexHash = toHex(digest);
		// convert the hex into BigInteger
		hashint = new BigInteger(hexHash, 16);

		// return the BigInteger
//		System.out.println(addressSize());
		return hashint;

//		Skulle ha lest koden skikkelig da en metode for dette var i klassen.....

//		StringBuffer hexString = new StringBuffer();
//		for (int i = 0; i < digest.length; i++) {
//			String hex = Integer.toHexString(0xFF & digest[i]);
//			// add a leading zero to each byte if needed
//			if (hex.length() == 1) {
//				hexString.append('0');
//			}
//			hexString.append(hex);
//		}
		// String hexHash = hexString.toString();
	}

	public static BigInteger addressSize() {

		// Task: compute the address size of MD5
		// done in the method bitSize();
		
		// get the digest length
		int lenght = bitSize();
		// compute the number of bits = digest length * 8
	
		// compute the address size = 2 ^ number of bits
		BigInteger size = new BigInteger("2");
		size = size.pow(lenght);
		// return the address size

		return size;
	}

	public static int bitSize() {
		// we use MD5 with 128 bits digest
		MessageDigest md = null;
		int digestlen = 0;

		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// find the digest length
		digestlen = md.digest().length;

		return digestlen * 8;
	}

	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for (byte b : digest) {
			strbuilder.append(String.format("%02x", b & 0xff));
		}
		return strbuilder.toString();
	}

}
