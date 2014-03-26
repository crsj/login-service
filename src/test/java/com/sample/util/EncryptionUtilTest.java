package com.sample.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

public class EncryptionUtilTest extends TestCase {

	EncryptionUtil encryptionUtil = null;
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		encryptionUtil = new EncryptionUtil();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
		encryptionUtil = null;
	}

	/**
	 * Test method for 'com.sample.util.EncryptionUtil.getEncryptedPassword(String)'
	 */
	@Test
	public void testGetEncryptedPassword() {
		String password = "testPassword";
		String passwordHash = "testPasswordHash";
		Assert.assertEquals("Sucess test for encrypt util",  passwordHash, encryptionUtil.getEncryptedPassword(password));
	}

}
