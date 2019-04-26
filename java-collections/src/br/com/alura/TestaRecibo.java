package br.com.alura;

import java.util.Comparator;
import java.util.TreeSet;

public class TestaRecibo {

	public static void main(String[] args) {
		
		Receipt2 rec01 = new Receipt2(1,100.58);
		Receipt2 rec02 = new Receipt2(2,12.50);
		Receipt2 rec03 = new Receipt2(3,4.01);
		
		Comparator<Receipt2> comparator = new Comparator<Receipt2>(){
			@Override
			public int compare(Receipt2 rec1, Receipt2 rec2) {
				//return rec1.getValue().compareTo(rec2.getValue());
				return rec1.getNumber().compareTo(rec2.getNumber());
			}
		};
		
		TreeSet<Receipt2> receipts = new TreeSet<>(comparator);
		
		receipts.add(rec02);
		receipts.add(rec03);
		receipts.add(rec01);
		
		System.out.println(receipts);
	}

}
