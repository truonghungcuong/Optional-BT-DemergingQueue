import java.util.*;

public class Main {

    public static final String MALE = "male";
    public static final String FEMALE = "female";

    public static void main(String[] args) {
        ArrayList<Employee> employees = newEmployeeList();
        System.out.println("Danh sách nhân viên ban đầu: ");
        printEmployeeList(employees);

        System.out.println("Danh sách nhân viên demerged: ");
        ArrayList<Employee> demergeEmployeeList = demergeEmployeeList(employees);
        printEmployeeList(demergeEmployeeList);

    }
    public static void printEmployeeList(ArrayList<Employee> list){
        for (int i = 0; i< list.size(); i++){
            System.out.printf("%d.\t %s\n", i+1, list.get(i).toString());
        }
    }

    public static ArrayList<Employee> demergeEmployeeList(ArrayList<Employee> list){
        Queue<Employee> maleQueue = new LinkedList<>();
        Queue<Employee> femaleQueue = new LinkedList<>();
        ArrayList<Employee> demerged = new ArrayList<>();

        list.forEach(employee-> {
            if (employee.getGender().equals(FEMALE))
                femaleQueue.add(employee);
            else
                maleQueue.add(employee);
        });

        femaleQueue.forEach(employee -> demerged.add(employee));
        maleQueue.forEach(employee -> demerged.add(employee));

        return demerged;
    }

    public static ArrayList<Employee> newEmployeeList(){
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("Vũ Hoàng V", "22/01/2001", MALE));
        list.add(new Employee("Trương Tiến D", "11/01/2001", MALE));
        list.add(new Employee("Nguyễn Thị Thu T", "05/09/2001", FEMALE));

        return list;
    }
}