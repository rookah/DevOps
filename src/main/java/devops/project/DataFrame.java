package devops.project;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class DataFrame{

	private ArrayList<String> labels;
	private ArrayList<ArrayList<Object>> df;
	
	
	public DataFrame() {
		df = new ArrayList<ArrayList<Object>>();
		labels = new ArrayList<String>();
	}
	
	public DataFrame(Object[][] initArray) {
		df = new ArrayList<ArrayList<Object>>();
		
		// Init labels
		labels = new ArrayList<String>();
		for (int i = 0; i < initArray.length; i++) {
			labels.add(Integer.toString(i));
		}
		
		// Add data to df
		for (int i = 0; i < initArray.length; i++) {
			ArrayList<Object> newRow = new ArrayList<Object>();
			for (int j = 0; j < initArray[i].length; j++) {
				newRow.add(initArray[i][j]);
			}
			df.add(newRow);
		}
	}
	
	@SuppressWarnings("resource")
	public DataFrame(String csv) {
		df = new ArrayList<ArrayList<Object>>();
		File file = new File(csv);
		Scanner scFile, scString;
		try {
			scFile = new Scanner(file);
			
			//labels
			labels = new ArrayList<String>();
			scString = new Scanner(scFile.nextLine()).useDelimiter("\\,");
			while (scString.hasNext()) {
				labels.add(scString.next());
			}
			scString.close();
			
			//data
			while (scFile.hasNextLine()) {
				ArrayList<Object> newRow = new ArrayList<Object>();
				scString = new Scanner(scFile.nextLine()).useDelimiter("\\,");
				while (scString.hasNext()) {
					newRow.add(scString.next());
				}
				df.add(newRow);
				scString.close();
			}
			scFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void addCol(ArrayList<Object> col) {
		df.add(col);	
	}
	
	public ArrayList<?> getCol(int col) {
		return df.get(col);
	}
	
	public String toString() {
		String ret = "";
		
		//labels
		for (int i = 0; i < labels.size() - 1; i++) {
			ret = ret + labels.get(i) + ",";
		}
		if (labels.size() != 0)
			ret = ret + labels.get(labels.size() - 1) + "\n";
		
		//data
		for (ArrayList<Object> row : df) {
			for (int i = 0; i < row.size() - 1; i++) {
				ret = ret + row.get(i) + ",";
			}
			if (row.size() != 0)
				ret = ret + row.get(row.size() - 1) + "\n";
		}
		
		return ret;
	}
}
