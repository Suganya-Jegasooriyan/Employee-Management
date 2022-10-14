package com.ideas2it.employeemanagement.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ideas2it.employeemanagement.model.Employee;
import com.ideas2it.employeemanagement.model.EmployeeProject;
import com.ideas2it.employeemanagement.controller.ProjectController;

public class ProjectView {

    private Scanner input = new Scanner(System.in);
    private ProjectController controller = new ProjectController();

    /** 
     * Shows the main menu for users
     */
    public void showMenu() {

        boolean isValid = false;
        System.out.println("\n ........Welcome to Project Management "
                + "Application........\nMain Menu:");
        
	    do {
            System.out.println("\n1.create \n2.update \n3.delete \n4.view "
                    + "\n5.exit"); 
            switch (isValidOption()) {
                case "1":
                    System.out.println("...Create...");
                    create();
	                break;
			
	            case "2":
	                System.out.println("...Update...");
                    update();
	                break;
				
	            case "3":
	                System.out.println("...Delete...");
                    delete();
	                break;
                
                case "4":
	                System.out.println("...View...");
                    view();
	                break;

		        case "5":
	                System.out.println("Exit \n\5Thank You\5");
                    isValid = true;
                    break;

	            default: System.out.println("\nPlease enter the correct option\n");
	        }
	    } while (!isValid);
    }

    /**
     * Gets the option from user and pass it to controller
     *
     * @return option 
     */
    public String isValidOption() {
  
        String option;
        boolean isValid = false; 

        do {
            System.out.println("Enter the option: ");
            option = input.next();
            if (controller.isValidOption(option)) {
                isValid = true;
            } else {
                System.out.println("\nPlease Enter the correct option\n");
                isValid = false;
            }
        } while(!isValid);
        return option;
    }

    public void create() {

        boolean isExits = false;
        boolean isValid = false;
        int projectId = 0;
	    String option;

        do {
            EmployeeProject project = new EmployeeProject();
            project.setCustomerId(getAndValidateCustomerId());
            project.setCustomerMailId(getAndValidateCustomerMailId());
            project.setProjectName(getAndValidateProjectName());
            project.setDateOfStart(getAndValidateDateOfStart());
            project.setDateOfEnd(getAndValidateDateOfEnd());    
            controller.setAllProject(project);
            projectId = project.getProjectId();
            System.out.println("\nGenerated Project ID: " + projectId + "\nCreated successfully\n");

            do {
                System.out.println("\n Do You want to Continue to add project"
                        + " details ? \n1.Yes \n2.No");
                switch (isValidOption()){
                    case "1":
                        isValid = true;
                        isExits = false;
                        break;

                    case "2":
                        isValid = true;
                        isExits = true;  
                        break; 
      	
                    default:System.out.println("\nPlease Enter the correct option");          
                }
            } while (!isValid); 
        } while (!isExits);
    } 

    /**
     * Gets the project id from user and pass it to controller for validation
     *
     * @return boolean value
     */
    public int getAndValidateProjectId() {

        boolean isValid = false;
        int projectId = 0;

        do {
            System.out.println("Enter the ID:");
            projectId = input.nextInt(); 
            if (controller.validateProjectId(projectId)) {
                isValid = true;   
            } else {
                System.out.println("\nPlease Enter valid ID\n");
            } 
        } while (!isValid);          
        return projectId;  
    }

    /**
     * Gets the customer id from user and pass it to controller for validation
     *
     * @return boolean value
     */
    public int getAndValidateCustomerId() {

        boolean isValid = false;
        int customerId = 0;

        do {
            System.out.println("Enter the Customer ID:");
            customerId = input.nextInt(); 
            if (controller.validateCustomerId(customerId)) {
                isValid = true;   
            } else {
                System.out.println("\nPlease Enter valid ID\n");
            } 
        } while (!isValid);          
        return customerId;  
    }

    /**
     * Gets the  customer mailid from user and pass it to controller for validation
     * @return customer mailId. 
     */
    public String getAndValidateCustomerMailId() {

        boolean isValid = false;
        String customerMailId = null;
         
        do {
            System.out.print("Enter the Customer MailId: ");
            customerMailId = input.nextLine();
            if (controller.validateCustomerMailId(customerMailId)) {
                isValid = true;
            } else {
                System.out.println("\n...Please Enter valid customer MailId...\n");
            }
        } while (!isValid);
        return customerMailId;   
    }

    /**
     * Gets the project name from user and pass it to controller for validation
     * @return project name. 
     */
    public String getAndValidateProjectName() {

        boolean isValid = false;
        String projectName;

        do {
            System.out.print("Enter Project Name: ");
            projectName = input.nextLine();
            if (controller.validateProjectName(projectName)) {
                isValid = true;
            } else {
                System.out.println("\n...Please Enter the correct project Name"
                        + "(note:It must contains alphabets only)...\n");
            }
        } while (!isValid);     
        return projectName;  
    }

    /**
     * Gets the date of start from user and pass it to controller for validation
     * @return dateofstart. 
     */
    public LocalDate getAndValidateDateOfStart() {

        String date; 
        boolean isValid = false;
        LocalDate dateOfStart = null;
 
        do {
            System.out.print("Enter Date Of Start(YYYY-MM-DD): ");
            date = input.nextLine();
            if (controller.validateDateOfStart(date)) {
                dateOfStart = LocalDate.parse(date);
                isValid = true;
            } else {
                System.out.println("\n...Please Enter the correct "
                        + "dateofbirth...\n");
            }
        } while (!isValid);
        return dateOfStart;
    }

    /**
     * Gets the date of end from user and pass it to controller for validation
     * @return dateofend. 
     */
    public LocalDate getAndValidateDateOfEnd() {

        String date; 
        boolean isValid = false;
        LocalDate dateOfEnd = null;
 
        do {
            System.out.print("Enter Date Of End(YYYY-MM-DD): ");
            date = input.nextLine();
            if (controller.validateDateOfEnd(date)) {
                dateOfEnd = LocalDate.parse(date);
                isValid = true;
            } else {
                System.out.println("\n...Please Enter the correct "
                        + "dateofbirth...\n");
            }
        } while (!isValid);
        return dateOfEnd;
    }

    /**
     * Displays the particular employee records or
     * Displays the all employee records.
     */
    public void view() {

        List<EmployeeProject> list = new ArrayList<>();
        boolean isValid = false;
        int id;
        String option;

        do {
            System.out.println("\n 1.View particular project \n 2.View all "
                    +"project \n 3.Back");
            switch (isValidOption()) {
                case "1":
                    viewParticularProject(); 
                    isValid = true;
                    break;
 
                case "2":
                    list = controller.viewAllProject();
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(list.get(i)); 
                    }
                    isValid = true;
                    break;

                case "3":
                    System.out.println("\n Back to Main Menu");
                    break;

                default: System.out.println("\n Please Enter the correct option");
            }
        } while (!isValid);
    } 

    /**
     * Displays the particular employee records
     */
    public void viewParticularProject() { 

       boolean isValid = false;
       int projectId;

        do {
            projectId = getAndValidateProjectId();
            //if (controller.viewParticularProject(projectId) != null) {
                System.out.println(controller.viewParticularProject(projectId));
                isValid = true;
            //} else {
                //System.out.println("Please Enter valid Employee ID ");
            //}                        
        }while(!isValid);
    }

    /**
     * Updates the particular employee records or
     * Updates particular column of employee records.
     */
    public void update() {

        boolean isValid = false;
        int projectId;

        do {
            System.out.println("\n1.Update particular project details \n2.Update"
                    + " specific type \n3.Back ");
            switch (isValidOption()) {
                case "1":
                    projectId = getAndValidateProjectId();
                    updateFullDetails(projectId); 
                    break;

                case "2":
                    projectId = getAndValidateProjectId();
                    updateSpecificDetails(projectId);
                    break;
        
                case "3":   
                    System.out.println("\nBack to mainMenu");
                    isValid = true;
                    break; 
 
                default:System.out.println("\n...Please Enter the correct option...\n");
            }
        } while (!isValid);  
    }

    /**
     * Updates the all field of particular employee details
     */
    public void updateFullDetails(int projectId) {   
        
        int customerId = getAndValidateCustomerId();
        controller.updateCustomerId(projectId, customerId);

        String customerMailId = getAndValidateCustomerMailId();
        controller.updateCustomerMailId(projectId, customerMailId);

        String projectName = getAndValidateProjectName();
        controller.updateProjectName(projectId, projectName);     
        
        LocalDate dateOfStart = getAndValidateDateOfStart();
        controller.updateDateOfStart(projectId, dateOfStart);

        LocalDate dateOfEnd = getAndValidateDateOfEnd();
        controller.updateDateOfEnd(projectId, dateOfEnd);
        System.out.println("\n...Updated Successfully...");     
    }

    /**
     * Updates the specific field of particular employee details 
     */
    public void updateSpecificDetails(int projectId) {

        boolean isValid = false;   

        do {           
            System.out.println("\n Choose the option to update the project " 
                    + "Details \n1.customerId \n2.customer email id \n3.project name" 
                    + "\n4.date of start \n5.date of end \n6.Exit");
            switch (isValidOption()) {               
                case "1":
                    int customerId= getAndValidateCustomerId();
                    controller.updateCustomerId(projectId, customerId);
                    break;
                
                case "2":
                    String customerMailId = getAndValidateCustomerMailId();
                    controller.updateCustomerMailId(projectId, customerMailId);
                    break;
                
                case "3":
                    String projectName = getAndValidateProjectName();
                    controller.updateProjectName(projectId, projectName);
                    break;

                case "4":
                    LocalDate dateOfStart = getAndValidateDateOfStart();
                    controller.updateDateOfStart(projectId, dateOfStart);
                    break;

                case "5":
                    LocalDate dateOfEnd = getAndValidateDateOfEnd();
                    controller.updateDateOfEnd(projectId, dateOfEnd);
                    break;

                case "6":
                    System.out.println("Back to update option ");
                    isValid = true;
                    break;

                default: System.out.println("\n...Please Enter the correct option...\n");
            }
            System.out.println("Updated Successfully");
        } while (!isValid); 
    }

    /**
     * Deletes the particular employee records or current address or
     * permanent address 
     */
    public void delete() {

        boolean isValid = false;
        int projectId;
        System.out.println("\n1.Delete particular project details" 
                + "\n2.Back");
                   
        do {
            switch(isValidOption()) {
                case "1":
                    projectId = getAndValidateProjectId();
                    controller.deleteParticularProject(projectId);
                    System.out.println("\nDeleted successfully..");
                    isValid = true;
                    break;

                case "2":
                    isValid = false;
                    break;
               
                default:System.out.println("...Please Enter the correct option..."); 
            }
       } while (!isValid);
    }
}