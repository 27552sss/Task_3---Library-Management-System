public class Book {
    private static int counter = 1;
    private int id;
    private String title;
    private String author;
    private boolean isIssued;
    private User issuedTo;

    public Book(String title, String author) {
        this.id = counter++;
        this.title = title;
        this.author = author;
        this.isIssued = false;
        this.issuedTo = null;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return isIssued; }
    public User getIssuedTo() { return issuedTo; }

    public void issue(User user) {
        this.isIssued = true;
        this.issuedTo = user;
    }

    public void returnBook() {
        this.isIssued = false;
        this.issuedTo = null;
    }

    @Override
    public String toString() {
        return id + ". " + title + " by " + author + (isIssued ? " (Issued to " + issuedTo.getName() + ")" : " (Available)");
    }
}
