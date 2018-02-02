package Question7;

import java.util.Comparator;

public class SortDepartment implements Comparator<Employee>
{
    // Used for sorting in ascending order by name
    public int compare(Employee a, Employee b)
    {
        return a.department.compareTo(b.department);
    }
}