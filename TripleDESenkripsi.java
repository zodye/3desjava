package _tgsKSJ;

import java.util.Scanner;
import _tgsKSJ.TripleDES;

public class TripleDESenkripsi {
	public static void main (String[] args) {
		System.out.print("Masukkan teks: ");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		String enc1,enc2,enc3;
		
		System.out.print("Kunci 1: ");
		String inKey = in.nextLine();
		System.out.print("Kunci 2: ");
		String inKey2 = in.nextLine();
		System.out.print("Kunci 3: ");
		String inKey3 = in.nextLine();
		in.close();
		try{
			TripleDES tes1 = new TripleDES(inKey);
			enc1=tes1.encrypt(input);
			TripleDES tes2 = new TripleDES(inKey2);
			enc2=tes2.encrypt(enc1);
			TripleDES tes3 = new TripleDES(inKey3);
			enc3=tes3.encrypt(enc2);
			System.out.println("Hasil enkripsi: "+enc3);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
