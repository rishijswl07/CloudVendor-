package com.springbootdb.SpringbootDB.Model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CloudVendorController.class)
class CloudVendorControllerTest
{
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CloudVendorService cloudVendorService;
    CloudVendor cloudVendorone;
    CloudVendor cloudVendortwo;
    List<CloudVendor>cloudVendorslist=new ArrayList<>();

    @BeforeEach
    void setUp()
    {
        cloudVendorone=new CloudVendor("1","Amozon","USA"
                ,"9999");
        cloudVendortwo=new CloudVendor("2","AZURE","USA"
                ,"000");
        cloudVendorslist.add(cloudVendorone);
        cloudVendorslist.add(cloudVendortwo);

    }

    @AfterEach
    void tearDown()
    {

    }

    @Test
    void testgetCloudVendorDetails()throws Exception
    {
        when(cloudVendorService.getCloudVendor("1"))
                .thenReturn(cloudVendorone);
        this.mockMvc.perform((get("/CloudVendor/1")))
                .andDo(print()).andExpect(status().isOk());

    }

    @Test
    void testgetAllCloudVendorDetails() throws Exception
    {
        when(cloudVendorService.getAllCloudVendors())
                .thenReturn(cloudVendorslist);
        this.mockMvc.perform((get("/CloudVendor/1")))
                .andDo(print()).andExpect(status().isOk());

    }

    @Test
    void testcreateCloudVendorDetails()throws Exception
    {
        ObjectMapper mapper=new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE,false);
        ObjectWriter ow=mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(cloudVendorone);
        when(cloudVendorService.createCloudVendor(cloudVendorone))
                .thenReturn(cloudVendorone);
        this.mockMvc.perform((get("/CloudVendor"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());


    }

    @Test
    void updateCloudVendorDetails() throws Exception
    {
        ObjectMapper mapper=new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE,false);
        ObjectWriter ow=mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(cloudVendorone);
        when(cloudVendorService.updateCloudVendor(cloudVendorone))
                .thenReturn("cloud vendor updated  successfully");
        this.mockMvc.perform((put("/CloudVendor"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());


    }

    @Test
    void testdeleteCloudVendorDetails() throws Exception
    {
        when(cloudVendorService.deleteCloudVendor("1"))
                .thenReturn("Success");
        this.mockMvc.perform((delete("/CloudVendor/1")))
                .andDo(print()).andExpect(status().isOk());


    }
}