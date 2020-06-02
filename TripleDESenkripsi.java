package _tgsKSJ;

import java.util.Scanner;
import _tgsKSJ.TripleDES;

public class TripleDESenkripsi {
	public static void main (String[] args) {
		System.out.print("Masukkan teks: ");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		
		System.out.print("Kunci: ");
		String inKey = in.nextLine();
		in.close();
		TripleDES tes = new TripleDES(inKey);
		try{
			System.out.println("Hasil: "+tes.harden(input));
		}catch(Exception e) {
			
		}
	}
}
