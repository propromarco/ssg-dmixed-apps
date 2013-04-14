package com.appspot.ssg.dmixed.client.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.appspot.ssg.dmixed.shared.ITermin;
import com.appspot.ssg.dmixed.shared.ITermine;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class Termine extends AbstractData implements ITermine {

    private static final long serialVersionUID = -6566178482824695480L;

    public class Mapping implements List<ITermin> {
        public class InternalIterator implements Iterator<ITermin> {

            private int _pos;

            public InternalIterator() {
                _pos = 0;
            }

            @Override
            public boolean hasNext() {
                return _pos < size();
            }

            @Override
            public ITermin next() {
                JSONValue jsonValue = _array.get(_pos);
                _pos++;
                return new Termin(jsonValue.isObject());
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

        }

        private JSONArray _array;

        public Mapping(JSONArray array) {
            _array = array;
        }

        @Override
        public int size() {
            return _array.size();
        }

        @Override
        public boolean isEmpty() {
            return size() == 0;
        }

        @Override
        public boolean contains(Object o) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Iterator<ITermin> iterator() {
            return new InternalIterator();
        }

        @Override
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override
        public <T> T[] toArray(T[] a) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean add(ITermin e) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean remove(Object o) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean addAll(Collection<? extends ITermin> c) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean addAll(int index, Collection<? extends ITermin> c) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override
        public ITermin get(int index) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ITermin set(int index, ITermin element) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(int index, ITermin element) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ITermin remove(int index) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int indexOf(Object o) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int lastIndexOf(Object o) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ListIterator<ITermin> listIterator() {
            throw new UnsupportedOperationException();
        }

        @Override
        public ListIterator<ITermin> listIterator(int index) {
            throw new UnsupportedOperationException();
        }

        @Override
        public List<ITermin> subList(int fromIndex, int toIndex) {
            throw new UnsupportedOperationException();
        }

    }

    public Termine(JSONObject object) {
        super(object);
    }

    @Override
    public List<ITermin> getAll() {
        JSONArray array = getArray("all");
        return new Mapping(array);
    }

}
