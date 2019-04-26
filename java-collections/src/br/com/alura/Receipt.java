package br.com.alura;

public class Receipt implements Comparable<Receipt> {
	private Integer number;
	private Double value;
	
	public Integer getNumber() {
		return number;
	}
	public Double getValue() {
		return value;
	}
	
	public Receipt(int num, double val) {
		this.number = num;
		this.value = val;
	}
	/**
	 *  Compares its two arguments for order.
	 * @return Returns a negative integer if the first argument is less than the second. 
	 * Or if the first argument is equal to the second returns zero. 
	 * Or returns a positive integer if the first argument is greater than the second. 
	 */
	@Override
	public int compareTo(Receipt rec) {
		//return number.compareTo(rec.getNumber());
		return value.compareTo(rec.getValue());
	}
	
	@Override
	public String toString() {
		return String.format("[Receipt number %d, valor: %.1f]", number, value);		
	}

	
}
