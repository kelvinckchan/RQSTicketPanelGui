package tPanel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

public class TicketPopUp {

	protected JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicketPopUp window = new TicketPopUp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TicketPopUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Ticket "+TicketPanel.ticketNumber);
		frame.setBounds(100, 100, 300, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground( Color.white );
		
		JLabel lblNewLabel = new JLabel("New label");
		frame.getContentPane().add(lblNewLabel, BorderLayout.CENTER);
		
		JLabel label = new JLabel(TicketPanel.ticketNumber);
		label.setFont(new Font("Arial", Font.PLAIN, 80));
		label.setBounds(73, 63, 163, 93);
		frame.getContentPane().add(label);
		
		JLabel lblYourTicketNumber = new JLabel("Your ticket number is :");
		lblYourTicketNumber.setFont(new Font("Arial", Font.PLAIN, 20));
		lblYourTicketNumber.setBounds(48, 27, 198, 49);
		frame.getContentPane().add(lblYourTicketNumber);
		
		JLabel lblPersons = new JLabel(TicketPanel.display.getText()+" - Person(s)");
		lblPersons.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPersons.setBounds(97, 160, 91, 27);
		frame.getContentPane().add(lblPersons);
		
		JLabel lblPleaseWaitFor = new JLabel("Please Wait for a moment.");
		lblPleaseWaitFor.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPleaseWaitFor.setBounds(58, 183, 188, 54);
		frame.getContentPane().add(lblPleaseWaitFor);
	}

	public void setVisible() {
		// TODO Auto-generated method stub
		
	}
}
