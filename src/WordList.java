import java.util.HashMap;
import java.io.*;


class WordList {
	
	
	
	static private HashMap<String, Boolean> list; // ordlista
	
	static int wordLength;
	static int size; // antal ord i ordlistan

	
	static public void read(int wordLength_, BufferedReader input) throws IOException {
		wordLength = wordLength_;
		size = 0;
		list = new HashMap<String, Boolean>();
		while (true) {
			String s = input.readLine();
			if (s.equals("#")) {
				break;
			}
			if (s.length() != wordLength) {
				System.out.println("Rad " + size + " i filen inneh?ller inte " + wordLength + " tecken.");
			}
			list.put(s, true);
			size++;
		}
	
	}


	static public String wordAt(int index) {
		if (index >= 0 && index < size) {
			return (String) list.values().toArray()[index];
		}
		return null;
	}


	static public String contains(String w) {
		if (list.containsKey(w)) {
			return w;
		}
		return null;
	}

	
	static public boolean markAsUsedIfUnused(String w) {

		if(list.containsKey(w)) {
		
			
		if(list.get(w).booleanValue()==false) {
		return false;	
		}else {
		
		list.put(w, false);}
		
		
		
	}
		return true;
	}

	public static void eraseUsed() {
		
		
		for (HashMap.Entry<String, Boolean> entry : list.entrySet()) {
		    entry.setValue(true);
		}
		
	}


}
