package day2;

import static util.FileUtils.readFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayTwo {

	public static void main(String[] args) {
		System.out.println("Day 2");
		List<String> testRows = readFile("day2", "test_input.txt");
		List<String> ansRows = readFile("day2", "input.txt");

		splitFile(testRows);
		splitFile(ansRows);

	}

	public static void splitFile(List<String> testRows) {

		String line = testRows.getFirst();
		String[] splitFile = line.split(",");
		//System.out.println(Arrays.toString(splitFile));

		ArrayList<NumberRange> ranges = new ArrayList<>();
		for (String r : splitFile) {
			String[] splitRange = r.split("-");

			long startOfRange = Long.parseLong(splitRange[0]);
			long endOfRange = Long.parseLong(splitRange[1]);

			NumberRange nr = new NumberRange(startOfRange, endOfRange);
			ranges.add(nr);

		}
		long totalOfRepetingInts=0;
		for (NumberRange range: ranges) {
			for (long i = range.getStartOfRange(); i <= range.getEndOfRange(); i++) {
				//System.out.println(i);
				String chars = Long.toString(i);
				String a = chars.substring(0, chars.length()/2);
				String b = chars.substring(chars.length()/2);
//				System.out.println(chars);
//				System.out.println(a);
//				System.out.println(b);
				
				if(a.equals(b)) {
				totalOfRepetingInts=totalOfRepetingInts+i;
				}
			}
		
			
		}
		System.out.println(totalOfRepetingInts);

	}

}
