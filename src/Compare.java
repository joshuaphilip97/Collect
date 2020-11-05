import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Compare {
	private static final File dates = new File("Dates.txt");
	private ArrayList<String> dateList = new ArrayList<String>();
	HashSet<String> dateSet = new HashSet<String>();
	HashMap<String, Integer> unsorted = new HashMap<String, Integer>();
	HashMap<String, Integer> sortedHashMap = new HashMap<String, Integer>();
	TreeMap<String, Integer> sortedTreeMap;
	public Compare() throws FileNotFoundException {
		readFile();
		unsortedHashMap();
		sortHashMap();
		sortTreeMap();
		
		System.out.println("Unsorted HashMap: " + unsorted);
		System.out.println("Sorted HashMap: " + sortedHashMap);
		System.out.println("Sorted TreeMap: " + sortedTreeMap);
		System.out.println("HashSet: " + dateSet);
		
	}
	
	public ArrayList<String> readFile() throws FileNotFoundException {
		Scanner scnr = new Scanner(dates);
		ArrayList<String> temp = new ArrayList<String>();
		while(scnr.hasNextLine()) {
			temp.add(scnr.nextLine());
		}
		scnr.close();
		
		String line;
		String [] date = new String[3];
		for(int i = 0; i < temp.size(); i++) {
			StringBuilder sb = new StringBuilder();
			line = temp.get(i);
			date = line.split("\\.");
			sb.append(date[2] + "-" + date[0] + "-" + date[1]);
			dateList.add(sb.toString());
		}
		
		return dateList;
	}
	
	public void add() {
		dateSet.addAll(dateList);
	}
	
	public void remove(String str) {
		if(dateSet.contains(str)) {
		dateSet.remove(str);
		System.out.println(dateSet);
		}
		
	}
	
	public HashMap<String, Integer> unsortedHashMap(){
		for(int i = 0;i < dateList.size(); i++) {
			unsorted.put(dateList.get(i), i);
		}
		return unsorted;
	}
	
	public HashMap<String, Integer> sortHashMap(){
		List<String> temp = new ArrayList<String>();
		temp.addAll(unsorted.keySet());
		Collections.sort(temp);
		
		for(int i = 0; i < temp.size(); i++) {
			sortedHashMap.put(temp.get(i), i);
		}
		return sortedHashMap;
		
	}
	
	public TreeMap<String, Integer> sortTreeMap(){
		sortedTreeMap = new TreeMap<String, Integer>(unsorted);
		return sortedTreeMap;
	}
	
	
}
