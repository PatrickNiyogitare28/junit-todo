package com.example.todo.repository;

import com.example.todo.enums.ETaskStatus;
import com.example.todo.model.Task;
import com.example.todo.repositories.TaskRepository;
import net.minidev.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TaskRepositoryTest {
  @Autowired
    TaskRepository taskRepository;

  @Test
    public void getAll_success(){
      List<Task> tasks = taskRepository.findAll();
      assertEquals(4, tasks.size());
  }

  @Test
  public void getOneById_success(){
    Optional<Task> taskOption = taskRepository.findById(102);
    assertTrue(taskOption.isPresent());
  }

  @Test
  public void getOneById_404(){
    Optional<Task> taskOption = taskRepository.findById(300);
    assertFalse(taskOption.isPresent());
  }

  @Test
  public void save_success(){
    Task newTask = new Task(302, "Taking notes","20:00", "20:30", ETaskStatus.ACTIVE);
    Task task = taskRepository.save(newTask);
    JSONObject expected = null;
		expected.put("id",newTask.getId());
		expected.put("name",newTask.getName());
        expected.put("startHour",newTask.getStartHour());
        expected.put("endHour",newTask.getEndHour());
        expected.put("status",newTask.getStatus());

    JSONObject actual = null;
    actual.put("id",task.getId());
    actual.put("name",task.getName());
    actual.put("startHour",task.getStartHour());
    actual.put("endHour",task.getEndHour());
    actual.put("status",task.getStatus());

    assertEquals(expected, actual);
  }
}
