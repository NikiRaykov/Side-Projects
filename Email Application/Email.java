package EmailApp;

import java.security.SecureRandom;
import java.util.Scanner;

public class Email {
    // Variables Setup
    private String firstName;
    private String lastName;
    private String department;
    private String password;
    private int defaultPrivatePassword = 10;
    private String email;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String companySuffix = ".company.com";

    // Constructor to receive first and last name

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
       // System.out.println("Email created: " + this.firstName + " " +  this.lastName);

         // Call a method to ask for the department
        this.department = setDepartment();
        // System.out.println("Department is: " + this.department);

        // Call a method that returns a random password
        this.password = generateARandomPassword(defaultPrivatePassword);
        // System.out.println("Your password is: " + this.password);

        // Combine elements to generate email
       emailGenerate(firstName, lastName);
       // System.out.println("Your email address is: " + emailGenerate(firstName, lastName));
    }

    private String emailGenerate(String firstName, String lastName) {
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + companySuffix;
        return email;
    }

    // Ask for the department
    private String setDepartment(){
        System.out.print("DEPARTMENT CODES\n1 for Sales\n2 for Accounting\n3 for Development\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);

     int departmentChoice = in.nextInt();

     if (departmentChoice == 1){
         return "Sales";
     }else if (departmentChoice == 2){
         return  "Accounting";
     }else if (departmentChoice == 3){
         return "Development";
     }
     return "";
    }

    // Generate a random password
    public String generateARandomPassword(int length){
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        return sb.toString();

    }

    // Method to change the password
    public void changePassword(String newPassword){
        this.password = newPassword;
    }

    // Method to set the mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    // Method for an alternative email address
    public void setAltEmailAddress(String altEmail){
        this.alternateEmail = altEmail;
    }

    public int getMailBoxCapacity(){    return mailboxCapacity; }

    public String displayPassword(){      return password; }

    public String displayAlternateEmail(){     return alternateEmail; }

    public String showInfo(){
        return "Name: " + firstName + lastName +
                "\nCompany email: " + email +
                "\nMailbox capacity: " + mailboxCapacity + " mb";
    }
}
