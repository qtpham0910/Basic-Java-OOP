

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;

public class BookManagement {
    public BookManagement(){
		super();
	}
    /* Thứ tự nhập
        +) Số lượng các cuốn sách

        +) 1 số nguyên 0 hoặc 1 (nếu 0 là sách tham khảo, 1 là sách giáo khoa)

        +)  id (mã sách), name (tên sách), quantity (số lượng), publisher (NXB), price (giá)

        +)  status (trạng thái) với sách giáo khoa,  tax (thuế) đối với sách tham khảo.
    */
	public Book[] readData(Scanner sc) {
        
        int n = Integer.parseInt(sc.nextLine());
        Book[] books = new Book[n];
        for(int i = 0;i < n; i++){
            int t = Integer.parseInt(sc.nextLine());
            
            if(t == 0){
            String id = sc.nextLine();
            String name = sc.nextLine();
            int quantity = Integer.parseInt(sc.nextLine());
            String publisher = sc.nextLine();
            double price = Double.parseDouble(sc.nextLine());
            
            double tax = Double.parseDouble(sc.nextLine());

            books[i] = new ReferenceBook(id, name, quantity, publisher,price, tax);
            }	 	  	 		 	    	  	     	 	
            else {
            String id = sc.nextLine();
            String name = sc.nextLine();
            int quantity = Integer.parseInt(sc.nextLine());
            String publisher = sc.nextLine();
            double price = Double.parseDouble(sc.nextLine());
            
            boolean status = Boolean.parseBoolean(sc.nextLine());
                // sc.nextLine();
             
            books[i] = new TextBook(id, name, quantity, publisher,price, status);
            }
        }
		return books;
	}
    // In thong tin các cuốn sách
	public void printBooks(Book[] books) {
		for(Book i: books){
            System.out.println(i.toString());
        }
	}
    // Tìm các cuốn sách của nhà xuất bản publisher
	public ArrayList<Book> findBooks(Book[] books, String publisher) {
        ArrayList<Book> byPubliser = new ArrayList<>();
        for(int i = 0; i < books.length; i++){
            if(books[i].getPublisher().equals(publisher))
                byPubliser.add(books[i]);
        }
		return byPubliser;

	}
    // Tính giá trị trung bình của các cuốn sách thuộc thể loại typeOfBooks
	public double computeAverage(Book[] books, String typeOfBooks) {
		double avg = 0.0 ;
        int n = 0;
        for(int i = 0; i < books.length; i++){	 	  	 		 	    	  	     	 	
            if(books[i].getClass().getName().equals(typeOfBooks)){
                avg += books[i].getAmount();
                n++;
            }
        }
        avg /= n;
        return avg;
	}
    // Sắp xếp các cuốn sách tăng dần về giá tiền
	public void sortByPrice(Book[] books) {
         for(int i = 0; i < books.length - 1; i++)
            for(int j = i+1; j < books.length; j++){
                if(books[i].getPrice() > books[j].getPrice()){
                    Book temp = books[i];
                    books[i] = books[j];
                    books[j] = temp;
                }
            }
    
       // Arrays.sort(books, Book.BookComparator);
	}

	public static void main(String[] args) {
	}
}
	 	  	 		 	    	  	     	 	
