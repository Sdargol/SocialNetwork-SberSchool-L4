package org.sdargol.sn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomIteratorTest {

    @Test
    void TestIteratorArrayObjects(){
        String[] arrString = {"el1", "el2", "el3"};
        CustomIterator customIterator = new CustomIterator(arrString);

        int index = 0;

        while (customIterator.hasNext()){
            assertEquals(arrString[index++], customIterator.next());
        }

        assertFalse(customIterator.hasNext());
    }

}