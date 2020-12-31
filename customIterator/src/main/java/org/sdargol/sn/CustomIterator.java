package org.sdargol.sn;

import java.util.Iterator;

public class CustomIterator implements Iterator<Object> {
    private Object[] arrSource;
    private int index;

    public CustomIterator(Object[] arrSource){
        this.arrSource = arrSource;
    }

    @Override
    public boolean hasNext() {
        return index < arrSource.length;
    }

    @Override
    public Object next() {
        return arrSource[index++];
    }
}
