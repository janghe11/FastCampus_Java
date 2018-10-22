package net.thjang.blog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    public StudentDAO studentDao() {
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.setHost("localhost:3306");
        studentDAO.setDatabase("student");
        studentDAO.setUsername("java");
        studentDAO.setPassword("java");

        return studentDAO;
    }

    @Bean
    public UI ui() {
        return new UI();
    }

    @Bean
    public MainController mainController() {
        MainController mainController = new MainController();
        mainController.setUi(this.ui());
        mainController.setStudentDAO(studentDao());

        return mainController;
    }
}
