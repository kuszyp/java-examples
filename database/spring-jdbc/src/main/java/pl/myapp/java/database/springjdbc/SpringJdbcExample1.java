package pl.myapp.java.database.springjdbc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class SpringJdbcExample1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConfig.class, UserRepository.class);
        UserRepository repository = context.getBean(UserRepository.class);

        // Add new user
        repository.addUSer("Koziołek Matołek", "koziolek@example.com");

        // Get all users
        List<User> users = repository.getAllUsers();
        users.forEach(System.out::println);

        // Get user by id
        User user = repository.getUserById(1);
        System.out.println("User with ID 1: " + user);

        context.close();
    }
}
