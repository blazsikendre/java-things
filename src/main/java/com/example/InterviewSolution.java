package com.example;

public class InterviewSolution {

    public int getStartIndexOfLongestPart(String input) {
        if (input.length() == 0) return 0;
        char last = 0;
        char current;
        int max = 0;
        int maxIndex = 0;
        int[] counter = new int[input.length()];

        for(int i = 0; i < input.length(); i++) {
            current = input.charAt(i);
            if (current != last) {
                counter[i] = 0;
            } else {
                counter[i] = counter[i - 1] + 1;
            }

            if (counter[i] > max) {
                max = counter[i];
                maxIndex = i;
            }

            last = current;
        }

        //TODO it should me move previous for loop
        /*
        for(int i = 0; i < counter.length; i++) {
            if (counter[i] > max) {
                max = counter[i];
                maxIndex = i;
            }
        }*/

        return maxIndex - max;
    }
}
