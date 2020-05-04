package playerPart;

import items.*;


public class TestMain {

	public static void main(String[] args) {

		
		Player player = new Player();
		
		player.addName();
		
		player.getExp(5000);
		
		player.checkLevelUp();
		
		player.showStatus();
		
		
		BrokenSword Bs = new BrokenSword("h", 0, 0, 0, 0, 0);
		
		
		
		
		
		Inventory iv = new Inventory();
		
		
		
		iv.addEquipment(Bs);
			
		iv.showInventory();
		
		
		
		
	}

}
