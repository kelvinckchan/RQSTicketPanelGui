package tPanel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TicketPanel {

	private JFrame frame;
	private JTextField txtTable_1;
	private JLabel lblQueueingSystem;
	JButton button[] = new JButton[10];
	public static TextField display = new TextField();
	public static String ticketNumber;
	public static int ticketNo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicketPanel window = new TicketPanel();
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
	 * @throws IOException
	 */
	public TicketPanel() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	class ImagePanel extends JComponent {
		private Image image;

		public ImagePanel(Image image) {
			this.image = image;
		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, this);

		}
	}

	private void initialize() throws IOException {
		display.setEditable(false);
		frame = new JFrame("Queueing System");
		frame.setSize(700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image img = new ImageIcon(this.getClass().getResource("/background.jpg")).getImage();
		frame.setContentPane(new ImagePanel(img));
		frame.getContentPane().setLayout(null);

		ticketNo = 1;
		ticketNumber = String.format("%03d", ticketNo);

		display.setForeground(Color.LIGHT_GRAY);
		display.setFont(new Font("Arial", Font.BOLD, 37));
		display.setText("PLEASE INSERT NUMBER");
		display.setBounds(255, 70, 435, 50);
		frame.getContentPane().add(display);

		for (int i = 0; i < 10; i++) {
			button[i] = new JButton("" + i);
			button[i].setFont(new Font("Arial", Font.BOLD, 23));
			button[i].setBackground(new Color(245, 245, 220));
			frame.getContentPane().add(button[i]);
		}

		button[0].setBounds(255, 460, 320, 100);
		button[0].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				String EnterNumber = button[0].getText();
				if ("1".equals(display.getText())) {
					display.setForeground(Color.BLACK);
					EnterNumber = display.getText() + button[0].getText();
					display.setText(EnterNumber);
				}
			}
		});

		button[1].setBounds(255, 350, 100, 100);
		button[1].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if ("PLEASE INSERT NUMBER".equals(display.getText())) {
					display.setForeground(Color.BLACK);
					String EnterNumber = button[1].getText();
					display.setText(EnterNumber);
				}
			}
		});

		button[2].setBounds(365, 350, 100, 100);
		button[2].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				if ("PLEASE INSERT NUMBER".equals(display.getText())) {
					display.setForeground(Color.BLACK);
					String EnterNumber = button[2].getText();
					display.setText(EnterNumber);
				}
			}
		});
		button[3].setBounds(475, 350, 100, 100);
		button[3].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				if ("PLEASE INSERT NUMBER".equals(display.getText())) {

					display.setForeground(Color.BLACK);
					String EnterNumber = button[3].getText();
					display.setText(EnterNumber);
				}
			}
		});
		button[4].setBounds(255, 240, 100, 100);
		button[4].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if ("PLEASE INSERT NUMBER".equals(display.getText())) {

					display.setForeground(Color.BLACK);
					String EnterNumber = button[4].getText();
					display.setText(EnterNumber);
				}
			}
		});
		button[5].setBounds(365, 240, 100, 100);
		button[5].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				if ("PLEASE INSERT NUMBER".equals(display.getText())) {
					display.setForeground(Color.BLACK);
					String EnterNumber = button[5].getText();
					display.setText(EnterNumber);
				}
			}
		});
		button[6].setBounds(475, 240, 100, 100);
		button[6].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if ("PLEASE INSERT NUMBER".equals(display.getText())) {
					display.setForeground(Color.BLACK);
					String EnterNumber = button[6].getText();
					display.setText(EnterNumber);
				}
			}
		});
		button[7].setBounds(255, 130, 100, 100);
		button[7].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if ("PLEASE INSERT NUMBER".equals(display.getText())) {
					display.setForeground(Color.BLACK);
					String EnterNumber = button[7].getText();
					display.setText(EnterNumber);
				}
			}
		});
		button[8].setBounds(365, 130, 100, 100);
		button[8].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if ("PLEASE INSERT NUMBER".equals(display.getText())) {
					display.setForeground(Color.BLACK);
					String EnterNumber = button[8].getText();
					display.setText(EnterNumber);
				}
			}
		});
		button[9].setBounds(475, 130, 100, 100);
		button[9].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if ("PLEASE INSERT NUMBER".equals(display.getText())) {
					display.setForeground(Color.BLACK);
					String EnterNumber = button[9].getText();
					display.setText(EnterNumber);
				}
			}
		});

		JButton clear = new JButton("Clear");
		clear.setFont(new Font("Arial", Font.BOLD, 23));
		clear.setBackground(new Color(245, 245, 220));
		clear.setBounds(585, 130, 105, 210);
		frame.getContentPane().add(clear);

		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				display.setForeground(Color.LIGHT_GRAY);
				display.setText("PLEASE INSERT NUMBER");
			}
		});

		JButton enter = new JButton("Enter");
		enter.setFont(new Font("Arial", Font.BOLD, 23));
		enter.setBackground(new Color(245, 245, 220));
		enter.setBounds(585, 350, 105, 210);
		frame.getContentPane().add(enter);
		enter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!"PLEASE INSERT NUMBER".equals(display.getText())) {
					ticketNumber = String.format("%03d", ticketNo);
					new TicketPopUp().frame.setVisible(true);
					display.setForeground(Color.LIGHT_GRAY);
					display.setText("PLEASE INSERT NUMBER");
					if (ticketNo == 999) {
						ticketNo = 1;
					} else {
						ticketNo++;
					}
				}
			}
		});

		txtTable_1 = new JTextField();
		txtTable_1.setEditable(false);
		txtTable_1.setBackground(new Color(255, 250, 250));
		txtTable_1.setFont(new Font("Arial", Font.PLAIN, 30));
		txtTable_1.setText("000");
		txtTable_1.setColumns(10);
		txtTable_1.setBounds(10, 250, 210, 50);
		frame.getContentPane().add(txtTable_1);

		lblQueueingSystem = new JLabel("QUEUEING SYSTEM");
		lblQueueingSystem.setFont(new Font("Arial Black", Font.PLAIN, 38));
		lblQueueingSystem.setBounds(255, 10, 429, 50);
		frame.getContentPane().add(lblQueueingSystem);

		JLabel lblNowCalling = new JLabel("Now Calling:");
		lblNowCalling.setFont(new Font("Arial", Font.BOLD, 25));
		lblNowCalling.setBounds(10, 200, 210, 57);
		frame.getContentPane().add(lblNowCalling);
	}
}
