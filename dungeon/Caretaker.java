package dungeon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Caretaker {
	
	FileOutputStream fos;
	FileInputStream fis;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	private List<Memento> mementoList = new ArrayList<Memento>();
	
	public Caretaker() {
		mementoList.add(new Memento(new State(null, null, null)));
		mementoList.add(new Memento(new State(null, null, null)));
	}
	
	public void add(Memento newMem, int index) {
		
		try {
			fos = new FileOutputStream("save" + index);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(newMem);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Memento get(int index) {
		
		try {
			fis = new FileInputStream("save" + index);
			ois = new ObjectInputStream(fis);
			Memento returnMem = (Memento)ois.readObject();
			ois.close();
			return returnMem;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
