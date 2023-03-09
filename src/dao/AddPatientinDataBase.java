package dao;

import utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.LinkedList;

public class AddPatientinDataBase {
    public void addPatient(Connection connection,int patientId ,int age,String firstName,String lastName ,long mobileNo,String city)
    {

            try {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into Hospital_Manegement_System(patientId,age,firstName,lastName,mobileNo,city)"+" values(?,?,?,?,?,?);");
                preparedStatement.setInt(1,patientId);
                preparedStatement.setInt(2,age);
                preparedStatement.setString(3,firstName);
                preparedStatement.setString(4,lastName);
                preparedStatement.setLong(5,mobileNo);
                preparedStatement.setString(6,city);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }catch (Exception e)
            {
                System.err.println("Exception occur !!!!!!!!!!!!!!!! "+e);
            }


    }
}
