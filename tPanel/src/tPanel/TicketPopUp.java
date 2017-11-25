package tPanel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import AppKickstarter.Msg.TicketRep;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

/**
 * This class implements a TicketPopUp
 * @author user
 * @version 1.0
 */


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
	 * 
	 * @param : ticketRep
	 */
	public TicketPopUp() {
		initialize();
	}
	TicketRep ticketRep ;
	
	public TicketPopUp(TicketRep ticketRep) {
		this.ticketRep=ticketRep;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * Show the content of the ticket
	 */
	private void initialize() {
		
		String Tid = String.format("%04d", ticketRep.getTicket().getTicketID());
		
		frame = new JFrame("Ticket " + Tid);
		frame.setBounds(100, 100, 300, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.white);

		JLabel lblNewLabel = new JLabel("New label");
		frame.getContentPane().add(lblNewLabel, BorderLayout.CENTER);

		JLabel label = new JLabel(Tid);
		label.setFont(new Font("Arial", Font.PLAIN, 80));
		label.setBounds(60, 63, 180, 93);
		frame.getContentPane().add(label);

		JLabel lblYourTicketNumber = new JLabel("Your ticket number is :");
		lblYourTicketNumber.setFont(new Font("Arial", Font.PLAIN, 20));
		lblYourTicketNumber.setBounds(48, 27, 250, 49);
		frame.getContentPane().add(lblYourTicketNumber);

		JLabel lblPersons = new JLabel(ticketRep.getClient().getnPerson() + " - Person(s)");
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
