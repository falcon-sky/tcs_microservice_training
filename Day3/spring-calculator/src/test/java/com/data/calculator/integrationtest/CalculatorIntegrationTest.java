package com.data.calculator.integrationtest;

import com.data.calculator.CalculatorController;
import com.data.calculator.MyOperation;
import com.data.calculator.Operation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({CalculatorController.class})
@ActiveProfiles(value = "test")
public class CalculatorIntegrationTest {
  @InjectMocks
  CalculatorController calculatorController;
  @MockBean
  MyOperation myOperation;
  @MockBean
  Operation operation;

  @Autowired
  private MockMvc mockMvc;
  @Value("${calculator.hello.url}")
  String hellourl;

  @Value("${calculator.add.url}")
  String addurl;

  @Value("${calculator.sub.url}")
  String suburl;

  @Value("${calculator.mul.url}")
  String mulurl;

  @Value("${calculator.div.url}")
  String divurl;

  @Value("${calculator.opr.url}")
  String oprurl;

  @Test
  public void testHelloGet() throws Exception {
    String expected = "hello";
    ResultActions responseEntity = mockMvc.perform(get(hellourl));
    responseEntity.andExpect(status().isOk());

    String result = responseEntity.andReturn().getResponse().getContentAsString();
    assertEquals(expected, result);
  }

  @Test
  public void testAddGet() throws Exception {
    int expected = 9;
    String num1 = "5";
    String num2 = "4";
    when(operation.add(anyInt(), anyInt())).thenReturn(expected);
    ResultActions responseEntity = mockMvc.perform(get(addurl).param("a", num1).param("b", num2));
    responseEntity.andExpect(status().isOk());
    String result = responseEntity.andReturn().getResponse().getContentAsString();
    assertEquals(String.valueOf(expected), result);
  }

}
