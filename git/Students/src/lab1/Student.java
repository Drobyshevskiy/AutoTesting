package lab1;

public class Student {

    private int id;
    private String surname, initials;
    private int[] marks;
    private String groupId;

    public Student(int id, String surname, String initials, int[] marks, String groupId) {
        this.id = id;
        this.surname = surname;
        this.initials = initials;
        this.marks = marks;
        this.groupId = groupId;
    }

    public static double AverageMarkStudent(String name, Student[] students) {
        int k = 0;
        double ave = 0;
        for (Student student : students) {

            if (student.getSurname().equals(name)) {
                int sum = 0;
                for (int i = 0; i < student.getMarks().length; i++) {
                    sum += student.getMarks()[i];
                }
                ave = sum / (double)student.getMarks().length;
                System.out.println(students[k].toString() + " " +"Средний балл:" + ave);
            }
               k++;
        }
        if(ave==0)
            System.out.println("Ошибка ввода");
        return ave;
    }

    public String toString() {
        String str = "";
        for(int i=0; i<marks.length; i++) {
            str += marks[i] + " ";
        }
        return id + ")\t" + surname + " " + initials+ "\t\t" + str+ "\t\t" +"группа:"+ groupId ;
    }

    public String getSurname() {
        return surname;
    }

    public int[] getMarks() {
        return marks;
    }
}