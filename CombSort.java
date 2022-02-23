public class CombSort
{
    static public <T extends Comparable<T>> void sort(T[] arr)
    {
        int size = arr.length;
        int gap = size;
        boolean sorted = true;
        while (gap != 1 || sorted)
        {
            int shrink;
            gap = gap * 10 / 13;
            if (gap < 1)
            {
                shrink = 1;
            } else
            {
                shrink = gap;
            }

            gap = shrink;
            sorted = false;
            for (int i = 0; i < size - gap; i++)
            {
                if (arr[i].compareTo(arr[i + gap]) > 0)
                {
                    T temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;
                    sorted = true;
                }
            }
        }
    }
}