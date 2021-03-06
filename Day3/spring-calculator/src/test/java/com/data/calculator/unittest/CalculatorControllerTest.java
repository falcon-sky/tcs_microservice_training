package com.data.calculator.unittest;

import com.data.calculator.CalculatorController;
import com.data.calculator.MyOperation;
import com.data.calculator.Operation;
import org.junit.Assert;
import org.junit.Test;


public class CalculatorControllerTest {
  MyOperation myOperation = new MyOperation();
  Operation operation = new Operation(myOperation);
  CalculatorController calculatorController = new CalculatorController(operation);

  @Test
  public void additionSuccessTest() {
    int a = 5;
    int b = 6;
    int expectedValue = 11;
    int actualValue = calculatorController.addition(a, b);
    Assert.assertEquals(expectedValue, actualValue);
  }

  @Test
  public void additionFailureTest() {
    int a = 5;
    int b = 6;
    int expectedValue = 12;
    int actualValue = calculatorController.addition(a, b);
    Assert.assertNotEquals(expectedValue, actualValue);
  }

  @Test
  public void subtractionTest() {

  }

  @Test
  public void multiplicationTest() {
  }

  @Test
  public void divisionTest() {
  }

  @Test
  public void myOperationTest() {
  }

}
