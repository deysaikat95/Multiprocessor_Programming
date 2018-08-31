package hw1;

import hw1.util.*;
import java.io.*;
import java.util.*;

public class Inventory {
	private static String outputFile = "out.txt";
	private static String inputFile = "in.txt";

	private static String[] shift(String[] data, int offset) {
		int i=0;
		String[] temp = new String[data.length-1];

		try {
			for(i=offset; i<data.length-1; i++) {
				temp[i] = data[i+1];
			}

			return temp;
		} catch (Exception e) {
			System.out.println(e + " in shift method");
			return null;
		}
	}
	private static void printList(ArrayList<String> input)
	{
		Iterator iter = input.iterator();
		System.out.println();
		System.out.println("printStrings");
		while (iter.hasNext())
		{
			System.out.println("==================");
			System.out.println(iter.next());
		}
	}

	private static ArrayList<String> parseCommend(String[] commend) {
		String input = merge(shift(commend,0));
		String[] inputs = input.split(" ");
		ArrayList<String> outputs = new ArrayList<String>();

		for (int i = 0; i < inputs.length; i++)
		{
			String temp = inputs[i];
			if (temp.equals(""))
				continue;

			if (inputs[i].charAt(0) == '\"')
			{
				if (inputs[i].charAt(inputs[i].length()-1) == '\"')
				{
					temp = temp.replace("\"","");
					outputs.add(temp);
					continue;
				}

				int j;
				for (j = i + 1; j < inputs.length; j++)
				{
					temp = temp.concat(" ");
					temp = temp.concat(inputs[j]);
					if (inputs[j].charAt(inputs[j].length()-1) == '\"')
					{
						temp = temp.replace("\"","");
						outputs.add(temp);
						i = j;
						break;
					}
				}
			}
			else
			{
				outputs.add(temp);
			}
		}

		return outputs;
	}

	private static String merge(String[] data) {
		try{
			String result = data[0];
			for (int i=1; i<data.length; i++) {
				result = result + " " + data[i];
			}
			return result;
		} catch (Exception e){
			System.out.println(e + " in merge method");
			return null;
		}
	}

	public static void main(String[] args) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		Database database = new Database(inputFile, outputFile);

		try {
			fileReader = new FileReader(inputFile);
			bufferedReader = new BufferedReader(fileReader);
			String line = new String();
			String[] commend;

			while (true) {
				line = bufferedReader.readLine();
				if (line == null)
					break;

				commend = line.split(" ");

				// LOAD
				if (commend[0].equals("LOAD")) {
					if (commend.length != 2) {
						PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(outputFile), true));
						printWriter.append(commend[0]+ ": ERROR WRONG_ARGUMENT_COUNT\n");
						printWriter.close();
						continue;
					}
					database.load(commend[1]);
				}

				// STORE
				else if (commend[0].equals("STORE")) {
					if (commend.length != 2) {
						PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(outputFile), true));
						printWriter.append(commend[0]+ ": ERROR WRONG_ARGUMENT_COUNT\n");
						printWriter.close();
						continue;
					}
					database.store(commend[1]);
				}

				// CLEAR
				else if (commend[0].equals("CLEAR")) {
					if (commend.length != 1) {
						PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(outputFile), true));
						printWriter.append(commend[0]+ ": ERROR WRONG_ARGUMENT_COUNT\n");
						printWriter.close();
						continue;
					}
					database.clear();
				}

				// ADD
				else if (commend[0].equals("ADD")) {
					ArrayList<String> data = parseCommend(commend);
					if (data.size() != 3) {
						PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(outputFile), true));
						printWriter.append(commend[0]+ ": ERROR WRONG_ARGUMENT_COUNT\n");
						printWriter.close();
						continue;
					}
					data.add("0");
					String[] dataStrings = data.stream().toArray(String[]::new);

					database.add(dataStrings);
				}

				// BUY
				else if (commend[0].equals("BUY")) {
					ArrayList<String> data = parseCommend(commend);
					if (data.size() != 3) {
						PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(outputFile), true));
						printWriter.append(commend[0]+ ": ERROR WRONG_ARGUMENT_COUNT\n");
						printWriter.close();
						continue;
					}

					String[] dataStrings = data.stream().toArray(String[]::new);

					try {
						int quantity = Integer.parseInt(dataStrings[2]);
						if (quantity <= 0)
						{
							PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(outputFile), true));
							printWriter.append(commend[0]+ ": ERROR INVALID_QUANTITY\n");
							printWriter.close();
							continue;
						}
					} catch (Exception e) {
						PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(outputFile), true));
						printWriter.append(commend[0]+ ": ERROR INVALID_QUANTITY\n");
						printWriter.close();
						continue;
					}

					database.buy(dataStrings);
				}

				// SELL
				else if (commend[0].equals("SELL")) {
					ArrayList<String> data = parseCommend(commend);
					if (data.size() != 3) {
						PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(outputFile), true));
						printWriter.append(commend[0]+ ": ERROR WRONG_ARGUMENT_COUNT\n");
						printWriter.close();
						continue;
					}

					String[] dataStrings = data.stream().toArray(String[]::new);

					try {
						int quantity = Integer.parseInt(dataStrings[2]);
						if (quantity <= 0)
						{
							PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(outputFile), true));
							printWriter.append(commend[0]+ ": ERROR INVALID_QUANTITY\n");
							printWriter.close();
							continue;
						}
					} catch (Exception e) {
						PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(outputFile), true));
						printWriter.append(commend[0]+ ": ERROR INVALID_QUANTITY\n");
						printWriter.close();
						continue;
					}

					database.sell(dataStrings);
				}

				// STATUS
				else if (commend[0].equals("STATUS")) {
					if (commend.length != 1) {
						PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(outputFile), true));
						printWriter.append(commend[0]+ ": ERROR WRONG_ARGUMENT_COUNT\n");
						printWriter.close();
						continue;
					}
					database.status();
				}

				// SEARCH
				else if (commend[0].equals("SEARCH")) {
					ArrayList<String> data = parseCommend(commend);
					if (data.size() != 1) {
						PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(outputFile), true));
						printWriter.append(commend[0]+ ": ERROR WRONG_ARGUMENT_COUNT\n");
						printWriter.close();
						continue;
					}
					String[] dataStrings = data.stream().toArray(String[]::new);
					database.search(dataStrings[0]);
				}

				// QUAN
				else if (commend[0].equals("QUAN")) {
					ArrayList<String> data = parseCommend(commend);
					PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(outputFile), true));

					if (commend[1].equals("BETWEEN"))
					{
						if (data.size() != 3)
						{
							printWriter.append(commend[0]+ ": ERROR WRONG_ARGUMENT_COUNT\n");
							printWriter.close();
							continue;
						}
					}
					else if (commend[1].equals("GREATER") || commend[1].equals("FEWER"))
					{	
						if (data.size() != 2) 
						{
							printWriter.append(commend[0]+ ": ERROR WRONG_ARGUMENT_COUNT\n");
							printWriter.close();
							continue;
						}
					}

					else
					{
						printWriter.append(commend[0]+ ": ERROR UNKNOWN_COMMAND\n");
						printWriter.close();
						continue;
					}

					String[] dataStrings = data.stream().toArray(String[]::new);
					
					try {
						if (commend[1].equals("BETWEEN"))
						{
							int quantity1 = Math.min(Integer.parseInt(dataStrings[1]), Integer.parseInt(dataStrings[2]));
							int quantity2 = Math.max(Integer.parseInt(dataStrings[1]), Integer.parseInt(dataStrings[2]));
							if (quantity1 < 0 || quantity2 < 0 || quantity1 == quantity2)
							{
								printWriter.append(commend[0]+ ": ERROR INVALID_QUANTITY\n");
								printWriter.close();
								continue;
							}
							dataStrings[1] = Integer.toString(quantity1);
							dataStrings[2] = Integer.toString(quantity2);
						}
						else
						{
							int quantity = Integer.parseInt(dataStrings[1]);
							if (quantity <= 0)
							{
								printWriter.append(commend[0]+ ": ERROR INVALID_QUANTITY\n");
								printWriter.close();
								continue;
							}
						}

					} catch (Exception e) {
						printWriter.append(commend[0]+ ": ERROR INVALID_QUANTITY\n");
						printWriter.close();
						continue;
					}

					database.quan(dataStrings);
				}
				// OTHERS
				else {
					PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(outputFile), true));
					printWriter.append(commend[0]+ ": ERROR UNKNOWN_COMMAND\n");
					printWriter.close();
				}
			}
		} catch (Exception e) {
			System.out.println("Error" + e);
		}
	}
}
