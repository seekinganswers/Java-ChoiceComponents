import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;

/*
 *	Creates a menu with three main menu items. Under each menu
 *	there is there are menu items about what each item does. Also,
 *	some menu items will have choice components and sliders for users
 *	to use to change text in the textarea.
 *	@version 2024020290
 *	@author Dorothy Hill
 *
*/

/*
 *	public class named ChoiceComponentsMenuDH  that implements
 *	the menu items in the JFrame.
*/
public class ChoiceComponentsMenuDH extends JFrame
{
	/*
	 *	Declared variables used in creating menu,
	 *	menu items, choice component.
	*/

	private static final int DEFAULT_WIDTH = 500;  // default width to set the menu
	private static final int DEFAULT_HEIGHT = 400; // default height to set the menu
	private JCheckBoxMenuItem readonlyItem; // checkbox menu item
	private JMenuItem menuItem;  // menu item variable
	private JMenuBar menuBar;  // menu bar variable
	private JMenu menu, optionsMenu; // menu and submenu variables
	private JPanel buttonPanel; // Jpanel for a button variable
	private ButtonGroup group; // button group variable
	private JLabel westlabel, eastlabel; // JLabel variable
	private static final int DEFAULT_SIZE = 18; // default font sized used in textArea
	private static final int TEXTAREA_ROWS = 4; //default row size for the textarea
	private static final int TEXTAREA_COLUMNS = 8; //default column size for the textarea
	private JCheckBox italic;
	private JCheckBox strikethrough;

	/*
	 *	Main method that will execute my menu method
	*/
	public static void main(String[] args)
	{
		// makes the ChoiceComponentsMenuDH method visible and able to be used
			new ChoiceComponentsMenuDH().setVisible(true);
	}

	/*
	 *	ChoiceComponentsMenuDH method that will execute the menu and items
	 *	within the menu along with the choice components.
	*/

	public ChoiceComponentsMenuDH()
	{

		/*
		 *	set textArea rows and colums in the center
		*/
		var textArea = new JTextArea(TEXTAREA_ROWS, TEXTAREA_COLUMNS);
		add(textArea, BorderLayout.CENTER); // centering the textArea in the border layout

		/*
		 *	set a label in the center of the textArea
		*/
		westlabel = new JLabel("Change Me!");
		westlabel.setFont(new Font("Serif", Font.BOLD, DEFAULT_SIZE)); // sets the font, size, and add bold to the label
		add (westlabel, BorderLayout.WEST); // sets the label in the north of the border

		/*
		 *	creates the variable textField and adds it to the textArea
		*/
		var textField = new JTextField();
		textField.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
		textArea.add(textField);  // adds the textField to the textArea

		var eastlabel = new JLabel("Modify Me.");
		eastlabel.setFont(new Font("Serif", Font.BOLD, DEFAULT_SIZE)); // sets the font, size, and add bold to the label
		add (eastlabel, BorderLayout.EAST); // sets the label in the north of the border

		/*
		 *	creates the scroll bar in the textArea
		*/
		var scrollPane = new JScrollPane(textArea);
		add(scrollPane, BorderLayout.CENTER); // centers the scroll bar to the center of the border layout
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  // creates a vertical scroll bar
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); // creates a hortizontal scroll bar

		/*
		 *	create the southPanel
		*/
		var southPanel = new JPanel();


		setTitle ("Dorothy's Menu"); // sets the frame and name's it Dorothy's Menu
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT); // sets the frame height
		setVisible(true); // sets the frame to visible
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set the close operation as default for the frame

		menuBar = new JMenuBar(); // declares the menuBars as the new JMenuBar
		setJMenuBar(menuBar); // sets the menuBar frame

		JMenu file = new JMenu("File"); // declares file as a JMenu
		menuBar.add(file); // adds the file to the menuBar

		// JMenu added to the file menu
		JMenu font = new JMenu("Font"); // declares a menu item name font
		font.setMnemonic(KeyEvent.VK_F); // set a mnemonic to "F"
		file.add(font); // add menu item to file
		file.addSeparator(); //adds a separator after the menu item under the meun file

		/*
		 *	submenu items for the font menu item
		*/

		JMenuItem size = new JMenuItem("Font Size");  // submenu for font declares font size
		size.setMnemonic(KeyEvent.VK_S); // set a mnemonic to "S"
		font.add(size); // adds size to the font
		var sizeSlider = new JSlider(JSlider.HORIZONTAL, 10, 30, DEFAULT_SIZE); // declare the slider variable
		sizeSlider.setPaintTicks(true); // set the paint ticks
		sizeSlider.setPaintLabels(true); // set the paint labels
		sizeSlider.setMajorTickSpacing(10); // set the max value
		sizeSlider.setMinorTickSpacing(5);  // set the min value

		/*
		 *	slider action to move east and west labels font
		 *	from smallest size to the largest size
		*/
		sizeSlider.addChangeListener(e -> {
				int fontSize = sizeSlider.getValue();
				eastlabel.setFont(new Font("Serif", Font.BOLD, fontSize)); // default setting for the east label
				westlabel.setFont(new Font("Serif", Font.BOLD, fontSize)); // default setting for the west label
        });
		font.add(sizeSlider); // adds slider to the font menu
		font.addSeparator(); //adds a separator after the menu item under the meun file

		JMenuItem color = new JMenuItem("Font Color");  // submenu for font declares font color
		color.setMnemonic(KeyEvent.VK_C);  //set mnemonic on C
		font.add(color); // adds color to the font
		var radioGroup = new ButtonGroup(); // declare radio buttons group
		var redButton = new JRadioButton("Red");

		/*
		 *	set the action of the red button with the labels
		*/
		redButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				eastlabel.setForeground(Color.RED);
				westlabel.setForeground(Color.RED);
			}
		});

		/*
		 *	set the action of the  green button with the labels
		*/
		var greenButton = new JRadioButton("Green");
		greenButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				eastlabel.setForeground(Color.GREEN);
				westlabel.setForeground(Color.GREEN);
			}
		});

		/*
		 *	set the action of the blue button with the labels
		*/
		var blueButton = new JRadioButton("Blue");
			blueButton.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e)
				{
					eastlabel.setForeground(Color.BLUE);
					westlabel.setForeground(Color.BLUE);
				}
		});
		font.add(redButton);
		font.add(greenButton);
		font.add(blueButton);

		font.addSeparator();//adds a separator after the menu item under the meun file

		/*
		 *	submenu for font declares font style
		*/
		JMenuItem style = new JMenuItem("Font Style"); // menu item for the font style
		var group = new ButtonGroup(); // set a combo box
		font.add(style); // adds color to the font
		style.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));// Accelerator added to the style menu item

		/*
		 *	ActionListener to handle font style changes based on checkbox selection
		*/
		ActionListener listener = event ->
				{
					int mode = 0;     // Initialize the font style mode
					if(italic.isSelected()) mode += Font.ITALIC; // Check if the "Italic" checkbox is selected
					if(strikethrough.isSelected()) { // Check if the "Strikethrough" checkbox is selected
						eastlabel.setText("<html><strike>" + eastlabel.getText() + // Apply strikethrough formatting to labels if selected
						"<html><strike>");
						westlabel.setText("<html><strike>" + westlabel.getText() + // Apply strikethrough formatting to labels if selected
						"<html><strike>");
						}

						/*
						 *	Remove strikethrough formatting from labels
						*/
						else{

							String eastlabelText = eastlabel.getText(); // removes formating from east label
							eastlabelText = eastlabelText.replace("<html><strike>", "");
							eastlabelText = eastlabelText.replace("<html><strike>", "");
							eastlabel.setText(eastlabelText);

							String westlabelText = westlabel.getText(); // removes formating from west label
							westlabelText = westlabelText.replace("<html><strike>", "");
							westlabelText = westlabelText.replace("<html><strike>", "");
							westlabel.setText(westlabelText);
						}
					/*
					 * Apply font style and size changes to the labels
					*/
					eastlabel.setFont(new Font("Serif", mode, DEFAULT_SIZE));
					westlabel.setFont(new Font("Serif", mode, DEFAULT_SIZE));
				};

				/*
				 *	creates the button panel to be used
				 *	to create buttons
				*/
				var buttonPanel = new JPanel();

				/*
				 *	Create and configure the "Italic" checkbox
				*/
				italic = new JCheckBox("Italic");
				italic.addActionListener(listener); // add the action listener
				buttonPanel.add(italic); // add italic to the button panel

				/*
				 *	Create and configure the "Strikethrough" checkbox
				*/
				strikethrough = new JCheckBox("Strikethrough");
				strikethrough.addActionListener(listener); // add the action listener
				buttonPanel.add(strikethrough); // add strikethrough to the button panel

		font.addSeparator();//adds a separator after the menu item under the meun file
		font.add(italic); // add to the font menu
		font.add(strikethrough); // add to the font menu

		/*
		 *	submenu of the file menu
		*/
		JMenuItem copy = new JMenuItem("Copy"); // creates the copy menuItem
		ImageIcon copyIcon = new ImageIcon("copy.png"); // declares the copy icon from file
		Image copyImage = copyIcon.getImage(); // gets the copy icon from file
		Image newCopyImage = copyImage.getScaledInstance(16,16, java.awt.Image.SCALE_SMOOTH); // rename the image and scales it down
		copyIcon = new ImageIcon(newCopyImage); // transforms the image back using the original name
		copy.setIcon(copyIcon); // sets the image as the menu label
		file.add(copy); // adds copy to the file


		/*
		 *	Delete button to clear text in the textArea
		*/
		var deleteButton = new JButton("Delete"); // decalre delete button
		southPanel.add(deleteButton); // add it to the south panel
		deleteButton.addActionListener(event -> {
		eastlabel.setVisible(true); // makes east label visible
		westlabel.setVisible(true); // makes west label visible
		copy.setEnabled(true); // makes copy menu item visible
		textArea.setText(""); // removes text from the textbox
		eastlabel.setForeground(null); //sets the west label to original color
		westlabel.setForeground(null); //sets the west label to original color
			});
		add(southPanel, BorderLayout.SOUTH); // adds the button to the south panel

		/*
		 *	submenu of the file menu
		*/
		JMenuItem paste = new JMenuItem("Paste"); // creates the paste menuItem

		ImageIcon pasteIcon = new ImageIcon("paste.jpg"); // declares the paste icon from file
		Image pasteImage = pasteIcon.getImage(); // gets the copy icon from file
		Image newPasteImage = pasteImage.getScaledInstance(16,16, java.awt.Image.SCALE_SMOOTH); // rename the image and scales it down
		pasteIcon = new ImageIcon(newPasteImage); // transforms the image back using the original name
		paste.setIcon(pasteIcon); // sets the image as the menu label

		/*
		 *	paste action when clicked will paste the labels into the textArea
		*/
		paste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				copy.setEnabled(false); // disables the copy button
				String labeleast = eastlabel.getText(); // gets the label text
				eastlabel.setVisible(false); // turns off the label visibility
				String labelwest = westlabel.getText(); // gets the label text
				westlabel.setVisible(false); // turns off the label visibility
				textArea.append(labeleast + "\n" + labelwest); //paste the labels into the textArea
			}
		});

		file.add(paste); // adds paste to the file

		/*
			submenu of the file menu
		*/
		JMenuItem exit = new JMenuItem("Exit");
		file.add(exit); // adds exit to the file
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK)); // Accelerator added to the exit menu item

		/*
		 *	Menu bar Item
		*/
		JMenu help = new JMenu("Help");
		menuBar.add(help);// add help to the menu bar
		JMenuItem helpTool = new JMenuItem("Help Features"); // menu item help tool
		ImageIcon helpIcon = new ImageIcon("help.gif"); // add image to menu
		helpTool.setIcon(helpIcon); // set icon
		help.add(helpTool); // add helptoo to the help menu
		helpTool.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_DOWN_MASK)); // Accelerator added to the helptool menu item

		/*
		 *	Menu bar Item
		*/
		JMenu about = new JMenu("About");
		menuBar.add(about); // add about to the menu bar
		JMenuItem aboutMe = new JMenuItem("About Me"); // menu item About me
		aboutMe.setMnemonic(KeyEvent.VK_A);  //set mnemonic on A
		ImageIcon aboutIcon = new ImageIcon("aboutMe.gif"); // add image to menu
		aboutMe.setIcon(aboutIcon); // set icon
		about.add(aboutMe);  // add about me to the about menu


		/*
		 *	Action for the exit button using an action listener
		*/
		class exitAction implements ActionListener
		{
			public void actionPerformed (ActionEvent e)
			{
				System.exit(0);
			}
		}

		/*
		 *	adds the exit action listener to the exit buttton on the menu
		*/
		exit.addActionListener(new exitAction());
			}
}