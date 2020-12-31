package org.sdargol.sn;

public class Main {
    public static void main(String[] args) {
        String[] arrString = {"el1", "el2", "el3"};
        CustomIterator customIterator = new CustomIterator(arrString);

        while (customIterator.hasNext()){
            System.out.println(customIterator.next());
        }
    }
}
