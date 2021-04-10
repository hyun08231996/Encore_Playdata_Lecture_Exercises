package fly.test;

interface Movable{
	void move(int x, int y);
}

interface Attackable{
	void attack(Unit u);
}

class Unit{
	int currentHP;
	int x;
	int y;
}

interface Fightable extends Movable, Attackable{
	void goahead();
}

class Fighter implements Fightable{

	@Override
	public void move(int x, int y) {
		
		
	}

	@Override
	public void attack(Unit u) {
		
		
	}

	@Override
	public void goahead() {
		
		
	}
	
}

public class fighterTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
