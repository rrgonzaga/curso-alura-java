package br.com.alura;

public class Receipt2 {
	private Integer number;
	private Double value;
	
	public Integer getNumber() {
		return number;
	}
	public Double getValue() {
		return value;
	}
	
	public Receipt2(int num, double val) {
		this.number = num;
		this.value = val;
	}
	
	@Override
	public String toString() {
		return String.format("[Receipt number %d, valor: %.1f]", number, value);		
	}

	
}
