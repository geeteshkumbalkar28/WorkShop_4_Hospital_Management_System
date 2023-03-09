package utility;
//private int patientId;
//private int age;
//private String firstName;
//private String lastName;
//private long mobileNo;
//private String city;
public enum ERegexPattern {
    FIRST_NAME_PPATTERN("^[A-Z]{1}[a-z]{1,}"),
    LAST_NAME_PPATTERN("^[A-Z]{1}[a-z]{1,}"),
    MOBILE_NUMBER_PATTERN("^(91)?[6-9]{1}[1-9]{1,9}");
    String constant;
    private ERegexPattern(String constant)
    {
        this.constant = constant;

    }
    public String getValue()
    {
        return constant;
    }

}
