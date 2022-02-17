package client.view.sharted;

import java.util.List;

public enum View
{
    //Login
    LOGIN,
    MANAGER_MAIN,
    DOCTOR_MAIN,
    NURSE_MAIN,
    //Doctor
    ADD_EDIT_SAMPLE,
    APPOINTMENTS,
    ASSIGN_NURSE,
    ADD_DIAGNOSE,
    PATIENTS_SAMPLE,
    PATIENT_INFO,
    PATIENTS,
    TREAT_PATIENT,
    //Manager

    ADD_EDIT_EMPLOYEE,
    ADD_EDIT_WARD,
    WARD,
    EMPLOYEE,
    //Nurse
    ALL_APPOINTMENTS,
    MAKE_APPOINTMENT,
    ADD_PATIENT,
    All_PATIENTS;


    private static final List<View> LOGIN_VALUES = List.of(LOGIN, MANAGER_MAIN, DOCTOR_MAIN, NURSE_MAIN);
    private static final List<View> DOCTOR_VALUES = List.of(ADD_EDIT_SAMPLE, APPOINTMENTS, ASSIGN_NURSE, ADD_DIAGNOSE, PATIENTS_SAMPLE,
                                                            PATIENT_INFO,
                                                            PATIENTS, TREAT_PATIENT);
    private static final List<View> MANAGER_VALUES = List.of(ADD_EDIT_EMPLOYEE, ADD_EDIT_WARD, WARD, EMPLOYEE);
    private static final List<View> NURSE_VALUES = List.of(ALL_APPOINTMENTS, MAKE_APPOINTMENT, ADD_PATIENT,
                                                           All_PATIENTS);


    public static List<View> getLoginValues()
    {
        return LOGIN_VALUES;
    }

    public static List<View> getDoctorValues()
    {
        return DOCTOR_VALUES;
    }

    public static List<View> getManagerValues()
    {
        return MANAGER_VALUES;
    }

    public static List<View> getNurseValues()
    {
        return NURSE_VALUES;
    }
}
