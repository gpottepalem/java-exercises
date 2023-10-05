import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Scratch {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee("emp-1", "Sw Engineer", "Boston"),
            new Employee("emp-2", "Sw Engineer", "Pune"),
            new Employee("emp-3", "Staff Engineer", "Boston"),
            new Employee("emp-4", "Staff Engineer", "Pune"),
            new Employee("emp-5", "Sw Engineer", "Boston")
        );

        System.out.println(imperativeWayGroupByCity(employees));
        System.out.println(imperativeWayCountByCity(employees));
        System.out.println(declarativeFunctionalWayGroupByCity(employees));
        System.out.println(declarativeFunctionalWayCountByCity(employees));
    }

    static Map<String, List<Employee>> imperativeWayGroupByCity(List<Employee> employees) {
        Map<String, List<Employee>> employeesGroupedByCity = new HashMap<>();
        for(Employee employee : employees) {
            List<Employee> cityEmployeesList = employeesGroupedByCity.getOrDefault(employee.city(), new ArrayList<>());
            cityEmployeesList.add(employee);
            employeesGroupedByCity.put(employee.city(), cityEmployeesList);
        }
        return employeesGroupedByCity;
    }

    static Map<String, Long> imperativeWayCountByCity(List<Employee> employees) {
        Map<String, Long> employeesGroupedByCity = new HashMap<>();
        for(Employee employee : employees) {
            Long count = employeesGroupedByCity.getOrDefault(employee.city(), 0L)+1;
            employeesGroupedByCity.put(employee.city(), count);
        }
        return employeesGroupedByCity;
    }

    static Map<String, List<Employee>> declarativeFunctionalWayGroupByCity(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::city));
    }

    static Map<String, Long> declarativeFunctionalWayCountByCity(List<Employee> employees) {
        return employees.stream()
                   .collect(
                       Collectors.groupingBy(Employee::city, Collectors.counting())
                   );
    }
}

record Employee(String name, String title, String city){}