package devops.project;

import java.util.ArrayList;
import java.io.*;

public class DataFrame{

	private ArrayList<String> labels;
	private ArrayList<ArrayList<?>> df;
	
	
	public DataFrame() {
		df = new ArrayList<ArrayList<?>>();
		labels = new ArrayList<String>();
	}
	
	public DataFrame(Object[][] initArray) {
		df = new ArrayList<ArrayList<?>>();
		
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
	
	public DataFrame(String csv) {
		File file = new File(csv);
	}
	
	public void addCol(ArrayList<?> col) {
		df.add(col);	
	}
	
	public ArrayList<?> getCol(int col) {
		return df.get(col);
	}
	
}
