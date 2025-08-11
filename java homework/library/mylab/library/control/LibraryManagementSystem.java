package mylab.library.control;

import java.util.List;

import mylab.library.entity.Book;
import mylab.library.entity.Library;

public class LibraryManagementSystem {

	public static void main(String[] args) {
		Library library = new Library("�߾� ������");
		
		addSampleBooks(library);
		System.out.println("===== " + library.getName() + " =====");
		System.out.println("��ü ���� ��: " + library.getTotalBooks());
		System.out.println("���� ������ ���� ��: " + library.getAvailableBooksCount());
		System.out.println("���� ���� ���� ��: " + library.getBorrowedBooksCount());
		System.out.println("");
        testFindBook(library);
        testCheckOut(library);
        System.out.println("������ ���� ����:");
		System.out.println("��ü ���� ��: " + library.getTotalBooks());
		System.out.println("���� ������ ���� ��: " + library.getAvailableBooksCount());
		System.out.println("���� ���� ���� ��: " + library.getBorrowedBooksCount());
		System.out.println("");
        testReturn(library);
        System.out.println("������ ���� ����:");
		System.out.println("��ü ���� ��: " + library.getTotalBooks());
		System.out.println("���� ������ ���� ��: " + library.getAvailableBooksCount());
		System.out.println("���� ���� ���� ��: " + library.getBorrowedBooksCount());
		System.out.println("");
        displayAvailableBooks(library);
	}
	
	// ���� ���� �߰� 
	public static void addSampleBooks(Library library) {
		library.addBook(new Book("�ڹ� ���α׷���", "���ڹ�", "978-89-01-12345-6", 2022, true));
        library.addBook(new Book("��ü������ ��ǰ� ����", "����ȣ", "978-89-01-67890-1", 2015, true));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008, true));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018, true));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005, true));
        library.addBook(new Book("�ڹ��� ����", "���ü�", "978-89-01-14077-4", 2019, true));
        
        System.out.println("������ �߰��Ǿ����ϴ�: �ڹ� ���α׷���");
        System.out.println("������ �߰��Ǿ����ϴ�: ��ü������ ��ǰ� ����");
        System.out.println("������ �߰��Ǿ����ϴ�: Clean Code");
        System.out.println("������ �߰��Ǿ����ϴ�: Effective Java");
        System.out.println("������ �߰��Ǿ����ϴ�: Head First Java");
        System.out.println("������ �߰��Ǿ����ϴ�: �ڹ��� ����");
	}

    // ���� �˻� �׽�Ʈ
    public static void testFindBook(Library library) {
        System.out.println("===== ���� �˻� �׽�Ʈ =====");

        System.out.println("�������� �˻� ���:");
        Book foundByTitle = library.findBookByTitle("�ڹ��� ����");
        if (foundByTitle != null) {
        	String okBorrow = foundByTitle.isAvailable() == true ? "����" : "�Ұ���";
        	System.out.printf("å ����: %s	����: %s	ISBN: %s	���ǳ⵵: %d	���� ���� ����: %s",
        			foundByTitle.getTitle(), foundByTitle.getAuthor(), foundByTitle.getIsbn(), foundByTitle.getPublishYear(), okBorrow);
        }
        System.out.println();
        System.out.println("\n���ڷ� �˻� ���:");
        List<Book> foundByAuthor = library.findBooksByAuthor("Robert C. Martin");
        for (Book book : foundByAuthor) {
        	String okBorrow = book.isAvailable() == true ? "����" : "�Ұ���";
        	System.out.printf("å ����: %s	����: %s	ISBN: %s	���ǳ⵵: %d	���� ���� ����: %s",
        			book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPublishYear(), okBorrow);
        }
        System.out.println();
    }

    // ���� ���� �׽�Ʈ
    public static void testCheckOut(Library library) {
        System.out.println("\n===== ���� ���� �׽�Ʈ =====");
        boolean checkedOut = library.checkOutBook("978-89-01-14077-4");
        if (checkedOut) {
            System.out.println("���� ���� ����!");
            Book borrowedBook = library.findBookByISBN("978-89-01-14077-4");
            System.out.println("����� ���� ����:");
            String okBorrow = borrowedBook.isAvailable() == true ? "����" : "�Ұ���";
        	System.out.printf("å ����: %s	����: %s	ISBN: %s	���ǳ⵵: %d	���� ���� ����: %s\n",
        			borrowedBook.getTitle(), borrowedBook.getAuthor(), borrowedBook.getIsbn(), borrowedBook.getPublishYear(), okBorrow);
        }
        System.out.println();
    }

    // ���� �ݳ� �׽�Ʈ
    public static void testReturn(Library library) {
        System.out.println("===== ���� �ݳ� �׽�Ʈ =====");
        boolean returned = library.returnBook("978-89-01-14077-4");
        if (returned) {
            System.out.println("���� �ݳ� ����!");
            Book returnedBook = library.findBookByISBN("978-89-01-14077-4");
            System.out.println("�ݳ��� ���� ����:");
            String okBorrow = returnedBook.isAvailable() == true ? "����" : "�Ұ���";
        	System.out.printf("å ����: %s	����: %s	ISBN: %s	���ǳ⵵: %d	���� ���� ����: %s",
        			returnedBook.getTitle(), returnedBook.getAuthor(), returnedBook.getIsbn(), returnedBook.getPublishYear(), okBorrow);
        }
        System.out.println("\n");
    }

    // ���� ������ ���� ��� ���
    public static void displayAvailableBooks(Library library) {
        System.out.println("===== ���� ������ ���� ��� =====");
        List<Book> availableBooks = library.getAvailableBooks();
        for (Book book : availableBooks) {
        	String okBorrow = book.isAvailable() == true ? "����" : "�Ұ���";
        	System.out.printf("å ����: %s	����: %s	ISBN: %s	���ǳ⵵: %d	���� ���� ����: %s\n",
        			book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPublishYear(), okBorrow);
            System.out.println("------------------------");
        }
    }
}