package Bank;
import java.util.*;
import java.io.*;
public class BankManagement{

    public static ArrayList<BankAccount> readData(String fName){
    /* Cần đọc dữ liệu từ tệp fName theo quy tắc: 
        Thông tin cho mỗi đối tượng đặt trên 01 dòng theo thứ tự:
        accountNumber, firstName, lastName, password, balance; 
        Nếu chữ số đầu của accountNumber là '1' thì coi là SavingsAccount
        và thông tin cuôi dòng là interestRate; ngược lại coi là CheckingAccount.
        Các trường cách nhau bởi ít nhất 01 khoảng trắng.
        Dùng try ... catch để xử lý ngoại lệ khi đọc tệp! Nếu không đọc được tệp cần hiển thị thông báo
        với đoạn đầu là: "Cannot open file" và phần tên tệp, các thông tin lỗi.
        Nếu thành công, trả về ArrayList các đối tượng đã đọc được.
        Bổ sung mã lệnh tương ứng - Có thể sửa giá trị trả về của return nhưng cần giữ nguyên kiểu trả về.
    */
    // String anAccountNumber, String firstName, String lastName, String password, double initialBalance
    //1 savingAcc 2 = checkingAcc
    	File inp = new File(fName);
    	ArrayList<BankAccount> acc = new ArrayList<>();
    	try {
			Scanner scanner = new Scanner(inp);
			while(scanner.hasNextLine()) {
				String[] info = scanner.nextLine().split("\\s+");
				String accountNumber = info[0];
				if(accountNumber.charAt(0) == '1') {
					String firstName = info[1];
					String lastName = info[2];
					String password = info[3];
					double balance = Double.valueOf(info[4]);
					double rate = Double.valueOf(info[5]);
					
					SavingsAccount save = new SavingsAccount(accountNumber, firstName, lastName, password, balance, rate);
					acc.add(save);
					
				} else if(accountNumber.charAt(0) == '2') {	
				String firstName = info[1];
				String lastName = info[2];
				String password = info[3];
				double balance = Double.valueOf(info[4]);
				
				CheckingAccount chk = new CheckingAccount(accountNumber, firstName, lastName, password, balance);
				acc.add(chk);
				}
			}
			scanner.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Cannot open file " + fName + " " + e);
			e.printStackTrace();
		}
        return acc;
    }


    public static void displayList(ArrayList<BankAccount> listAccount){

        /* Bổ sung mã lệnh để in xâu tương ứng trả về bởi toString() của mỗi đối tượng
            chú ý phương thức cần thực hiện được với cả SavingsAccount và CheckingAccount
            và thông tin tương ứng cho mỗi trường hợp */
    	for(BankAccount i: listAccount) {
    		System.out.println(i.toString());
    	}
    }

    public static ArrayList<BankAccount> listOfSavingsAccount(ArrayList<BankAccount> listAccount){
        ArrayList<BankAccount> listSavingsAccount = new  ArrayList<BankAccount>();
        // Bổ sung mã lệnh để tách các SavingsAccount từ listAccount ra thành một ArrayList riêng 
        for(BankAccount i: listAccount) {
        	if(i.getClass().getName().equals("SavingsAccount")) {
        		listSavingsAccount.add(i);
        	}
        }
        return listSavingsAccount;
    }

    public static ArrayList<BankAccount> listOfCheckingAccount(ArrayList<BankAccount> listAccount){
        ArrayList<BankAccount> listCheckingAccount = new  ArrayList<BankAccount>();
        // Bổ sung mã lệnh để tách các CheckingAccount từ listAccount ra thành một ArrayList riêng 
        for(BankAccount i: listAccount) {
        	if(i.getClass().getName().equals("CheckingAccount")) {
        		listCheckingAccount.add(i);
        	}
        }
        return listCheckingAccount;
    }

    public static void sortByBalance(ArrayList<BankAccount> listAccount){
        // Bổ sung mã lệnh để sắp xếp listAccount theo thứ tự tăng dần của balance
    	int n = listAccount.size();
    	for(int i = 0; i < n; i++) {
    		for(int j = i + 1; j < n; j++) {
    			if(listAccount.get(i).getBalance() > listAccount.get(j).getBalance()) {
    				BankAccount temp = listAccount.get(i);
    				listAccount.set(i, listAccount.get(j));
    				listAccount.set(j, temp);
    			}
    		}
    	}
    }

    public static void saveToFile(ArrayList<BankAccount> listAccount, String fileName){

        try{
            
            /* Bổ sung mã lệnh để mở tệp fileName và ghi thông tin các Account trong listAccount vào tệp
                Thông tin được ghi trên từng dòng cho mỗi trường theo thứ tự: accountNumber, firstName, lastName, 
                balance (2 chữ số phần thập phân), sau đó nếu là SavingsAccount thì thêm interestRate, ngược lại 
                thêm transactionCount.
               + Mẫu thông tin ghi cho SavingsAccount cần tương đương với:
                    format("%s%n%s %s%n%.2f%n%.3f%n", accountNumber, firstName, lastName, balance, interestRate);
                
               + Mẫu thông tin ghi cho CheckingAccount cần tương đương với:
                    format("%s%n%s %s%n%.2f%n%d%n", accountNumber, firstName, lastName, balance,transactionCount);*/
//        	File outfile = new File(fileName);
//        	FileOutputStream fos = new FileOutputStream(outfile);
        	PrintStream out = new PrintStream(fileName);
        	System.setOut(out);        	
//        	for(BankAccount i:listAccount) {
//        		i.toFile();
        	Formatter f = new Formatter(fileName);
            for(BankAccount acc: listAccount){
                if(acc.getClass().getName().equals("SavingsAccount")){
                    SavingsAccount account = (SavingsAccount) acc;
                    f.format("%s%n%s %s%n%.2f%n%.3f%n", account.getAccountNumber(), account.getFirstName(),account.getLastName(),account.getBalance(),account.getInterestRate());
                } else if(acc.getClass().getName().equals("CheckingAccount")){
                    CheckingAccount account1 = (CheckingAccount) acc;
                    f.format("%s%n%s %s%n%.2f%n%d%n", account1.getAccountNumber(), account1.getFirstName(),account1.getLastName(),account1.getBalance(),account1.getTransactionCount());
                }            
            	
        	}
            f.close();
        } catch(IOException e){
            // In ra thông báo: "Cannot access file " + fileName + " to write!\n" + e.getMessage()
        	System.out.println("Cannot access file " + fileName + " to write!\n" + e.getMessage());
        }
    }

    public static ArrayList<BankAccount> filterByBalance(ArrayList<BankAccount> listAccount,
                                                            double upperBound, double lowerBound){
        ArrayList<BankAccount> results  = new ArrayList<BankAccount>();

        // Bổ sung mã lệnh để trả về danh sách các account có balance lớn hơn hoặc bằng
        // lowerBound và nhỏ hơn hoặc bằng upperBound (gồm cả 2 loại account)
        for(BankAccount i : listAccount) {
        	if(i.getBalance() >= lowerBound && i.getBalance() <= upperBound) {
        		results.add(i);
        	}
        }
        return results;
    }

    public static BankAccount searchByAccountNumber(ArrayList<BankAccount> listAccount, String accountNum){
        BankAccount result  = null;

        // Bổ sung mã lệnh để tìm và trả về đối tượng trong danh sách listAccount có accountNumber trùng với accountNum.
        // Nếu không có trả về null.
        for(BankAccount i:listAccount) {
        	if(i.getAccountNumber().equals(accountNum)) {
        		result = i;
        	}
        }
        return result;
    }

    public static void main(String args[]){
            ArrayList<BankAccount> listAccount = readData("data.txt");
            // Không cần thay đổi phương thức main()!
            saveToFile(listAccount, "out.txt");
     }
}
