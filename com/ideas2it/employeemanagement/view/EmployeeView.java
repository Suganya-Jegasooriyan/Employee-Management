package com.ideas2it.employeemanagement.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.ideas2it.employeemanagement.model.Address;
import com.ideas2it.employeemanagement.model.Employee;
import com.ideas2it.employeemanagement.controller.EmployeeController;

/** 
 * Gets the input from user and displays the output
 * version 1.0.0
 */
public class EmployeeView {

    private Scanner input = new Scanner(System.in);
    private EmployeeController controller = new EmployeeController();

    /** 
     * Shows the main menu for users
     */
    public void showMenu() {

        boolean isValid = false;
       
        System.out.println("\n ........Welcome to Employee Management "
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
                System.out.println("\nPlease Enter the correct option1111\n");
                isValid = false;
            }
        } while(!isValid);
        return option;
    }
    
    /**
     * Creates the employee details and passes to controller
     *
     */
    public void create() {

        boolean isExits = false;
        boolean isValid = false;
        int id = 0;
	    String option;

        do {
            Employee employee = new Employee();
            employee.setFirstName(getAndValidateFirstName());
            employee.setLastName(getAndValidateLastName());
            employee.setSalary(getAndValidateSalary());
            employee.setMailId(getAndValidateMailId());
            employee.setMobileNumber(getAndValidateMobileNumber());
            employee.setDateOfBirth(getAndValidateDateOfBirth());     
            employee.setAddress(employeeAddress());
            id = controller.setEmployee(employee);
            System.out.println("\nGenerated ID: " + id + "\nCreated successfully\n");
            do {
                System.out.println("\n Do You want to Continue to add employee"
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
     * Collects the employees address and pass it to controller  
     *
     */
    public List employeeAddress() {

        boolean isValid = false;
        List<Address> addDetails = new ArrayList<>();
        System.out.println("\nEnter the current address\n");

        do {
            Address address = new Address();
            address.setAddressType(getAndValidateAddressType());
            address.setFirstLine(getAndValidateFirstLine());
            address.setSecondLine(getAndValidateSecondLine());
            address.setCity(getAndValidateCity());
            address.setDistrict(getAndValidateDistrict());
            address.setState(getAndValidateState());
            address.setPinCode(getAndValidatePinCode());
            addDetails.add(address);
            System.out.println("\n Do You want to Continue to add employee "
                    + "permanent address ? \n1.Yes \n2.No");
            switch (isValidOption()){
                case "1":
                    System.out.println("\nEnter the permanent address\n");
                    break;
                    
                case "2":
                    isValid = true;
                    break;
                    
        
                default:System.out.println("\nPlease Enter the correct option");          
            }
        } while(!isValid);
        return addDetails;
    }
    
    /**
     * Gets the id from user and pass it to controller for validation
     *
     * @return boolean value
     */
    public int getAndValidateId() {

        boolean isValid = false;
        int id = 0;

        do {
            System.out.println("Enter the ID:");
            id = input.nextInt(); 
            if (controller.validateId(id)) {
                isValid = true;   
            } else {
                System.out.println("\nPlease Enter valid ID\n");
            } 
        } while (!isValid);          
        return id;  
    }

    /**
     * Gets the first name from user and pass it to controller for validation
     * @return firstname. 
     */
    public String getAndValidateFirstName() {

        boolean isValid = false;
        String firstName = null;

        do {
            System.out.print("Enter FirstName: ");
            firstName = input.nextLine();
            if (controller.validateFirstName(firstName)) {
                firstName = firstName.substring(0,1).toUpperCase(
                        ) + firstName.substring(1);
                isValid = true;
            } else {
                System.out.println("\n...Please Enter the correct firstname"
                        + "(note:It must contains characters only)...\n");
            }
        } while (!isValid);
        return firstName;
    }
    
    /**
     * Gets the last name from user and pass it to controller for validation
     * @return lastname. 
     */
    public String getAndValidateLastName() {

        boolean isValid = false;
        String lastName;

        do {
            System.out.print("Enter LastName: ");
            lastName = input.nextLine();
            if (controller.validateLastName(lastName)) {
                lastName = lastName.substring(0,1).toUpperCase(
                        )+ lastName.substring(1);
                isValid = true;
            } else {
                System.out.println("\n...Please Enter the correct LastName"
                        + "(note:It must contains alphabets only)...\n");
            }
        } while (!isValid);     
        return lastName;  
    }
   
    /**
     * Gets the salary from user and pass it to controller for valiadtion
     * @return salary. 
     */
    public String getAndValidateSalary() {

        boolean isValid = false;
        String salary = null;

        do {
            System.out.print("Enter Salary: ");
            salary = input.nextLine();
            if (controller.validateSalary(salary)) {
                isValid = true;
            } else {
                System.out.println("\nPlease Enter minimum 1000 upto maximum"
                        + " 1000000\n");
            }
        } while (!isValid);     
        return salary;  
    }
    
    /**
     * Gets the mobile number from user and pass it to controller for validation
     * @return mobile number.  
     */
    public String getAndValidateMobileNumber() {

        boolean isValid = false;
        String mobileNumber = null;

        do {
            System.out.print("Enter MobileNumber: ");
            mobileNumber = input.nextLine();
            if (controller.validateMobileNumber(mobileNumber)) {
                isValid = true;
            } else {
                System.out.println("\nPlease enter the 10 digits"
                        + "(eg.7358520563)\n");
            }
        } while (!isValid);     
        return mobileNumber;  
    }

    /**
     * Gets the mail id from user and pass it to controller for validation
     * @return mailId. 
     */
    public String getAndValidateMailId() {

        boolean isValid = false;
        String mailId = null;
         
        do {
            System.out.print("Enter the MailId: ");
            mailId = input.nextLine();
            if (controller.validateMailId(mailId)) {
                isValid = true;
            } else {
                System.out.println("\n...Please Enter valid MailId...\n");
            }
        } while (!isValid);
        return mailId;   
    }

    /**
     * Gets the date of birth from user and pass it to controller for validation
     * @return dateofbirth. 
     */
    public LocalDate getAndValidateDateOfBirth() {

        String date; 
        boolean isValid = false;
        LocalDate dateOfBirth = null;
 
        do {
            System.out.print("Enter Date Of Birth(YYYY-MM-DD): ");
            date = input.nextLine();
            if (controller.validateDateOfBirth(date)) {
                dateOfBirth = LocalDate.parse(date);
                isValid = true;
            } else {
                System.out.println("\n...Please Enter the correct "
                        + "dateofbirth...\n");
            }
        } while (!isValid);
        return dateOfBirth;
    }  

    /**
     * Displays the particular employee records or
     * Displays the all employee records.
     */
    public void view() {

        List<Employee> list = new ArrayList<>();
        boolean isValid = false;
        int id;
        String option;

	    do {
            System.out.println("\n 1.View particular employee \n 2.View all "
                    +"employee \n 3.Back");
            switch (isValidOption()) {
                case "1":
                    viewParticularEmployee(); 
                    isValid = true;
                    break;
 
                case "2":
                    list = controller.viewAllEmployee();
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
    public void viewParticularEmployee() { 

       boolean isValid = false;
       int id;

        do {
            id = getAndValidateId();
            if (controller.viewParticularEmployee(id) != null) {
                System.out.println(controller.viewParticularEmployee(id));
                isValid = true;
            } else {
                System.out.println("Please Enter valid Employee ID ");
            }                        
        }while(!isValid);
    }

    /**
     * Updates the particular employee records or
     * Updates particular column of employee records.
     */
    public void update() {

        boolean isValid = false;
	    int id;
	    String option;

        do {
            System.out.println("\n1.Update particular employee details \n2.Update"
                    + " specific type \n3.Update address \n4.Back ");

            switch (isValidOption()) {
                case "1":
                    id = getAndValidateId();
                    updateFullDetails(id); 
                    break;

                case "2":
                    id = getAndValidateId();
                    updateSpecificDetails(id);
                    break;
                    
                case "3":
                    id = getAndValidateId();
                    updateAddress(id);
                    break;

                case "4":   
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
    public void updateFullDetails(int id) {   
        
        String firstName = getAndValidateFirstName();
        controller.updateFirstName(id, firstName);

        String lastName = getAndValidateLastName();
        controller.updateLastName(id, lastName);

        String mobileNumber = getAndValidateMobileNumber();
        controller.updateMobileNumber(id, mobileNumber);

        String salary = getAndValidateSalary();
        controller.updateSalary(id, salary);

        String mailId = getAndValidateMailId();
        controller.updateMailId(id, mailId);     
        
        LocalDate dateOfBirth = getAndValidateDateOfBirth();
        controller.updateDateOfBirth(id, dateOfBirth);
        System.out.println("\n...Updated Successfully...");     
    }

    /**
     * Updates the specific field of particular employee details 
     */
    public void updateSpecificDetails(int id) {

        boolean isValid = false;   
        String option; 

        do {           
            System.out.println("\n Choose the option to update the Employee " 
                    + "Details \n1.FirstName \n2.LastName \n3.MobileNumber" 
                    + "\n4.Salary \n5.MailId \n6.DateOfBirth \n7.Exit");
            switch (isValidOption()) {               
	            case "1":
                    String firstName = getAndValidateFirstName();
                    controller.updateFirstName(id, firstName);
	                break;
				
	            case "2":
                    String lastName = getAndValidateLastName();
                    controller.updateLastName(id, lastName);
	                break;
				
	            case "3":
                    String mobileNumber = getAndValidateMobileNumber();
                    controller.updateMobileNumber(id, mobileNumber);
	                break;

	            case "4":
                    String salary = getAndValidateSalary();
                    controller.updateSalary(id, salary);
	                break;

                case "5":
                    String mailId = getAndValidateMailId();
                    controller.updateMailId(id, mailId);
	                break;

                case "6":
                    LocalDate dateOfBirth = getAndValidateDateOfBirth();
                    controller.updateDateOfBirth(id, dateOfBirth);
	                break;

	            case "7":
	                System.out.println("Back to update option ");
                    isValid = true;
	                break;

	            default: System.out.println("\n...Please Enter the correct option...\n");
            }
            System.out.println("Updated Successfully");
        } while (!isValid); 
    }

    /**
     * updates the particular employee address
     *
     */
    public void updateAddress(int id) {

        String firstLine;
        String secondLine;
        String city;
        String district;
        String state;
        String pinCode;
        String addressType;
        System.out.println("\n1.update current address \n2.update permanent "
               + "address");
        switch (isValidOption()) {   
            case "1":
                System.out.println("Enter the current address");
                addressType = "current";
                firstLine = getAndValidateFirstLine();
                secondLine = getAndValidateSecondLine();
       	        city = getAndValidateCity();
	            district = getAndValidateDistrict();
                pinCode = getAndValidatePinCode();
	            state = getAndValidateState();
                controller.updateCurrentAddress(id, addressType, firstLine,
                        secondLine, city, state, district, pinCode);
                break;
      
            case "2":
                System.out.println("Enter the permanent address");
                addressType = "permanent";
                firstLine = getAndValidateFirstLine();
                secondLine = getAndValidateSecondLine();
       	        city = getAndValidateCity();
	            district = getAndValidateDistrict();
                pinCode = getAndValidatePinCode();
	            state = getAndValidateState();
                controller.updatePermanentAddress(id, addressType, firstLine, 
                        secondLine, city, state, district, pinCode);
                break;

            default:System.out.println("Please Enter the correct option");           
        }
    }

    public String getAndValidateAddressType() {

        boolean isValid = false;
        String addressType;
        
        do {
            System.out.print("Enter the AddressType(Current/Permanent): ");
            addressType = input.nextLine();
            if (controller.validateAddressType(addressType)) {
                isValid = true;
            } else {
                System.out.println("\n...Please Enter valid MailId...\n");
            }
        } while (!isValid);
        return addressType;    
    }

    /**
     * Gets the first line of address from user and pass it to 
     * controller for validation
     * @return firstLine. 
     */
    public String getAndValidateFirstLine() {
		
	    boolean isValid = false;
	    String firstLine;
		
	    do {
	        System.out.print("Enter the Address First Line: ");
	        firstLine = input.nextLine();
            if (controller.validateFirstLine(firstLine)) {
                isValid = true;
            } else {
                System.out.println("\n...Please Enter valid MailId...\n");
            }
        } while (!isValid);
	    return firstLine;
    }

    /**
     * Gets the second line of address from user and pass it 
     * to controller for validation
     * @return secondLine. 
     */
    public String getAndValidateSecondLine() {
		
	    boolean isValid = false;
	    String secondLine;
		
	    do {
	        System.out.print("Enter the Address Second Line: ");
	        secondLine = input.nextLine();
            if (controller.validateSecondLine(secondLine)) {
                isValid = true;
            } else {
                System.out.println("\n...Please Enter valid MailId...\n");
            }
        } while (!isValid);
	    return secondLine;
    }	

    /**
     * Gets the city from user and pass it to controller for validation
     * @return city. 
     */
    public String getAndValidateCity() {
		
	    boolean isValid = false;
	    String city;
		
	    do {
	        System.out.print("Enter the city: ");
	        city = input.nextLine();
            if (controller.validateCity(city)) {
                isValid = true;
            } else {
                System.out.println("\n...Please Enter valid MailId...\n");
            }
        } while (!isValid);
	    return city;
    }	

    /**
     * Gets the district from user and pass it to controller for validation
     * @return district. 
     */
    public String getAndValidateDistrict() {
		
	    boolean isValid = false;
	    String district;
		
	    do {
	        System.out.print("Enter the district: ");
	        district = input.nextLine();
            if (controller.validateDistrict(district)) {
                isValid = true;
            } else {
                System.out.println("\n...Please Enter valid MailId...\n");
            }
        } while (!isValid);
	return district;
    }	

    /**
     * Gets the state from user and pass it to controller for validation
     * @return state. 
     */
    public String getAndValidateState() {
		
	    boolean isValid = false;
	    String state;
		
	    do {
	        System.out.print("Enter the state: ");
	        state = input.nextLine();
            if (controller.validateState(state)) {
                isValid = true;
            } else {
                System.out.println("\n...Please Enter valid MailId...\n");
            }
        } while (!isValid);
	return state;
    }

    /**
     * Gets the pincode from user and pass it to controller for validation
     * @return pincode. 
     */
    public String getAndValidatePinCode() {
		
        boolean isValid = false;
        String pinCode;
		
	    do {
	        System.out.print("Enter the pincode: ");
	        pinCode = input.nextLine();
            if (controller.validatePinCode(pinCode)) {
                isValid = true;
            } else {
                System.out.println("\n...Please Enter valid MailId...\n");
            }
        } while (!isValid);
        return pinCode;
    }

    /**
     * Deletes the particular employee records or 
     */
    public void delete() {

        boolean isValid = false;
	    int id;
        String addressType;
	    String option;
        System.out.println("\n1.Delete particular employee details \n2.Delete " 
                + "particular employee current address\n3.Delete particular"
                + "employee permanent address \n4.Back");
                   
        do {
            switch(isValidOption()) {
                case "1":
                    id = getAndValidateId();
                    controller.deleteParticularEmployee(id);
                    System.out.println("\nDeleted successfully..");
                    isValid = true;
                    break;

                case "2":
                    id = getAndValidateId(); 
                    addressType = getAndValidateAddressType();  
                    controller.deleteCurrentAddress(id, addressType);
                    isValid = true;
                    break;

                case "3":
                    System.out.println("Enter the Id: ");
                    id = getAndValidateId();
                    addressType = getAndValidateAddressType();    
                    controller.deletePermanentAddress(id, addressType);
                    isValid = true;
                    break; 

                case "4":
                    isValid = false;
                    break;
               
                default:System.out.println("...Please Enter the correct option..."); 
            }
       } while (!isValid);
    }	
}