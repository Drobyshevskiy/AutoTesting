package lab1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Student[]students = new Student[4];
        students[0] = new Student(1,"Болтач", "В.С.", new int []{6,8,7,6},"2");
        students[1] = new Student(2,"Петров","П.П.", new int []{9,10,8,8},"9");
        students[2] = new Student(3,"Иванов", "И.И.", new int []{3,1,3,4},"9");
        students[3] = new Student(4,"Петров","В.А.", new int []{9,10,9,10},"2");

        Group[] groups = new Group[2];
        groups[0] = new Group("2",  new Student[]{students[0], students[3], });
        groups[1] = new Group("9",  new Student[]{students[1], students[2]});

        System.out.println("Список всех студентов:");
        for(int i=0; i<students.length; i++) System.out.println(students[i].toString());

        while (true) {
            System.out.println("____________________________________________\n" +
                    "1) Cредний балл отдельного студента:\n" +
                    "2) Cредний балл всей группы\n" +
                    "3) Выход\n");
            Scanner in = new Scanner(System.in);
            int option = in.nextInt();
            Scanner scanner = new Scanner(System.in);
            switch (option) {
                case 1:
                    System.out.println("Введите Фамилию студента");
                    String nameOfStudent = scanner.nextLine();
                    Student.AverageMarkStudent(nameOfStudent, students);
                    break;
                case 2:
                    System.out.println("Введите номер группы");
                    String idGroup = scanner.nextLine();
                    System.out.println("Средний балл группы " + idGroup + ": " + Group.AverageMarkGroup(idGroup, groups));
                    break;
                case 3: {
                    scanner.close();
                    System.exit(0);
                }
                default:
                    System.out.println("Ошибка ввода");
            }
        }
    }
}