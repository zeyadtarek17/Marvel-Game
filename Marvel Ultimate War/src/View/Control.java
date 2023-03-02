package View;

import java.awt.Color;
import java.awt.Point;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import engine.Game;
import engine.Player;
import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.LeaderAbilityAlreadyUsedException;
import exceptions.LeaderNotCurrentException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;
import model.abilities.Ability;
import model.abilities.AreaOfEffect;
import model.world.Champion;
import model.world.Cover;
import model.world.Direction;

public class Control implements ActionListener, KeyListener {
	private static Game game;
	private Player player1 = new Player("p1");
	private Player player2 = new Player("p2");
	Start start;
	int counter = 0;
	boolean onMove;
	boolean onAttack;
	boolean onCast;
	boolean onCastSingle1;
	boolean onCastSingle2;
	boolean onCastSingle3;

	public Control() throws IOException {
		this.game = new Game(player1, player2);
		start = new Start();
		start.getStartButton().addActionListener(this);
		start.getConfirm().addActionListener(this);
		start.getSelectleader().addActionListener(this);
		start.getProceed().addActionListener(this);
		for (int i = 0; i < start.map.length; i++) {
			for (int j = 0; j < start.map[i].length; j++) {
				start.map[i][j].addActionListener(this);
			}
		}
		start.getEndturn().addActionListener(this);
		start.move.addActionListener(this);
		start.attack.addActionListener(this);
		start.cast1.addActionListener(this);
		start.cast2.addActionListener(this);
		start.cast3.addActionListener(this);

		start.move.addKeyListener(this);
		start.attack.addKeyListener(this);
		start.cast1.addKeyListener(this);
		start.cast2.addKeyListener(this);
		start.cast3.addKeyListener(this);
		start.leaderAbility1.addActionListener(this);
		start.leaderAbility2.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == start.getStartButton()) {
			start.removelabel(start.label1);

			player1.setName(start.getName1().getText());
			player2.setName(start.getName2().getText());
			for (int i = 0; i < game.getAvailableChampions().size(); i++) {
				JButton champion = new JButton(game.getAvailableChampions().get(i).getName());
				champion.setBackground(Color.black);
				champion.setForeground(Color.white);
				champion.setFont(new Font("algerian", Font.BOLD, 20));
				champion.addActionListener(this);
				start.Grid.add(champion);
				start.Champions.add(champion);
			}
			start.addlabel(start.label2);
			JOptionPane.showMessageDialog(null, "You must choose a leader for each team to proceed", "Leader",
					JOptionPane.INFORMATION_MESSAGE);
		}

		for (int i = 0; i < start.Champions.size(); i++) {
			if (e.getSource() == start.Champions.get(i)) {
				String name = game.getAvailableChampions().get(i).toString();
				start.getDetails().setText(name);
				counter = i;
			}
		}
		if (e.getSource() == start.getConfirm() && player1.getTeam().size() < 3) {
			player1.getTeam().add(game.getAvailableChampions().get(counter));
			start.Champions.get(counter).setBackground(Color.blue);
			start.Champions.get(counter).setEnabled(false);
			if (player1.getTeam().size() == 3)
				JOptionPane.showMessageDialog(null, "Now for " + player2.getName() + "to select Champions", null,
						JOptionPane.INFORMATION_MESSAGE);

		} else if (e.getSource() == start.getConfirm() && player2.getTeam().size() < 3) {
			player2.getTeam().add(game.getAvailableChampions().get(counter));
			start.Champions.get(counter).setBackground(Color.red);
			start.Champions.get(counter).setEnabled(false);
		}
		if (e.getSource() == start.getSelectleader() && player1.getTeam().size() < 3) {
			player1.setLeader(game.getAvailableChampions().get(counter));
		}
		if (e.getSource() == start.getSelectleader() && player2.getTeam().size() < 3) {
			player2.setLeader(game.getAvailableChampions().get(counter));
		}
		if (e.getSource() == start.proceed) {
			game.prepareChampionTurns();
			game.placeChampions();
			start.removelabel(start.getLabel2());
			start.addlabel(start.getLabel3());
			refresh();
		}
		if (e.getSource() == start.endturn) {
			game.endTurn();
			refresh();
		}
		if (e.getSource() == start.move) {
			JOptionPane.showMessageDialog(null, "Use the arrows to choose directions", "Directions",
					JOptionPane.INFORMATION_MESSAGE);
			onMove = true;
		}
		if (e.getSource() == start.attack) {
			JOptionPane.showMessageDialog(null, "Use the arrows to choose directions", "Directions",
					JOptionPane.INFORMATION_MESSAGE);
			onAttack = true;
		}
		if (e.getSource() == start.cast1 && onCast == false && onCastSingle3 == false) {
			if (((Champion) game.getTurnOrder().peekMin()).getAbilities().get(0)
					.getCastArea() == AreaOfEffect.DIRECTIONAL) {
				JOptionPane.showMessageDialog(null, "Use the arrows to choose directions", "Directions",
						JOptionPane.INFORMATION_MESSAGE);
				onCast = true;
			} else if (((Champion) game.getTurnOrder().peekMin()).getAbilities().get(0)
					.getCastArea() == AreaOfEffect.SINGLETARGET) {
				JOptionPane.showMessageDialog(null, "Click on the Champion", "Choose Champion",
						JOptionPane.INFORMATION_MESSAGE);
				onCastSingle1 = true;
				return;
			} else
				try {
					game.castAbility(((Champion) game.getTurnOrder().peekMin()).getAbilities().get(0));
					refresh();
				} catch (NotEnoughResourcesException | AbilityUseException | ChampionDisarmedException
						| CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
				}
		}

		if (e.getSource() == start.cast2 && onCast == false && onCastSingle2 == false) {
			if (((Champion) game.getTurnOrder().peekMin()).getAbilities().get(1)
					.getCastArea() == AreaOfEffect.DIRECTIONAL) {
				JOptionPane.showMessageDialog(null, "Use the arrows to choose directions", "Directions",
						JOptionPane.INFORMATION_MESSAGE);
				onCast = true;
			} else if (((Champion) game.getTurnOrder().peekMin()).getAbilities().get(1)
					.getCastArea() == AreaOfEffect.SINGLETARGET) {
				JOptionPane.showMessageDialog(null, "Click on the Champion", "Choose Champion",
						JOptionPane.INFORMATION_MESSAGE);
				onCastSingle2 = true;
				return;
			} else
				try {
					game.castAbility(((Champion) game.getTurnOrder().peekMin()).getAbilities().get(1));
					refresh();
				} catch (NotEnoughResourcesException | AbilityUseException | ChampionDisarmedException
						| CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
				}
		}
		if (e.getSource() == start.cast3 && onCast == false && onCastSingle3 == false) {
			if (((Champion) game.getTurnOrder().peekMin()).getAbilities().get(2)
					.getCastArea() == AreaOfEffect.DIRECTIONAL) {
				JOptionPane.showMessageDialog(null, "Use the arrows to choose directions", "Directions",
						JOptionPane.INFORMATION_MESSAGE);
				onCast = true;
			} else if (((Champion) game.getTurnOrder().peekMin()).getAbilities().get(2)
					.getCastArea() == AreaOfEffect.SINGLETARGET) {
				JOptionPane.showMessageDialog(null, "Click on the Champion", "Choose Champion",
						JOptionPane.INFORMATION_MESSAGE);
				onCastSingle3 = true;
				return;
			} else
				try {
					game.castAbility(((Champion) game.getTurnOrder().peekMin()).getAbilities().get(2));
					refresh();
				} catch (NotEnoughResourcesException | AbilityUseException | ChampionDisarmedException
						| CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
				}
		}
		if (e.getSource() == start.leaderAbility1 || e.getSource() == start.leaderAbility2) {
			try {
				game.useLeaderAbility();
			} catch (LeaderNotCurrentException | LeaderAbilityAlreadyUsedException | CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
			}
			refresh();
		}
		if (onCastSingle1 == true) {
			Point l = getLocation(e);
			Ability a = game.getCurrentChampion().getAbilities().get(0);
			try {
				game.castAbility(a, l.x, l.y);
				refresh();
			} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
					| ChampionDisarmedException | CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
			}
			onCastSingle1 = false;
		}
		if (onCastSingle2 == true) {
			Point l = getLocation(e);
			refresh();
			Ability a = game.getCurrentChampion().getAbilities().get(1);
			try {
				game.castAbility(a, l.x, l.y);
			} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
					| ChampionDisarmedException | CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
			}
			onCastSingle2 = false;
		}
		if (onCastSingle3 == true) {
			Point l = getLocation(e);
			refresh();
			Ability a = game.getCurrentChampion().getAbilities().get(2);
			try {
				game.castAbility(a, l.x, l.y);
			} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
					| ChampionDisarmedException | CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
			}
			onCastSingle3 = false;
		}
	}

	public Point getLocation(ActionEvent e) {
		Point l = new Point(0, 0);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (e.getSource() == start.map[i][j]) {
					l.x = i;
					l.y = j;
				}
			}
		}
		return l;
	}

	public void refresh() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (game.getBoard()[i][j] == null) {
					start.map[i][j].setBackground(Color.white);
					continue;
				}
				if (game.getBoard()[i][j] instanceof Champion) {
					Champion c = (Champion) game.getBoard()[i][j];
					if (game.getTurnOrder().peekMin() == c) {
						start.map[i][j].setText(c.getName());
						start.map[i][j].setBackground(Color.GRAY);
						start.map[i][j].setForeground(Color.white);
					} else if (player1.getTeam().contains(c)) {
						start.map[i][j].setText(c.getName());
						start.map[i][j].setBackground(Color.blue);
						start.map[i][j].setForeground(Color.white);
					} else {
						start.map[i][j].setText(c.getName());
						start.map[i][j].setBackground(Color.red);
						start.map[i][j].setForeground(Color.white);
					}
				}
				if (game.getBoard()[i][j] instanceof Cover) {
					Cover c = (Cover) game.getBoard()[i][j];
					start.map[i][j].setText("" + c.getCurrentHP());
					start.map[i][j].setBackground(Color.black);
					start.map[i][j].setForeground(Color.white);
				}
			}
		}
		start.repaint();
		start.revalidate();
		if (game.checkGameOver() instanceof Player) {
			JOptionPane.showMessageDialog(null, "The Winner Is : " + game.checkGameOver().getName(), "Winner",
					JOptionPane.INFORMATION_MESSAGE);
			start.removelabel(start.label3);
			start.dispose();
			return;
		}
		start.player1detailstext
				.setText("Leader Ability Used: " + game.isFirstLeaderAbilityUsed() + "\n" + player1.toString());
		start.player2detailstext
				.setText("Leader Ability Used: " + game.isSecondLeaderAbilityUsed() + "\n" + player2.toString());
		start.turnordertext.setText(
				game.getTurnOrder().toString() + "\n" + ((Champion) game.getTurnOrder().peekMin()).toStringoneline());
		start.repaint();
		start.revalidate();
	}

	public static void main(String[] args) throws IOException {
		new Control();
	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {
		Direction d = null;
		if (e.getKeyCode() == 37)
			d = Direction.LEFT;
		if (e.getKeyCode() == 38)
			d = Direction.DOWN;
		if (e.getKeyCode() == 39)
			d = Direction.RIGHT;
		if (e.getKeyCode() == 40)
			d = Direction.UP;
		if (onMove == true) {
			try {
				game.move(d);
				onMove = false;
				refresh();
			} catch (NotEnoughResourcesException | UnallowedMovementException e1) {
				onMove = false;
				JOptionPane.showMessageDialog(null, e1.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (onAttack == true) {
			try {
				game.attack(d);
				onAttack = false;
				refresh();
			} catch (NotEnoughResourcesException | ChampionDisarmedException | InvalidTargetException e1) {
				onAttack = false;
				JOptionPane.showMessageDialog(null, e1.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (onCast == true) {
			try {
				game.attack(d);
				onCast = false;
				refresh();
			} catch (NotEnoughResourcesException | ChampionDisarmedException | InvalidTargetException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void keyReleased(KeyEvent e) {
	}

}
