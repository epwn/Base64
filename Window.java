//Author:  Ryan Miller
//Created on:  10/17/2013
//E-mail: ryanmillera@gmail.com

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.apache.commons.codec.binary.Base64;
import javax.swing.*;


public class Window 
{
	JTextArea inputArea = new JTextArea();
	JTextArea outputArea = new JTextArea();
	JButton action = new JButton("Encode");
	
	Window()
	{
		//Create components
		JFrame frame = new JFrame("Base64 Encoder");
		JPanel panel = new JPanel();
		JLabel input = new JLabel("Input:");
		JLabel output = new JLabel("Output:");
		
		//Create ActionListeners
		action.addActionListener(new actionListener());
		
		//Layout
		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addComponent(input)
					.addComponent(inputArea)
				    .addComponent(output)
				    .addComponent(outputArea)
				    .addComponent(action)
		);
		layout.setVerticalGroup(
				layout.createSequentialGroup()
							.addComponent(input)
				            .addComponent(inputArea)
				            .addComponent(output)
				            .addComponent(outputArea)
				            .addComponent(action)
		);
		
		//Create frame
		frame.setSize(500, 400);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	class actionListener implements ActionListener 
	{ 
		public void actionPerformed(ActionEvent e) 
		{
			String input = inputArea.getText();
			byte[] encodedBytes = Base64.encodeBase64(input.getBytes());
			outputArea.setText(new String(encodedBytes));
			
		}	
	}	
}
