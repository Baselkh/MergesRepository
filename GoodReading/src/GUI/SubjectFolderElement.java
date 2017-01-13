package GUI;

import java.awt.image.BufferedImage;

public class SubjectFolderElement extends AbstractFolderElement {

	private String subjectID;
	private String subjectName;
	
	public SubjectFolderElement(String subjectID, String name, BufferedImage folderIcon){
		super(name, folderIcon);
		this.subjectID= subjectID;
	}
	
	public String getSubjectID(){
		return subjectID;
	}
	
	public String getSubjectName(){
		return subjectName;
	}
}
