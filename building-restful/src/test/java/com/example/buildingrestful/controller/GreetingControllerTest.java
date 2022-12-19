package com.example.buildingrestful.controller;

import com.example.buildingrestful.BuildingRestfulApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.is;

/**
 * Reference https://stackoverflow.com/questions/65520264/how-to-test-json-structure-in-spring-boot
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.MOCK,
    classes = BuildingRestfulApplication.class)
@AutoConfigureMockMvc
public class GreetingControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void default_greeting()
        throws Exception {
        mvc.perform(get("/greeting")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content()
                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.content", is("Hello, World!")))
            .andExpect(jsonPath("$.id", is(1)));
    }

    @Test
    public void custom_greeting () throws Exception {
        //Given
        String customName = "Pepe";
        String urlPath = String.format("/greeting?name=%s", customName);

        //Then
        mvc.perform(get(urlPath)
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content()
                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.content", is(String.format("Hello, %s!", customName))))
            .andExpect(jsonPath("$.id", is(2)));
    }
}
