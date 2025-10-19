package com.example.demo;




import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;


import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class IModule4ApplicationTests {
	@Autowired
    private MockMvc mockMvc;


    @Autowired
    private CatCarrier catCarrier;
    @MockitoBean
    private CatService service;


    private BanditCat testCat = new BanditCat(101, "testcat", "testnickname", 10);
    private CatDTO testDTO;
    
    private ObjectMapper mapper = new ObjectMapper();



    @Test
    public void testCreate() throws Exception {

        var request = post("/api/cats")
        		.contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(testCat));

        mockMvc.perform(request)
                .andExpect(status().isCreated());
                
    }
    	
    	
    	
    

    @Test
    public void testUpdate() throws Exception {
        catCarrier.save(testCat);
        testCat.setName("NewName");

        var request = put("/api/cats/" + testCat.getId())
        		.contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(testCat));

        mockMvc.perform(request)
                .andExpect(status().isOk());
    }

    @Test
    public void testGet() throws Exception {
        catCarrier.save(testCat);

        var request = get("/api/cats/" + testCat.getId());
        mockMvc.perform(request)
                .andExpect(status().isOk());
    }

    @Test
    public void testDelete() throws Exception {
        catCarrier.save(testCat);
        var request = delete("/api/cats/" + testCat.getId());
        mockMvc.perform(request)
                .andExpect(status().isNoContent());
    }

	

	

}
