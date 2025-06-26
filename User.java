import java.util.*;

abstract class User {
    private String name;
    private int userId;
    private List<Book> issuedBooks = new ArrayList<>();

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public String getName() { return name; }
    public int getUserId() { return userId; }

    public List<Book> getIssuedBooks() {
        return issuedBooks;
    }

    public void issueBook(Book book) {
        issuedBooks.add(book);
    }

    public void returnBook(Book book) {
        issuedBooks.remove(book);
    }

    public abstract int getIssueLimit();

    @Override
    public String toString() {
        return getClass().getSimpleName() + " ID: " + userId + ", Name: " + name;
    }
}

class Student extends User {
    public Student(int userId, String name) {
        super(userId, name);
    }

    @Override
    public int getIssueLimit() {
        return 3;
    }
}

class Teacher extends User {
    public Teacher(int userId, String name) {
        super(userId, name);
    }

    @Override
    public int getIssueLimit() {
        return 5;
    }
}
