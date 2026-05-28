package my.OOP.exes.Abstraction;

public class E_Abstraction {

	public static void main(String[] args) {
		
		
		System.out.println("==========================");
		System.out.println("===== Warriors Brawl =====");
		System.out.println("==========================\n");

		
		// Character array
		Character [] team = {
				 new Royal_Knight("Royal Knight", 100, 20),
				 new Dark_Knight("Dark Knight", 80, 10),
				 new Warrior("Warriror", 80, 15),
				 new Mage("Mage", 50, 25),
				 new Archer("Archer", 60, 15)
		};
		
		
		// Showing Special Skills
		System.out.println("\n== Using Special Skills ==\n");
		for(Character c : team) {
		    c.specialSkill();
		}
		
		// Showing Normal Attacks
		System.out.println("\n== Using Normal Attacks ==\n");
		for(Character c : team) {
		    c.attackDemo();
		}
		
		
		// installing character Info into 'c' and 'c1'
		Character c = team[0];
		Character c1 = team[1];
		c.showStatus();
		c1.showStatus();
		System.out.println("\n== Death Match ==\n");
		do {
			c.attack(c1);	
			c1.attack(c);	
			c.heal(5);
			c1.heal(10);
		}while(c.getHp() != 0 && c1.getHp() != 0);
	}
	
}

abstract class Character{
	// private fields
	private String name;
	private int hp;
	private int attackDamage;
	
	// get values 
	public Character(String name, int hp, int attackDamage) {
		this.name = name;
		this.attackDamage = attackDamage;
		if(hp < 0) {
			System.out.println("HP cannot be below 0");
			this.hp = 0;
		}
		else {
			this.hp = hp;
		}
	}	
	
	// show METHOD
	public void showStatus() {
		System.out.println("\n== Status ==" + 
							"\nName : " + name + 
							"\nHp : " + hp + 
							"\nAttackDmg : " + attackDamage + "\n");
	}
	
	// getter METHOD
	public int getHp() {
		return hp;
	}
	
	// attack Demo METHOD
	public void attackDemo() {
		System.out.println("%s is attacking randomly !".formatted(name));
	}
	
	// attack with another character METHOD
	public void attack(Character x) {
		if(hp > 0) {
			System.out.println("%s is attacking !".formatted(name));
			x.takeDamage(this.attackDamage);
		}
	}
	
	// take damage METHOD
	// since x calls this method, every field in this method belongs to x
	public void takeDamage(int dmg) {
		hp -= dmg;
		if(hp <= 0) {
			hp = 0;
			System.out.println("%s HP is 0.\n%s has been defeated\n".formatted(name, name));
		}
		else {
			System.out.println("%s Hp is %d\n".formatted(name, hp));
		}
	}
	
	// heal METHOD
	public void heal(int amount) {
		if(hp>0) {
			this.hp += amount;
			System.out.println("%s healed %d HP using potion".formatted(name, amount));
			System.out.println("%s HP : %d\n".formatted(name,hp));		
		}
	}
	
	abstract void specialSkill();
}

class Royal_Knight extends Character{
	
	public Royal_Knight(String name, int hp, int attackDamage) {
		super(name, hp, attackDamage);
	}
	
	@Override
	public void specialSkill() {
		System.out.println("Royal Knight using Special Skill <Divine Blade>");
	}
	
	@Override
	public void attackDemo() {
		System.out.println("Royal Knight uses Heavy Sword");
	}
	
}


class Dark_Knight extends Character{
	
	public Dark_Knight(String name, int hp, int attackDamage) {
		super(name, hp, attackDamage);
	}
	
	@Override
	public void specialSkill() {
		System.out.println("Dark Knight using Special Skill <Poison Dagger>");
	}
	
	@Override
	public void attackDemo() {
		System.out.println("Royal Knight uses Dual Blades");
	}
	
}


class Warrior extends Character{

	public Warrior(String name, int hp, int attackDamage) {
		super(name, hp, attackDamage);
	}
	
	@Override
	public void specialSkill() {
		System.out.println("Warrior using Special skill <Slash>");
	}
	
	@Override
	public void attackDemo() {
		System.out.println("Warrior uses Sword Attack");
	}
}


class Mage extends Character{

	public Mage(String name, int hp, int attackDamage) {
		super(name, hp, attackDamage);
	}
	
	@Override
	public void specialSkill() {
		System.out.println("Mage using Special skill <Fireball>");
	}
	
	@Override
	public void attackDemo() {
		System.out.println("Mage uses Magic Attack");
	}
}


class Archer extends Character{

	public Archer(String name, int hp, int attackDamage) {
		super(name, hp, attackDamage);
	}
	
	@Override
	public void specialSkill() {
		System.out.println("Archer using Special skill <Double Arrow>");
	}
	
	@Override
	public void attackDemo() {
		System.out.println("Archer uses Arrow Shot");
	}
}