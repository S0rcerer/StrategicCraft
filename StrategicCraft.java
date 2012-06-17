package net.minecraft.src.StrategicCraft;

import net.minecraft.src.Block;
import net.minecraft.src.BlockStep;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;

public class StrategicCraft{
	
	public StrategicCraft()
	{
		BlockStep b = new BlockStep(254,false);
		ModLoader.registerBlock(b);
		ModLoader.addRecipe(new ItemStack(b), new Object[]{"D",Character.valueOf('D'),Block.dirt});
		b.setBlockName("Tonnik block");
		ModLoader.addName(b, "Tonniks Block");
	}

}
