package testdata;

import models.Employee;

public class EmployeeData {
    public static final Employee DEFAULT_EMPLOYEE = Employee.builder()
            .firstName("Peter")
            .middleName("Mac")
            .lastName("Anderson")
            .nationality("British")
            .maritalStatus("Married")
            .dateOfBirth("2002-10-10")
            .gender("Male")
            .build();

    public static final Employee FULL_NAME = Employee.builder()
            .firstName("Peter")
            .middleName("Mac")
            .lastName("Anderson")
            .build();

    public static final Employee ID = Employee.builder()
            .employeeId("007")
            .build();
    public static final Employee EDITED_FIRST_NAME = Employee.builder()
            .firstName("Juan")
            .build();

    public static final Employee EDITED_LAST_NAME = Employee.builder()
            .lastName("James")
            .build();

    public static final Employee EDITED_NATIONALITY = Employee.builder()
            .nationality("British")
            .build();

    public static final Employee EDITED_MARITAL_STATUS = Employee.builder()
            .maritalStatus("Single")
            .build();

    public static final Employee EDITED_DATE_OF_BIRTH = Employee.builder()
            .dateOfBirth("2002-10-10")
            .build();

    public static final Employee EDITED_GENDER = Employee.builder()
            .gender("Male")
            .build();

    public static final Employee FULLY_EDITED_EMPLOYEE = Employee.builder()
            .firstName("Juan")
            .middleName("Mac")
            .lastName("James")
            .nationality("British")
            .maritalStatus("Married")
            .dateOfBirth("2002-10-10")
            .gender("Male")
            .build();
}
