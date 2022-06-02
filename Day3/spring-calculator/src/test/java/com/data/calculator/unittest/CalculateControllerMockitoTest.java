package com.data.calculator.unittest;

import com.data.calculator.CalculatorController;
import com.data.calculator.Operation;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith({MockitoExtension.class})
public class CalculateControllerMockitoTest {

  @InjectMocks
  private CalculatorController calculatorController;

  @Mock
  private Operation operation;

  @Test
  public void additionTest() {
    int expectedSum = 9;
    when(operation.add(anyInt(), anyInt())).thenReturn(expectedSum);
    int actualSum = calculatorController.addition(4, 5);
    assertEquals(actualSum, expectedSum);
  }

  @Test
  public void substractionTest() {
    int expectedSub = 1;
    when(operation.add(anyInt(), anyInt())).thenReturn(expectedSub);
    int actualSub = calculatorController.addition(4, 5);
    assertEquals(actualSub, expectedSub);
  }

  @Test
  public void multiplicationTest() {
    int expectedMul = 20;
    when(operation.add(anyInt(), anyInt())).thenReturn(expectedMul);
    int actualMul = calculatorController.addition(4, 5);
    assertEquals(actualMul, expectedMul);
  }
}
