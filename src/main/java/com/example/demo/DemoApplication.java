package com.example.demo;

import com.example.demo.data.TaskRepository;
import com.example.demo.models.Task;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner runApplication(TaskRepository taskRepository) {
		return (args -> {
			// call methods you want to use
			//performCreateOperations(taskRepository);
			//performUpdateOperations(taskRepository);
			performFindOperations(taskRepository);
		});
	}
	
	private void performFindOperations(TaskRepository taskRepository) {
		System.out.println("Task list:");
		for (Task task : taskRepository.findAll()) {
			System.out.println(task);
		}

		System.out.println("List of enabled tasks:");
		for (Task task : taskRepository.findAllByCompleted(true)) {
			System.out.println(task);
		}
	}

	private void performCreateOperations(TaskRepository taskRepository) {
		Task articleTask = new Task("Finish article", "Finish the article and send for review", true);
		taskRepository.save(articleTask);

		Task speechTask = new Task("Meeting speech", "Prepare the speech for the meeting", false);
		taskRepository.save(speechTask);

		Task drTask = new Task("Call dr Robbins", "Cancel the visit", true);
		taskRepository.save(drTask);

		Task bookingTask = new Task("Book a hotel", "Book a hotel for vacation", true);
		Task savedTask = taskRepository.save(bookingTask);
	}

	private void performUpdateOperations(TaskRepository taskRepository) {
		System.out.println("Updating tasks's title");
		Task task = taskRepository.findByName("Meeting speech") ;

		if (task != null) {
			System.out.println(task);
			task.setCompleted(true);
			taskRepository.save(task);
			System.out.println(taskRepository.findByName("Meeting speech"));
		}
	}

}
