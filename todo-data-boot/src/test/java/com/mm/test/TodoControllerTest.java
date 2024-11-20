package com.mm.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mm.rest.TodoController;
import com.mm.service.TodoService;
import com.mm.utility.Todo;

@ExtendWith(MockitoExtension.class)
public class TodoControllerTest {

	@Mock
	private TodoService service;
	
	@InjectMocks
	private TodoController todocontoller;
	
	 private MockMvc mockMvc;
	
	private Todo todo;
	@BeforeEach
	void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(todocontoller).build();
		todo= new Todo();
		todo.setId(1);
		todo.setTask("math");
		todo.setPriority("high");
		todo.setStatus("pending");
		todo.setAssignDate(LocalDate.parse("2024-11-19"));
		todo.setFinishDate(LocalDate.parse("2025-12-12"));
	}
	
	@Test
	void save() {
		doNothing().when(service).save(any(Todo.class), eq(1));
        String response = todocontoller.save(todo, 1);
        assertEquals("todo saved", response);
        verify(service, times(1)).save(any(Todo.class), eq(1));
	}
	
	@Test
    void testSaveTodo() throws Exception {
        // Arrange: Mock the save method of TodoService
        doNothing().when(service).save(any(Todo.class), eq(1));

        // Act & Assert: Perform the POST request and verify the response
        mockMvc.perform(post("/save1/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1, \"title\":\"Test Todo\", \"description\":\"Description of test todo\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("todo saved"));

        // Verify that the save method was called with the correct parameters
        verify(service, times(1)).save(any(Todo.class), eq(1));
    }
	
}
