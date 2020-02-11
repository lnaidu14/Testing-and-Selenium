package com.parameters;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamTest2 {
	
	@Test
	@Parameters({"url"})
	public void test(String url) {
		System.out.println(url);
	}
	
	@Test
	@Parameters({"emailID"})
	public void test2(String emailID) {
		System.out.println(emailID);
	}

}
