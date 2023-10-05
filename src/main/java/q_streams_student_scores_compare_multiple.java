import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given a list of students with name, score find the students who scored highest.
 */
class Scratch {
    public static void main(String[] args) {
        record Student(String name, Integer score, Integer age){};
        List<Student> studentScores = List.of(
            new Student("Glen", 95, 35),
            new Student("Mike", 90, 35),
            new Student("Dave", 80, 40),
            new Student("Mark", 90, 30),
            new Student("Greg", 95, 30)
        );

        // Declarative Functional way, focus on what, find the highest scored students
        Map<Integer, List<Student>> studentsGroupdByScore = studentScores.stream()
            .sorted(
                Comparator.comparing(Student::score).reversed()
                    .thenComparing(Student::age).reversed()
            )
            .collect(
                Collectors.groupingBy(
                    Student::score,
                    LinkedHashMap::new, // preserve order
//                Collectors.mapping(Student::name, Collectors.toList()))
                    Collectors.mapping(it -> it, Collectors.toList()))
            );

        System.out.println(studentsGroupdByScore);
    }
}
