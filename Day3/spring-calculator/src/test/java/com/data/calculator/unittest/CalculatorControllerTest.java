package com.data.calculator.unittest;

import com.data.calculator.CalculatorController;
import com.data.calculator.Operation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Matchers.anyInt;

@RunWith(SpringJUnit4ClassRunner.class)
public class CalculatorControllerTest {

    @InjectMocks
    CalculatorController calculatorController;

    @Mock
    Operation operation;

    @Test
    public void additionTest(){
        int expectedResult=9;
        Mockito.when(operation.add(anyInt(),anyInt())).thenReturn(expectedResult);
        int actualResult=calculatorController.addition(4,5);
        Assert.assertEquals(expectedResult,actualResult);

    }

    @Test
    public void subtractionTest(){

    }

    @Test
    public void multiplicationTest(){}

    @Test
    public void divisionTest(){}

    @Test
    public void myOperationTest(){}

}
