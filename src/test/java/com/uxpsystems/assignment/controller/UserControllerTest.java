package com.uxpsystems.assignment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uxpsystems.assignment.entity.Response;
import com.uxpsystems.assignment.entity.Users;
import com.uxpsystems.assignment.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class UserControllerTest {

    @MockBean
    private UserServiceImpl service;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void addUserTest() throws Exception {
        Users user = new Users("Kislaya","12345", Users.Status.Activated);
        String json = mapper.writeValueAsString(user);
        MvcResult result = mockMvc.perform(post("/users/save").content(json)
        .contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
        String res =  result.getResponse().getContentAsString();
        Response response = mapper.readValue(res, Response.class);
        Assert.assertTrue(response.isStatus() == Boolean.TRUE);
    }

}
