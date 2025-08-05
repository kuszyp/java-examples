package pl.myapp.java.examples.springData;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDataJpaExample1 {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(DatabaseConfig.class);

    UserRepository repository = context.getBean(UserRepository.class);
    repository.save(new User(1, "John Doe", "john@example.com"));


    System.out.println("Hello, World!");
  }
}
