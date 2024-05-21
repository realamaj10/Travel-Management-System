package model.RW;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import model.base.Administrator;
import model.base.Date;
import model.base.Client;

public class UserRW {
    private final File fUser;
    private ArrayList<Client> cli;
    
    
    public UserRW(){
        fUser = new File("user.txt");
        cli = new ArrayList<Client>();
        if(!fUser.exists()){
            writeClient();
        }else{
            cli = readClient();
        }
    }
    
    public ArrayList<Client> readClient(){
        try{
            FileInputStream fis = new FileInputStream(fUser);
            ObjectInputStream ois = new ObjectInputStream(fis);
            cli = (ArrayList<Client>) ois.readObject();
            ois.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not Found!!!");
		} catch (ClassNotFoundException e) {
			System.err.println("Class not Found!!!");
		} catch (IOException e) {
			System.err.println("File not accessable!!!");
		}
		return cli;
	}

	private void writeClient() {
		try {
			FileOutputStream fos = new FileOutputStream(fUser);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			if(cli.isEmpty()){
				cli.add(new Administrator("admin","pass","User",
                                        "ADMIN",new Date("10/2/2018"), "admin@pharmacy.com", 
                                        "670000000"));
			}
			oos.writeObject(cli);
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not Found!!!");
		} catch (IOException e) {
			System.err.println("File not Writable!!!");
		}
		readClient();
        }
        
	public Client checkUser(String username,String password){
		for(Client x:cli){
			if(username.equals(x.getUsername()) && x.getPassword().equals(password)){
				return x;
			} 
		}
		return null;
                
               
	}
       
	public void addCli(Client c){
		cli.add(c);
		writeClient();
	}
	public void remove(Client c){
		cli.remove(c);
		writeClient();
	}
}
