package cpclub;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PhoneBook extends Object{

	private Hashtable<String, LinkedList<PhoneEntry>> data;
	
	public PhoneBook() {
		this(5);
	}
	
	public PhoneBook(int numSlots) {
		data = new Hashtable<String, LinkedList<PhoneEntry>>();
	}

	public void load() throws IOException {
		BufferedReader k = new BufferedReader(new FileReader(new File("H:\\git\\at2015\\Christopher cushman\\bin\\cpclub\\phone.txt")));

		while(k.ready()) {
			Scanner s = new Scanner(k.readLine());
			add(new PhoneEntry(s.next(), s.next()));

		}
	}
	
	public void add(PhoneEntry obj) {
		if(data.containsKey(obj.name))
			data.get(obj.name).add(obj);
		else {
			LinkedList<PhoneEntry> ll = new LinkedList<PhoneEntry>();
			ll.add(obj);
			data.put(obj.name, ll);
		}
	}
	public void display() {
		for(String s : data.keySet()) {
			System.out.println("Name: "+ s);
			System.out.println(data.get(s).toString());
			
		}

	}
	
	public int getCapacity() {
		return data.size();
	}
	
	public int getSize() {
		int size = 0;
		for(String s : data.keySet())
			size += data.get(s).size();
		return size;
	}
	
	public int getNullBuckets() {
		int size = 0;
		for(LinkedList<PhoneEntry> ll : data.values())
			size += Optional.of(ll).isPresent() ? 1 : 0;
		return size;
	}
	
	public LinkedList<PhoneEntry> getLongestList() {
		LinkedList<PhoneEntry> yo = new LinkedList<PhoneEntry>();
		for(LinkedList<PhoneEntry> ll : data.values())
			yo = ll.size() > yo.size() ? ll : yo;
		return yo;
	}
	
	public String lookup(String name) {
		return name;
		
	}
	
	
}

