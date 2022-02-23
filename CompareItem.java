public class CompareItem implements Comparable<CompareItem>
{
    int int_val;
    int int_stab;   

    public CompareItem(int int_val, int int_stab)
    {
        this.int_val = int_val;
        this.int_stab = int_stab;
    }

    @Override
    public int compareTo(CompareItem item)
    {
        if (item.int_val < this.int_val)
        {
            return 1;
        } else if (item.int_val == this.int_val)
        {
            return 0;
        } else
        {
            return -1;
        }
    }
}
