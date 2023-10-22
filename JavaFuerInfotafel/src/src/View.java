package src;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View {

	private JFrame frame;
	private JTextField NameBildTextfield;
	private Bilderwechsler meinBilderwechsler;
	
	private JLabel Bild1Label = new JLabel(" ");
	
	private JButton LöschenButton1 = new JButton("Löschen");
	
	private JLabel Bild2Label = new JLabel(" ");
	
	private JButton LöschenButton2 = new JButton("Löschen");
	
	private JLabel Bild3Label = new JLabel(" ");
	
	private JButton LöschenButton3 = new JButton("Löschen");
	
	private JLabel Bild4Label = new JLabel(" ");
	
	private Thread meinThread;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
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
	public View() {
		
		meinBilderwechsler = new Bilderwechsler("H:/Jonas/Unterricht/Systembetreuung/Java_Infotafel/info.html");
		
		
		initialize();
		int zahlBilder = meinBilderwechsler.getMeineBilderSize();
		for(int i = 0; i < zahlBilder; i++) {
			switch(i) {
				case 0 : Bild1Label.setText(meinBilderwechsler.getbilderName(0));
							break;
				case 1: Bild2Label.setText(meinBilderwechsler.getbilderName(1));
							break;
							
				case 2: Bild3Label.setText(meinBilderwechsler.getbilderName(2));
							break;
				case 3: Bild4Label.setText(meinBilderwechsler.getbilderName(3));
			}
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 585, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		JPanel BilderPanel = new JPanel();
		
		JPanel BildHinzufügenPanel = new JPanel();
		GroupLayout mainPanel = new GroupLayout(frame.getContentPane());
		mainPanel.setHorizontalGroup(
			mainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(mainPanel.createSequentialGroup()
					.addGroup(mainPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(mainPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
						.addGroup(mainPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(BildHinzufügenPanel, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, mainPanel.createSequentialGroup()
					.addContainerGap(117, Short.MAX_VALUE)
					.addComponent(BilderPanel, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
					.addGap(94))
		);
		mainPanel.setVerticalGroup(
			mainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(mainPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(BilderPanel, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(BildHinzufügenPanel, GroupLayout.PREFERRED_SIZE, 39, Short.MAX_VALUE)
					.addGap(5))
		);
		
		JLabel LabelErklärung = new JLabel("Name des neuen Bildes hier eingeben:");
		
		NameBildTextfield = new JTextField();
		NameBildTextfield.setColumns(10);
		
		JButton HinzufügenButton = new JButton("hinzufügen");
		HinzufügenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				meinBilderwechsler.BildHinzufuegen(NameBildTextfield.getText());
				NameBildTextfield.setText("");
				int zahlBilder = meinBilderwechsler.getMeineBilderSize();
				for(int i = 0; i < zahlBilder; i++) {
					switch(i) {
						case 0 : Bild1Label.setText(meinBilderwechsler.getbilderName(0));
									break;
						case 1: Bild2Label.setText(meinBilderwechsler.getbilderName(1));
									break;
									
						case 2: Bild3Label.setText(meinBilderwechsler.getbilderName(2));
									break;
						case 3: Bild4Label.setText(meinBilderwechsler.getbilderName(3));
					}
				}
			}
		});
		GroupLayout gl_BildHinzufügenPanel = new GroupLayout(BildHinzufügenPanel);
		gl_BildHinzufügenPanel.setHorizontalGroup(
			gl_BildHinzufügenPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_BildHinzufügenPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(LabelErklärung, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(NameBildTextfield, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(HinzufügenButton)
					.addContainerGap())
		);
		gl_BildHinzufügenPanel.setVerticalGroup(
			gl_BildHinzufügenPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_BildHinzufügenPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_BildHinzufügenPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(LabelErklärung)
						.addComponent(HinzufügenButton)
						.addComponent(NameBildTextfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		BildHinzufügenPanel.setLayout(gl_BildHinzufügenPanel);
		//blabla
		
		
		JButton LöschenButton4 = new JButton("Löschen");
		LöschenButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				meinBilderwechsler.bildLoeschen(meinBilderwechsler.getbilderName(3));
				Bild4Label.setText(" ");
			}
		});
		GroupLayout gl_BilderPanel = new GroupLayout(BilderPanel);
		gl_BilderPanel.setHorizontalGroup(
			gl_BilderPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_BilderPanel.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_BilderPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_BilderPanel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(Bild1Label, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
							.addComponent(Bild3Label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(Bild2Label, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
						.addComponent(Bild4Label, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_BilderPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(LöschenButton4)
						.addComponent(LöschenButton2)
						.addComponent(LöschenButton1)
						.addComponent(LöschenButton3))
					.addContainerGap(46, Short.MAX_VALUE))
		);
		LöschenButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				meinBilderwechsler.bildLoeschen(meinBilderwechsler.getbilderName(0));
				Bild1Label.setText(" ");
			}
		});
		LöschenButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				meinBilderwechsler.bildLoeschen(meinBilderwechsler.getbilderName(1));
				
				Bild2Label.setText(" ");
									
			}
		});
		LöschenButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				meinBilderwechsler.bildLoeschen(meinBilderwechsler.getbilderName(2));
				Bild3Label.setText(" ");
			}
		});
		gl_BilderPanel.setVerticalGroup(
			gl_BilderPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_BilderPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_BilderPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(Bild1Label)
						.addComponent(LöschenButton1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_BilderPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(Bild2Label)
						.addComponent(LöschenButton2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_BilderPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(Bild3Label)
						.addComponent(LöschenButton3))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_BilderPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(Bild4Label)
						.addComponent(LöschenButton4))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		BilderPanel.setLayout(gl_BilderPanel);
		
		JButton StartButton = new JButton("Start");
		StartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Starten eines Threads:
				meinThread = new BWThread(meinBilderwechsler);
				meinThread.start();
				//Alternative ohne Thread:
				//meinBilderwechsler.setWechseln(true);
				//meinBilderwechsler.BilderWechseln();
			}
		});
		
		JButton StopButton = new JButton("Stop");
		StopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				meinBilderwechsler.setWechseln(false);
				//Alternative ohne Thread:
				//meinBilderwechsler.setWechseln(false);
			}
		});
		GroupLayout StartStopPanel = new GroupLayout(panel);
		StartStopPanel.setHorizontalGroup(
			StartStopPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(StartStopPanel.createSequentialGroup()
					.addGap(35)
					.addComponent(StartButton)
					.addPreferredGap(ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
					.addComponent(StopButton)
					.addGap(57))
		);
		StartStopPanel.setVerticalGroup(
			StartStopPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(StartStopPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(StartStopPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(StartButton)
						.addComponent(StopButton))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		panel.setLayout(StartStopPanel);
		frame.getContentPane().setLayout(mainPanel);
	}
}
