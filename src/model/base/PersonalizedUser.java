package model.base;

public class PersonalizedUser extends Client {
	public PersonalizedUser(String user, String pass, String name, String surname, Date bdt, String email,
             String phoneNumber) {
		super(user, pass, name, surname, bdt, email, phoneNumber);
		
		setType(UserType.PersonalizedUser);
	}
	

	public String toString(){
		return "User has name : "+super.getName() + " and surname: "+super.getSurname();
	}
	
	
	
}

