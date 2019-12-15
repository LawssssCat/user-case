package cn.edut.util.a;

import org.junit.Test;

/**
 * 测试resource的包路径
 */
public class Test_a {
	@Test
	public void test01() {
		String path = this.getClass().getResource("/a/a.properties").getPath();
		System.out.println(path);
	}
}	
