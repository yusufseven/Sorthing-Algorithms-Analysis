public class GnomeSort
{
    static public<T extends Comparable<T>> void sort(T[] arr)
    {
        int i = 0;

        while (i < arr.length)
        {
            if (i == 0)
            {
                i++;
            }
            if (arr[i].compareTo(arr[i - 1]) >= 0)
            {
                i++;
            }
            else
            {
                T temp;
                temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
                i--;
            }
        }
    }
}
