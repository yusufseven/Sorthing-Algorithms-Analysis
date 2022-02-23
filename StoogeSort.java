public class StoogeSort
{
    static public <T extends Comparable<T>>void sort(T[] arr, int i, int j) // i is first index, j is last index
    {
        if (i >= j)
        {
            return;
        }

        if (arr[i].compareTo(arr[j]) > 0)
        {
            T temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        if (j - i + 1 > 2)
        {
            int k = (j - i + 1) / 3;
            sort(arr, i, j - k);
            sort(arr, i + k, j);
            sort(arr, i, j - k);
        }
    }
}
