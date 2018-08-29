package hw1.util;

import hw1.*;
import java.util.*;
import java.io.*;


public class CSV {

	public static ArrayList<String[]> load(String name) {
		ArrayList<String[]> database = new ArrayList<String[]>();
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		try
		{
			fileReader = new FileReader("hw1/util/" + name);
			bufferedReader = new BufferedReader(fileReader);
			String string = new String();
			String[] contents ;
			while (true) {
				string = bufferedReader.readLine();
				if(string == null)
					break;
				contents = string.split(",");
				database.add(contents);
			}
			return database;
		} catch (Exception e) { 
			System.out.println(e + " in load method in CSV.java");
			return null;
		}
	}

	public static void store(String name, ArrayList<String[]> database) {
		try {
				PrintWriter printWriter = new PrintWriter("hw1/util/" + name, "UTF-8");
				String[] temp;
				ListIterator iterator = database.listIterator();
				while (iterator.hasNext()) {
					temp = (String[])iterator.next();
					int i;
					for (i = 0; i<temp.length-1; i++) {
						printWriter.print((temp[i] + ","));
					}
					printWriter.print(temp[temp.length-1]);
					printWriter.print("\n");
				}
				printWriter.close();
			} catch (Exception e) {
				System.out.println(e + " in store method in CSV.java");
			}
	}
}