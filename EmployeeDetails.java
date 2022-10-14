import com.ideas2it.employeemanagement.view.EmployeeView;
import com.ideas2it.employeemanagement.view.ProjectView;
import java.util.Scanner;

/**
 * Initiate the controller.
 *
 * @author   Suganya J
 * @version  1.0.0
 */
public class EmployeeDetails {

    public static void main(String[] args) {

        EmployeeView employeeView = new EmployeeView();
        ProjectView projectView = new ProjectView();
        Scanner input = new Scanner(System.in);

        System.out.println("\n1.Employee \n2.Project \nEnter the option: ");
        switch(input.nextInt()){
            case 1:
                employeeView.showMenu();
                break;
            case 2:
                projectView.showMenu();
                break;	
        }
    }
}