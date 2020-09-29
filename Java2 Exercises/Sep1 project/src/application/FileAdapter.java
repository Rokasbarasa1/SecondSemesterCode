package application;


import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;

public class FileAdapter {

	private String fileName;
	private FileIO fileIO;
	private Player players;

	public FileAdapter(String fileName) {
		fileIO = new FileIO();
		this.fileName = fileName;
	}

	public Player getAllPlayers() {
		try {
			players = (Player) fileIO.readObjectFromFile(fileName);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "The file player.bin is not found", "Red card",
					JOptionPane.ERROR_MESSAGE);
			System.out.println("File not found");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "The progran can not read the file: player.bin", "Red card",
					JOptionPane.ERROR_MESSAGE);
			System.out.println("IO Error reading file");
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null,
					"Somthing is missing, try to reinstall the program!\n\nSee the userguide to avoid loosing data",
					"Red card", JOptionPane.ERROR_MESSAGE);
			System.out.println("Class Not Found");
		}
		return players;
	}

	public MatchList getAllMatches() {

		MatchList matchList = new MatchList();

		try {
			matchList = (MatchList) fileIO.readObjectFromFile(fileName);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "The file match.bin is not found", "Red card",
					JOptionPane.ERROR_MESSAGE);
			System.out.println("File not found");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "The progran can not read the file: match.bin", "Red card",
					JOptionPane.ERROR_MESSAGE);
			System.out.println("IO Error reading file");
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null,
					"Somthing is missing, try to reinstall the program!\n\nSee the userguide to avoid loosing data",
					"Red card", JOptionPane.ERROR_MESSAGE);
			System.out.println("Class Not Found");
		}
		return matchList;
	}

	/**
	 * Methode for retrieving a formation object with all formations, with a
	 * messagebox in case of an error
	 * 
	 * @return
	 */
	public Formation getAllFormations() {
		Formation formation = new Formation(fileName);

		try {
			formation = (Formation) fileIO.readObjectFromFile(fileName);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "The file formations.bin is not found", "Red card",
					JOptionPane.ERROR_MESSAGE);
			System.out.println("File not found");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "The progran can not read the file: formations.bin", "Red card",
					JOptionPane.ERROR_MESSAGE);
			System.out.println("IO Error reading file");
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null,
					"Somthing is missing, try to reinstall the program!\n\nSee the userguide to avoid loosing data.",
					"Red card", JOptionPane.ERROR_MESSAGE);
			System.out.println("Class Not Found");
		}

		return formation;
	}

	/**
	 * Methode for saving all player objects in a file, with a messagebox in case of
	 * an error
	 * 
	 * @param players
	 */
	public void savePlayers(Player players) {
		try {
			fileIO.writeToFile(fileName, players);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "The file: players.bin is not found", "Red card",
					JOptionPane.ERROR_MESSAGE);
			System.out.println("File not found");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Somthing went wrong writing to the file", "Red card",
					JOptionPane.ERROR_MESSAGE);
			System.out.println("IO Error writing to file");
		}
	}

	/**
	 * Methode for saving all match objects in a file, with a messagebox in case of
	 * an error
	 * 
	 * @param matches
	 */
	public void saveMatches(Match matches) {
		try {
			fileIO.writeToFile(fileName, matches);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "The file: matches.bin is not found", "Red card",
					JOptionPane.ERROR_MESSAGE);
			System.out.println("File not found");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Somthing went wrong writing to the file", "Red card",
					JOptionPane.ERROR_MESSAGE);
			System.out.println("IO Error writing to file");
		}
	}

	/**
	 * Methode for saving all formation objects in a file, with a messagebox in case
	 * of an error
	 * 
	 * @param formations
	 */
	public void saveFormations(Formation formations) {
		try {
			fileIO.writeToFile(fileName, formations);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "The file: formations.bin is not found", "Red card",
					JOptionPane.ERROR_MESSAGE);
			System.out.println("File not found");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Somthing went wrong writing to the file", "Red card",
					JOptionPane.ERROR_MESSAGE);
			System.out.println("IO Error writing to file");
		}
	}
}