import java.util.Scanner;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Abiturient {

	public static void main(String[] args) throws IOException {
		Scanner input =  new Scanner(System.in);
		File list = new File ("Abiturient_ANSI.txt");
		FileReader fr = new FileReader(list);
		BufferedReader reader = new BufferedReader(fr);
		String line = reader.readLine();
		String s;
		line = reader.readLine();
		int n = Integer.parseInt(line);
		System.out.println(n);
		
		String [] fam = new String[n]; 
		String [] nam = new String[n];
		String [] fath = new String[n];
		String [] adress = new String[n];
		long [] id = new long[n];
		String [] numberph = new String[n];
		int [][] number = new int[n][10];
		int[] sum = new int[n];
		boolean[] bol = new boolean[n];
		for (int i = 0; i <= (n - 1); i++) {
			fam[i] = reader.readLine();
			System.out.print(fam[i]);
			System.out.print(' ');
			nam[i] = reader.readLine();
			System.out.print(nam[i]);
			System.out.print(' ');
			fath[i] = reader.readLine();
			System.out.print(fath[i]);
			System.out.print(' ');
			adress[i] = reader.readLine();
			System.out.print(adress[i]);
			System.out.print(' ');
			id[i] = Long.parseLong(reader.readLine());
			System.out.print(id[i]);
			System.out.print(' ');
			numberph[i] = reader.readLine();
			System.out.print(numberph[i]);
			System.out.print(' ');
			s = reader.readLine();
			bol[i] = false;
			sum[i] = 0;
			for (int m = 0; m<=9; m++) {
				number[i][m] = (int) s.charAt(m) - 48;
				System.out.print(number[i][m]);
				System.out.print(' ');
				sum[i] += number[i][m];
			}
			System.out.println();
			
		}
		System.out.println();
		System.out.println("Двоечники");
		Stud st = new Stud(n,number,bol,nam,fam);
		System.out.println();
		Stud st2 = new Stud(sum, n, nam, fam);
	}

}


class Stud{
	private String fam[], nam[], fath[], adress[], numberph[];
	private int id[], number[][];
	private boolean bol[];
	
	public String getFam() {
		return fam[1];
	}
	
	public String setFam(String a) {
		fam[1] = a;
		return a;
	}
	
	Stud(int n,int number[][], boolean bol[], String nam[], String fam[]){
		for (int i = 0; i < n; i++) {
			for (int m = 0; m < 9; m++) {
				if (number[i][m] == 2) {
					bol[i] = true;
					System.out.print(nam[i]);
					System.out.print(' ');
					System.out.print(fam[i]);
					System.out.println();
					break;
					
				}
			}
		}
	}
	
	Stud(int[] sum, int n, String fam[], String nam[]){
		System.out.println("Введите порог баллов");
		Scanner input =  new Scanner(System.in);
		int g = input.nextInt();
		System.out.println();
		System.out.println("Студенты с заданным порогом баллов");
		System.out.println();
		for (int i = 0; i < n; i++) {
			if (sum[i] > g) {
				System.out.print(nam[i]);
				System.out.print(' ');
				System.out.print(fam[i]);
				System.out.println();
			}
		}
	}
	
}