package com.data.calculator.integrationtest;

import com.data.calculator.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.springframework.http.HttpMethod.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({App.class})
@ActiveProfiles(value = "test")
public class CalculatorIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
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
    public void testAddGet() throws Exception {
        String expected= "9";
        ResultActions responseEntity = processApiRequest(addurl, HttpMethod.GET, "4", "5");
        responseEntity.andExpect(status().isOk());

        String result = responseEntity.andReturn().getResponse().getContentAsString();
        assertEquals(expected, result);
    }

    private ResultActions processApiRequest(String api, HttpMethod methodType, String num1,String num2) {
        ResultActions response = null;
        try {
            switch (methodType) {
                case GET:
                    response = mockMvc.perform(get(api).param("a",num1).param("b",num2));
                    break;

                case DELETE:
                    response = mockMvc.perform(delete(api, null));
                    break;
                default:
                    fail("Method Not supported");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
        return response;
    }



}
