package net.minecraft.src.StrategicCraft;

import net.minecraft.src.Block;
import net.minecraft.src.BlockStep;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;

public class StrategicCraft{
	
	public StrategicCraft()
	{
		int tex = ModLoader.addOverride("/terrain.png", "/textures/TowerPack.png");
		TowerPackageBlock b = new TowerPackageBlock(254, tex);
		ModLoader.registerBlock(b);
		ModLoader.addRecipe(new ItemStack(b), new Object[]{"D",Character.valueOf('D'),Block.dirt});
		b.setBlockName("Tower Package Block");
		ModLoader.addName(b, "Tower Package");
	}

}
