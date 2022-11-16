package zestbloom.pages;

public class TestDataSetup {

    public static String getUserRegisterEmail() {
        return userRegisterEmail;
    }

    public static void setUserRegisterEmail(String userRegisterEmail) {
        TestDataSetup.userRegisterEmail = userRegisterEmail;
    }

    private static String userRegisterEmail;

    public static String getUserPassword() {
        return userPassword;
    }

    public static void setUserPassword(String userPassword) {
        TestDataSetup.userPassword = userPassword;
    }

    private static String userPassword;
}
