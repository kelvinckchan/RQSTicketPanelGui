package tPanel;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import AppKickstarter.Msg.*;
import AppKickstarter.Server.Client;
import AppKickstarter.Server.Ticket;

public class TicketPanelController {

	private final String ServerIP = "127.0.0.1";
	private final int ServerPort = 54321;
	private Socket socket;

	private PrintWriter out;
	private DataInputStream in;
	private Queue<TicketRep> TicketRepList = new LinkedList<TicketRep>();

	public TicketPanelController() throws IOException {
		do {
			try {
				socket = new Socket(ServerIP, ServerPort);
			} catch (ConnectException e) {
				System.err.println("Trying to connect Server..");
			}
		} while (socket == null || !socket.isConnected());
		System.out.println("Socket Connected!");
		out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		in = new DataInputStream(socket.getInputStream());
		SocketInHandler socketHandler = new SocketInHandler();
		new Thread(socketHandler).start();
	}

	static int clientID = 1;

	public void SendTicketReq(int nPerson) {
		String ClientID = "Client-" + String.format("%04d", clientID++);
		TicketReq ticketReq = new TicketReq(new Client(ClientID, nPerson));
		System.out.println("Sent> " + ticketReq.toString());
		out.write(ticketReq.toString());
		out.flush();
	}

	public Queue<TicketRep> getTicketRepList() {
		return TicketRepList;
	}

	class SocketInHandler implements Runnable {
		private DataInputStream in;

		public SocketInHandler() {
		}

		public void run() {
			try {
				while (true) {
					in = new DataInputStream(socket.getInputStream());
					byte[] buffer = new byte[1024];
					in.read(buffer);
					String IncomingMsg = new String(buffer);
					System.out.println("Receive> " + IncomingMsg);
					String[] SplitedMsg = IncomingMsg.split(":");
					String Type = SplitedMsg[0];
					String MsgDetail = SplitedMsg[1];
					String[] DetailParts = MsgDetail.trim().split("\\s+");

					String ClientID = DetailParts[0];
					int nPerson = Integer.valueOf(DetailParts[1]);
					int TicketID = Integer.valueOf(DetailParts[2]);
					Client client = new Client(ClientID, nPerson);
					Ticket ticket = new Ticket(TicketID, client);
					TicketRepList.add(new TicketRep(client, ticket));
					// notifyAll();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // run
	}

}
