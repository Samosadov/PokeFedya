public class Pokemon {
	private static final int MIN_HEALTH = 4;
	private String name;
	private int health;
	// private int defence;
	// private int protection;
	private int experience;
	private int level;
	private int expToLevel;
	private List<Attack> abilities;
	
	public Pokemon() {
		String name = "Ordinary Theodor";
		health = MIN_HEALTH;
		experience = 0;
		level = 1;
		expToLevel = level * 20;
		abilities = new ArrayList<>(List.of(new Attack()));
	}
	
	public Pokemon(String name, int health, int experience, int level, List abilities) {
		this.name = name;
		this.health = health;
		this.experience = experience;
		this.level = level;
		expToLevel = level * 20;
		this.abilities = abilities;
	}
	
	public void levelUp() {
		experience += 5;
		if (experience >= expToLevel) {
			level++;
			experience -= expToLevel;
			health += level;
			for(Attack a : abilities) a.setForce(a.getForce() + level);
			Game.showMessage("Your Fedya looks more powerful!");
			show();
		}
	}

	public void hit(Attack attack, Pokemon mon) {
		if (attack.isPossible(this)) {
			energy -= attack.getMovePoints();
			float dmg = attack.makeDamage(this);
			mon.setHealth((mon.getHealth() < dmg) ? mon.getHealth() - dmg: 0);
			attack.makeDamage(mon);
		}
		else Game.showMessage("Not enough move points.");
	}
	
	public void show() {
		Sytem.out.println(this);
	}
	
	@Override
	public String toString() {
		return name + " HP: " + health + " Exp: " + experience + " lvl: " + level;
	}
}