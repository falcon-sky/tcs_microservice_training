package com.data.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

  private final Operation operation;

  @Autowired
  public CalculatorController(Operation operation) {
    this.operation = operation;
  }

  @GetMapping("/hello")
  public String addition() {

    return "hello";
  }

  @GetMapping("/add")
  public int addition(@RequestParam(name = "a", required = true) int a,
                      @RequestParam(name = "b", required = true) int b) {
    int add = operation.add(a, b);
    return add;
  }

  @GetMapping("/sub")
  public int subtraction(@RequestParam(name = "a", required = true) int a,
                         @RequestParam(name = "b", required = true) int b) {
    int sub = operation.sub(a, b);
    return sub;
  }

  @GetMapping("/mul")
  public int multiplication(@RequestParam(name = "a", required = true) int a,
                            @RequestParam(name = "b", required = true) int b) {
    int mul = operation.mul(a, b);
    return mul;
  }

  @GetMapping("/div")
  public double division(@RequestParam(name = "a", required = true) int a,
                         @RequestParam(name = "b", required = true) int b) {
    double div = operation.div(a, b);
    return div;
  }

  @GetMapping("/myopr")
  public String myoperation() {
    String result = operation.myOperation();
    return result;
  }

}
