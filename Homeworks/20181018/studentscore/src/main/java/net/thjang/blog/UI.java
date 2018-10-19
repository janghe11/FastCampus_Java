package net.thjang.blog;

import java.util.List;
import java.util.Scanner;

public class UI {

    public int main() {
        int choiceNumber = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("원하시는 항목의 숫자를 입력하여 주십시오.");
        System.out.println("1. 학생 등록");
        System.out.println("2. 학생 목록 보기");
        System.out.println("3. 종료");
        System.out.print("선택 : ");

        choiceNumber = scanner.nextInt();

        switch (choiceNumber) {
            case 1:
                System.out.println("학생 등록을 선택하셨습니다.");
                return 1;
            case 2:
                System.out.println("학생 목록 보기를 선택하였습니다.");
                return 2;
            default:
                System.out.println("종료합니다.");
                return 3;
        }
    }

    public Student addStudent() {
        Student student = new Student();
        String name;
        int literatureScore;
        int englishScore;
        int mathScore;
        String registerCheck;

        Scanner scanner = new Scanner(System.in);
        System.out.print("이름 : ");
        name = scanner.next();
        System.out.println("");

        System.out.print(" 국어 : ");
        literatureScore = scanner.nextInt();
        System.out.println("");

        System.out.print(" 영어 : ");
        englishScore = scanner.nextInt();
        System.out.println("");

        System.out.print(" 수학 : ");
        mathScore = scanner.nextInt();
        System.out.println("");

        System.out.print("등록할까요? (Y / N)");
        registerCheck = scanner.next();

        if (registerCheck.equals("Y") || registerCheck.equals("y")) {
            student.setName(name);
            student.setLiteratureScore(literatureScore);
            student.setEnglishScore(englishScore);
            student.setMathScore(mathScore);
        } else {}

        return student;
    }

    public void listStudent(List<Student> studentList) {
        for (Student student : studentList) {
            System.out.print("이름 : " + student.getName());
            System.out.print("국어 : " + student.getLiteratureScore());
            System.out.print("영어 : " + student.getEnglishScore());
            System.out.print("수학 : " + student.getMathScore());
            System.out.println("");
        }
    }

    public void end() {
        System.exit(0);
    }
}
