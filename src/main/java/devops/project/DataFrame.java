package devops.project;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class DataFrame {

	private ArrayList<String> labels;
	private ArrayList<ArrayList<Object>> df;
	
	
	public DataFrame() {
		labels = new ArrayList<String>();
		df = new ArrayList<ArrayList<Object>>();
	}
	
	public DataFrame(Object[][] initArray) {
		df = new ArrayList<ArrayList<Object>>();
		
		// init labels
		labels = new ArrayList<String>();
		for (int i = 0; i < initArray.length; i++) {
			labels.add(Integer.toString(i));
		}
		
		// add data to df
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
			
			// labels
			labels = new ArrayList<String>();
			scString = new Scanner(scFile.nextLine()).useDelimiter("\\,");
			while (scString.hasNext()) {
				labels.add(scString.next());
			}
			scString.close();
			
			// data
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
	
	public String printLabels() {
		String ret = "";
		
		for (int i = 0; i < labels.size() - 1; i++) {
			ret = ret + labels.get(i) + ",";
		}
		if (labels.size() != 0)
			ret = ret + labels.get(labels.size() - 1) + "\n";
		
		return ret;
	}
	
	public String printRow(int index) {
		String ret = "";
		
		ArrayList<Object> row = df.get(index);
		for (int i = 0; i < row.size() - 1; i++) {
			ret = ret + row.get(i) + ",";
		}
		if (row.size() != 0)
			ret = ret + row.get(row.size() - 1) + "\n";
		
		return ret;
	}
	
	public String printData() {
		String ret = "";
		
		for (int i = 0; i < df.size(); i++) {
			ret = ret + printRow(i);
		}
		
		return ret;
	}
	
	public String toString() {
		String ret = "";
		
		ret = ret + printLabels();
		ret = ret + printData();

		return ret;
	}
	
	public String printFirst(int end) {
		String ret = "";
		
		ret = ret + printLabels();
		
		if (end > df.size()) {
			end = df.size();
		}
		for(int j = 0; j < end;j++) {
			ret = ret + printRow(j);
		}

		return ret;
	}
	
	public String printLast(int start) {
		String ret = "";
		
		ret = ret + printLabels();
		
		if (start > df.size()) {
			start = df.size();
		}
		for(int j = df.size() - start; j < df.size();j++) {
			ret = ret + printRow(j);
		}

		return ret;
	}
	
	public DataFrame selectIndex(ArrayList<Integer> indexList) {
		DataFrame ret = new DataFrame();
		
		for (String s : labels) {
			ret.labels.add(s);
		}
		
		for (int i : indexList) {
			if (i >= 0 && i < df.size()) {
				ArrayList<Object> newRow = new ArrayList<Object>();
				for (int j = 0; j < df.get(i).size(); j++) {
					newRow.add(df.get(i).get(j));
				}
				ret.df.add(newRow);
			}
		}
		
		return ret;
	}
	
	public DataFrame selectColumn(ArrayList<String> labelList) {
		DataFrame ret = new DataFrame();
		
		for (String l : labelList) {
			ret.labels.add(l);
		}
		
		for (ArrayList<Object> dfRow : df) {
			ArrayList<Object> newRow = new ArrayList<Object>();
			for (int i = 0; i < ret.labels.size(); i++) {
				for (int j = 0; j < labels.size(); j++) {
					if (ret.labels.get(i).equals(labels.get(j))) {
						newRow.add(dfRow.get(j));
					}
				}
			}
			ret.df.add(newRow);
		}

		return ret;
	}

	public DataFrame mean() {
		return mean(labels);
	}

	public DataFrame mean(ArrayList<String> labelList) {
		DataFrame ret = new DataFrame();
		ArrayList<Object> meanRow = new ArrayList<Object>();
		
		for (String l : labelList) {
			ret.labels.add(l);
		}

		for (int i = 0; i < ret.labels.size(); i++) {
			float mean = 0;
			int nbElements = 0;
			for (ArrayList<Object> dfRow : df) {
				for (int j = 0; j < labels.size(); j++) {
					if (ret.labels.get(i).equals(labels.get(j))) {
						mean += Float.parseFloat((String) dfRow.get(j));
						nbElements++;
					}
				}
			}
			mean = mean / nbElements;
			meanRow.add(mean);
		}

		ret.df.add(meanRow);
		return ret;
	}

	public float max() {
		return max(labels);
	}

	public float max(ArrayList<String> labelList) {
		Boolean df_empty = true;
		float max = 0;
		for (int i = 0; i < labelList.size(); i++) {
			for (int j = 0; j < labels.size(); j++) {
				if (labelList.get(i).equals(labels.get(j))) {
					for (ArrayList<Object> dfRow : df) {
						if (df_empty) {
							max = Float.parseFloat((String) dfRow.get(j));
							df_empty = false;
						}
						else {
							max = Math.max(max, Float.parseFloat((String) dfRow.get(j)));
						}
					}
				}
			}
		}

		return max;
	}

	public float min() {
		return min(labels);
	}

	public float min(ArrayList<String> labelList) {
		Boolean df_empty = true;
		float min = 0;
		for (int i = 0; i < labelList.size(); i++) {
			for (int j = 0; j < labels.size(); j++) {
				if (labelList.get(i).equals(labels.get(j))) {
					for (ArrayList<Object> dfRow : df) {
						if (df_empty) {
							min = Float.parseFloat((String) dfRow.get(j));
							df_empty = false;
						}
						else {
							min = Math.min(min, Float.parseFloat((String) dfRow.get(j)));
						}
					}
				}
			}
		}

		return min;
	}
}
