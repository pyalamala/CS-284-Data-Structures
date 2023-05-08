package rolodex;

import java.util.ArrayList;

public class Rolodex {
	private Entry cursor;
	private final Entry[] index;

	// Constructor

	Rolodex() {
		index = new Entry[26];
		int n = 0;
		for (char letter = 'A'; letter <= 'Z'; letter++){
			index[n] = new Separator(null, null, letter);
			n++;
		}

		for (int i = 0; i <= 25; i++){
			if (i == 0){
				index[i].prev = index[25];
				index[i].next = index[1];
			}
			else if (i == 25){
				index[i].prev = index[24];
				index[i].next = index[0];
			}
			else{
				index[i].prev = index[i - 1];
				index[i].next = index[i + 1];
			}
		}
	}

	public Boolean contains(String name) {
		char firstLetter = name.charAt(0);
		initializeCursor();
		Boolean isName = false;
		
		while(!((Separator)cursor).getName().equalsIgnoreCase(String.valueOf(firstLetter))){
			nextSeparator();
		}

		nextEntry();

		while(!cursor.isSeparator()){
			if (cursor.getName().equalsIgnoreCase(name)){
				isName = true;
			}
			nextEntry();
		}

		return isName;
	}
	
	public int size() {
		Entry current = index[0];
		int size = 0;

		while (current.next != index[0]) {
				size += current.size();
				current = current.next;
			}

		return size;

	}

	public ArrayList<String> lookup(String name) {
		    if (contains(name)){
				char firstLetter = name.charAt(0);
				initializeCursor();
				ArrayList<String> lookup = new ArrayList<String>();

				while(!cursor.getName().equalsIgnoreCase(String.valueOf(firstLetter))){
					nextSeparator();
				}

				nextEntry();

				while(!cursor.isSeparator()){
					if (cursor.getName().equalsIgnoreCase(name)){
						lookup.add(((Card)cursor).getCell());
						nextEntry();
					}
				}
				return lookup;
				
			}
			else{
				throw new IllegalArgumentException("lookup: name not found");
			}
			
	}


	public String toString() {
		Entry current = index[0];

		StringBuilder b = new StringBuilder();
		while (current.next!=index[0]) {
			b.append(current.toString()+"\n");
			current=current.next;
		}
		b.append(current.toString()+"\n");		
		return b.toString();
	}

	public void addCard(String name, String cell){
		initializeCursor();
		Entry current = index[0];
		char firstLetter = name.charAt(0);
		
		while(!cursor.getName().equalsIgnoreCase(String.valueOf(firstLetter))){
			nextSeparator();
		}

		if (!cursor.next.isSeparator()){
			nextEntry();
			
			while(!cursor.isSeparator()){
				if (name.compareToIgnoreCase(cursor.getName()) == 0){
					current = cursor;
					while(!current.isSeparator()){
						if (((Card)current).getCell().equalsIgnoreCase(cell)){
							throw new IllegalArgumentException("addCard: duplicate entry");
						}
						current = current.next;
					}
					break;
				}
				else if (name.compareToIgnoreCase(cursor.getName()) < 0){
					break;
				}
	
				nextEntry();
			}

			Entry newCard = new Card(cursor.prev, cursor, name, cell);
			cursor.prev.next = newCard;
			cursor.prev = newCard;
		}
		else{
			Entry newCard = new Card(cursor, cursor.next, name, cell);
			cursor.next.prev = newCard;
			cursor.next = newCard;
		}
		
	}

	public void removeCard(String name, String cell) {
		if (!contains(name)){
			throw new IllegalArgumentException("removeCard: name does not exist");
		}

		else{
			char firstLetter = name.charAt(0);
			initializeCursor();

			while(!cursor.getName().equalsIgnoreCase(String.valueOf(firstLetter))){
				nextSeparator();
			}

			nextEntry();
			
			while(!name.equalsIgnoreCase(cursor.getName()) || !cursor.isSeparator()){
				Entry current = cursor;
				if (((Card)current).getCell().equalsIgnoreCase(cell)){
					break;
				}
				else{
					nextEntry();
				}
			}

			if (cursor.isSeparator()){
				throw new IllegalArgumentException("removeCard: cell for that name does not exist");
			}
			else{
				cursor.prev.next = cursor.next;
				cursor.next.prev = cursor.prev;
			}
		}
	}

	public void removeAllCards(String name) {
		if (!contains(name)){
			throw new IllegalArgumentException("removeAllCards: name does not exist");
		}
		else{
			char firstLetter = name.charAt(0);
			initializeCursor();

			while(!cursor.getName().equalsIgnoreCase(String.valueOf(firstLetter))){
				nextSeparator();
			}

			nextEntry();

			while(!name.equalsIgnoreCase(cursor.getName()) && !cursor.isSeparator()){
				nextEntry();
			}

			while(name.equalsIgnoreCase(cursor.getName())){
				Entry current = cursor;
				removeCard(name, ((Card)current).getCell());
				nextEntry();
			}
			
		}

	}

	// Cursor operations

	public void initializeCursor() {
		cursor = index[0];
	}

	public void nextSeparator() {
		while(!cursor.next.isSeparator()){
			nextEntry();
		}
		nextEntry();
	}

	public void nextEntry() {
		cursor = cursor.next;

	}

	public String currentEntryToString() {
		return cursor.toString();
	}


	public static void main(String[] args) {

		Rolodex r = new Rolodex();
		System.out.println(r);

		r.addCard("Chloe", "123");
		r.addCard("Chad", "23");
		r.addCard("Cris", "3");
		r.addCard("Cris", "4");
		r.addCard("Cris", "5");
		r.addCard("Maddie", "23");
		System.out.println(r);

		r.removeCard("Chad", "23");
		System.out.println(r);

		r.removeAllCards("Cris");
		System.out.println(r);
	}

}
