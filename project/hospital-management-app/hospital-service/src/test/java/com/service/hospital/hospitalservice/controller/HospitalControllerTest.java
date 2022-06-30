package com.service.hospital.hospitalservice.controller;

import com.service.hospital.hospitalservice.producer.ArtemisProducer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({HospitalController.class})
public class HospitalControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    HospitalController hospitalController;

    @MockBean
    ArtemisProducer producer;

    @Test
    public void produceTestSuccess() throws Exception {
        String expectedResponse="message sent:Hello from controller";
        doNothing().when(producer).send(anyString());
        ResultActions response =mockMvc.perform(get("/send").param("msg","Hello from controller"));
        response.andExpect(status().isOk());
        String actualResult = response.andReturn().getResponse().getContentAsString();
        assertEquals(expectedResponse, actualResult);
    }

}
