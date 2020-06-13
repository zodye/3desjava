package _tgsKSJ;

import java.util.Scanner;
import _tgsKSJ.TripleDES;

public class TripleDESdekripsi {
	public static void main (String[] args) {
		System.out.print("Masukkan cipher: ");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		String dec1,dec2,dec3;
		
		System.out.print("Kunci 1: ");
		String inKey = in.nextLine();
		System.out.print("Kunci 2: ");
		String inKey2 = in.nextLine();
		System.out.print("Kunci 3: ");
		String inKey3 = in.nextLine();
		in.close();
		try{
			TripleDES tes = new TripleDES(inKey3);
			dec1=tes.decrypt(input);
			TripleDES tes2 = new TripleDES(inKey2);
			dec2=tes2.decrypt(dec1);
			TripleDES tes3 = new TripleDES(inKey);
			dec3=tes3.decrypt(dec2);
			System.out.println("Hasil dekripsi: "+dec3);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
