package blog.util;

import org.junit.Test;

import com.github.wheatphp.blog.util.Platforms;

public class PlatFormsTest {
	private Platforms platforms = new Platforms();
	
	@Test
	public void testIsLinux() {
		System.out.println("isLinux:"+platforms.isLinux());
	}
	
	@Test
	public void testIsWindows() {
		System.out.println("isWindows:"+platforms.isWindows());
	}
}
