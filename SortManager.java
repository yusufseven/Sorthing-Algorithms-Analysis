public class SortManager
{
    public static void buffer(int bufferSize)   // buffer method is required for warming up in order to get more consistent results
    {
        ArrayUtility utility = new ArrayUtility();

        CompareItem[] combBuffer = new CompareItem[bufferSize];
        utility.fillArray(combBuffer, bufferSize);
        CombSort.sort(combBuffer);

        CompareItem[] gnomeBuffer = new CompareItem[bufferSize];
        utility.fillArray(gnomeBuffer, bufferSize);
        GnomeSort.sort(gnomeBuffer);

        CompareItem[] shakerBuffer = new CompareItem[bufferSize];
        utility.fillArray(shakerBuffer, bufferSize);
        ShakerSort.sort(shakerBuffer);

        CompareItem[] stoogeBuffer = new CompareItem[bufferSize];
        utility.fillArray(stoogeBuffer, bufferSize);
        StoogeSort.sort(stoogeBuffer, 0, stoogeBuffer.length - 1);

        CompareItem[] bitonicBuffer = new CompareItem[bufferSize];
        utility.fillArray(bitonicBuffer, bufferSize);
        BitonicSort.sort(bitonicBuffer, bitonicBuffer.length, 1);

        System.out.println("=====================================");
        System.out.println("Done buffering");
        System.out.println("=====================================");
    }

    public static void sortAll(int sortAmount, int arrSize)
    {
        ArrayUtility utility = new ArrayUtility();

        long totalTimeComb = 0;
        long totalTimeGnome = 0;
        long totalTimeShaker = 0;
        long totalTimeStooge = 0;
        long totalTimeBitonic = 0;

        for (int i = 0; i < sortAmount; i++)
        {
            CompareItem[] myArr = new CompareItem[arrSize];
            utility.fillArray(myArr, arrSize);

            CompareItem[] temp1 = myArr;        // Creating 5 copies of this created array so that we can use the same
            CompareItem[] temp2 = myArr;        // array for our loops.
            CompareItem[] temp3 = myArr;
            CompareItem[] temp4 = myArr;
            CompareItem[] temp5 = myArr;

            long timeAComb = System.nanoTime();
            CombSort.sort(temp1);
            long timeBComb = System.nanoTime();

            long timeAGnome = System.nanoTime();
            GnomeSort.sort(temp2);
            long timeBGnome = System.nanoTime();

            long timeAShaker = System.nanoTime();
            ShakerSort.sort(temp3);
            long timeBShaker = System.nanoTime();

            long timeAStooge = System.nanoTime();
            StoogeSort.sort(temp4, 0, temp4.length - 1);
            long timeBStooge = System.nanoTime();

            long timeABitonic = System.nanoTime();
            BitonicSort.sort(temp5, temp5.length, 1);
            long timeBBitonic = System.nanoTime();

            if (i != 0)
            {
                totalTimeComb += timeBComb - timeAComb;
                totalTimeGnome += timeBGnome - timeAGnome;
                totalTimeShaker += timeBShaker - timeAShaker;
                totalTimeStooge += timeBStooge - timeAStooge;
                totalTimeBitonic += timeBBitonic - timeABitonic;
            }
        }
        // outputs that shows up each loop
        System.out.println("Sort amount = " + sortAmount + "    Array Size = " + arrSize);
        System.out.println("-------------------------------------");
        System.out.println("CombSort       avg time : " + totalTimeComb / sortAmount);
        System.out.println("GnomeSort      avg time : " + totalTimeGnome / sortAmount);
        System.out.println("ShakerSort     avg time : " + totalTimeShaker / sortAmount);
        System.out.println("StoogeSort     avg time : " + totalTimeStooge / sortAmount);
        System.out.println("BitonicSort    avg time : " + totalTimeBitonic / sortAmount);
        System.out.println("-------------------------------------");
        System.out.println();
    }

    public static void runSort(int sortAmount, int[] allSizes)
    {
        buffer(100);
        for (int i : allSizes)
        {
            sortAll(sortAmount, i);
        }
    }
}
