package model.base;

public class GenericUser extends Client{


	public GenericUser(String user, String pass, String name, String surname, Date bdt, String email,
			String phoneNumber) {
		super(user, pass, name, surname, bdt, email, phoneNumber);
	
		setType(UserType.GenericUser);
	}

	public String toString(){
		return "User has name: "+ super.getName()+" and surname: "+super.getSurname();
	}
	

}
