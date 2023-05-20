import java.util.*;

public class Test {

    public static void main(String[] args){

        System.out.println("Hello String...");
        System.out.println();

        List<String> names = new ArrayList<>();

        names.add("Nyarko");
        names.add("Acheampong");
        names.add("Boateng");
        names.add("Ofori");
        names.add("Esi");

        System.out.println("Names without sorting: " + names);
        System.out.println();

//        Using inbuilt Collections sort
        Collections.sort(names);

        System.out.println("Names after sorting: " + names);
        System.out.println();


//        Writing our own sort logic and passing it to the Comparator
        Comparator<String> com = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

//                We write our compare logic here
                if(o1.length() > o2.length())
                    return 1;
                else
                    return -1;
            }
        };

        Collections.sort(names, com);

        System.out.println("Names after using our own sorting logic: " + names);
        System.out.println();

        List<Integer> numbers = new ArrayList<>();
        numbers.add(45);
        numbers.add(29);
        numbers.add(31);
        numbers.add(52);
        numbers.add(18);

        System.out.println("No sorting: " + numbers);
        System.out.println();

//        Collections.sort(numbers);
//        System.out.println("Inbuilt sorting: " + numbers);

        Comparator<Integer> sorter = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

//                We write our compare logic here
                if(o1%10 > o2%10)
                    return 1;
                else
                    return -1;
            }
        };
        Collections.sort(numbers, sorter);
        System.out.println("Custom sorting: " + numbers);
        System.out.println();

//        Making use of Lambda expressions and also implementing Comparable functional interface

//        1. With Comparable Interface
        class Student implements Comparable<Student> {
            private int age;
            private String name;

            public Student(int age, String name) {
                this.age = age;
                this.name = name;
            }

            @Override
            public String toString() {
                return "Student{" +
                        "age=" + age +
                        ", name='" + name + '\'' +
                        '}';
            }

            @Override
            public int compareTo(Student stu) {
                if(this.age > stu.age)
                    return 1;
                else
                    return -1;
            }
        }

//        Create Students list
        List<Student> students = new ArrayList<>();
        students.add(new Student(33, "Kofi"));
        students.add(new Student(21, "Ama"));
        students.add(new Student(19, "Anita"));
        students.add(new Student(25, "Max"));

        Collections.sort(students);

        for(Student student: students){
            System.out.println(student);
        }
        System.out.println();


//        2. With Comparator and Lambda
        class Employee {
            private int age;
            private String name;

            public Employee(int age, String name) {
                this.age = age;
                this.name = name;
            }

            @Override
            public String toString() {
                return "Employee{" +
                        "age=" + age +
                        ", name='" + name + '\'' +
                        '}';
            }
        }

//        Create Employees list
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(43, "Nelson"));
        employees.add(new Employee(39, "Mandela"));
        employees.add(new Employee(51, "Tibu"));
        employees.add(new Employee(30, "Addo"));

//        Using Lambda expression makes it clean and simple
        Comparator<Employee> compa = (i, j) -> i.age > j.age ? 1 : -1;

//        Now we compare and sort the employees by age and print to console
        Collections.sort(employees, compa);
        for (Employee em: employees) {
            System.out.println(em);
        }
    }

}
