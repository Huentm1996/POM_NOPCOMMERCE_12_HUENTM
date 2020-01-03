package com.nopcommerce.java;

public class Java_05_System {
	public static void main(String[] args) {
		String rootFolder = System.getProperty("user.dir");
		String osName = System.getProperty("os.name");
		String osArchitecture = System.getProperty("os.arch");
		String osVersion = System.getProperty("os.version");
		System.out.println("OS name = " + osName);
		System.out.println("OS arc = " + osArchitecture);
		System.out.println("OS ver = " + osVersion);
	}

}
