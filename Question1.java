import java.util.*;

class EmptyListException extends Exception {
    public EmptyListException(String message) {
        super(message);
    }
}

public class Question1 {
    private ArrayList<String> students;

    public Question1() {
        students = new ArrayList<>();
    }

    public void addStudent(String name) {
        students.add(name);
        System.out.println(name + " added successfully!");
    }

    public void removeStudent(String name) {
        if (students.remove(name)) {
            System.out.println(name + " removed successfully!");
        } else {
            System.out.println(name + " not found in the list.");
        }
    }

    public void displayStudents() throws EmptyListException {
        if (students.isEmpty()) {
            throw new EmptyListException("Error: Student list is empty!");
        }

        Collections.sort(students);
        System.out.println("Sorted Student Names: " + students);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Question1 app = new Question1();
        int choice;

        do {
            System.out.println("\nStudent List Menu");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name to add: ");
                    String nameToAdd = sc.nextLine();
                    app.addStudent(nameToAdd);
                    break;

                case 2:
                    System.out.print("Enter student name to remove: ");
                    String nameToRemove = sc.nextLine();
                    app.removeStudent(nameToRemove);
                    break;

                case 3:
                    try {
                        app.displayStudents();
                    } catch (EmptyListException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Exiting program... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}
