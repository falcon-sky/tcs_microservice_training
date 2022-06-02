package com.data.calculator;

import org.springframework.stereotype.Component;

@Component
public class Operation {
  private final MyOperation myOperation;

  public Operation(MyOperation myOperation) {
    this.myOperation = myOperation;
  }

  public int add(int num1, int num2) {
    int sum = num1 + num2;
    return sum;
  }

  public int sub(int num1, int num2) {
    int sub = num1 - num2;
    return sub;
  }

  public int mul(int num1, int num2) {
    int mul = num1 * num2;
    return mul;
  }

  public int div(int num1, int num2) {
    int mul = num1 / num2;
    return mul;
  }

  public String myOperation() {
    String data = myOperation.doTheOperation();
    return data + ":" + "operation done";
  }
}
