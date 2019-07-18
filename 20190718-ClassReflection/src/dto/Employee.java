package dto;
 
public class Employee extends Person {
    private static double salary = 0.;
 
    @Override
    public String toString() {
        return super.toString()+" Employee [salary=" + salary + "]";
    }
}