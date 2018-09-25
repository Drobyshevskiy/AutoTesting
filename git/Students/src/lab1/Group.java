package lab1;

public class Group {

    private String id;
    private Student[] students;

    public Group(String id, Student[] students) {
        this.id = id;
        this.students = students;
    }

    public static double AverageMarkGroup(String id, Group[] groups) {
        int k = 0;
        double sum = 0;
        double ave = 0;
        for (Group group : groups) {
            if (group.getId().equals(id)) {
                for (int i = 0; i < group.getStudents().length; i++) {
                    sum += Student.AverageMarkStudent(group.getStudents()[i].getSurname(), group.getStudents());
                }
                ave = sum/(double)group.getStudents().length;

            }
                k++;
        }
        if(ave==0)
            System.out.println("Ошибка ввода");
        return ave;
    }

    public String getId() {
        return id;
    }

    public Student[] getStudents() {
        return students;
    }
}