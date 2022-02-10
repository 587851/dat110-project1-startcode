package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;

	public static final int MESSAGINGPORT = 8080;
	public static final String MESSAGINGHOST = "localhost";
	
	public static byte[] encapsulate(Message message) {
		
		byte[] segment = new byte[SEGMENTSIZE];
		byte[] data = message.getData();
		
		segment[0] = (byte) data.length;
		for(int i = 1; i <= data.length; i++) {
			segment[i] = data[i-1];
		}

		return segment;
		
	}

	public static Message decapsulate(byte[] segment) {

		Message message = null;
		
		byte[] data = new byte[segment[0]];
		for(int i = 1; i <= data.length; i++) {
			data[i-1] = segment[i];
		}
		message = new Message(data);
		
		return message;
		
	}
	
}
