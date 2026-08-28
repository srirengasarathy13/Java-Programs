package Builder;

public class StudentBuilderDemo {

    private int studentId;
    private String name;
    private String course;
    private int year;
    private double fees;

    private StudentBuilderDemo(StudentBuilder builder) {
        this.studentId = builder.studentId;
        this.name = builder.name;
        this.course = builder.course;
        this.year = builder.year;
        this.fees = builder.fees;
    }

    public static class StudentBuilder {

        private int studentId;
        private String name;
        private String course;
        private int year;
        private double fees;

        public StudentBuilder setStudentId(int studentId) {
            this.studentId = studentId;
            return this;
        }

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder setCourse(String course) {
            this.course = course;
            return this;
        }

        public StudentBuilder setYear(int year) {
            this.year = year;
            return this;
        }

        public StudentBuilder setFees(double fees) {
            this.fees = fees;
            return this;
        }

        public StudentBuilderDemo build() {
            return new StudentBuilderDemo(this);
        }
    }

    public void displayDetails() {
        System.out.println("Student ID : " + studentId);
        System.out.println("Name       : " + name);
        System.out.println("Course     : " + course);
        System.out.println("Year       : " + year);
        System.out.println("Fees       : " + fees);
    }

    public static void main(String[] args) {

        StudentBuilderDemo student = new StudentBuilderDemo.StudentBuilder()
                .setStudentId(101)
                .setName("R Sri Rengasarathy")
                .setCourse("BE CSE")
                .setYear(4)
                .setFees(75000)
                .build();

        student.displayDetails();
    }
}
