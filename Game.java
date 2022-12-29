public class Game {
	
	public static void init() {
	}
	
	public static battle(Pokemon pokemon1, Pokemon pokemon2) {
		while (pokemon1.getHealth() > 0 && pokemon2.getHealth() > 0) {
			pokemon1.show();
			pokemon2.show();
			pokemon1.hit(pokemon1.get(0), pokemon2);
			pokemon2.hit(pokemon2.get(0), pokemon1);
		}
		if (pokemon1.getHealth() > 0) {
			showMessage(pokemon1.getName() + " is winner!");
			pokemon1.levelUp();
		} else if (pokemon2.getHealth() > 0) {
				showMessage(pokemon2.getName() + " is winner!");
				pokemon2.levelUp();
		} else showMessage("Both is dead.");

	}
	
	public void showMessage(String msg) {
		System.out.println(msg);
	}
	
	public static void main(String[] args) {
		init();
		Pokemon pokemon1 = new Pokemon();
		Pokemon pokemon2 = new Pokemon();
		battle(pokemon1, pokemon2);
	}
}