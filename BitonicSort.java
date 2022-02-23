public class BitonicSort
{

    static <T extends Comparable<T>> void compAndSwap(T[] arr, int i, int j, int direction)
    {
        if ((arr[i].compareTo(arr[j]) > 0 && direction == 1) || (arr[i].compareTo(arr[j]) < 0 && direction == 0))
        {
            T temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    static <T extends Comparable<T>> void bitonicMerge(T[] a, int low, int count, int direction)
    {
        if (count > 1)
        {
            int k = count / 2;
            for (int i = low; i < low + k; i++)
                compAndSwap(a, i, i + k, direction);
            bitonicMerge(a, low, k, direction);
            bitonicMerge(a, low + k, k, direction);
        }
    }

    static <T extends Comparable<T>> void bitonicSort(T[] arr, int low, int count, int direction)
    {
        if (count > 1)
        {
            int k = count / 2;
            bitonicSort(arr, low, k, 1);
            bitonicSort(arr, low + k, k, 0);
            bitonicMerge(arr, low, count, direction);
        }
    }

    static <T extends Comparable<T>> void sort(T[] arr, int arraySize, int up)
    {
        bitonicSort(arr, 0, arraySize, up);
    }
}