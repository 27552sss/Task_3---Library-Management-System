import java.util.*;
import java.io.*;

class Library {
    private List<Book> books;
    private Map<Integer, User> users;

    public Library(String csvPath) {
        books = new ArrayList<>();
        users = new HashMap<>();
        loadBooksFromCSV(csvPath);
    }

    public void registerUser(User user) {
        users.put(user.getUserId(), user);
        System.out.println("Welcome, " + user.getName() + "! Your ID is: " + user.getUserId());
    }

    public void loadBooksFromCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",", 2);
                if (data.length >= 2) {
                    books.add(new Book(data[0].trim(), data[1].trim()));
                }
            }
            System.out.println("Books loaded successfully from CSV.");
        } catch (IOException e) {
            System.out.println("Error loading books from file: " + e.getMessage());
        }
    }

    public void displayBooks() {
        System.out.println("Book List:");
        for (Book book : books) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }
    }

    public void displayIssuedBooks() {
        System.out.println("Issued Books:");
        books.stream().filter(Book::isIssued).forEach(System.out::println);
    }

    public void displayUserSummary() {
        System.out.println("User-wise Book Summary:");
        users.values().forEach(user -> {
            System.out.println(user);
            user.getIssuedBooks().forEach(book -> System.out.println("  - " + book.getTitle()));
        });
    }

    public void issueBook(int bookId, int userId) {
        Book book = getBookById(bookId);
        User user = users.get(userId);

        if (book == null || user == null) {
            System.out.println("Invalid book or user ID.");
            return;
        }

        if (book.isIssued()) {
            System.out.println("Book is already issued.");
        } else if (user.getIssuedBooks().size() >= user.getIssueLimit()) {
            System.out.println("User has reached the issue limit.");
        } else {
            book.issue(user);
            user.issueBook(book);
            System.out.println("Book issued to " + user.getName());
        }
    }

    public void returnBook(int bookId) {
        Book book = getBookById(bookId);
        if (book == null || !book.isIssued()) {
            System.out.println("Invalid or unissued book.");
            return;
        }
        User user = book.getIssuedTo();
        user.returnBook(book);
        book.returnBook();
        System.out.println("Book returned: " + book.getTitle());
    }

    private Book getBookById(int id) {
        return books.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }

    public Set<Integer> getUserIds() {
        return users.keySet();
    }
}
