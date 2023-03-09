package services;

import Interface.IHospital;
import dao.AddPatientinDataBase;
import model.Patient;
import utility.DBConnection;
import utility.RegexUtil;

import java.sql.Connection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HospitalImp implements IHospital {
    private static Connection connection = DBConnection.dbconnection.getConnection();
    private static LinkedList<Patient> list = new LinkedList<>();

    @Override
    public void insertPatientinfo(Patient pojoPatient) {
        RegexUtil regexUtil = new RegexUtil();
        if(regexUtil.isValidFirstName(pojoPatient.getFirstName()))
        {
            if(regexUtil.isValidLastName(pojoPatient.getLastName()))
            {
                if(regexUtil.isValidMobileNumber(Long.toString(pojoPatient.getMobileNo())))
                {

                    list.add(pojoPatient);
                    System.out.println(pojoPatient.toString());

                }
            }

        }
    }

    @Override
    public void removeByName(Scanner scanner) {
        System.out.println("Enter the name of that patient that you want to remove the information");
        String fName = scanner.next();
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i).getFirstName()).equals(fName)) {
                list.remove(i);
            }

        }
    }

    @Override
    public void searchById(Scanner scanner) {
        System.out.println("Enter the Id of that patient that you want to search the information");
        int id = scanner.nextInt();

        list.stream()
                .filter(n -> n.getPatientId() == id)
                .forEach(n -> System.out.println("Age is :" + n.getAge()));


    }

    private static void sortedPatientsByAgeAs() {
        List<Patient> sortedPatientsByAgeAsc = list.stream()
                .sorted(Comparator.<Patient, Integer>comparing(Patient::getAge))
                .collect(Collectors.toList());
        for (int i = 0; i < sortedPatientsByAgeAsc.size(); i++) {

            System.out.println(sortedPatientsByAgeAsc.get(i).toString());

        }
    }

    private static void sortedPatientsByAgeDes() {
        List<Patient> sortedPatientsByAgeDesc = list.stream()
                .sorted(Comparator.<Patient, Integer>comparing(Patient::getAge).reversed())
                .collect(Collectors.toList());

        for (int i = 0; i < sortedPatientsByAgeDesc.size(); i++) {

            System.out.println(sortedPatientsByAgeDesc.get(i).toString());

        }
    }

    @Override
    public void sortByAge() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1 :ascending ");
        System.out.println("2 : descending ");
        int checkCondition = scanner.nextInt();
        switch (checkCondition) {
            case 1:
                sortedPatientsByAgeAs();
                break;
            case 2:
                sortedPatientsByAgeDes();
                break;
        }


    }

    @Override
    public int calculateAverageAgeOfAllPatient() {
        int AverageAgeOfPatient = 0;
        for (int i = 0; i < list.size(); i++) {
            AverageAgeOfPatient = AverageAgeOfPatient + (list.get(i).getAge());
        }
        AverageAgeOfPatient = AverageAgeOfPatient / (list.size());
        return AverageAgeOfPatient;

    }

    @Override
    public void displyInfo() {
        System.out.println("************************************************************************************");

        for (int i = 0; i < list.size(); i++) {

            System.out.println("********************** Patient" + (i + 1) + "***********************");

            System.out.println(list.get(i).toString());
        }

        System.out.println("*************************************************************************************");
    }
    public void insertInJdbc()
    {
        AddPatientinDataBase addPatientinDataBase = new AddPatientinDataBase();
        for(int counter =0;counter<list.size();counter++)
        {
                addPatientinDataBase.addPatient(connection,list.get(counter).getPatientId(),list.get(counter).getAge(),list.get(counter).getFirstName(),list.get(counter).getLastName(),list.get(counter).getMobileNo(),list.get(counter).getCity());
        }


    }
}
