package View;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import engine.Game;
import engine.Player;

public class Quiz2 extends JFrame implements ActionListener {
	JButton champ3;
	JButton champ2;
	JButton champ1;
	int hp1;
	int hp2;
	int hp3;
	int r;

	Game game = new Game(new Player("1"), new Player("2"));

	public Quiz2() throws IOException {
		this.setTitle("Quiz2");
		this.setResizable(false);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setSize(1366, 768);
		this.setVisible(true);

		JPanel Grid = new JPanel();
		Grid.setBackground(Color.black);
		Grid.setBounds(0, 0, 1366, 768);
		Grid.setLayout(new GridLayout(3, 1));

		champ1 = new JButton();
		champ1.addActionListener(this);
		champ2 = new JButton();
		champ2.addActionListener(this);
		champ3 = new JButton();
		champ3.addActionListener(this);

		Grid.add(champ1);
		Grid.add(champ2);
		Grid.add(champ3);
		this.add(Grid);
		
		r = (int) (Math.random() * 14);
		hp1 = game.getAvailableChampions().get(r).getCurrentHP();
		hp2 = game.getAvailableChampions().get(r + 1).getMaxHP();
		hp3 = game.getAvailableChampions().get(r + 2).getMaxHP();
		String champ1str = game.getAvailableChampions().get(r).getName() + "  " + hp1;
		String champ2str = game.getAvailableChampions().get(r + 1).getName() + "  " + hp2;
		String champ3str = game.getAvailableChampions().get(r + 2).getName() + "  " + hp3;

		champ1.setText(champ1str);
		champ2.setText(champ2str);
		champ3.setText(champ3str);
		revalidate();
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == champ1) {
			hp1=hp1-500;
			if(hp1<0)
				return;
			System.out.println(hp1);
			String champ1str = game.getAvailableChampions().get(r).getName() + "  " + hp1;
			champ1.setText(champ1str);
//			System.out.println(champ1str);
		}
		if (e.getSource() == champ2) {
			hp2=hp2-500;
			String champ2str = game.getAvailableChampions().get(r + 1).getName() + "  " + hp2 ;
			champ2.setText(champ2str);
		}
		if (e.getSource() == champ3) {
			hp3=hp3-500;
			String champ3str = game.getAvailableChampions().get(r + 2).getName() + "  " + hp3;
			champ3.setText(champ3str);
		}
		revalidate();
		repaint();

	}

	public static void main(String[] args) throws IOException {
		new Quiz2();
	}
}
