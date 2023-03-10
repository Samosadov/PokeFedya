public class Attack {
	private String name;
	private boolean active;
	private float force;
	private float chanceToCritical;
	private float movePoints;
	
	public Attack() {
		name = "Base Punch";
		force = 2.0;
		chanceToCritical = 0.05;
		movePoints = 2.0;
	}

	public Attack(String name, float force, float movePoints) {
		this.name = name;
		this.force = force;
		this.chanceToCritical = 0.05;
		this.movePoints = movePoints;
	}
	
	public Attack(String name, float force, float chanceToCritical, float movePoints) {
		this.name = name;
		this.force = force;
		this.chanceToCritical = chanceToCritical;
		this.movePoints = movePoints;
	}
	
	public boolean isPossible(Pokemon pokemon) {
		return movePoints >= pokemon.getEnergy();
	}
	
	public float makeDamage(Pokemon pokemon) {
		return (Math.random() < chanceToCritical) ? 2 * force : force;
	}
	
	public void setChanceToCritical(float chanceToCritical) { this.chanceToCritical = chanceToCritical; }
	
	public void setForce(float force) { this.force = force; }
	
	public boolean isActive() { return active; }
	
	public void setActive(boolean active) { this.active = active; }
}