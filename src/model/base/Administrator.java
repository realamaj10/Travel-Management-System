package model.base;

public class Administrator extends Client {

    public Administrator(String user, String pass, String name, String surname, Date bdt, String email,
            String phoneNumber) {
        super(user, pass, name, surname, bdt, email, phoneNumber);
        setType(UserType.Administrator);
    }


}
