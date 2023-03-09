package Interface;

import model.Patient;

import java.util.Scanner;

public interface IHospital {

    void insertPatientinfo(Patient pojoPatient);

    void removeByName(Scanner scanner);

    void searchById(Scanner scanner);

    void sortByAge();

    int calculateAverageAgeOfAllPatient();

    void displyInfo();


}
