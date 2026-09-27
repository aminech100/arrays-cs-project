package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        if (students == null || students.length == 0) return null;
        Student oldest = students[0];
        for (Student student : students) {
            if (student.getAge() > oldest.getAge()) {
                oldest = student;
            }
        }
        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        if (students == null) return 0;
        int count = 0;
        for (Student s : students){
            if (s.isAdult()){
                count ++;
            }
        }
        return count;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        if (students == null || students.length == 0) return 0;
        double sum = 0;
        for (Student s : students){
            sum += s.getGrade();
        }
        return sum/students.length;
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        if (students == null) return null;
        for (Student s : students){
            if (s.getName().equals(name)){
                return s;
            }
        }
        return null;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        if (students == null) return;
        Arrays.sort(students, (s1,s2) -> s2.getGrade() - s1.getGrade());
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        if (students == null) return;
        for (Student s : students){
            if (s.getGrade() >= 15){
                System.out.println(s);
            }
        }
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        if (students == null) return false;
        for (Student s : students){
            if (s.getId() == id){
                s.setGrade(newGrade);
                return true;
            }
        }
        return false;
    }


    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        if (students == null) return false;
        for (int i=0; i<students.length; i++){
            for (int j=i+1; j<students.length; j++){
                if (students[i].getName().equals(students[j].getName())){
                    return true;
                }
            }
        }
        return false;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        int arrayLength = (students == null) ? 0 : students.length;
        Student[] newArray = new Student[arrayLength + 1];
        if (students != null){
            for (int i=0; i<students.length; i++){
                newArray[i] = students[i];
            }
        }
        newArray[newArray.length - 1] = newStudent;
        return newArray;
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student[] arr = {
                new Student(1, "Amine", 19,14),
                new Student(2, "Ahmed", 20,17),
                new Student(3, "Rayan", 21,13),
                new Student(4, "Ayman", 20,15),
                new Student(5, "Ilyass", 19,11),
        };

        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        System.out.println("== Oldest Student ==");
        System.out.println(findOldest(arr));

        // 3) Count adults
        System.out.println("Adults students count: " + countAdults(arr));

        // 4) Average grade
        System.out.println("Average grade: " + averageGrade(arr));

        // 5) Find by name
        System.out.println("Find by name (Amine): " + findStudentByName(arr, "Amine"));

        // 6) Sort by grade desc
        // sort function
        sortByGradeDesc(arr);
        System.out.println("\n== Sorted by grade (desc) ==");
        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id
        // function
        boolean updated = updateGrade(arr, 2, 16);
        System.out.println("\nUpdated id=4? " + updated);
        System.out.println(findStudentByName(arr, "Ahmed"));

        // 9) Duplicate names
        System.out.println("Has duplicate names? " + hasDuplicateNames(arr));

        // 10) Append new student
        Student newStud = new Student(6, "Younes", 22, 18);
        arr = appendStudent(arr, newStud);
        System.out.println("== After appending a new student (Younes) ==");
        for (Student s : arr) System.out.println(s);
    }
}

