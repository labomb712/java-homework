package mylab.library.entity;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int publishYear;
    private boolean isAvailable;
    
    public Book() {
        this.title = "";
        this.author = "";
        this.isbn = "";
        this.publishYear = 0;
    	this.isAvailable = true;
    }
    public Book(String title, String author, String isbn, int publishYear, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishYear = publishYear;
        this.isAvailable = true;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public int getPublishYear() { return publishYear; }
    public void setPublishYear(int publishYear) { this.publishYear = publishYear; }

    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean isAvailable) { this.isAvailable = isAvailable; }

    @Override
    public String toString() {
    	return String.format(
    	        "제목: %s\n 저자: %s\n ISBN: %s\n 출판년도: %d\n 대출 가능: %s",
    	        title,
    	        author,
    	        isbn,
    	        publishYear,
    	        isAvailable ? "예" : "아니오"
    	    );

    }
    
    // 도서 대출 처리
    public boolean checkOut() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        } else {
            return false;
        }
    }

    // 도서 반납 처리
    public void returnBook() {
        isAvailable = true;
    }

}