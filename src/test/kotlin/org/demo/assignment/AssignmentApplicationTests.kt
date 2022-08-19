package org.demo.assignment

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc

@SpringBootTest
@AutoConfigureMockMvc
class AssignmentApplicationTests(

    @Autowired val mockMvc: MockMvc,
    @Autowired val objectMapper: ObjectMapper
)
