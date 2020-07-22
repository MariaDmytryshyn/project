package app.configuration;

public interface Checker {
    String  REG_EX_EMAIL = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    String REG_EX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,15}$";
    String REG_EX_LOGIN = "^[A-Za-z0-9_-]{8,20}$";
    String REG_EX_MOB = "(0/91)?[7-9][0-9]{10}";

}
