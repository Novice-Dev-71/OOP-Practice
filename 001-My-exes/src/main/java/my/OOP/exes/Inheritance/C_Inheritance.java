package my.OOP.exes.Inheritance;

public class C_Inheritance {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Character ch1 = new Character("Royal Knight", 100, 20);
		Character ch2 = new Character("Dark Knight", 80, 10);
//		ch1.attack(ch2);
//		ch2.attack(ch1);
//		ch1.showStatus();
//		ch2.showStatus();
//		ch1.heal(5);
//		ch2.heal(10);
		
		// Character array
		Character [] team = {
				 new Warrior("Warriror", 80, 15),
				 new Mage("Mage", 50, 25),
				 new Archer("Archer", 60, 15)
		};
		
		for(Character c : team) {
		    c.specialSkill();
		}
		
	}
}

class Character{
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
		System.out.println("== Status ==" + 
							"\nName : " + name + 
							"\nHp : " + hp + 
							"\nAttackDmg : " + attackDamage + "\n");
	}
	
	// attack METHOD
	public void attack(Character x) {
		System.out.println("%s is attacking !".formatted(name));
		x.takeDamage(this.attackDamage);
	}
	
	// take damage METHOD
	// since x calls this method, every field in this method belongs to x
	public void takeDamage(int dmg) {
		hp -= dmg;
		if(hp <= 0) {
			hp = 0;
			System.out.println("%s HP is below 0.\n%s has been defeated\n".formatted(name, name));
		}
		else {
			System.out.println("%s Hp is %d\n".formatted(name, hp));
		}
	}
	
	// heal METHOD
	public void heal(int amount) {
		if(hp<=0) {
			System.out.println("%s has been defeated. %s cannot heal.".formatted(name, name));
		}
		else {
			this.hp += amount;
			System.out.println("%s healed %d HP using potion".formatted(name, amount));
			System.out.println("%s HP : %d\n".formatted(name,hp));
		}
	}
	
	public void specialSkill() {
		System.out.println("Basic Skill");
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
}


class Mage extends Character{

	public Mage(String name, int hp, int attackDamage) {
		super(name, hp, attackDamage);
	}
	
	@Override
	public void specialSkill() {
		System.out.println("Mage using Special skill <Fireball>");
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
}
