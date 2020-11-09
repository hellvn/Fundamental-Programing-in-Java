package Ex1_4_Employee;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee e1 = new Employee(001, "Hoang", "Vuong", 200);
        System.out.println(e1);
        System.out.println("The full name is: "+ e1.getName());
        System.out.println("The Annual salary is: "+e1.getAnnualSalary());
        System.out.println("The raised salary is: "+e1.raiseSalary(5));
    }
}
