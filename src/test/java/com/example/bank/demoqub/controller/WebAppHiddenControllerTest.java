package com.example.bank.demoqub.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@RunWith(SpringRunner.class)
@WebMvcTest(WebAppController.class)
public class WebAppHiddenControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebAppController classUnderTest;

    @Test
    public void given10Pound_whenPay_thenReturnContains0() throws Exception {
        classUnderTest.amount = 10;
        mockMvc.perform(get("/pay"))
                .andExpect(content().string(containsString("£0")));

    }

}