package my.OOP.exes.ObjClass;

public class A_Object_Classes {
	public static void main(String[] args) {
		Character ch1 = new Character("Royal Knight", 100, 20); 
		ch1.attack(); ch1.showStatus(); 
		
		Character ch2 = new Character("Dark Knight", 80, 10); 
		ch2.attack(); ch2.showStatus(); 
		} 
}

class Character{ 
//	private fields 
	private String name; 
	private int hp; 
	private int attackDamage;
	
//	get values 
	public Character(String name, int hp, int attackDamage) { 
		this.name = name; 
		this.attackDamage = attackDamage; 
		if(this.hp < 0) { 
			System.out.println("HP cannot be below 0"); 
		} else {
			this.hp = hp; } 
		} 

// attack METHOD 
	public void attack() { 
		System.out.println(name + " is attacking !"); 
		} 
	
// show METHOD 
	public void showStatus() { 
		System.out.println("== Status ==" + 
							"\nName : " + name + 
							"\nHp : " + hp + 
							"\nAttackDmg : " + attackDamage + "\n"); 
		} 
}
