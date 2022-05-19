public class TextBook extends Book {

	private boolean status;
    
    public TextBook(String id, String name, int quantity, String publisher, double price) {
    }
    
	public TextBook(String id, String name, int quantity, String publisher, double price, boolean status) {
        super(id ,name, quantity, publisher, price);
        this.status = status;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
    /*
    Đối với sách giáo khoa: 
    nếu tình trạng sách mới thì thành tiền = đơn giá * số lượng.
     Nếu tình trạng sách cũ thì thành tiền = đơn giá* số lượng* 50%
     */

	@Override
	public double getAmount() {
		// TODO Auto-generated method stub
		return (status == true) ? getPrice() * getQuantity() : getPrice() * getQuantity() * 0.5;
	}

	@Override
	public String toString() {
		return "TextBook [status=" + status + ", getId()=" + getId() + ", getName()=" + getName() + ", getQuantity()="
				+ getQuantity() + ", getPublisher()=" + getPublisher() + ", getPrice()=" + getPrice() + ", getAmount()="
				+ getAmount() + "]";
	}	 	  	 		 	    	  	     	 	
}
