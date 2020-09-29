package application;

/**
 * An edited version of the FileIO class from SDJ1 session 25
 */

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FileIO {

	/**
	 * Methode for writing an object a specific file, with exceptions
	 * 
	 * @param fileName
	 * @param obj
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void writeToFile(String fileName, Object obj) throws FileNotFoundException, IOException {
		ObjectOutputStream writeToFile = null;
		try {
			FileOutputStream fileOutStream = new FileOutputStream(fileName);
			writeToFile = new ObjectOutputStream(fileOutStream);
			writeToFile.writeObject(obj);
		} finally {
			if (writeToFile != null) {
				try {
					writeToFile.close();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Somthing went wrong in writng to" + fileName, "Red card",
							JOptionPane.ERROR_MESSAGE);
					System.out.println("IO Error closing file " + fileName);
				}
			}
		}
	}

	/**
	 * Methode for writing objects to a array in a specific file, with exceptions
	 * 
	 * @param fileName
	 * @param objs
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void writeToFile(String fileName, Object[] objs) throws FileNotFoundException, IOException {
		ObjectOutputStream writeToFile = null;

		try {
			FileOutputStream fileOutStream = new FileOutputStream(fileName);
			writeToFile = new ObjectOutputStream(fileOutStream);

			for (int i = 0; i < objs.length; i++) {
				writeToFile.writeObject(objs[i]);
			}
		} finally {
			if (writeToFile != null) {
				try {
					writeToFile.close();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Somthing went wrong in writng to" + fileName, "Red card",
							JOptionPane.ERROR_MESSAGE);
					System.out.println("IO Error closing file " + fileName);
				}
			}
		}
	}

	/**
	 * Methode for reading an object from a specific file, with exceptions
	 * 
	 * @param fileName
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Object readObjectFromFile(String fileName)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		Object obj = null;
		ObjectInputStream readFromFile = null;
		try {
			FileInputStream fileInStream = new FileInputStream(fileName);
			readFromFile = new ObjectInputStream(fileInStream);
			try {
				obj = readFromFile.readObject();
			} catch (EOFException eof) {
			}
		} finally {
			if (readFromFile != null) {
				try {
					readFromFile.close();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Somthing went wrong in writng to" + fileName, "Red card",
							JOptionPane.ERROR_MESSAGE);
					System.out.println("IO Error closing file " + fileName);
				}
			}
		}
		return obj;
	}

	/**
	 * Methode for read from objects from an array in a specific file, with
	 * exceptions
	 * 
	 * @param fileName
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Object[] readArrayFromFile(String fileName)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<Object> objs = new ArrayList<Object>();

		ObjectInputStream readFromFile = null;
		try {
			FileInputStream fileInStream = new FileInputStream(fileName);
			readFromFile = new ObjectInputStream(fileInStream);
			while (true) {
				try {
					objs.add(readFromFile.readObject());
				} catch (EOFException eof) {
					// Done reading
					break;
				}
			}
		} finally {
			if (readFromFile != null) {
				try {
					readFromFile.close();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Somthing went wrong in writng to" + fileName, "Red card",
							JOptionPane.ERROR_MESSAGE);
					System.out.println("IO Error closing file " + fileName);
				}
			}
		}
		return objs.toArray();
	}

}
