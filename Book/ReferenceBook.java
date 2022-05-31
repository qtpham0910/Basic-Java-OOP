
	public class ReferenceBook extends Book{
	private double tax;
	public ReferenceBook(String id, String name, int quantity, String publisher, double price) {
		
		// TODO Auto-generated constructor stub
	}
	
	public ReferenceBook(String id, String name, int quantity, String publisher, double price,
			double tax) {
	
	}

	@Override
	public double getAmount() {
		// TODO Auto-generated method stub
	}

	@Override
	public String toString() {
		return "ReferenceBook [tax=" + tax + ", getId()=" + getId() + ", getName()=" + getName() + ", getQuantity()="
				+ getQuantity() + ", getPublisher()=" + getPublisher() + ", getPrice()=" + getPrice()+ ", getAmount()=" + getAmount() +  "]";
	}
