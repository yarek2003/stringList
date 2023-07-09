import java.util.Arrays;

public class StringListImpl implements StringList{
    private final String[] arrayStorage;
    private int arraySize;


    public  StringListImpl (int size)  {
        this.arrayStorage = new String[size];

    }

    @Override
    public String add(String item) {
        validateItem(item);
        validateSize();
        arrayStorage[arraySize++] = item;
      return item;
    }

    @Override
    public String add(int index, String item) {
        validateItem(item);
        validateSize();
        validateIndex(index);
        if (index == arraySize) {
            arrayStorage[arraySize++] = item;
            return item;
        }
        System.arraycopy(arrayStorage, index, arrayStorage, index + 1, arraySize - index);
        arrayStorage[index] = item;
        arraySize++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        validateItem(item);
        validateSize();
        validateIndex(index);
        arrayStorage[arraySize++] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        validateItem(item);
        int index = indexOf(item);
        return remove(index);
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        String item = arrayStorage[index];
        if(index != arraySize){
            System.arraycopy(arrayStorage, index + 1, arrayStorage, index, arraySize - index);
        }
        arraySize--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        for (int i = 0; i < arraySize; i++) {
           if (item.equals(arrayStorage[i])) return true ;
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < arraySize; i++) {
            if (item.equals(arrayStorage[i])) return i ;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = arraySize-1; i >=  0; i--) {
            if (item.equals(arrayStorage[i])) return i ;
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return arrayStorage[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return arraySize;
    }

    @Override
    public boolean isEmpty() {
        return arraySize == 0;
    }

    @Override
    public void clear() {
        arraySize = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(arrayStorage, arraySize);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (String el : arrayStorage) {
            if (el != null) {
                sb.append(el + " ");
            }
        }
        return sb.toString();
    }

    private void validateItem(String item) {
        if (item == null) {
            throw new ItemNotFoundException();
        }
    }

    private void validateIndex(int index) {
        if (index > arraySize || index < 0) {
            throw new InvalidIndexException();
        }
    }

    private void validateSize() {
        if (arraySize >= arrayStorage.length) {
            throw new StorageIsFullException();
        }
    }
}
