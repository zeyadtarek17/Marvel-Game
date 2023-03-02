package View;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import engine.Game;
import engine.Player;
import model.abilities.Ability;

public class Quiz extends JFrame implements ActionListener {
	JButton name;
	JButton type;
	JButton counter;
	JButton next;
	JLabel l;
	Game game = new Game(new Player("1"), new Player("2"));

	public Quiz() throws IOException {
		this.setTitle("Quiz");
		this.setResizable(false);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setSize(1366, 768);
		this.setVisible(true);
		
		JPanel Grid = new JPanel();
		Grid.setBackground(Color.black);
		Grid.setBounds(0, 0, 1366, 768); 
		Grid.setLayout(new GridLayout(2,2));
		
 		name = new JButton();
		type = new JButton();
		counter = new JButton();
		next = new JButton();
		
		Grid.add(name);
		Grid.add(type);
		Grid.add(counter);
		Grid.add(next);
		this.add(Grid);
		
		next.addActionListener(this);
		int count = (int) (Math.random() * 45);
		Ability a = game.getAvailableAbilities().get(count);
		name.setText(a.getName());
		type.setText(a.getType());
		counter.setText(count + "");
		next.setText("Next");
		this.revalidate();
		this.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == next) {
			int count = (int) (Math.random() * 45);
			Ability a = game.getAvailableAbilities().get(count);
			name.setText(a.getName());
			type.setText(a.getType());
			counter.setText(count + "");
			this.revalidate();
			this.repaint();
		}
	}

	public static void main(String[] args) throws IOException {
		new Quiz();
	}
}
