package com.example.project.Insertion_Sort;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class InsertionSort {

    // PART A. implementing insertion sort
    public static int[] insertionSort(int[] elements) {
        int count = 0;
        // Start from the second element (index 1) because the first element is already "sorted"
        for (int i = 1; i < elements.length; i++) {
            int currentElement = elements[i];  // The current element to be inserted into the sorted portion
            int j = i - 1; // Start comparing with the previous element in the sorted portion

            
            while (j >= 0 && elements[j] > currentElement) { // Shift elements in the sorted portion to the right until the correct position for currentElement is found
                count++;
                elements[j + 1] = elements[j]; // Shift the element to the right
                j--; // Move to the previous element
            }

            // Insert the currentElement into its correct position
            elements[j + 1] = currentElement;
        }

    
        System.out.println("INSERTION SORT: Number of loop iterations: " + count);
        return elements;
    }

   
    public static void selectionSort(int[] elements) {
        int count = 0;
        for (int i = 0; i < elements.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < elements.length; j++) {
                count++;
                if (elements[j] < elements[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = elements[i];
            elements[i] = elements[minIndex];
            elements[minIndex] = temp;
        }
        System.out.println("SELECTION SORT: Number of loop iterations: " + count);
    }

    // PART B. sorting a 1000-word list
    public static ArrayList<String> insertionSortWordList(ArrayList<String> words) {
        int count = 0;
        for (int i = 1; i < words.size(); i++) {
            String currentString = words.get(i);
            int j = i-1;
            while (j>= 0 && words.get(j).compareTo(currentString) > 0) { //sort portion (left of currenString) is greater than the currentString
                count++;
                words.set(j+1, words.get(j));
                j--;
            }
            //place current string in sorted position.
            words.set(j, currentString);
        }
        System.out.println("INSERTION SORT: Number of loop iterations: " + count);
        return words;
    }

    public static void selectionSortWordList(ArrayList<String> words) {
        int count = 0;
        for (int i = 0; i < words.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < words.size(); j++) {
                count++;
                if (words.get(j).compareTo(words.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            String temp = words.get(i);
            words.set(i, words.get(minIndex));
            words.set(minIndex, temp);
        }
        System.out.println("SELECTION SORT: Number of loop iterations: " + count);
    }

    public static ArrayList<String> loadWordsInto(ArrayList<String> wordList) {
        try {
            Scanner input = new Scanner(new File("src/main/java/com/example/project/Selection_Sort/words.txt"));
            while (input.hasNext()) {
                String word = input.next();
                wordList.add(word);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return wordList;
    }

    public static void main(String[] args) {
        System.out.println("\n--- PART B: TESTING INSERTION SORT ON WORD LIST --- ");
        ArrayList<String> allWords = new ArrayList<String>();

        // load words from words.txt into array list; see helper method below
        loadWordsInto(allWords);
        System.out.println("This list contains " + allWords.size() + " common words:");

        // sort the list with insertion sort
        InsertionSort.insertionSortWordList(allWords);

        System.out.println(allWords);
        boolean pass2 = true;
        for (int i = 1; i < allWords.size(); i++) {
            if (allWords.get(i).compareTo(allWords.get(i - 1)) < 0) {
                pass2 = false;
            }
        }
        if (pass2 && allWords.size() != 0 && allWords.get(0).equals("a") && allWords.get(1000).equals("your")) {
            System.out.println("----TEST PASS----");
        } else {
            System.out.println("----!!!!!!!TEST FAIL!!!!!!!----");
        }



        System.out.println("\n--- PART C: RUNTIME TESTS FOR SORTING ALGORITHMS --- ");
        ArrayList<String> allWords = new ArrayList<String>();
        ArrayList<String> allWords2 = new ArrayList<String>();

        // load words from words.txt into array list; see helper method below
        loadWordsInto(allWords);
        loadWordsInto(allWords2);

        // sort the list with insertion sort
        InsertionSort.selectionSortWordList(allWords2);
        InsertionSort.insertionSortWordList(allWords);
    }
}