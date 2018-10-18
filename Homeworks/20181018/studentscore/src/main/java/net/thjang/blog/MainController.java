package net.thjang.blog;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainController {

    public void control() {
        int selectedNumber = 0;
        int queryInserted = 0;
        Student student;
        List<Student> studentList;
        StudentDAO studentDAO;

        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("student.xml");

        UI ui = applicationContext.getBean(UI.class);
        studentDAO = applicationContext.getBean(StudentDAO.class);
        selectedNumber = ui.main();

        switch (selectedNumber) {
            case 1:
                student = ui.addStudent();
                queryInserted = studentDAO.add(student);

                if (queryInserted != 0)
                    System.out.println("입력하신 정보가 정상적으로 반영되었습니다.");
                else
                    System.out.println("오류가 발생하였습니다. 다시 시도해 주세요.");
                break;
            case 2:
                studentList = studentDAO.getList();
                ui.listStudent(studentList);
                break;
            default:
                break;
        }
    }
}
