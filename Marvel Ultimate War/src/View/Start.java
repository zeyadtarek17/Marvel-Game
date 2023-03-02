package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Start extends JFrame {
	JLabel label1;
	static JLabel label2 = new JLabel();
	public JButton startButton;
	JTextField name1;
	JTextField name2;
	String storeName = "";
	ImageIcon img;
	ArrayList<JButton> Champions = new ArrayList<JButton>() ;
	JPanel detail;
	JTextArea details;
	JPanel Grid;
	JButton confirm;
	JButton selectleader;
    JButton proceed;
    JLabel label3;
    JPanel board;
    ArrayList<JButton> boardcurr= new ArrayList<JButton>();
    JPanel turnorderpanel;
    JTextArea turnordertext;
    JPanel player1details;
    JTextArea player1detailstext;
    JPanel player2details;
    JTextArea player2detailstext;
    JButton endturn;
    Cell[][] map = new Cell[5][5];
    JButton move;
    JButton attack;
    JButton cast1;
    JButton cast2;
    JButton cast3;
    JOptionPane movechoices;
    JButton leaderAbility1;
    JButton leaderAbility2;
    
	public Start() throws IOException {
		this.setTitle("Marvel Ultimate war");
		this.setResizable(false);
		//img = new ImageIcon(getClass().getResource("/start2.jpg"));
		label1 = new JLabel();
		this.add(label1);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setSize(1366, 768);
		
		startButton = new JButton("Start Game");
		startButton.setBounds(590, 550, 150, 50);
		label1.add(startButton);

		JTextArea p1 = new JTextArea("Enter the name of the first player");
		p1.setBounds(50, 50, 220, 30);
		p1.setFont(new Font("Sans Serif",Font.BOLD,13));
		p1.setEditable(false);

		JTextArea p2 = new JTextArea("Enter the name of the second player");
		p2.setBounds(1070, 50, 250, 30);
		p2.setFont(new Font("Sans Serif",Font.BOLD,13));
		p1.setEditable(false);

		name1 = new JTextField();
		name1.setBounds(50, 100, 220, 50);

		name2 = new JTextField();
		name2.setBounds(1070, 100, 250, 50);

		label1.add(name1);
		label1.add(name2);
		label1.add(p1);
		label1.add(p2);

		detail = new JPanel();
		detail.setBackground(Color.black);
		detail.setBounds(1366 - 300, 0, 300, 768); 
		
		details = new JTextArea();
		details.setBounds(1366-300, 0 , 300 , 550);
		details.setBackground(Color.black);
		details.setFont(new Font("Sans Serif",Font.BOLD,12));
		details.setForeground(Color.WHITE);

		Grid = new JPanel();
		Grid.setLayout(new GridLayout(0, 5));
		Grid.setBounds(0,0, 1366-300, 750);
		label2.add(Grid, BorderLayout.CENTER);
		
		confirm = new JButton("Confirm Champion");
		confirm.setBounds(1366-225,560,150,30);
		confirm.setVisible(true);
		
		selectleader = new JButton("Select as a leader");
		selectleader.setBounds(1366-225, 600 , 150, 30);
		selectleader.setVisible(true);
		
		proceed = new JButton("Press To Play ");
		proceed.setBounds(1366-300, 660,300,70);
		proceed.setFont(new Font("Sans Serif",Font.BOLD,24));
		proceed.setVisible(true);
		
		
		label2.add(confirm);
		label2.add(selectleader);
		label2.add(proceed);
		label2.add(detail);
		label2.add(details);
		
		label3 =new JLabel();
		
		turnorderpanel= new JPanel();
		turnorderpanel.setBounds(0, 0, 1366, 100);
		turnorderpanel.setBackground(Color.black);
		
		turnordertext= new JTextArea();
		turnordertext.setBounds(10, 0, 1366, 100);
		turnordertext.setBackground(Color.black);
		turnordertext.setForeground(Color.white);
		turnordertext.setFont(new Font("Sans Serif",Font.BOLD,14));
		
		player1details = new JPanel();
		player1details.setBounds(0, 768-668, 200,668);
		player1details.setBackground(Color.blue);
		
		
		player1detailstext = new JTextArea();
		player1detailstext.setBounds(0, 768-668, 200, 668);
		player1detailstext.setEditable(false);
		player1detailstext.setBackground(Color.blue);
		player1detailstext.setForeground(Color.WHITE);
		player1detailstext.setFont(new Font("Sans Serif",Font.ITALIC,14));
		
		player2details = new JPanel();
		player2details.setBounds(1366-200, 768-668, 210,668);
		player2details.setBackground(Color.red);
		
		player2detailstext = new JTextArea();
		player2detailstext.setBounds(1366-200, 768-668, 200, 568);
		player2detailstext.setEditable(false);
		player2detailstext.setBackground(Color.red);
		player2detailstext.setForeground(Color.WHITE);
		player2detailstext.setFont(new Font("Sans Serif",Font.ITALIC,14));
		
		board= new JPanel();
		board.setBounds(1366-1166,786-688,1366-400,768-120);
		board.setLayout(new GridLayout(5, 5));
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = new Cell();
				board.add(map[i][j]); // adds cell to the board panel 		 
			}
		}
		
		endturn=new JButton("EndTurn");
		endturn.setBounds(1366-200, 680, 200, 51);
		endturn.setVisible(true);
		
		move= new JButton("MOVE");
		move.setBounds(1200,0 , 83, 25);
		move.setVisible(true);
		attack=new JButton("ATTACK");
		attack.setBounds(1283,0 , 83, 25);
		attack.setVisible(true);
		cast1= new JButton("CAST ABILITY 1");
		cast1.setBounds(1200,25 , 166, 25);
		cast1.setVisible(true);
		cast2= new JButton("CAST ABILITY 2");
		cast2.setBounds(1200,50 , 166, 25);
		cast2.setVisible(true);
		cast3= new JButton("CAST ABILITY 3");
		cast3.setBounds(1200,75 , 166, 25);
		cast3.setVisible(true);
		
		
		leaderAbility1 = new JButton("Use Leader Ability");
		leaderAbility1.setBounds(1166,630,200,50);
		leaderAbility1.setVisible(true);
		
		leaderAbility2 = new JButton("Use Leader Ability");
		leaderAbility2.setBounds(0,630,200,50);
		leaderAbility2.setVisible(true);
		
		label3.add(leaderAbility1);
		label3.add(leaderAbility2);
		label3.add(attack);
		label3.add(move);
		label3.add(cast1);
		label3.add(cast2);
		label3.add(cast3);
		label3.add(turnordertext);
		label3.add(turnorderpanel);
		label3.add(board);
		label3.add(endturn);
		label3.add(player1detailstext);
		label3.add(player1details);
		label3.add(player2detailstext);
		label3.add(player2details);
		
		
		this.setVisible(true);
		this.revalidate();
		this.repaint();
	}

	public JLabel getLabel3() {
		return label3;
	}

	public JPanel getBoard() {
		return board;
	}

	public ArrayList<JButton> getBoardcurr() {
		return boardcurr;
	}

	public JPanel getTurnorderpanel() {
		return turnorderpanel;
	}

	public JTextArea getTurnordertext() {
		return turnordertext;
	}

	public JPanel getPlayer1details() {
		return player1details;
	}

	public JTextArea getPlayer1detailstext() {
		return player1detailstext;
	}

	public JPanel getPlayer2details() {
		return player2details;
	}

	public JTextArea getPlayer2detailstext() {
		return player2detailstext;
	}

	public JButton getEndturn() {
		return endturn;
	}

	public JButton getConfirm() {
		return confirm;
	}

	public JButton getSelectleader() {
		return selectleader;
	}

	public JButton getProceed() {
		return proceed;
	}

	public JLabel getLabel1() {
		return label1;
	}

	public JLabel getLabel2() {
		return label2;
	}

	public ArrayList<JButton> getChampions() {
		return Champions;
	}

	public JPanel getDetail() {
		return detail;
	}

	public JTextArea getDetails() {
		return details;
	}

	public JPanel getGrid() {
		return Grid;
	}

	public JLabel getLabel() {
		return label1;
	}

	public JButton getStartButton() {
		return startButton;
	}

	public JTextField getName1() {
		return name1;
	}

	public JTextField getName2() {
		return name2;
	}

	public String getStoreName() {
		return storeName;
	}

	public ImageIcon getImg() {
		return img;
	}

	public void removelabel(JLabel l) {
		this.remove(l);
		this.repaint();
		this.revalidate();
	}

	public void addlabel(JLabel l) {
		this.add(l);
		this.repaint();
		this.revalidate();
	}

	public void addChampion(JButton Champion) {
		Grid.add(Champion);
	}
//	public static void main(String[] args) throws IOException {
//		label2.setVisible(true);
//	}
}
