package com.raj.sampleprogram.zipcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * This Class will check the range of Zip codes and remove the overlapping Zip codes and merge them.
 * 
 * @author raja
 *
 */
public class ZipCodeAnalyser {
	private static final int startIndex = 0;
	private static final int endIndex = 1;

	public static void main(String[] args) {
		ZipCodeAnalyser zipCodeAnalyser = new ZipCodeAnalyser();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please input the total number of ZipCode range:");
		int totalSize = scanner.nextInt();
		Integer[][] zipCodeRanges = new Integer[totalSize][2];
		System.out.println("Please Enter Start ZipCode and End ZipCode Range one per line");
		for (int i = 0; i < totalSize; i++) {
			zipCodeRanges[i][0] = scanner.nextInt();
			zipCodeRanges[i][1] = scanner.nextInt();
		}
		scanner.close();
		System.out.println("Original ZipCode Range");
		zipCodeAnalyser.printData(Arrays.asList(zipCodeRanges));
		List<Integer[]> zipCodelist = new ArrayList<Integer[]>(Arrays.asList(zipCodeRanges));
		zipCodeAnalyser.removeOverLap(zipCodelist);
		System.out.println("Final ZipCode Range");
		zipCodeAnalyser.printData(zipCodelist);
	}

	/**
	 * This Method used to sort the List of zipCodeRange by startIndex.
	 *  
	 * @param zipCodelist
	 */
	private static void sortZipCodeRange(List<Integer[]> zipCodelist) {
		Collections.sort(zipCodelist, new Comparator<Integer[]>() {
			public int compare(Integer[] zipCodeRange1, Integer[] zipCodeRange2) {
				return zipCodeRange1[0].compareTo(zipCodeRange2[0]);
			}
		});
	}

	/**
	 * T
	 * @param zipCodelist
	 * @return List<Integer[]>
	 */
	public List<Integer[]> removeOverLap(List<Integer[]> zipCodelist) {
		if (zipCodelist != null) {
			sortZipCodeRange(zipCodelist);
			for (int i = 0; i < zipCodelist.size(); i++) {
				for (int j = 1; j < zipCodelist.size();) {
					if (i != j
							&& zipCodelist.get(j)[startIndex] <= zipCodelist.get(i)[endIndex]
							&& zipCodelist.get(j)[startIndex] >= zipCodelist.get(i)[startIndex]) {
						if (zipCodelist.get(j)[startIndex] <= zipCodelist.get(i)[startIndex]) {
							zipCodelist.get(i)[startIndex] = zipCodelist.get(j)[startIndex];
						}
						if (zipCodelist.get(i)[endIndex] <= zipCodelist.get(j)[endIndex]) {
							zipCodelist.get(i)[endIndex] = zipCodelist.get(j)[endIndex];
						}
						zipCodelist.remove(j);
					} else {
						j++;
					}
				}
			}
		}
		return zipCodelist;
	}

	/**
	 * This method used iterate the arrayList and print them.
	 * 
	 * @param zipCodelist
	 */
	public void printData(List<Integer[]> zipCodelist) {
		if (zipCodelist != null) {
			for (int i = 0; i < zipCodelist.size(); i++) {
				System.out.println("["+zipCodelist.get(i)[startIndex] + "," + zipCodelist.get(i)[endIndex]+"]");
			}
		}
	}
}
