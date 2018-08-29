package hw1;

import hw1.util.*;
import java.util.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//import org.apache.commons.validator.DateValidator;

public class Database {
	private static String outputFile;
	private static String inputFile;

	Database(String inputFile, String outputFile)
	{
		this.inputFile = inputFile;
		this.outputFile = outputFile;
	}

	ArrayList<String[]> database;
	int num_entry;

	Database() {
		this.database = new ArrayList<String[]>();
		num_entry = 0;
	}

	public static boolean isValidDate(String inDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    	dateFormat.setLenient(false);
    	try {
      		dateFormat.parse(inDate.trim());
    	} catch (ParseException pe) {
      		return false;
    	}
    		return true;
	}

	public static void printStringArr(String[] stringArr) {
		try {
			System.out.print("#");
			for (int i=0; i<stringArr.length; i++)
				System.out.print(stringArr[i] + "|");

			System.out.println("#");
		} catch (Exception e) {
			System.out.println(e + " in printStringArr method");
		}
	}

	// public static boolean dateVailidator (String date) {
	// 	datevailidator = new DateValidator();
	// 	return datevailidator.isValid(date,"MM/dd/yyyy",true);
	// }

	/* LOAD */
	public void load(String name) {
		try {
			PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(this.outputFile), true));
			File f = new File(name);

			if(!f.exists()) { 
    				printWriter.append("LOAD: ERROR FILE_NOT_FOUND\n");
    				printWriter.close();
    				return;
			}

			System.out.println(name);
			this.database = CSV.load(name);
			this.num_entry = this.database.size();
			printWriter.append("LOAD: OK " + this.num_entry + "\n");
			printWriter.close();
		} catch (Exception e) {
			System.out.println(e + " in load method in Database.java");
		}
	}

	public void clear() {
		try {
			PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(outputFile), true));
			this.database = new ArrayList<String[]>();
			num_entry = 0;
			printWriter.append("CLEAR: OK\n");
			printWriter.close();
		} catch (Exception e) {
			System.out.println(e + " in clear method");
		}
	}

	public void add(String[] data, boolean quotation1, boolean quotation2) {
		try {
			PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(outputFile), true));

			/* DUPBLICATE ERROR HANDLING */
			if (internalSearch(data[1],data[2]) != -1) {
				printWriter.append("ADD: ERROR DUPLICATE_ENTRY\n");
				printWriter.close();
				return;
			}

			if (!data[3].equals("true") && !data[3].equals("false")) {
				printWriter.append("ADD: ERROR NOT_BOOL\n");
				printWriter.close();
				return;
			}

			if (!Database.isValidDate(data[0])) {
				printWriter.append("ADD: ERROR INVALID_DATE\n");
				printWriter.close();
				return;
			}

			this.database.add(data);
			this.num_entry = this.database.size();

			printWriter.append("ADD: OK ");
			if (quotation1)
				printWriter.append("\"");

			printWriter.append(data[1]);

			if (quotation1)
				printWriter.append("\"");

			printWriter.append(" ");

			if (quotation2)
				printWriter.append("\"");

			printWriter.append(data[2]);

			if (quotation2)
				printWriter.append("\"");

			printWriter.append("\n");

			printWriter.close();
		} catch (Exception e) {
			System.out.println(e + " in add method in Database.java");
		}
	}

	public void store(String name) {
		try {
			PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(outputFile), true));
			CSV.store(name,this.database);
			printWriter.append("STORE: OK " + this.num_entry + "\n");
			printWriter.close();

		} catch (Exception e) {
			System.out.println(e + "in store method in Database.java");
		}
	}

	public void status() {
		String[] temp;
		int count = 0;
		try {
			PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(outputFile), true));
			ListIterator iterator = this.database.listIterator();
			while (iterator.hasNext()) {
				temp = (String[])iterator.next();
				printWriter.append(temp[1] + "," + temp[2] + "," + temp[0] + "\n");
				count++;
			}
			printWriter.append("STATUS: OK " + count + "\n");
			printWriter.close();
		} catch (Exception e) {
			System.out.println(e + " in show method");
		}
	}	

	public void search(String data) {
		String[] temp;
		int count = 0;
		try {
			PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(outputFile), true));
			ListIterator iterator = this.database.listIterator();
			while (iterator.hasNext()) {
				temp = (String[])iterator.next();
				if (temp[1].contains(data) || temp[2].contains(data)) {
					count++;
				}
			}
			printWriter.append("SEARCH: OK " + count + "\n");
			iterator = this.database.listIterator();
			while (iterator.hasNext()) {
				temp = (String[])iterator.next();
				if (temp[1].contains(data) || temp[2].contains(data)) {
					printWriter.append(temp[1] + "," + temp[2] + "," + temp[0] + "," + temp[3] + "\n");
				}
			}	
			printWriter.close();
		} catch (Exception e) {
			System.out.println(e + " in search method");
		}
	}

	public int internalSearch (String title, String director) {
		try {
			String[] temp;
			ListIterator iterator = this.database.listIterator();
			while (iterator.hasNext()) {
				temp = (String[])iterator.next();
				if (temp[1].equals(title) && temp[2].equals(director)) {
					return this.database.indexOf(temp);
				}
			}

			return -1;
		} catch (Exception e) {
			System.out.println(e + " in internalSearch method");
			return -2;
		}
	}

/*
	String[] data's form = {"Third argument of commend. (EX. true or 01/01/2016)","Title","Director"}
*/
	public void update(String[] data, boolean quotation1, boolean quotation2) 
	{
		try {
			PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(outputFile), true));
			/* update old {Title, Director} to new {Title, Director} */
			if (!data[2].equals("true") && !data[2].equals("false") && !data[2].contains("/")) {
				//System.out.println("gotcha");
				int offset = internalSearch(data[0], data[1]);

				if (offset == -1) {
					printWriter.append("UPDATE: ERROR FILM_NOT_FOUND\n");
					printWriter.close();
					return;
				}
				//Database.printStringArr(data);

				/* DUPBLICATE ERROR HANDLING */
				if (internalSearch(data[2],data[3]) != -1) {
					printWriter.append("UPDATE: ERROR DUPLICATE_ENTRY\n");
					printWriter.close();
					return;
				}


				String[] temp = (String[])this.database.get(offset);

				temp[1] = data[2];
				temp[2] = data[3];

				printWriter.append("UPDATE : OK ");
				if (data[2].contains(" "))
					printWriter.append("\"");

				printWriter.append(data[2]);

				if (data[2].contains(" "))
					printWriter.append("\"");

				printWriter.append(" ");

				if (data[3].contains(" "))
					printWriter.append("\"");

				printWriter.append(data[3]);

				if (data[3].contains(" "))
					printWriter.append("\"");

				printWriter.append("\n");

			} else {


				// System.out.println("gotcha222");
				int offset = internalSearch(data[0], data[1]);
				if (offset == -1) {
					printWriter.append("UPDATE: ERROR FILM_NOT_FOUND\n");
					printWriter.close();
					return;
				}
				// System.out.println(offset);
				String[] temp = (String[])this.database.get(offset);
				if (data[2].equals("true") || data[2].equals("false")) {
					temp[3] = data[2];
				} else if (Database.isValidDate(data[2])) {
					temp[0] = data[2];
				} 
				/* ERROR HANDLING */
				else {
					printWriter.append("UPDATE: INVALID_DATE_OR_BOOL\n");
					printWriter.close();
					return;
				}

				printWriter.append("UPDATE : OK ");
				if (quotation1)
					printWriter.append("\"");

				printWriter.append(data[0]);

				if (quotation1)
					printWriter.append("\"");

				printWriter.append(" ");

				if (quotation2)
					printWriter.append("\"");

				printWriter.append(data[1]);

				if (quotation2)
					printWriter.append("\"");

				printWriter.append("\n");
				
			}
			printWriter.close();
		} catch (Exception e) {
			System.out.println(e + " in update method in Database.java");
		}
	}
}
