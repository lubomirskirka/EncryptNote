/**
 * This class offers the programmer a high-level approach to saving
 * small data. This class addresses the problem of saving non-volatile
 * data for use after the program quits. Data is saved to a file in
 * the file system. 
 * MSave provides simple high-level methods for reading and writing
 * lines to a file.
 * 
 * @name MSave.java
 * @version 1.0
 * @date 21. March 2015
 * @autor Ing. Martin Risko
 */
package risko;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class MSave {

	private File file;

	/**
	 * Creates an MSave instance with a specified fileName.
	 * 
	 * @param fileName
	 *            Name of the file with which MSave will work.
	 */
	public MSave(String fileName) {
		file = new File(fileName);
	}

	/**
	 * Tests whether the file exists.
	 * 
	 * @return true if the file exits, false otherwise
	 */
	public boolean exists() {
		return file.exists();
	}

	/**
	 * Creates the file with the file name specified in the constructor call.
	 * The path for the file will be the same as the path for the project source
	 * code.
	 */
	public void createFile() {
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deletes the file.
	 */
	public void deleteFile() {
		file.delete();
	}

	/**
	 * Writes String data to a line in the file.
	 * 
	 * @param lineNumber
	 *            The line number at which to write the data.
	 * @param data
	 *            Data to be written at the specified line.
	 */
	public void write(int lineNumber, String data) {
		List<String> lines = null;
		try {
			lines = Files.readAllLines(file.toPath());
			verifyCapacity(lines, lineNumber + 1);
			lines.set(lineNumber, data);
			Files.write(file.toPath(), lines);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Writes String data to a specific line in the file.
	 * 
	 * @param lineNumber
	 *            The line number from where to read the data.
	 * @return Data read from the specified line number.
	 */
	public String read(int lineNumber) {
		List<String> lines = null;
		try {
			lines = Files.readAllLines(file.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines.get(lineNumber);
	}

	/**
	 * Returns the number of lines in the file.
	 * 
	 * @return The number of lines in the file.
	 */
	public int fileLength() {
		List<String> lines = null;
		try {
			lines = Files.readAllLines(file.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines.size();
	}

	/**
	 * Private MSave class method for ensuring a certain List<String> capacity.
	 * 
	 * @param list
	 *            The List<String> to be checked/updated
	 * @param capacity
	 *            The requested List<String> capacity to be ensured.
	 */
	private static void verifyCapacity(List<String> list, int capacity) {
		if (list.size() < capacity)
			for (int i = list.size(); i < capacity; i++)
				list.add("");
	}
}
