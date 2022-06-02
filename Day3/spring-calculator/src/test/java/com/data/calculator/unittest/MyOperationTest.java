package com.data.calculator.unittest;

import com.data.calculator.MyOperation;
import org.junit.Assert;
import org.junit.Test;


public class MyOperationTest {
  @Test
  public void doTheOperationSuccessTest() {
    String expectedValue = "MyOperation done";
    MyOperation myOperation = new MyOperation();
    String actualValue = myOperation.doTheOperation();
    Assert.assertNotNull(actualValue);
    Assert.assertEquals(expectedValue, actualValue);
  }

  @Test
  public void doTheOperationFailureTest() {
    String expectedValue = "MyOperation done not success";
    MyOperation myOperation = new MyOperation();
    String actualValue = myOperation.doTheOperation();
    Assert.assertNotNull(actualValue);
    Assert.assertNotEquals(expectedValue, actualValue);
  }
}
