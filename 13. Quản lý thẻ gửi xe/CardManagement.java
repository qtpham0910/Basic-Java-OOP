import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;

public class CardManagement {

	
	public CardManagement()
	{
		super();
	}
	/*
	    Thứ tự nhập như sau:
	    - Số lượng xe
	    - Trong vòng lặp để nhập thông tin mỗi thẻ: nhập số nguyên c = 0 (thẻ học sinh) hoặc 1 (thẻ nhân viên)
	    - Nhập thông tin mỗi thẻ: id, years, day, price, fee (với thẻ nhan viên), và card (với thẻ học sinh)
	*/
	public ArrayList<Card> readData (String fileName)
	{
        
		File file = new File(fileName);
		ArrayList<Card> card = new ArrayList<>();
	try{
		    
        Scanner scanner = new Scanner(file);
	    int n = Integer.parseInt(scanner.nextLine());
	    for(int i = 0 ; i < n; i++){
            int c = Integer.parseInt(scanner.nextLine());
            if(c == 0){
                // student
                String id = scanner.nextLine();
                int year = Integer.parseInt(scanner.nextLine());
                double days = Double.parseDouble(scanner.nextLine());
                double price = Double.parseDouble(scanner.nextLine());
                double fee = Double.parseDouble(scanner.nextLine());
                StudentCard  stuCard = new StudentCard(id, year, days, price, fee);
                card.add(stuCard);
            }	 	  	 		 	    	  	     	 	
            else if(c == 1){
                //staff
                String id = scanner.nextLine();
                int year = Integer.parseInt(scanner.nextLine());
                double days = Double.parseDouble(scanner.nextLine());
                double price = Double.parseDouble(scanner.nextLine());
                double tax = Double.parseDouble(scanner.nextLine());
                StaffCard  stfCard = new StaffCard(id, year, days, price, tax);
                card.add(stfCard);
            }
	    }
	}
	catch (FileNotFoundException e){
	    System.out.println(e);
	}
		return card;
		
	}
	
	public void printArrayList(ArrayList<Card> cards) {
		for (int i =0;i<cards.size();i++)
			System.out.println(cards.get(i).toString());
	}
	// Hoan thien phuong thuc findCards de tim nhung  xe co nam san xuat la year
	
	public ArrayList<Card> findCards (ArrayList<Card> cards, int year){
		//Begin editable part
        ArrayList<Card> byYear = new ArrayList<Card>();
        for(Card i: cards){
            if(year == i.getYear())
            byYear.add(i);
        }
		return byYear;
		//End editable part
	}
	
	// Hoan thien phuong thuc getMaxAmount để trả về danh sách các thẻ có giá gửi xe 
    //thành tiền cao nhất thuộc loại typeOfCard (typeOfCard có thể là 
    //thẻ sinh viên, hoặc thẻ nhân viên)
	public ArrayList<Card> getMaxAmount (ArrayList<Card> cards, String typeOfCard){	 	  	 		 	    	  	     	 	
		//Begin editable part
        ArrayList<Card> mx = new ArrayList<Card>();
        double mxamt = -1;
        for(Card i : cards){
            if(i.getClass().getName() == typeOfCard){
                if(i.getAmount() > mxamt){
                    mxamt = i.getAmount();
                }
                               
            }
        }
            for(Card i : cards){
                if(i.getClass().getName() == typeOfCard){
                    if(i.getAmount() == mxamt){
                        mx.add(i);
                    }
                }
            }
        
		return mx;
		//End editable part
	}
	
	
	// Hoan thien phuong thuc sortByAmount de sap xep cac xe theo thu tu giam dan
	public void sortByAmount (ArrayList<Card> cards) {
		//Begin editable part
        Collections.sort(cards, Card.CardComparator);
		//End editable part
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		CardManagement cardMng = new CardManagement();
		ArrayList<Card> cards = cardMng.readData("datas.txt");
	}

}	 	  	 		 	    	  	     	 	
