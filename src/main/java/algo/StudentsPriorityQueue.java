package algo;

import java.util.*;

/*
 * Create the Student and Priorities classes here.
 */
class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getCGPA() {
        return this.cgpa;
    }
}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        Queue<Student> queue = new PriorityQueue<Student>(events.size(), new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1.getCGPA() > s2.getCGPA()) {
                    return -1;
                } else if (s1.getCGPA() < s2.getCGPA()) {
                    return 1;
                }

                if (s1.getName().compareTo(s2.getName()) != 0)
                    return s1.getName().compareTo(s2.getName());

                return (s1.getID() - s2.getID());
            }
        });

        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).startsWith("ENTER")) {
                String[] arr = events.get(i).split(" ");
                queue.add(new Student(Integer.parseInt(arr[3]), arr[1], Double.parseDouble(arr[2])));
            } else {
                queue.poll();
            }
        }

        List<Student> students = new ArrayList<>(queue.size());
        while (!queue.isEmpty()) {
            students.add((Student) queue.poll());
        }
        return students;
    }
}

public class StudentsPriorityQueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}