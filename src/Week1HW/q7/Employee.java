package Week1HW.q7;

/**
 * Functionality: Implements the Employee class which describes employees with a comparison method
 */
public class Employee implements Comparable<Employee> {
    private final String name;
    private String department;
    private int age;

    //parameterized constructor
    Employee(String name, String department, int age) {
        this.name = name;
        this.department = department;
        this.age = age;
    }

    @Override
    public int compareTo(Employee other) { //hierarchy of precedence goes name > department > age
        if(this.name.equals(other.name)){
           if(this.department.equals(other.department)){
               if(this.age == other.age){
                   return 0; //all variables are equal
               }
               else{
                   return this.age > other.age ? 1 : -1; //all variables are equal but age
               }
           }
           else{
               return this.department.compareTo(other.department); //name is equal, department is now
           }
        }
        else{
            return this.name.compareTo(other.name); //name is not equal
        }
    }
    public String toString(){//overrides the tostring function of an object
        return "Name:" + this.name + "/Department:" + this.department + "/Age:" + this.age;
    }
}
