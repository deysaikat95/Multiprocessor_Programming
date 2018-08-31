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

	private ArrayList<String[]> database;
	private int num_entry;

	Database(String inputFile, String outputFile)
	{
		this.inputFile = inputFile;
		this.outputFile = outputFile;
		this.database = new ArrayList<String[]>();
		num_entry = 0;
	}

	private static boolean isValidDate(String inDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    	dateFormat.setLenient(false);
    	try {
      		dateFormat.parse(inDate.trim());
    	} catch (ParseException pe) {
      		return false;
    	}
    		return true;
	}

	private int internalSearch (String name, String company) {
		try {
			String[] temp;

			if (this.num_entry == 0)
				return -1;

			ListIterator iterator = this.database.listIterator();
			while (iterator.hasNext()) {
				temp = (String[])iterator.next();
				if (temp[0].equals(name) && temp[1].equals(company)) {
					return this.database.indexOf(temp);
				}
			}

			return -1;
		} catch (Exception e) {
			System.out.println(e + " in internalSearch method");
			return -2;
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

	public void add(String[] data) {
		try {
			PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(outputFile), true));

			if (internalSearch(data[0],data[1]) != -1) {
				printWriter.append("ADD: ERROR DUPLICATE_ENTRY\n");
				printWriter.close();
				return;
			}

			if (!Database.isValidDate(data[2])) {
				printWriter.append("ADD: ERROR INVALID_DATE\n");
				printWriter.close();
				return;
			}

			this.database.add(data);
			this.num_entry = this.database.size();

			printWriter.append("ADD: OK ");

			if(data[0].contains(" "))
			{
				printWriter.append("\"");
				printWriter.append(data[0]);
				printWriter.append("\"");
			}
			else
				printWriter.append(data[0]);

			printWriter.append(" ");

			if (data[1].contains(" "))
			{
				printWriter.append("\"");
				printWriter.append(data[1]);
				printWriter.append("\"");
			}
			else
				printWriter.append(data[1]);

			printWriter.append("\n");

			printWriter.close();
		} catch (Exception e) {
			System.out.println(e + " in add method in Database.java");
		}
	}

	public void buy(String[] data) {
		try {
			PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(outputFile), true));

			/* DUPBLICATE ERROR HANDLING */
			int index = internalSearch(data[0], data[1]);
			if (index < 0) {
				printWriter.append("BUY: ERROR CANNOT_BUY_BEFORE_ADD\n");
				printWriter.close();
				return;
			}
			String[] temp = this.database.get(index);

			int quantity = Integer.parseInt(temp[3]);
			quantity += Integer.parseInt(data[2]);

			temp[3] =  Integer.toString(quantity);

			printWriter.append("BUY: OK ");

			if(data[0].contains(" "))
			{
				printWriter.append("\"");
				printWriter.append(data[0]);
				printWriter.append("\"");
			}
			else
				printWriter.append(data[0]);

			printWriter.append(" ");

			if (data[1].contains(" "))
			{
				printWriter.append("\"");
				printWriter.append(data[1]);
				printWriter.append("\"");
			}
			else
				printWriter.append(data[1]);

			printWriter.append(" ");

			printWriter.append(temp[3]);

			printWriter.append("\n");

			printWriter.close();
		} catch (Exception e) {
			System.out.println(e + " in buy method in Database.java");
		}
	}

	public void sell(String[] data) {
		try {
			PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(outputFile), true));

			/* DUPBLICATE ERROR HANDLING */
			int index = internalSearch(data[0], data[1]);
			if (index < 0) {
				printWriter.append("SELL: ERROR CANNOT_SELL_BEFORE_ADD\n");
				printWriter.close();
				return;
			}
			String[] temp = this.database.get(index);

			int quantity = Integer.parseInt(temp[3]);
			quantity -= Integer.parseInt(data[2]);
			if (quantity < 0)
			{
				printWriter.append("SELL: ERROR CANNOT_SELL_QUANTITY_MORE_THAN_STOCK\n");
				printWriter.close();
				return;

			}

			temp[3] =  Integer.toString(quantity);

			printWriter.append("SELL: OK ");

			if(data[0].contains(" "))
			{
				printWriter.append("\"");
				printWriter.append(data[0]);
				printWriter.append("\"");
			}
			else
				printWriter.append(data[0]);

			printWriter.append(" ");

			if (data[1].contains(" "))
			{
				printWriter.append("\"");
				printWriter.append(data[1]);
				printWriter.append("\"");
			}
			else
				printWriter.append(data[1]);

			printWriter.append(" ");

			printWriter.append(temp[3]);

			printWriter.append("\n");

			printWriter.close();
		} catch (Exception e) {
			System.out.println(e + " in sell method in Database.java");
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
		try {
			PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(outputFile), true));
			printWriter.append("STATUS: OK " + this.database.size() + "\n");

			ListIterator iterator = this.database.listIterator();
			while (iterator.hasNext())
			{
				temp = (String[])iterator.next();
				printWriter.append(temp[0] + "," + temp[1] + "," + temp[2] + "," + temp[3] + "\n");
			}

			printWriter.close();
		} catch (Exception e) {
			System.out.println(e + " in status method");
		}
	}	

	public void search(String data) {
		String[] temp;
		ArrayList<String> outputs = new ArrayList<String>();

		int count = 0;
		try {
			PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(outputFile), true));
			ListIterator iterator = this.database.listIterator();
			while (iterator.hasNext())
			{
				temp = (String[])iterator.next();
				if (temp[0].contains(data) || temp[1].contains(data)) {
					outputs.add(temp[0] + "," + temp[1] + "," + temp[2] + "," + temp[3] + "\n");
					count++;
				}
			}
			printWriter.append("SEARCH: OK " + count + "\n");
			ListIterator outputIter = outputs.listIterator();
			while (outputIter.hasNext())
				printWriter.append((String)outputIter.next());

			printWriter.close();
		} catch (Exception e) {
			System.out.println(e + " in search method");
		}
	}
	
	public void quan(String[] data) {
		String[] temp;
		ArrayList<String> outputs = new ArrayList<String>();

		int count = 0;
		try {
			PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(outputFile), true));
			ListIterator iterator = this.database.listIterator();
			while (iterator.hasNext())
			{
				temp = (String[])iterator.next();
				if (data[0].equals("GREATER") && Integer.parseInt(temp[3]) > Integer.parseInt(data[1]))
				{
					outputs.add(temp[0] + "," + temp[1] + "," + temp[2] + "," + temp[3] + "\n");
					count++;
				}
				else if (data[0].equals("FEWER") && Integer.parseInt(temp[3]) < Integer.parseInt(data[1]))
				{
					outputs.add(temp[0] + "," + temp[1] + "," + temp[2] + "," + temp[3] + "\n");
					count++;
				}
				else if (data[0].equals("BETWEEN") && Integer.parseInt(temp[3]) > Integer.parseInt(data[1]) 
						&& Integer.parseInt(temp[3]) < Integer.parseInt(data[2]))
				{
					outputs.add(temp[0] + "," + temp[1] + "," + temp[2] + "," + temp[3] + "\n");
					count++;
				}
				else {}
			}
			printWriter.append("QUAN: OK " + count + "\n");
			ListIterator outputIter = outputs.listIterator();
			while (outputIter.hasNext())
				printWriter.append((String)outputIter.next());

			printWriter.close();
		} catch (Exception e) {
			System.out.println(e + " in quan method");
		}
	}
}
