package com.rama.app;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rama.app.controller.AppController;
import com.rama.app.data.Employee;
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
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({AppController.class})
@ActiveProfiles(value = "test")
public class AppControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @Value("${employee.get.url}")
  String geturl;

  @Value("${employee.post.url}")
  String posturl;

  @Value("${employee.put.url}")
  String puturl;

  @Value("${employee.delete.url}")
  String deleteurl;


  @Test
  public void testEmployeeGet() throws Exception {
    ResultActions responseEntity = processApiRequest(geturl, HttpMethod.GET, null,
      null);
    responseEntity.andExpect(status().isOk());
    ObjectMapper mapper = new ObjectMapper();
    String result = responseEntity.andReturn().getResponse().getContentAsString();
    assertEquals("get employee ", result);
  }

  @Test
  public void testEmployeePost() throws Exception {
    Employee employee = createEmployee("test", "dev");
    ResultActions responseEntity = processApiRequest(posturl, HttpMethod.POST, null, employee);
    responseEntity.andExpect(status().isOk());
    ObjectMapper mapper = new ObjectMapper();
    Employee result = mapper.readValue(responseEntity.andReturn().getResponse().getContentAsString(),
      new TypeReference<Employee>() {
      });

    assertEquals("test", result.getName());
    assertEquals("dev", result.getRole());

  }


  private ResultActions processApiRequest(String api, HttpMethod methodType, String name, Employee employee) {
    ResultActions response = null;
    try {
      switch (methodType) {
        case GET:
          response = mockMvc.perform(get(api));
          break;
        case POST:
          response = mockMvc.perform(post(api).contentType(MediaType.APPLICATION_JSON)
            .content(asJsonString(employee)).accept(MediaType.APPLICATION_JSON));
          break;
        case PUT:
          response = mockMvc.perform(put(api, name).contentType(MediaType.APPLICATION_JSON)
            .content(asJsonString(employee)).accept(MediaType.APPLICATION_JSON));
          break;
        case DELETE:
          response = mockMvc.perform(delete(api, name));
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

  private String asJsonString(final Object obj) {
    try {
      final ObjectMapper mapper = new ObjectMapper();
      final String jsonContent = mapper.writeValueAsString(obj);
      return jsonContent;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private static Employee createEmployee(String name, String role) {
    Employee empEmployee = new Employee(name, role);
    return empEmployee;
  }
}
