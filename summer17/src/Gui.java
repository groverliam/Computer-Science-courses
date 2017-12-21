

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

public class Gui {
	static ArrayList<String> words = new ArrayList<String>();
	static ArrayList<String> matched = new ArrayList<String>();

	private JPanel main;
	private int width = 300;
	private int height = 500;
	private JButton submit = new JButton("submit");
	private TextField input = new TextField("Enter your letters");
	private TextView output = new TextView(20);
	private String enteredText;
	//private ArrayList<Character> charList = new ArrayList<Character>();
	private int size;
	public Gui()
	{

		changeFile();

		main = new JPanel();
		output.setEditable(false);
		

		main.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		main.setOpaque( false );
		main.setBounds( 0, 0, width, height );
		main.addMouseListener( new MouseAdapter() {} );
		main.setVisible( true );
		submit.addActionListener(actionListener);
		main.add(input);
		main.add(submit);

		gbc.gridy++;
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridwidth = 2;
		gbc.gridheight = 2;
		main.add(output,gbc);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setBounds( ( screenSize.width - width ) / 2, ( screenSize.height - height ) / 2, width, height );
		frame.add( main );
		frame.setVisible( true );

	}

	
	Matcher matcher;
	String regex;
	ActionListener actionListener = new ActionListener() {
		@Override
		public void actionPerformed( ActionEvent e ) {
			boolean pressed = e.getSource() == submit;
			output.setText("");
			enteredText = input.getText();

			//size = enteredText.length();

			//char[] charList = enteredText.toCharArray();


			while(!words.isEmpty())
			{
				/*if(words.get(0).matches(enteredText))
				{
					matched.add(words.get(0));
					words.remove(0);
				}
				else
				{
					words.remove(0);
				}*/
				regex = words.get(0);
				matcher = Pattern.compile(regex).matcher(enteredText);
				if(matcher.find())
				{
					matched.add(regex);
					words.remove(0);
				}
				else
				{
					words.remove(0);
				}
				
			}

			input.setText("Enter new text");
			
			for(int i = 0; i < matched.size(); i++)
			{
				output.setText(output.getText() + matched.get(i) + "\n");
			}


		}
	};
	String fileInput;
	public void changeFile()
	{
		try {
			Scanner scan = new Scanner(new FileReader("/Users/admin/Desktop/CS/summer17/src/web2"));
			while(scan.hasNextLine()){
				try {
					fileInput = scan.next();
					//System.out.println(fileInput);
					words.add(fileInput);
				} catch (NoSuchElementException e){}
				
			}

		} catch (FileNotFoundException ex) {
			System.out.println("File Not Found.\nTry Again Later.");

		}

	}



}
