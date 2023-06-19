import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Student> students = seed();
        System.out.println(students);

        Student john = getStudentByName(students,"John");
        Student monica = getStudentByName(students, "Monica");

        try{
            john.sayHello();
            monica.sayHello();
        } catch (NullPointerException e) {
            System.out.println("Hello, I'm unknown");
        }

    }

    public static List<Student> seed() {
        List<Student> students = new ArrayList<>();
        List<String> names = new ArrayList<>(List.of("Lisa", "John", "Peter", "Franny", "Luis", "Ben", "Anna"));
        for(String name: names) {
            students.add(new Student(name));
        }
        return students;
    }

    public static Student getStudentByName(List<Student> list, String name ) {
        return list.stream().
                filter(p -> p.getName().equals(name)).
                findFirst().orElse(null);
    }
}
