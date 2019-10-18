public class ArrayList<T> implements List<T> {

    private T[] arr;
    private int size = 0;
    private int max = 10;

    ArrayList() {
        arr = (T[]) new Object[10];
    }

    public void add(T item) {
        if (arr.length == size) {
            growArray();
        }
        arr[size++] = item;
    }

    public void add(int ind, T item) {
        if (arr.length == size)
            growArray();
        if (size-ind >= 0)
            System.arraycopy(arr, ind, arr, ind + 1, size - ind);
        arr[ind] = item;
        size++;
    }

    public T remove(int ind) {
        T item = arr[ind];
        for(int i = ind; i < size-1; i++)
            arr[i] = arr[i+1];
        size--;
        return item;
    }

    public T get(int ind) {
        return arr[ind];
    }

    public int size() {
        return size;
    }

    private void growArray() {
        T[] tempArr = (T[]) new Object[arr.length*2];
        System.arraycopy(arr, 0, tempArr, 0, arr.length);
        arr = tempArr;
    }
}