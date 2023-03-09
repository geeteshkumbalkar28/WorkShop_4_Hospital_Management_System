//Program: Write a Java program to create a class called "Hospital" with instance variables "patients" (a list of Patient objects) and "numPatients" (the number of patients in the list). Include the following methods:
//
//        A method to add a patient to the list
//        A method to remove a patient from the list
//        A method to search for a patient by their ID
//        A method to sort the patients in the list by their age (ascending or descending order)
//        A method to calculate the average age of all patients
//        A method to print the details of all patients in the hospital

package controler;


import exception.FirstNameException;
import exception.InvalidLastNameException;
import exception.MobileNumberException;
import model.Patient;
import services.HospitalImp;

import java.util.Scanner;

public class HospitalMain {
    private static Patient patient;
    private static HospitalImp hospitalImp = new HospitalImp();
    private static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int checkCondition = 0;
        do {
            System.out.println("Enter your choice");
            System.out.println("1 : Insert information");
            System.out.println("2 : Remove information by first name");
            System.out.println("3 : Search for a patient by their ID ");
            System.out.println("4 : sort the patients in the list by their age (ascending or descending order) ");
            System.out.println("5 : calculate the average age of all patients ");
            System.out.println("6 : print the details of all patients in the hospital ");
            System.out.println("10 : Tarminate the application ");

            checkCondition = SCANNER.nextInt();
            switch (checkCondition) {
                case 1:
                    try{

                        insertInfo();
                    }catch (InvalidLastNameException lastName)
                    {
                        System.err.println(lastName);
                        insertInfo();
                    }catch (FirstNameException firstName)
                    {
                        System.err.println(firstName);
                        insertInfo();
                    }catch (MobileNumberException mobileNumber)
                    {
                        System.err.println(mobileNumber);
                        insertInfo();
                    }

                    break;
                case 2:
                    hospitalImp.removeByName(SCANNER);
                    break;
                case 3:
                    hospitalImp.searchById(SCANNER);
                    break;
                case 4:
                    hospitalImp.sortByAge();
                    break;
                case 5:
                    System.out.println("Average age of all patients :" + hospitalImp.calculateAverageAgeOfAllPatient());
                    break;
                case 6:
                    hospitalImp.displyInfo();
                    break;
                case 10:
                    hospitalImp.insertInJdbc();
                    checkCondition = 0;
                    break;
            }
        } while (checkCondition != 0);
    }

    public static void insertInfo() {
        patient = new Patient();
//        private int patientId;
//        private int age;
//        private String firstName;
//        private String lastName;
//        private long mobileNo;
//        private String city;
        System.out.println("Enter the patient Id");
        int id = SCANNER.nextInt();
        patient.setPatientId(id);

        System.out.println("Enter the patient age");
        int age = SCANNER.nextInt();
        patient.setAge(age);

        System.out.println("Enter the patient firstName");
        String fName = SCANNER.next();
        patient.setFirstName(fName);
        System.out.println("Enter the patient lastName");
        String lName = SCANNER.next();
        patient.setLastName(lName);
        System.out.println("Enter the patient city");
        String city = SCANNER.next();
        patient.setCity(city);
        System.out.println("Enter the patient mobileNo");
        long mobileNo = SCANNER.nextLong();
        patient.setMobileNo(mobileNo);

        hospitalImp.insertPatientinfo(patient);
    }
}
