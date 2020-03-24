package lesson04;

public class App04 {

	public static void main(String[] args) {
		Building commandCenter = new Building();
		commandCenter.setHp(400);
		Infantry mariner1 = new Infantry();
		Infantry mariner2 = new Infantry();
		mariner1.name = "John";
		mariner2.name = "Jessie";
		mariner1.state();
		mariner1.shoot(mariner2);
		mariner2.state();
		mariner1.shoot(commandCenter);
	}

}

class Terran {
	private int hp, ap; // HP = health, AP = armor

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		//this.hp = hp;
	}

	public int getAp() {
		return ap;
	}

	public void setAp(int ap) {
		this.ap = ap;
	}
	
}
class Building extends Terran {
	boolean canFly, produceUnits, produceUpgrades;
	int size;
}
class Infantry extends Terran {
	boolean canShoot, canJump;
	int speed, range, attack;
	int height, weight;
	String name;
	public Infantry() {
		this.setHp(100);
		this.setAp(1);
		attack = 8;
		canJump = false;
		canShoot = true;
		height = 170;
		speed = 8;
		range = 5;
	}
	public void shoot(Terran target) {
		System.out.println(
			/*"Target is "+target.name+*/". Piu piu!");
		//target.hp-=attack;
		target.setHp(target.getHp() - attack);
	}
	public void state() {
		System.out.println("My name is "+name);
		System.out.println("HP: "+this.getHp());
	}
}
class Mech extends Terran {
	boolean canShoot;
	int speed, range, attack;
	int mass;
	public void shoot() {
		System.out.println("Boom!");
	}
}


















