package com.github.wheatphp.blog.util;

public class Platforms {
	public static boolean isLinux() {
		String os = System.getProperty("os.name").toLowerCase();
		return os.indexOf("linux") >= 0;
	}
	
	public static boolean isWindows() {
		String os = System.getProperty("os.name").toLowerCase();
		return os.indexOf("windows") >= 0;
	}
	
}
