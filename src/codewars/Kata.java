package cowers;

/**
 * Created by Peter on 1/7/17.
 */
/*
Create a function that returns the name of the winner in a fight between two fighters.

Each fighter takes turns attacking the other and whoever kills the other first is victorious. Death is defined as having health <= 0.

Each fighter will be a Fighter object/instance. See the Fighter class below in your chosen language.

Both health and damagePerAttack (damage_per_attack for python) will be integers larger than 0. You can mutate the Fighter objects.
Example:

  declareWinner(new Fighter("Lew", 10, 2), new Fighter("Harry", 5, 4), "Lew") => "Lew"

  // Python
  declare_winner(Fighter("Lew", 10, 2), Fighter("Harry", 5, 4), "Lew") => "Lew"

  Lew attacks Harry; Harry now has 3 health.
  Harry attacks Lew; Lew now has 6 health.
  Lew attacks Harry; Harry now has 1 health.
  Harry attacks Lew; Lew now has 2 health.
  Lew attacks Harry: Harry now has -1 health and is dead. Lew wins.

Technical note for Clojure programmers: The second fighter argument (f2) always attacks first.

CodeWars URL: https://www.codewars.com/kata/two-fighters-one-winner/train/java

 */
public class Kata {
    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        while (fighter1.health >= 0 && fighter2.health >= 0) {
            //Fighter 1 attacks:
            fighter2.health -= fighter1.dangerPerAttack;
            if (fighter2.health < 0) {
                return fighter1.name;
            }
            //fighter2 attacks
            fighter1.health -= fighter2.dangerPerAttack;
            if (fighter1.health < 0) {
                return fighter2.name;
            }
        }
        return "Nobody.";
    }


    public static void main(String[] args) {
        String f1_name = args[0];
        int f1_health = Integer.parseInt(args[1]);
        int f1_danger = Integer.parseInt(args[2]);

        String f2_name = args[3];
        int f2_health = Integer.parseInt(args[4]);
        int f2_danger = Integer.parseInt(args[5]);

        System.out.println(Kata.declareWinner(new Fighter(f1_name, f1_health, f1_danger), new Fighter(f2_name, f2_health, f2_danger), f1_name));
    }
}

class Fighter {
    String name;
    int health, dangerPerAttack;
    Fighter(String name, int health, int dangerPerAttack) {
        this.name = name;
        this.health = health;
        this.dangerPerAttack = dangerPerAttack;
    }
}

