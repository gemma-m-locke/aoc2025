package day1;

import java.io.*;
import java.util.List;

import static util.FileUtils.readFile;

public class DayOne {

	static void main() {

		List<String> testRows = readFile("day1", "test_input.txt");
		int testAns = parseInstructions(testRows);
		System.out.println("Test answer: " + testAns);

		List<String> ansRows = readFile("day1", "input.txt");
		int realAns = parseInstructions(ansRows);
		System.out.println("Real answer: " + realAns);

		int testAns2 = parseInstructionsTwoStar(testRows);
		System.out.println("Test answer 2: " + testAns2);
		int realAns2 = parseInstructionsTwoStar(ansRows);
		System.out.println("Real answer 2: " + realAns2);
	}

	static int parseInstructions(List<String> instructions) {
		int total = 0;
		int currentCount = 50;

		for (String i : instructions) {
			String d = i.substring(0, 1);
			String sn = i.substring(1);
			int n = Integer.parseInt(sn) % 100;

			int direction = 0;
			if (d.equals("L")) {
				direction = -1 * n;

			} else if (d.equals("R")) {
				direction = n;
			}

			currentCount = currentCount + direction;

			if (currentCount > 99) {
				currentCount = currentCount - 100;
			} else if (currentCount < 0) {
				currentCount = currentCount + 100;
			}

			if (currentCount == 0) {
				total++;
			}
		}
		return total;
	}

	static int parseInstructionsTwoStar(List<String> instructions) {
		int total = 0;
		int currentCount = 50;
		int prevCount = 0;

		for (String i : instructions) {
			String d = i.substring(0, 1);
			String sn = i.substring(1);
			int n = Integer.parseInt(sn);

			int body = n / 100;
			total += body;

			int remainder = n % 100;

			int direction = 0;
			if (d.equals("L")) {
				direction = -1 * remainder;

			} else if (d.equals("R")) {
				direction = remainder;
			}

			prevCount = currentCount;
			currentCount = currentCount + direction;

			int toAdd = 0;
			if (currentCount > 99) {
				currentCount = currentCount - 100;
				toAdd++;
			} else if (currentCount < 0) {
				currentCount = currentCount + 100;
				toAdd++;
			} else if (currentCount == 0) {
				toAdd++;
			}

			if (prevCount != 0) {
				total += toAdd;
			}

			// Leaving print in because it's real helpful to debug
			// System.out.println("Start " + prevCount + ", Instruction " + i + ", End " +
			// currentCount + ", Total " +total);
		}

		return total;
	}
}
