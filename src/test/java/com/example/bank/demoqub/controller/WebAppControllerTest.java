package com.example.bank.demoqub.controller;

import org.junit.Before;
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
public class WebAppControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebAppController classUnderTest;

    @Before
    public void setUp() {
        classUnderTest.amount = 50;
    }

    @Test
    public void given50Pound_whenGetAmount_thenReturnContains50() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(content().string(containsString("£50")));

    }

    @Test
    public void given50Pound_whenPay_thenReturnContains40() throws Exception {
        mockMvc.perform(get("/pay"))
                .andExpect(content().string(containsString("£40")));

    }

    @Test
    public void given50Pound_whenReceive_thenReturnContains60() throws Exception {
        mockMvc.perform(get("/receive"))
                .andExpect(content().string(containsString("£60")));

    }

}