package game;

import java.util.List;

public class Game {

    public static void init() {
    }

    public static void battle(Pokemon pokemon1, Pokemon pokemon2) {
        while (pokemon1.getHealth() > 0 && pokemon2.getHealth() > 0) {
            pokemon1.show();
            pokemon2.show();
            pokemon1.hit(pokemon1.getAbilities().get(0), pokemon2);
            pokemon2.hit(pokemon2.getAbilities().get(0), pokemon1);
        }
        if (pokemon1.getHealth() > 0) {
            showMessage(pokemon1.getName() + " is winner!");
            pokemon1.levelUp();
        } else if (pokemon2.getHealth() > 0) {
            showMessage(pokemon2.getName() + " is winner!");
            pokemon2.levelUp();
        } else showMessage("Both is dead.");

    }

    public static void showMessage(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) {
        init();
        Pokemon pokemon1 = new Pokemon();
        Pokemon pokemon2 = new Pokemon("Unusual Theodor", 8, 0, 1, List.of(new Attack()));
        battle(pokemon1, pokemon2);
    }
}