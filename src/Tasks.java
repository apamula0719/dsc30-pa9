/*
 * Name: TODO
 * PID: TODO
 */

import java.util.*;

/**
 * Part 1 Programming tasks
 *
 * @author Aneesh Pamula
 * @since 6/5/2023
 */

public class Tasks {

    /**
     * TODO: Question A
     * @param entries the list of customer id's
     * @return true if there are any duplicates, false otherwise
     */
    public static boolean raffleChecker(int[] entries) {
        int id_length = 1000;
        Integer[] counter = new Integer[id_length];
        for(int entry : entries){
            if(counter[entry] == null)
                counter[entry] = 1;
            else
                return true;
        }
        return false;
    }

    // List Node class provided for reference
    public static class Node {
        Node next;
        String name;
        public Node(String name) {
            this.name = name;
        }
    }

    /**
     * TODO: Question B
     * @param head the head node of the linked list to find the middle of
     * @return the middle node of the list
     */
    public static String middleNode(Node head) {
        Node n1 = head;
        Node n2 = head;
        while(n2.next != null){
            n1 = n1.next;
            n2 = n2.next.next;
        }
        return n1.name;
    }
    /**
     * TODO: Question C
     * @param newMessage The message to be constructed
     * @param oldMessage The message that provides the letters
     * @return True if the message can be constructed, false if otherwise
     */
    public static boolean canConstruct(String newMessage, String oldMessage) {
       char[] oldMessageArray = oldMessage.toCharArray();
       for(char c : newMessage.toCharArray()){
           String lettersLeft = String.valueOf(oldMessageArray);
           int charIndex = lettersLeft.indexOf(c);
           if(charIndex >= 0) {
               oldMessageArray[charIndex] = '_';
               continue;
           }
           return false;
       }
        return true;
    }

    /**TODO:
     * Question D
     * @param buyers List of all buyers
     * @param k Number of most frequent buyers to return
     * @return an array of the k most frequent buyers
     */
    public static String[] frequentCustomers(String[] buyers, int k) {
        //Get a list of all unique buyers
        ArrayList<String> uniqueBuyers = new ArrayList<>();
        for(String buyer : buyers)
            if(!uniqueBuyers.contains(buyer))
                uniqueBuyers.add(buyer);

        //Get the counts of each buyer
        int[] buyerCounts = new int[uniqueBuyers.size()];
        for(String buyer : buyers)
            buyerCounts[uniqueBuyers.indexOf(buyer)]++;

        String[] mostFrequentBuyers = new String[k];

        //Iterate through the list, finding the buyer who donated the most for each iteration. Then, add that
        //buyer to the list of the most frequent, and remove them from the list.
        for(int i = 0; i < k; i++){//Outer loop to fill mostFrequentBuyers
            int largestCountIndex = 0;
            for(int j = 0; j < buyerCounts.length; j++){//Inner loop to find largest not-yet-added buyer
                if(buyerCounts[j] > buyerCounts[largestCountIndex])
                    largestCountIndex = j;
            }
            mostFrequentBuyers[i] = uniqueBuyers.get(largestCountIndex);
            buyerCounts[largestCountIndex] = -1;
        }
        return mostFrequentBuyers;
    }

    public static void main(String[] args){
        String[] buyers = new String[]{"CustomerA", "CustomerB", "CustomerB", "CustomerA", "CustomerC", "CustomerD", "CustomerA"};
        for(String s : frequentCustomers(buyers, 2)){
            System.out.print(s + " ");
        }
    }
}
