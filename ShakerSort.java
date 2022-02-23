public class ShakerSort
{
    static <T extends Comparable<T>>void sort(T[] arr)
    {
        boolean swapped = true;
        int start = 0;
        int end = arr.length;

        while (swapped)
        {
            swapped = false;
            for (int i = start; i < end - 1; ++i)
            {
                if (arr[i].compareTo(arr[i + 1]) > 0)
                {
                    T temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
            swapped = false;
            end = end - 1;
            for (int i = end - 1; i >= start; i--)
            {
                if (arr[i].compareTo(arr[i + 1]) > 0)
                {
                    T temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
            start = start + 1;
        }
    }
}