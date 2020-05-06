package playerPart;

import items.*;

public class TestMain {

	public static void main(String[] args) {

		Player player = new Player();

		player.addName();

		player.getExp(5000);

		player.checkLevelUp();

		player.showStatus();

		A_Hat A1 = new A_Hat("", 0, 0, 0, 0, 0);

		A_HeadPiece A2 = new A_HeadPiece("", 0, 0, 0, 0, 0);

		B_OldArmor B1 = new B_OldArmor("", 0, 0, 0, 0, 0);

		B_ShiningArmor B2 = new B_ShiningArmor("", 0, 0, 0, 0, 0);

		B_DiamondArmor B3 = new B_DiamondArmor("", 0, 0, 0, 0, 0);

		C_OldCloak C1 = new C_OldCloak("", 0, 0, 0, 0, 0);

		C_ShiningCloak C2 = new C_ShiningCloak("", 0, 0, 0, 0, 0);

		C_InvisibilityCloak C3 = new C_InvisibilityCloak("", 0, 0, 0, 0, 0);

		D_SilverWand D1 = new D_SilverWand(null, 0, 0, 0, 0, 0);

		D_GoldWand D2 = new D_GoldWand(null, 0, 0, 0, 0, 0);

		D_DiamondWand D3 = new D_DiamondWand(null, 0, 0, 0, 0, 0);

		Inventory iv = new Inventory();

		iv.addEquipment(A1);

		iv.addEquipment(A2);

		iv.addEquipment(B1);

		iv.addEquipment(B2);

		iv.addEquipment(B3);

		iv.addEquipment(C1);

		iv.addEquipment(C2);

		iv.addEquipment(C3);

		iv.addEquipment(D1);

		iv.addEquipment(D2);

		iv.addEquipment(D3);

		iv.showInventory();
		iv.showEquip();

		while (true) {

			iv.equipItem();

		}

	}

}
