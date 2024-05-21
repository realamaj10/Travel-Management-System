package model.RW;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import model.base.Loc;

public class LocationRW {
    private final File fLoc;
    private ArrayList<Loc> loc;
    public int vertices = 0;
    
    public LocationRW(){
        fLoc = new File("location.txt");
        loc = new ArrayList<Loc>();
        if(!fLoc.exists()){
            writeLoc();
        }else{
            loc = readLoc();
        }
    }
    
    public ArrayList<Loc> readLoc(){
        try{
            FileInputStream fis = new FileInputStream(fLoc);
            ObjectInputStream ois = new ObjectInputStream(fis);
            loc = (ArrayList<Loc>) ois.readObject();
            ois.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not Found!!!");
		} catch (ClassNotFoundException e) {
			System.err.println("Class not Found!!!");
		} catch (IOException e) {
			System.err.println("File not accessable!!!");
		}
		return loc;
	}

	private void writeLoc() {
		try {
			FileOutputStream fos = new FileOutputStream(fLoc);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			
			oos.writeObject(loc);
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not Found!!!");
		} catch (IOException e) {
			System.err.println("File not Writable!!!");
		}
		readLoc();
        }
        
	public Loc checkLoc(String name){
		for(Loc l:loc){
			if(name.equals(l.getName())){
				return l;
			} 
		}
		return null;
                
               
	}
       
	public void addLoc(Loc l){
		loc.add(l);
		writeLoc();
                vertices++;
	}
	public void remove(Loc l){
		loc.remove(l);
		writeLoc();
                vertices--;
	}
}
