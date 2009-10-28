package com.fkereki.mvptest.client;

import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KeyValueMapTest {

	@Before
	public void setUp() throws Exception {
	}


	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testKeyValueMap() {
		KeyValueMap kvm0 = new KeyValueMap("");
		assertTrue(kvm0.isEmpty());
	}


	@Test
	public void testKeyValueMapString() {
		KeyValueMap kvm1 = new KeyValueMap("pepe=123456");
		assertEquals(1, kvm1.size());

		KeyValueMap kvm2 = new KeyValueMap("pepe=123&juan=456");
		assertEquals(2, kvm2.size());
		assertTrue(kvm2.containsKey("pepe"));
		assertTrue(kvm2.containsKey("juan"));
		assertEquals("123", kvm2.get("pepe"));
		assertEquals("456", kvm2.get("juan"));
	}


	@Test
	public void testToString() {
		KeyValueMap kvm0 = new KeyValueMap("");
		assertEquals("", kvm0.toString());

		KeyValueMap kvm1 = new KeyValueMap("pepe=123456");
		assertEquals("pepe=123456", kvm1.toString());

		KeyValueMap kvm2 = new KeyValueMap(
		    "pepe=123&juan=456&luis=7890");
		String kvmst2 = kvm2.toString();
		assertTrue(kvmst2.contains("pepe=123"));
		assertTrue(kvmst2.contains("juan=456"));
		assertTrue(kvmst2.contains("luis=7890"));
		assertTrue(kvmst2.contains("\n"));
	}


	@Test
	public void testWithEasyMock() {
		KeyValueMap kvmMock = createMock(KeyValueMap.class);
		kvmMock.initializeWithString("pepe=123");
		replay(kvmMock);
		kvmMock.initializeWithString("pepe=123");
		verify(kvmMock);
	}
}
