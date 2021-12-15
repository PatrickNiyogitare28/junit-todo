package com.example.todo.services;

import com.example.todo.enums.ETaskStatus;
import com.example.todo.model.Task;
import com.example.todo.repositories.TaskRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TaskServiceTest {
    @Mock
    private TaskRepository taskRepositoryMock;

    @InjectMocks
    private TaskService taskService;

    @Test
    public void getAll_withSomeElement(){
        when(taskRepositoryMock.findAll()).thenReturn(Arrays.asList(
                new Task(1, "Packing","11:00","12:00", ETaskStatus.ACTIVE),
                new Task(2, "Reading","12:00","13:00", ETaskStatus.ACTIVE)
                ));
        assertEquals(1, taskService.getAll().get(0).getId());
        assertEquals(2, taskService.getAll().get(1).getId());
    }
}
