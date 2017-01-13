package GUI;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import client.controller.CategoriesController;
import client.controller.ControllerType;
import client.controller.Controllers;
import client.controller.SubjectsController;
import protocol.response.BooksInSubjectResponse;
import protocol.response.SubjectsInCategoryResponse;

public class SubjectsInCategoryGUI extends JFrame {

	private JButton createSubjectButton;
	private JButton deleteSubjectButton;
	private JButton renameSubjectButton;
	private BufferedImage folderIcon;
	private ArrayList<String> booksNames;
	private MouseAdapter mouseClickListener;
	private ArrayList<String> subjectsIDs;	// May be unnecessary
	private ArrayList<String> subjectsNames;	// May be unnecessary
	
	public SubjectsInCategoryGUI(ArrayList<String> subjectsIDs, ArrayList<String> subjectsNames, String categoryName){
		super(categoryName);
		this.subjectsIDs= subjectsIDs;
		this.subjectsNames= subjectsNames;
		Container pane= getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		
		// Initializing buttons
		createSubjectButton= new JButton("Create Category");
		deleteSubjectButton= new JButton("Delete Category");
		renameSubjectButton= new JButton("Rename Category");
		
		// Adding buttons
		JPanel buttonsPanel= new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));	// Panel for containing buttons
		buttonsPanel.add(createSubjectButton);
		buttonsPanel.add(deleteSubjectButton);
		buttonsPanel.add(renameSubjectButton);
		pane.add(buttonsPanel);
		
		// Categories icons layout
		JPanel iconsPanel= new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
		try{	// Initializing the pointer to the icon
			folderIcon= ImageIO.read(new File("images\\folder_icon.png"));
		}
		catch(IOException e){}	///////Messing Code/////////
		createFolderClickListener();
		int i= 0;
		for(String s: subjectsIDs){
			iconsPanel.add(makeFolderIcon(s, subjectsNames.get(i)));
			i++;
		}
		pane.add(iconsPanel);
		
		// Displaying
		pack();
		setVisible(true);
	}
	
	private void createFolderClickListener(){
		mouseClickListener= new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				super.mouseClicked(e);
//				String subjectName= ((AbstractFolderElement)e.getSource()).getName();
//				SubjectsController controller= (SubjectsController) 
//						Controllers.getInstance().getController(ControllerType.SUBJECT_CONTROLLER);
//				BooksInSubjectResponse resp= controller.getBooksInSubject(subjectName);
//				////###########################
//				////###########################
//				////###########################
//				////###########################
//				////###########################
//				////###########################
//				////###########################
			}
		};
	}
	
	private SubjectFolderElement makeFolderIcon(String subjectID, String categoryName){
		SubjectFolderElement folder= new SubjectFolderElement(subjectID, categoryName, folderIcon);
		folder.addMouseListener(mouseClickListener);
		return folder;
	}
}
