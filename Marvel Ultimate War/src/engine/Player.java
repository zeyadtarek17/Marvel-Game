package engine;

import java.util.ArrayList;

import model.world.Champion;

public class Player {
	private String name;
	private ArrayList<Champion> team;
	private Champion leader;

	public Player(String name) {
		this.name = name;
		team = new ArrayList<Champion>();

	}

	public Champion getLeader() {
		return leader;
	}

	public void setLeader(Champion leader) {
		this.leader = leader;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Champion> getTeam() {
		return team;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "name=" + name  +"\n"+ team.get(0).playerdetailstoString(team)+", leader :" + leader.getName() ;
	}
	

}
