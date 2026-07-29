package Task2_TrainingInstituteManagementSystem;

import java.util.*;

class Course {
    int courseId;
    String courseName;
    String trainerName;
    double courseFee;

    Course(int courseId, String courseName, String trainerName, double courseFee) {

        if (courseFee <= 0) {
            throw new IllegalArgumentException("Invalid Course Fee");
        }

        this.courseId = courseId;
        this.courseName = courseName;
        this.trainerName = trainerName;
        this.courseFee = courseFee;
    }

    void display() {
        System.out.println("Course ID : " + courseId);
        System.out.println("Course Name : " + courseName);
        System.out.println("Trainer Name : " + trainerName);
        System.out.println("Course Fee : " + courseFee);
        System.out.println();
    }
}

public class TrainingInstitute {

    public static void main(String[] args) {

        ArrayList<Course> courses = new ArrayList<>();

        try {
            courses.add(new Course(101, "Core Java", "Ganesh", 5000));
            courses.add(new Course(102, "Python", "Kumar", 4500));
            courses.add(new Course(103, "Spring Boot", "Raja", 6000));
            courses.add(new Course(104, "SQL", "Rani", 3000));
            courses.add(new Course(105, "HTML", "Sarala", 2500));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("--------------------");
        System.out.println("      Courses");
        System.out.println("--------------------");

        for (Course c : courses) {
            c.display();
        }

        HashMap<Integer, Course> courseMap = new HashMap<>();

        for (Course c : courses) {
            courseMap.put(c.courseId, c);
        }

        int searchId = 101;

        System.out.println("--------------------");
        System.out.println("   Course Search");
        System.out.println("--------------------");

        if (courseMap.containsKey(searchId)) {
            System.out.println("Course Found");
            courseMap.get(searchId).display();
        } else {
            System.out.println("Course Not Found");
        }

        courseMap.remove(105);


        HashSet<String> technologies = new HashSet<>();

        technologies.add("Java");
        technologies.add("Python");
        technologies.add("Java");
        technologies.add("Spring Boot");
        technologies.add("Python");
        technologies.add("SQL");

        System.out.println("--------------------");
        System.out.println("   Technologies");
        System.out.println("--------------------");

        for (String tech : technologies) {
            System.out.println(tech);
        }

        technologies.remove("SQL");

        System.out.println();
        System.out.println("After Removing SQL");
        System.out.println("Total Technologies : " + technologies.size());
        System.out.println();

        ArrayList<Integer> scores = new ArrayList<>();

        scores.add(85);
        scores.add(90);
        scores.add(78);
        scores.add(95);
        scores.add(88);

        int total = 0;
        int highest = scores.get(0);
        int lowest = scores.get(0);

        System.out.println("--------------------");
        System.out.println("  Student Scores");
        System.out.println("--------------------");

        for (Integer score : scores) {

            System.out.print(score + " ");

            total += score;

            if (score > highest) {
                highest = score;
            }

            if (score < lowest) {
                lowest = score;
            }
        }

        double average = (double) total / scores.size();

        System.out.println("\n");
        System.out.println("--------------------");
        System.out.println("  Score Analysis");
        System.out.println("--------------------");

        System.out.println("Total Score   : " + total);
        System.out.println("Average Score : " + average);
        System.out.println("Highest Score : " + highest);
        System.out.println("Lowest Score  : " + lowest);

        System.out.println();
        System.out.println("--------------------");
        System.out.println(" Exception Demo");
        System.out.println("--------------------");

        try {
            Course c = new Course(106, "React", "Vignesh", -2000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
    }
}