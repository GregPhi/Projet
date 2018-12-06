package aei.graphical;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AEIGraphical extends JFrame {
	private static final long serialVersionUID = 9211040966447342469L;
	private JPanel pan = new JPanel();
	private GridLayout g = new GridLayout(3,0);
	
	public AEIGraphical() {
		super("AEI");
		this.addWindowListener(new CloseWindowEvent());
		this.setPreferredSize(new Dimension(300,250));
		
		JButton jM = new JButton("Membres");
		ButtonMembres bM = new ButtonMembres();
		jM.addActionListener(bM);
		JButton jT = new JButton("Tombola");
		ButtonTombola bT = new ButtonTombola();
		jT.addActionListener(bT);
		JButton jC = new JButton("Calendier Avent");
		ButtonCalendrierAvent bC = new ButtonCalendrierAvent();
		jC.addActionListener(bC);
		
		this.setLayout(this.g);
		
		pan.add(jM);
		pan.add(jT);
		pan.add(jC);
		this.getContentPane().add(pan);
	}
	
	private class ButtonMembres implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	private class ButtonTombola implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	private class ButtonCalendrierAvent implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	private class CloseWindowEvent extends WindowAdapter{
		@Override
		public void windowClosing(java.awt.event.WindowEvent e) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		AEIGraphical t = new AEIGraphical();
		t.setVisible(true);
	}
}
