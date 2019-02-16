package com.example.demo.controllers;

import com.example.demo.models.OptimizationRequest;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



//This class should be as CICD project for future integration and development//
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OptimizationControllerTest {

    @Autowired
    private MockMvc mockMvc;
    Gson gson = new Gson();



    @Test
    public void shouldCallIterativeStrategy() throws Exception {
        mockMvc.perform(post("/iterativeStrategy")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(new OptimizationRequest().setJunior(1).setSenior(2).setRooms(Arrays.asList(12,13,34)))))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldCallRecursiveStrategy() throws Exception {
        mockMvc.perform(post("/recursiveStrategy")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(new OptimizationRequest().setJunior(1).setSenior(2).setRooms(Arrays.asList(12,13,34)))))
                .andExpect(status().isOk());
    }


    @Test
    public void shouldCallRecursiveException() throws Exception {
        mockMvc.perform(post("/nonExistedrecursiveStrategy")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(new OptimizationRequest().setJunior(1).setSenior(2).setRooms(Arrays.asList(12,13,34)))))
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void shouldCallOptimizationException() throws Exception {
        mockMvc.perform(post("/iterativeStrategy")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(new OptimizationRequest().setJunior(1).setSenior(2).setRooms(Arrays.asList(0,13,34)))))
                .andExpect(status().is4xxClientError());
    }




}