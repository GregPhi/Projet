package aei.graphical;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -459209075433389371L;
	private JPanel pan = new JPanel();
	private GridLayout g = new GridLayout(2,0);
	
	public Test() {
		super("Test");
		this.setPreferredSize(new Dimension(200,150));
		
		JButton jt = new JButton("but");
		ButtonT bt = new ButtonT();
		jt.addActionListener(bt);
		
		this.setLayout(this.g);
		
		this.getContentPane().add(jt);
		
		pan.add(new JLabel("Test"));
		this.getContentPane().add(pan);
	}
	
	private JPanel pane() {
		JPanel p = new JPanel();
		p.add(new JLabel("test fonction"));
		return p;
	}
	
	private class ButtonT implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Test.this.remove(pan);
			add(pane(),BorderLayout.CENTER);
			validate();
			pack();
		}
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		t.setVisible(true);
	}
}
