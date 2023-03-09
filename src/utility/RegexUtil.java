package utility;

import exception.FirstNameException;
import exception.InvalidLastNameException;
import exception.MobileNumberException;

import java.util.regex.Pattern;

public class RegexUtil {
//    public static void main(String[] args) {
//        RegexUtil regexUtil = new RegexUtil();
//        System.out.println(regexUtil.isValidFirstName("Geetesh"));
//
//        System.out.println(regexUtil.isValidFirstName("eetesh"));
//
//        System.out.println(regexUtil.isValidLastName("Keetesh"));
//
//        System.out.println(regexUtil.isValidMobileNumber("447376717"));
//
//    }
    public boolean isValidFirstName(String input) throws FirstNameException
    {
        boolean checkCondition = Pattern.matches(ERegexPattern.FIRST_NAME_PPATTERN.getValue(),input);
        if(!checkCondition)
        {
            throw new FirstNameException("invalid First name !!!!!!!!!!");
        }
        return checkCondition;

    }
    public boolean isValidLastName(String input)throws InvalidLastNameException
    {
        boolean checkCondition = Pattern.matches(ERegexPattern.LAST_NAME_PPATTERN.getValue(),input);
        if(!checkCondition)
        {
            throw new InvalidLastNameException("invalid Last name !!!!!!!!!!");
        }
        return checkCondition;

    }
    public boolean isValidMobileNumber(String input)throws MobileNumberException
    {
        boolean checkCondition = Pattern.matches(ERegexPattern.MOBILE_NUMBER_PATTERN.getValue(),input);
        if(!checkCondition)
        {
            throw new MobileNumberException("invalid mobile number !!!!!!!!!!!");
        }
        return checkCondition;

    }
}
