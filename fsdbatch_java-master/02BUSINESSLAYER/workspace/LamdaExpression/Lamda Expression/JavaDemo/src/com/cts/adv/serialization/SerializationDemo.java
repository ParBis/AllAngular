package com.cts.adv.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Item item = new Item(2, "Iphone", 34433.3);
		
		//SErialization
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bout);
		oos.writeObject(item);
		
		for(Byte b : bout.toByteArray()){
			System.out.print(b);
		}
		
//		Deserialize
		ByteArrayInputStream bais = new ByteArrayInputStream(bout.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bais);	
		Item deserializedItem = (Item)ois.readObject();
		System.out.println("");
		System.out.println(deserializedItem);
	
		
		
		
	}
}
