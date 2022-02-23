import java.util.Random;

public class ArrayUtility
{
    // prints an array, used for testing
    public void printArray(CompareItem[] arr, String myStr)
    {
        System.out.println(myStr);
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i].int_val + " ");

        System.out.println();
    }


    // Fills given arrays with random integers
    public static void fillArray(CompareItem[] arrName, int size)
    {
        Random ran = new Random();
        for (int i = 0; i < size; i++)
        {
            arrName[i] = new CompareItem(ran.nextInt(100), ran.nextInt());
        }
    }
}
