package Question7;

import java.util.Comparator;

public class SortByName implements Comparator<Employee>
{
    // Used for sorting in ascending order by name
    public int compare(Employee a, Employee b)
    {
        return a.name.compareTo(b.name);
    }
}