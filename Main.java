import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter your name: ");
            String name = sc.nextLine();
            System.out.print("Are you a Student or Teacher? (S/T): ");
            String role = sc.nextLine();

            int userId = new Random().nextInt(1000) + 1;
            User user = role.equalsIgnoreCase("T") ? new Teacher(userId, name) : new Student(userId, name);

            Library library = new Library("data.csv");
            library.registerUser(user);

          
                System.out.println("\n📚 Library Menu:");
                                System.out.println("1. View Issued Books");
                System.out.println("2. View User Book Summary");
                System.out.println("3. Issue Book");
                System.out.println("4. Return Book");
                System.out.println("5. Exit");
                  while (true) {
                System.out.print("Choose: ");

                int choice = sc.nextInt();

                switch (choice) {
                                        case 1 -> library.displayIssuedBooks();
                    case 2 -> library.displayUserSummary();
                    case 3 -> {
                        System.out.print("Enter Book ID: ");
                        int bookId = sc.nextInt();
                        library.issueBook(bookId, userId);
                    }
                    case 4 -> {
                        System.out.print("Enter Book ID to return: ");
                        int bookId = sc.nextInt();
                        library.returnBook(bookId);
                    }
                    case 5 -> {
                        System.out.println("Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid choice.");
                }
            }
        }
    }
}
