package net.thjang.blog;

import java.util.List;

public class MainController {
    private UI ui;
    private StudentDAO studentDAO;

    public MainController() {
    }

    public MainController(UI ui, StudentDAO studentDAO) {
        this.ui = ui;
        this.studentDAO = studentDAO;
    }

    public UI getUi() {
        return ui;
    }

    public void setUi(UI ui) {
        this.ui = ui;
    }

    public StudentDAO getStudentDAO() {
        return studentDAO;
    }

    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public void control() {
        int selectedNumber = 0;
        int queryInserted = 0;
        Student student;
        List<Student> studentList;

        while (true) {

            selectedNumber = ui.main();

            switch (selectedNumber) {
                case 1:
                    student = ui.addStudent();
                    queryInserted = studentDAO.add(student);

                    if (queryInserted == 0)
                        System.out.println("입력하신 정보가 정상적으로 반영되었습니다.");
                    else
                        System.out.println("오류가 발생하였습니다. 다시 시도해 주세요.");
                    break;
                case 2:
                    studentList = studentDAO.getList();
                    ui.listStudent(studentList);
                    break;
                default:
                    ui.end();
                    break;
            }
        }
    }
}
