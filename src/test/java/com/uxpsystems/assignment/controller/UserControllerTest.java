package com.uxpsystems.assignment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uxpsystems.assignment.entity.Response;
import com.uxpsystems.assignment.entity.Users;
import com.uxpsystems.assignment.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class UserControllerTest {

    @InjectMocks
    private UserController controller;

    @MockBean
    private UserServiceImpl userService;

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

    @Test
    public void updateUserTest() throws Exception {
        List<Users> user = new ArrayList<>();
        Users users = new Users("Kislaya", "12345", Users.Status.Activated);
        user.add(users);
        users.setUsername("Kishu");
        String json = mapper.writeValueAsString(users);
        MvcResult result = mockMvc.perform(put("/users/update/1").content(json)
        .contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
        String res =  result.getResponse().getContentAsString();
        Response response = mapper.readValue(res, Response.class);
        Assert.assertTrue(response.isStatus()==Boolean.TRUE);
    }

    @Test
    public void deleteUserTest() throws Exception{
        Users user = new Users();
        user.setUserId(1);
        user.setUsername("Kislaya");
        user.setPassword("12345");
        user.setStatus(Users.Status.Activated);
        String json = mapper.writeValueAsString(user);
        userService.deleteUser(1);
        verify(userService, Mockito.times(1)).deleteUser(user.getUserId());
        MvcResult result = mockMvc.perform(delete("/users/delete/1").content(json)
                .contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
}

    @Test
    public void getUserTest() throws Exception{
        Users user = new Users();
        user.setUserId(1);
        user.setUsername("Kislaya");
        user.setPassword("12345");
        user.setStatus(Users.Status.Activated);
        String json = mapper.writeValueAsString(user);
        MvcResult result = mockMvc.perform(get("/users/1").content(json)
                .contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

}
