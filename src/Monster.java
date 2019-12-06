
public abstract class Monster {
	private String name;
	private int damage;
	private int life;
	private String type;

	public String getName() {
		return name;
	}

	public int getDamage() {
		return damage;
	}

	public int getLife() {
		return life;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Monster(String name, int damage, int life) {
		this.name = name;
		this.damage = damage;
		this.life = life;
		this.type = "normal";
	}

	public void takeHit(Monster attacker) {
		double factor;

		switch (attacker.type + "->" + this.type) {
		case "fire->grass":
		case "grass->water":
		case "water->fire":
			factor = 2.0;
			break;
		case "grass->fire":
		case "water->grass":
		case "fire->water":
			factor = 0.5;
			break;
		default:
			factor = 1.0;
		}

		this.life -= factor * attacker.damage;

		if (this.isAlive()) {
			System.out.println(this.name + " has " + this.life + " points remaining");
		} else {
			System.out.println(this.name + " is KO!");
		}
	}
	
	public boolean isAlive() {
		return this.life >= 0;
	}
	
	@Override
	public String toString() {
		String result = "";

		result += "Monster " + this.getName();
		result += " is a " + this.getType().substring(0, 1).toUpperCase() + this.getType().substring(1) + "Monster";
		result += " and has " + this.getDamage() + " Damagepoints";
		result += " and " + this.getLife() + " Lifepoints";
		
		return result;
	}
}
