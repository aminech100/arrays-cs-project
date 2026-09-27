package samplearrays;

public class CourseNumbersArray {
    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};
        int[] updatedCourses = new int[registeredCourses.length+1];

        for (int i=0; i < registeredCourses.length; i++){
            updatedCourses[i] = registeredCourses[i];
        }
        updatedCourses[updatedCourses.length-1] = 2200;
        int targetCourse = 2400;
        boolean found = false;
        System.out.println("----- Updated Courses List -----");
        for (int i=0; i<updatedCourses.length; i++){
            System.out.println("Course n°" + updatedCourses[i]);
            if (updatedCourses[i] == targetCourse){
                found = true;
            }
        }
        if (found)
            System.out.println("Course n°" + targetCourse + " found.");
        else
            System.out.println("Course n°" + targetCourse + " NOT found");

    }
}
