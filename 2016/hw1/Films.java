package hw1;

import hw1.util.*;
import java.io.*;

public class Films {

	public static String[] shift(String[] data, int offset) {
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

	public static String[] filter_update(String data) {
			try {
					String copy = data;
					String[] temp = data.split("\"");
					if (temp.length == 1) {
						if (temp[0].split(" ")[2].equals("true") || temp[0].split(" ")[2].equals("false") || temp[0].split(" ")[2].contains("/")) {
							String[] result = new String[3];
							result[0] = temp[0].split(" ")[0];
							result[1] = temp[0].split(" ")[1];
							result[2] = temp[0].split(" ")[2];
							return result;
						} else {
							String[] result = new String[4];
							result[0] = temp[0].split(" ")[0];
							result[1] = temp[0].split(" ")[1];
							result[2] = temp[0].split(" ")[2];
							result[3] = temp[0].split(" ")[3];
							return result;
						}
					} else if (temp.length == 2) { 
						String[] result = new String[4];
						result[0] = temp[0].split(" ")[0];
						result[1] = temp[0].split(" ")[1];
						result[2] = temp[0].split(" ")[2];
						result[3] = temp[1];
						return result;
					} else if (temp.length == 3) {
						String[] result = new String[3];
						if (!temp[0].contains(" ")) {
							if (temp[2].split(" ")[2].equals("true") || temp[2].split(" ")[2].equals("false") || temp[2].split(" ")[2].contains("/")) {
								result[0] = temp[1];
								result[1] = temp[2].split(" ")[1];
								result[2] = temp[2].split(" ")[2];
								return result;
							} else {
								result = new String[4];
								result[0] = temp[1];
								result[1] = temp[2].split(" ")[1];
								result[2] = temp[2].split(" ")[2];
								result[3] = temp[2].split(" ")[3];
								return result;
							}
						}
						if (temp[2].split(" ")[1].equals("true") || temp[2].split(" ")[1].equals("false") || temp[2].split(" ")[1].contains("/")) {
							result[0] = temp[0].split(" ")[0];
							result[1] = temp[1];
							result[2] = temp[2].split(" ")[1];
							return result;
						} else {
							result = new String[4];
							if (copy.split(" ")[1].contains("\"")) {
								result[0] = temp[0].split(" ")[0];
								result[1] = temp[1];
								result[2] = temp[2].split(" ")[1];
								result[3] = temp[2].split(" ")[2];
								return result;
							} else {
								result[0] = temp[0].split(" ")[0];
								result[1] = temp[0].split(" ")[1];
								result[2] = temp[1];
								result[3] = temp[2].split(" ")[1];
								return result;
							}
						}
					} else if (temp.length == 4) {
						String[] result = new String[4];
						result[0] = temp[0].split(" ")[0];
						result[1] = temp[0].split(" ")[1];
						result[2] = temp[1];
						result[3] = temp[3];
						return result;
					} else if (temp.length == 5) {
						String[] result = new String[4];
						if (temp[4].split(" ")[1].equals("true") || temp[4].split(" ")[1].equals("false") || temp[4].split(" ")[1].contains("/")) {
							result[0] = temp[1];
							result[1] = temp[3];
							result[2] = temp[4].split(" ")[1];
							return result;
						} else if (data.split(" ")[4].contains("\"")) {
							result[0] = temp[0].split(" ")[0];
							result[1] = temp[1];
							result[2] = temp[3];
							result[3] = temp[4].split(" ")[1];
							return result;
						} else {
							result[0] = temp[1];
							result[1] = temp[3];
							result[2] = temp[4].split(" ")[1];
							result[3] = temp[4].split(" ")[2];
							return result;
						}
					} else if (temp.length == 6) {
						String[] result = new String[4];
						if(temp[0].equals("")) {
							result[0] = temp[1];
							result[1] = temp[2].split(" ")[1];
							result[2] = temp[3];
							result[3] = temp[5];
							return result;
						} else {
							result[0] = temp[0].split(" ")[0];
							result[1] = temp[1];
							result[2] = temp[3];
							result[3] = temp[5];
							return result;
						}
					} else if (temp.length == 7) {
						String[] result = new String[4];
						result[0] = temp[1];
						result[1] = temp[3];
						result[2] = temp[5];
						result[3] = temp[6].split(" ")[1];
						return result;
					} else if (temp.length == 8) {
						String[] result = new String[4];
						result[0] = temp[1];
						result[1] = temp[3];
						result[2] = temp[5];
						result[3] = temp[7];
						return result;
					} else {
						return null;
					}
				} catch (Exception e) {
					System.out.println(e + " in filter_update method");
					return null;
				}
		}

	public static String[] filter_add(String data) {

		try {
				String[] temp = data.split("\"");
				if (temp.length == 1) {
					String[] result = temp[0].split(" ");
					String temp1 = result[0];
					result[0] = result[2];
					result[2] = result[1];
					result[1] = temp1;					
					return result;
				} else if (temp.length == 3) {
					String[] result = new String[4];
					if (!temp[0].contains(" ")) {
						result[0] = temp[2].split(" ")[2];
						result[1] = temp[1];
						result[2] = temp[2].split(" ")[1];
						result[3] = temp[2].split(" ")[3];
						return result;
					}
					result[0] = temp[2].split(" ")[1];
					result[1] = temp[0].split(" ")[0];
					result[2] = temp[1];
					result[3] = temp[2].split(" ")[2];
					return result;
				} else if (temp.length == 5) {
					String[] result = new String[4];
					result[0] = temp[4].split(" ")[1];
					result[1] = temp[1];
					result[2] = temp[3];
					result[3] = temp[4].split(" ")[2];
					return result;
				} else {
					return null;
				}
			} catch (Exception e) {
				System.out.println(e + " in filter_add method");
				return null;
			}
	}

	public static String merge(String[] data) {
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

	public static void write(String string) {
		try {
				PrintWriter printWriter = new PrintWriter("hw1/out.txt", "UTF-8");
				printWriter.print(string);
		} catch (Exception e) {
			System.out.println(e + " in witeOut method");
		}
	}

	public static boolean check(String string) {
		if (string.contains("\""))
			return true;

		return false;
	}

	public static void main(String[] args) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		Database database = new Database();

		try {
			fileReader = new FileReader("hw1/in.txt");
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
					if (commend.length > 2) {
						PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File("hw1/out.txt"), true));
						printWriter.append(commend[0]+ ": ERROR WRONG_ARGUMENT_COUNT\n");
						printWriter.close();
						continue;
					}
					database.load(commend[1]);
				}

				// STORE
				else if (commend[0].equals("STORE")) {
					if (commend.length > 2) {
						PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File("hw1/out.txt"), true));
						printWriter.append(commend[0]+ ": ERROR WRONG_ARGUMENT_COUNT\n");
						printWriter.close();
						continue;
					}
					database.store(commend[1]);
				}

				// CLEAR
				else if (commend[0].equals("CLEAR")) {
					if (commend.length > 1) {
						PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File("hw1/out.txt"), true));
						printWriter.append(commend[0]+ ": ERROR WRONG_ARGUMENT_COUNT\n");
						printWriter.close();
						continue;
					}
					database.clear();
				}

				// ADD
				else if (commend[0].equals("ADD")) {
					if (commend.length < 5) {
						PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File("hw1/out.txt"), true));
						printWriter.append(commend[0]+ ": ERROR WRONG_ARGUMENT_COUNT\n");
						printWriter.close();
						continue;
					}

					if (commend.length == 5 && commend[1].contains("\"")) {
						PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File("hw1/out.txt"), true));
						printWriter.append(commend[0]+ ": ERROR WRONG_ARGUMENT_COUNT\n");
						printWriter.close();
						continue;
					}

					if (commend[commend.length-2].contains("\"")) {
						PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File("hw1/out.txt"), true));
						printWriter.append(commend[0]+ ": ERROR WRONG_ARGUMENT_COUNT\n");
						printWriter.close();
						continue;
					}

					String[] data = shift(commend,0);
					boolean quotation1 = check(commend[1]);
					boolean quotation2 = false;
					int cnt = 0;
					for (int i=1; i<commend.length; i++) {
						if (commend[i].contains("\""))
							cnt++;

						if (cnt > 2) {
							quotation2 = true;
							break;
						}

						if (cnt == 2 && !quotation1) {
							quotation2 = true;
							break;
						}
					}

					String temp = merge(data);
					database.add(filter_add(temp), quotation1, quotation2);
				}

				// SHOW
				else if (commend[0].equals("SHOW")) {
					if (commend.length > 1) {
						PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File("hw1/out.txt"), true));
						printWriter.append(commend[0]+ ": ERROR WRONG_ARGUMENT_COUNT\n");
						printWriter.close();
						continue;
					}
					database.show();
				}

				// UPDATE
				else if (commend[0].equals("UPDATE")) {
					if (commend.length < 4) {
						PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File("hw1/out.txt"), true));
						printWriter.append(commend[0]+ ": ERROR WRONG_ARGUMENT_COUNT\n");
						printWriter.close();
						continue;
					}

					if (commend.length == 4 && commend[1].contains("\"")) {
						PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File("hw1/out.txt"), true));
						printWriter.append(commend[0]+ ": ERROR WRONG_ARGUMENT_COUNT\n");
						printWriter.close();
						continue;
					}

					if (commend.length == 4 && ( !commend[commend.length-1].equals("true") && !commend[commend.length-1].equals("false") && !commend[commend.length-1].contains("/"))) {
						PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File("hw1/out.txt"), true));
						printWriter.append(commend[0]+ ": ERROR INVALID_DATE_OR_BOOL\n");
						printWriter.close();
						continue;
					}

					if (commend.length == 5 && ( !commend[commend.length-1].equals("true") && !commend[commend.length-1].equals("false") && !commend[commend.length-1].contains("/"))) {
						PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File("hw1/out.txt"), true));
						printWriter.append(commend[0]+ ": ERROR INVALID_DATE_OR_BOOL\n");
						printWriter.close();
						continue;
					}

					String[] data = shift(commend,0);
					boolean quotation1 = check(commend[1]);
					boolean quotation2 = false;
					int cnt = 0;
					for (int i=1; i<commend.length; i++) {
						if (commend[i].contains("\""))
							cnt++;

						if (cnt > 2) {
							quotation2 = true;
							break;
						}

						if (cnt == 2 && !quotation1) {
							quotation2 = true;
							break;
						}
					}

					String temp = merge(data);
					database.update(filter_update(temp), quotation1, quotation2);
				}

				// SEARCH
				else if (commend[0].equals("SEARCH")) {
					if (commend.length > 2) {
						PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File("hw1/out.txt"), true));
						printWriter.append(commend[0]+ ": ERROR WRONG_ARGUMENT_COUNT\n");
						printWriter.close();
						continue;
					}
					database.search(commend[1]);
				}

				// OTHERS
				else {
					System.out.println("Wrong commend");
					PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File("hw1/out.txt"), true));
					printWriter.append(commend[0]+ ": ERROR UNKOWN_COMMAND\n");
					printWriter.close();
				}
			}
		} catch (Exception e) {
			System.out.println("Error" + e);
		}
	}
}