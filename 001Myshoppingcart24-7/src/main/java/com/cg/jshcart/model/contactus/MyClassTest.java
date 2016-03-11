package com.cg.jshcart.model.contactus;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyClassTest {

	@Test
	public void testGetMessage() {
		String name="Smita";
		MyClass c1=new MyClass();
		String msg=c1.getMessage(name);
		assertEquals("HELLO Smita", msg);
	}

}
