package org.openjfx.hellofx;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class FileReader {

	public static LinkedHashMap<String, ArrayList<String>> read(File file) throws FileNotFoundException, IOException {

		// Get the extension of the file
		String extension = getExtension(file.getAbsolutePath()).get();
		System.out.println(extension);

		LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<String, ArrayList<String>>();

		switch (extension) {
			case "csv":
				map = readCSV(file);
				break;
			case "json":
				break;
			// case "xml":
			// 	break;
			default:
				System.out.println("Filetype not supported");
				break;

		}
		return map;
	}

	// Source: https://www.baeldung.com/java-file-extension
	public static Optional<String> getExtension(String filename) {
		return Optional.ofNullable(filename)
				.filter(f -> f.contains("."))
				.map(f -> f.substring(filename.lastIndexOf(".") + 1));
	}

	/**
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static LinkedHashMap<String, ArrayList<String>> readCSV(File file)
			throws FileNotFoundException, IOException {

		// Create map with an associated list for each label
		LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<String, ArrayList<String>>();

		try (Scanner scanner = new Scanner(file)) {

			// Get the first line, initialize a key for each label and pair it with a new
			// list.
			String[] labels = scanner.nextLine().split(",");

			for (String label : labels) {
				map.put(label, new ArrayList<String>());
			}

			// Populate the lists in the map with column values.
			while (scanner.hasNextLine()) {

				String[] columns = scanner.nextLine().split(",");

				// For each entry(list) in the map, add the column
				int i = 0;
				for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
					// Get lists from map, add a column-value to each.
					try {
						entry.getValue().add(columns[i]);
					} catch (ArrayIndexOutOfBoundsException e) {
						entry.getValue().add("");
					}
					i++;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
}
