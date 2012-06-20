package net.minecraft.src.StrategicCraft;

import net.minecraft.src.*;

public class TowerPackageBlock extends Block{
	
	int[][][] blocks = 
		{
		   {{4,4,4,4,4},
			{4,4,4,4,4},
			{4,4,4,4,4},
			{4,4,4,4,4},
			{4,4,4,4,4}},
			
		   {{5,5,5,5,5},
			{5,0,0,0,5},
			{0,0,0,0,5},
			{5,0,0,0,5},
			{5,5,5,5,5}},

		   {{5,5,5,5,5},
			{5,0,0,0,5},
			{0,0,0,0,5},
			{5,0,0,0,5},
			{5,5,5,5,5}},
				
		   {{5,5,5,5,5},
			{5,0,0,0,5},
			{5,0,0,0,5},
			{5,0,0,0,5},
			{5,5,5,5,5}},

		   {{5,5,5,5,5},
			{5,5,5,5,5},
			{5,5,5,5,5},
			{5,5,5,5,5},
			{5,5,5,5,5}},

		   {{85,85,85,85,85},
			{85,0,0,0,85},
			{85,0,0,0,85},
			{85,0,0,0,85},
			{85,85,85,85,85}},

		};
	
	
	
	
	
	
	
	
	
	protected TowerPackageBlock(int par1, int par2) {
		super(par1, par2, Material.wood);
		
		
		
	}
	
    public boolean blockActivated(World world, int y, int z, int x, EntityPlayer player)
    {
    	//   x  y  z
    	//   y  z  x
    	
    	for (int ry=0;ry<5;ry++){
    		for (int rz=0;rz<6;rz++){
    			for (int rx=0;rx<5;rx++){
    				world.setBlock(y+ry, z+rz, x+rx, blocks[rz][rx][ry]);
    			}
    		}
    	}
        return true;
    }
	
}
