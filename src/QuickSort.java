public class QuickSort {
    public void sort(int[] array) {

        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int start, int end) {
        if(start >= end)
            return;
        var boundery = partition(array, start, end);
        sort(array, start, boundery - 1);
        sort(array, boundery + 1, end);
    }

    private int partition(int[] array, int start, int end) {
        var pivit = array[end];
        var boundery = start - 1;

        for(var i = start; i < end; i++) {
            if(array[i] <= pivit)
                swap(array, i, ++boundery);
        }

        return boundery;
    }

    private void swap(int[] array, int index1, int index2) {
        var tem = array[index1];
        array[index1] = array[index2];
        array[index2] = tem;
    }
}
