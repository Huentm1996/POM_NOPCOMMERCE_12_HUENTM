package com.nopcommerce.java;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import org.testng.annotations.AfterClass;

public class Java_03_Assert {
  @BeforeClass
  public void beforeClass() {
  }
  @Test
  public void TC_01() {
	  System.out.println("Step 01 - Open X Page");
	  System.out.println("Step 02 - Verify X Page Display");
	  Assert.assertTrue(false);
	  
	  System.out.println("Step 03 - Verify y field displayed");
	  assertTrue(true);

  }
  @Test
  public void TC_02() {
  }
  @Test
  public void TC_03() {
  }
  @Test
  public void TC_04() {
  }

  @AfterClass
  public void afterClass() {
  }

}
