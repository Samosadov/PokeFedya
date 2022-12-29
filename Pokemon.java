public class Pokemon {
	private static final int MIN_HEALTH = 4;
	private String name;
	private int health;
	// private int defence;
	// private int protection;
	private int experience;
	private int level;
	private List<Attack> abilities;
	
	public Pokemon() {
		String name = "Ordinary Theodor";
		health = MIN_HEALTH;
		experience = 0;
		level = 1;
		abilities = new ArrayList<>(List.of(new Attack()));
	}
	
	public Pokemon(String name, int health, int experience, int level, List abilities) {
		this.name = name;
		this.health = health;
		this.experience = experience;
		this.level = level;
		this.abilities = abilities;
	}
	
	public void hit(Attack attack, Pokemon mon) {
		if (attack.isPossible(this)) mon.health = (mon.health > attack.force) ? mon.health - attack.force : 0;
		else showMessage("Not enough move points.");
	}
	
	public void show() {
		
	}
	
	public void showMessage(String msg) {
		System.out.println(msg);
	}
	
	@Override
	public String toString() {
		return name + " HP: " + health + " Exp: " + experience + " lvl: " + level;
	}
}