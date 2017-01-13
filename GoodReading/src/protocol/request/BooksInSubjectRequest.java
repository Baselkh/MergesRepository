package protocol.request;

import messages.Message;
import messages.MessageType;

/**
 * @author Basel
 *
 */
public class BooksInSubjectRequest implements Message {

	private String subjectName;
	
	public BooksInSubjectRequest(String subjectName){
		this.subjectName= subjectName;
	}
	
	@Override
	public MessageType getMessageType() {
		return MessageType.BOOKS_IN_SUBJECT_REQUEST;
	}
	
	public String getSubjectName(){
		return subjectName;
	}
}
