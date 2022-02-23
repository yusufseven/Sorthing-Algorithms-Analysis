public class Main
{
    public static void main(String[] args)
    {
        SortManager sortManager = new SortManager();

        int[] allSizes = {2, 4, 8, 16, 32, 64, 128, 256, 512}; // 1024, 2048, 4096 removed for testing in dev servers
        sortManager.runSort(100, allSizes);

    }
}
