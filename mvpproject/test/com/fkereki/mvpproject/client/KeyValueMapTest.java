package com.fkereki.mvpproject.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KeyValueMapTest {

  @Before
  public void setUp()
      throws Exception {
  }

  @After
  public void tearDown()
      throws Exception {
  }

  @Test
  public void testKeyValueMap() {
    final KeyValueMap kvm0 = new KeyValueMap("");
    assertTrue(kvm0.isEmpty());
  }

  @Test
  public void testKeyValueMapNoParameters() {
    final KeyValueMap kvm = new KeyValueMap();
    assertTrue(kvm.isEmpty());
  }

  @Test
  public void testKeyValueMapNoValues() {
    final KeyValueMap kvm = new KeyValueMap("curly&larry&moe&stooges=3");
    assertEquals(4, kvm.size());

    assertTrue(kvm.containsKey("curly"));
    assertTrue(kvm.containsKey("larry"));
    assertTrue(kvm.containsKey("moe"));
    assertTrue(kvm.containsKey("larry"));

    assertEquals("", kvm.get("curly"));
    assertEquals("", kvm.get("larry"));
    assertEquals("", kvm.get("moe"));
    assertEquals("3", kvm.get("stooges"));
  }

  @Test
  public void testKeyValueMapString() {
    final KeyValueMap kvm1 = new KeyValueMap("lincoln=1865");
    assertEquals(1, kvm1.size());

    final KeyValueMap kvm2 = new KeyValueMap("lincoln=1865&darwin=1882");
    assertEquals(2, kvm2.size());
    assertTrue(kvm2.containsKey("lincoln"));
    assertTrue(kvm2.containsKey("darwin"));
    assertEquals("1865", kvm2.get("lincoln"));
    assertEquals("1882", kvm2.get("darwin"));
  }

  @Test
  public void testToString() {
    final KeyValueMap kvm0 = new KeyValueMap("");
    assertEquals("", kvm0.toString());

    final KeyValueMap kvm1 = new KeyValueMap("lincoln=1865");
    assertEquals("lincoln=1865", kvm1.toString());

    final KeyValueMap kvm2 = new KeyValueMap(
        "lincoln=1865&darwin=1882&einstein=1955");
    final String kvmst2 = kvm2.toString();
    assertTrue(kvmst2.contains("lincoln=1865"));
    assertTrue(kvmst2.contains("darwin=1882"));
    assertTrue(kvmst2.contains("einstein=1955"));
    assertTrue(kvmst2.contains("\n"));
  }
}
