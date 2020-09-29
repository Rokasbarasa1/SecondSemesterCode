package application;

/**
 * An edited version of the LoadInitialData class from SDJ1 session 25
 */

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadInitialData {

	public static void main(String[] args) {

		/**
		 * initialize players from a spicific file into system memory when starting the program
		 */
		try {
			FileInputStream fileIn = new FileInputStream("players.bin");
			ObjectInputStream read = new ObjectInputStream(fileIn);
			while (true) {
				try {
					Player player = (Player) read.readObject();
					System.out.println(player);

				} catch (EOFException eof) {
					System.out.println("End of file");
					break;
				}
			}
			read.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found, or could not be opened");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("IO Error reading file");
			System.exit(1);
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found");
			System.exit(1);
		}

		/**
		 * initialize matches from a spicific file into system memory when starting the program
		 */
		try {
			FileInputStream fileIn = new FileInputStream("matches.bin");
			ObjectInputStream read = new ObjectInputStream(fileIn);
			while (true) {
				try {
					Match matches = (Match) read.readObject();
					System.out.println(matches);

				} catch (EOFException eof) {
					System.out.println("End of file");
					break;
				}
			}
			read.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found, or could not be opened");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("IO Error reading file");
			System.exit(1);
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found");
			System.exit(1);
		}

		/**
		 * initialize formations from a spicific file into system memory when starting the program
		 */
		try {
			FileInputStream fileIn = new FileInputStream("formations.bin");
			ObjectInputStream read = new ObjectInputStream(fileIn);
			while (true) {
				try {
					Formation formations = (Formation) read.readObject();
					System.out.println(formations);

				} catch (EOFException eof) {
					System.out.println("End of file");
					break;
				}
			}
			read.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found, or could not be opened");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("IO Error reading file");
			System.exit(1);
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found");
			System.exit(1);
		}
	}

}
