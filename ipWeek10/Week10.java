package ipWeek10;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

class week10 {
	
	static boolean	existsInFile(String fileName, String word) {
		try {
			Scanner scanner = new Scanner(new File(fileName));
			while (scanner.hasNext()) {
				if (scanner.next().equals(word)) {
					scanner.close();
					return true;
				}
			}
			scanner.close();
			return false;
		} catch (FileNotFoundException e) {
			return false;
		}
	}
	
	static void	writeRandomInts(String fileName, int n, int min, int max) {
		try {
			PrintWriter writer = new PrintWriter(new File(fileName));
			for (int i = 0; i < n; i++) {
				writer.println(min + (int)(Math.random() * (max - min + 1)));
			}
			writer.close();
		} catch (FileNotFoundException e) {
			return ;
		}
	}
	
	static boolean[][] readBooleanMatrix(String fileName) {
		try {
			Scanner scanner = new Scanner(new File(fileName));
			int row = scanner.nextInt();
			int col = scanner.nextInt();
			boolean[][] array = new boolean[row][col];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					String bool = scanner.next();
					array[i][j] = bool.equals("T");
				}
			}
			scanner.close();
			return array;
		} catch (FileNotFoundException e) {
			return null;
		}
	}
	
	static String boolToString(boolean[][] array) {
		String s = "{";
		for (int i = 0; i < array.length; i++) {
			s += "{";
			int j = 0;
			while ( j < array[i].length - 1) {
				s += array[i][j];
				s += ", ";
				j++;
			}
			s += array[i][j];
			s += "}";
		}
		s += "}";
		return s;
	}
	
	static void writeBool(String fileName, boolean[][] array) {
		try {
			PrintWriter writer = new PrintWriter(new File(fileName));
			writer.println(array.length);
			writer.println(array[0].length);
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array[0].length; j++) {
					writer.println(array[i][j] == true ? "T" : "F");
				}
			}
			writer.close();
		} catch (FileNotFoundException e) {
			return ;
		}
	}
	
	static String vlookup(String fileName, String s, int index) {
		try {
			Scanner scanner = new Scanner(new File(fileName));
			while(scanner.hasNext()) {
				String line = scanner.nextLine();
				if (line.contains(s)) {
					String[] array = line.split(" ");
					scanner.close();
					return array[index];
				}
			}
			scanner.close();
			return null;
		} catch (FileNotFoundException e) {
			return null;
		}
	}
	
	static void filter(String filesrc, int linestart, int linefinish, String filedest) {
		try {
			Scanner scanner = new Scanner(new File(filesrc));
			PrintWriter writer = new PrintWriter(new File(filedest));
			int counter = 0;
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				if (counter >= linestart && counter <= linefinish) {
					writer.println(line);
				}
				counter++;
			}
			scanner.close();
			writer.close();
		} catch (FileNotFoundException e) {
			return ;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("'li' exists in word: " + existsInFile("test1.txt", "li"));
		System.out.println("'la' exists in word: " + existsInFile("test1.txt", "la"));
		writeRandomInts("test2.txt", 5, 50, 100);
		System.out.println(boolToString(readBooleanMatrix("test3.txt")));
		boolean[][] boolarray = {{true, false}, {true, false}, {true, false}};
		writeBool("test4.txt", boolarray);
		System.out.println("Nota final: " + vlookup("pauta.dat", "24642", 3));
		System.out.println("Nota projeto: " + vlookup("pauta.dat", "55555", 2));
		System.out.println("Nota teste: " + vlookup("pauta.dat", "19822", 1));
		filter("pauta.dat", 1, 2, "teste.dat");
	}
}