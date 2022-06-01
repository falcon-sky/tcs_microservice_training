package com.data.calculator.unittest;

import com.data.calculator.MyOperation;
import com.data.calculator.Operation;
import org.junit.Assert;
import org.junit.Test;

public class OperationTest {

  @Test
  public void addTest() {
    MyOperation myOperation = new MyOperation();
    Operation operation = new Operation(myOperation);
    int expectedResult = 9;
    int actualResult = operation.add(4, 5);
    Assert.assertEquals(expectedResult, actualResult);

  }

  @Test
  public void subtractionTest() {
    MyOperation myOperation = new MyOperation();
    Operation operation = new Operation(myOperation);
    int expectedResult = 2;
    int actualResult = operation.sub(6, 4);
    Assert.assertEquals(expectedResult, actualResult);
  }

  @Test
  public void multiplicationTest() {
    MyOperation myOperation = new MyOperation();
    Operation operation = new Operation(myOperation);
    int expectedResult = 20;
    int actualResult = operation.mul(4, 5);
    Assert.assertEquals(expectedResult, actualResult);
  }

  @Test
  public void divisionTest() {
    MyOperation myOperation = new MyOperation();
    Operation operation = new Operation(myOperation);
    int expectedResult = 2;
    int actualResult = operation.div(4, 2);
    Assert.assertEquals(expectedResult, actualResult);
  }

  @Test
  public void myOperationTest() {
    MyOperation myOperation = new MyOperation();
    Operation operation = new Operation(myOperation);
    String expectedResult = "MyOperation done:operation done";
    ;
    String actualResult = operation.myOperation();
    Assert.assertEquals(expectedResult, actualResult);
  }
}
