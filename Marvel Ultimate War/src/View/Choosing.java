package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Choosing extends JPanel {
	private ArrayList<JButton> B = new ArrayList<JButton>();
	Cell[][] map = new Cell[3][5];
	JFrame frame = new JFrame();
	JLabel label;
	JPanel player1;
	JPanel player2;
	JPanel Grid;

	public Choosing() {
//		for (int i = 0; i < 3; i++) {
//			for (int j = 0; j < 5; j++) {
//				map[i][j] = new Cell();
//				map[i][j].addActionListener(this);
//				map[i][j].addActionListener(map[i][j]);
//				this.add(map[i][j]);
//				B.add(map[i][j]);
//				// label.add(map[i][j]);
//			}
//		}
		player1 = new JPanel();
		player1.setBackground(Color.red);
		player1.setBounds(0, 0, 200, 768);

		player2 = new JPanel();
		player2.setBackground(Color.blue);
		player2.setBounds(1366-210, 0, 210, 768);
		
		Grid= new JPanel();
		Grid.setLayout(new GridLayout(0, 3));
		Grid.setBounds(200,0,900,768);
		add(Grid,BorderLayout.CENTER);
		
//		frame.add(player1);
//		frame.add(player2);
//		frame.add(Grid);
//		frame.setVisible(true);
		this.revalidate();
		this.repaint();
	}
	public void addChampion(JButton Champion) {
		Grid.add(Champion);
	}

	public static void main(String[] args) {
		new Choosing();
	}
}
