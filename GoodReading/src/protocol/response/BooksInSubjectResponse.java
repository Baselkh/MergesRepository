package protocol.response;

import java.util.ArrayList;

import messages.Message;
import messages.MessageType;

/**
 * @author Basel
 *
 */
public class BooksInSubjectResponse implements Message {

	ArrayList<String> booksNames;
	
	public BooksInSubjectResponse(ArrayList<String> booksNames){
		this.booksNames= booksNames;
	}
	
	public ArrayList<String> getBooksName(){
		return booksNames;
	}
	
	@Override
	public MessageType getMessageType() {
		return MessageType.BOOKS_IN_SUBJECT_RESPONSE;
	}
}
