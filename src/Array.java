
public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void insert(int item) {
        if (items.length == count) {
            int[] newItems = new int[count * 2];
            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }


        items[count] = item;
        count++;
    }

    public void removeAt(int index) throws IllegalAccessException {
        if (index < 0 || index >= count)
            throw new IllegalAccessException();

        for (int i = index; i < count; i++)
            items[i] = items[i + 1];

        count--;
    }

    public int indexOf(int item) {

        for (int i = 0; i < count; i++)
            if (items[i] == item) {
                return items[i];
            }

        return -1;


    }

    public int max() {
        int k = items[0];
        for (int i = 0; i < count; i++)
            if (items[i] > k) {
                k = items[i];
            }

        return k;
    }

    public void insertAt (int index, int item) throws IllegalAccessException {
        if (index < 0)
            throw new IllegalAccessException();

        int prevValue = items[index];
        items[index] = item;

        for (int i = index + 1; i <= count; i++) {
            int val = items[i];
            items[i] = prevValue;
            prevValue = val;
        }

        count++;
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }
}
