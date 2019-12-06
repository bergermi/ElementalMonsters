import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;

public class Arena {

	public static void main(String[] args) {
		List<Monster> monsters = new ArrayList<>();
		Monster player, opponent, defender, previousDefender, attacker;

		monsters.add(new FireMonster("Flamy", 70, 300));
		monsters.add(new GrassMonster("Greeny", 10, 1000));
		monsters.add(new WaterMonster("Wavy", 50, 600));

		player = Arena.chooseMonster(monsters);
		monsters.remove(player);
		Collections.shuffle(monsters);
		opponent = monsters.get(0);

		attacker = player;
		defender = opponent;

		while (defender.isAlive() && attacker.isAlive()) {
			defender.takeHit(attacker);

			// Switch roles
			previousDefender = defender;
			defender = attacker;
			attacker = previousDefender;
		}
	}

	public static Monster chooseMonster(List<Monster> monsters) {
		int number = 1;

		for (Monster monster : monsters) {
			System.out.print("Monster " + number + ": ");
			System.out.println(monster);

			number++;
		}

		int playerMonsterNumber = -1;

		while (playerMonsterNumber == -1) {
			System.out.println("Please enter the number for your Monster: ");
	
			try {
				playerMonsterNumber = IO.getStdinScanner().nextInt();
			} catch (InputMismatchException e) {
				IO.getStdinScanner().next();
			}
			
			if (playerMonsterNumber < 1 || playerMonsterNumber > monsters.size()) {
				playerMonsterNumber = -1;
			}
		}
		
		return monsters.get(playerMonsterNumber - 1);
	}

}
