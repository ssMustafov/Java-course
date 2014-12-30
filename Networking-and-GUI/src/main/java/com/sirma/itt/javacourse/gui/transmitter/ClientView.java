package com.sirma.itt.javacourse.gui.transmitter;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

/**
 * Represents the user interface of the client side.
 * 
 * @author Sinan
 */
public class ClientView extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static final String WINDOW_TITLE = "Client";
	private static final String CONNECT_MESSAGE = "Connect";
	private static final int WINDOW_WIDTH = 500;
	private static final int WINDOW_HEIGHT = 400;
	private JButton button;
	private JTextArea consoleArea;
	private JRadioButton stringChannelButton;
	private JRadioButton intChannelButton;
	private String choosedChannel = MulticastingConstants.STRING_CHANNEL_NAME;

	/**
	 * Creates a new user interface for the client.
	 */
	public ClientView() {
		super(WINDOW_TITLE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		button = new JButton(CONNECT_MESSAGE);
		button.setActionCommand(CONNECT_MESSAGE);

		consoleArea = new JTextArea(5, 20);
		DefaultCaret caret = (DefaultCaret) consoleArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(consoleArea);
		consoleArea.setEditable(false);

		stringChannelButton = new JRadioButton("String channel");
		stringChannelButton.setActionCommand(MulticastingConstants.STRING_CHANNEL_NAME);
		stringChannelButton.setSelected(true);

		intChannelButton = new JRadioButton("Integer channel");
		intChannelButton.setActionCommand(MulticastingConstants.INTEGER_CHANNEL_NAME);
		intChannelButton.setSelected(true);

		ButtonGroup group = new ButtonGroup();
		group.add(stringChannelButton);
		group.add(intChannelButton);

		button.addActionListener(this);
		stringChannelButton.addActionListener(this);
		intChannelButton.addActionListener(this);

		setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.add(button);

		JPanel radioPanel = new JPanel();
		radioPanel.add(stringChannelButton);
		radioPanel.add(intChannelButton);

		add(radioPanel, BorderLayout.NORTH);
		add(panel, BorderLayout.WEST);
		add(scrollPane, BorderLayout.CENTER);

		setVisible(true);
	}

	/**
	 * Appends a given message to the text area.
	 * 
	 * @param message
	 *            - the message to be appended to the text area
	 */
	public void appendMessageToConsole(String message) {
		consoleArea.append(message + System.lineSeparator());
	}

	/**
	 * Shows an error dialog with given message.
	 * 
	 * @param message
	 *            - the message to be shown in the error dialog
	 */
	public void showErrorDialog(String message) {
		JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals(CONNECT_MESSAGE)) {
			MulticastClient client = new MulticastClient(choosedChannel, this);
			client.start();

			button.setEnabled(false);
		} else if (cmd.equals(MulticastingConstants.STRING_CHANNEL_NAME)) {
			choosedChannel = MulticastingConstants.STRING_CHANNEL_NAME;
		} else if (cmd.equals(MulticastingConstants.INTEGER_CHANNEL_NAME)) {
			choosedChannel = MulticastingConstants.INTEGER_CHANNEL_NAME;
		}
	}

}
