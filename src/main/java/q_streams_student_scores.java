//import lombok.AllArgsConstructor;
//import lombok.Data;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Given a list of students with name, score find the students who scored highest.
 */
class Scratch {
    public static void main(String[] args) {
        record Student(String name, Integer score){};

        List<Student> studentScores = List.of(
            new Student("Glen", 95),
            new Student("Mike", 90),
            new Student("Dave", 80),
            new Student("Mark", 90),
            new Student("Greg", 95)
        );

//        List<StudentClass> studentScores1 = List.of(
//            new StudentClass("Glen", 95),
//            new StudentClass("Mike", 90),
//            new StudentClass("Dave", 80),
//            new StudentClass("Mark", 90),
//            new StudentClass("Greg", 95)
//        );
        // Declarative Functional way, focus on what, find the highest scored students
        Map<Integer, List<String>> studentsGroupdByScore = studentScores.stream()
            .sorted(Comparator.comparing(Student::score).reversed())
            .collect(Collectors.groupingBy(
                Student::score,
                LinkedHashMap::new, // preserve order
                Collectors.mapping(Student::name, Collectors.toList())));

        System.out.println(studentsGroupdByScore);

        Optional<Integer> firstKey = studentsGroupdByScore.keySet().stream().findFirst();
        if (firstKey.isPresent()) {
            System.out.println(studentsGroupdByScore.get(firstKey.get()));
        }
    }
}

//@Data
//@AllArgsConstructor
//class StudentClass {
//    private String name;
//    private Integer score;
//}
