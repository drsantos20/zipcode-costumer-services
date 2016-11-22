package com.customer.zipcodeservice;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.customer.zipcodeservice.controller.ZipCodeController;
import com.customer.zipcodeservice.model.ZipCode;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ZipCodeServiceApplication.class)
@WebAppConfiguration
@IntegrationTest({"server.port=8080"})
public class ZipCodeControllerTest  {
   private MockMvc mockMvc;
   @Mock
   private ZipCodeController zipCodeController;
   
   @Before
   public void setUp() throws Exception {
       MockitoAnnotations.initMocks(this);
       mockMvc = MockMvcBuilders.standaloneSetup(zipCodeController).dispatchOptions(true).build();
   }
   
   @Test
   public void cepNotFoundTest() throws Exception {

      ZipCode zipCodeIn = new ZipCode();
      zipCodeIn.setId("99999999");

      ZipCode zipCodeOut = new ZipCode();

      when(zipCodeController.getCep(zipCodeIn)).thenReturn(zipCodeOut);

      String body = "{ \"id\": \"99999999\" }";

      mockMvc.perform(post("/").contentType(MediaType.APPLICATION_JSON).content(body)).andDo(MockMvcResultHandlers.print())
            .andExpect(status().isOk()).andExpect(jsonPath("$.id", IsNull.nullValue()));
   }

   @Test
   public void getZipCode() throws Exception {
      
      ZipCode zipCodeOut = new ZipCode();
      zipCodeOut.setId("01202001");
      zipCodeOut.setState("SP");
      
      ZipCode zipCodeIn = new ZipCode();
      zipCodeIn.setId("01202001");
      when(zipCodeController.getCep(zipCodeIn)).thenReturn(zipCodeOut);
      String body = "{ \"id\": \"01202001\" }";
      
      mockMvc.perform(post("/").contentType(MediaType.APPLICATION_JSON).content(body)).andDo(MockMvcResultHandlers.print())
      .andExpect(status().isOk()).andExpect(jsonPath("$.id", is("01202001"))).andExpect(jsonPath("$.state", is("SP")));
   }
   
   @Test
   public void zipCodeZerosTest() throws Exception {

      ZipCode zipCodeOut = new ZipCode();
      zipCodeOut.setId("80000000");
      zipCodeOut.setState("Orlando");
      
      ZipCode zipCodeIn = new ZipCode();
      zipCodeIn.setId("80000001");
      when(zipCodeController.getCep(zipCodeIn)).thenReturn(zipCodeOut);

      String body = "{ \"id\": \"80000001\" }";

      mockMvc.perform(post("/").contentType(MediaType.APPLICATION_JSON).content(body)).andDo(MockMvcResultHandlers.print())
            .andExpect(status().isOk()).andExpect(jsonPath("$.id", is("80000000"))).andExpect(jsonPath("$.state", is("Orlando")));
   }
   
}
