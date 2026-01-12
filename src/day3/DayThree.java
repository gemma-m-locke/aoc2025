package day3;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static util.FileUtils.readFile;

public class DayThree {

    public static void main(String[] args) {

        List<String> testRows = readFile("day3", "test_input.txt");
        int testTotal = getMaxJoltage(testRows);
        System.out.println("Total Joltage in all banks: " + testTotal);

        List<String> ansRows = readFile("day3", "input.txt");
        int Total = getMaxJoltage(ansRows);
        System.out.println("Total Joltage in all banks: " + Total);
    }

    static int getMaxJoltage(List<String> input) {
        int totalBankJoltage = 0;
        for (String bank : input) {
            totalBankJoltage = totalBankJoltage + getMaxBankJoltage(bank);
        }

        return totalBankJoltage;
    }

    static int getMaxBankJoltage(String bank) {

        // So we parse from
        // "123" []char
        // ['1', '2', '3'] []char
        // And then store the casted version that we can lookup
        // [ 1, 2, 3] []int

        List<Integer> bankAsInts = new ArrayList<>();
        for (int i = 0; i < bank.length(); i++) {
            char chara = bank.charAt(i);
            int num = Character.getNumericValue(chara);

            bankAsInts.add(num);

        }

        int largestNum = 0;
        int secondNum = 0;
        int secondStart = 0;
        for (int i = 0; i < bank.length() - 1; i++) {

            if (bankAsInts.get(i) > largestNum) {
                largestNum = bankAsInts.get(i);
                secondStart = i + 1;
            }
            secondNum = 0;
            for (int j = secondStart; j < bank.length(); j++) {
                if (bankAsInts.get(j) > secondNum) {
                    secondNum = bankAsInts.get(j);

                }
            }
        }

        int largestJoltage = (largestNum * 10) + secondNum;
        return largestJoltage;

    }
}
