package net.minecraft.src.StrategicCraft;

import net.minecraft.src.World;

public class Building {
	
	private int[][][] blocks = 
		{
			   {{4,4,4,4,4},
				{4,4,4,4,4},
				{4,4,4,4,4},
				{4,4,4,4,4},
				{4,4,4,4,4}},
				
			   {{4,5,5,5,4},
				{5,0,0,65,5},
				{0,0,0,0,5},
				{5,0,0,0,5},
				{4,5,5,5,4}},

			   {{4,5,0,5,4},
				{5,0,0,65,5},
				{0,0,0,0,0},
				{5,0,0,0,5},
				{4,5,0,5,4}},
					
			   {{4,5,5,5,4},
				{5,0,0,65,5},
				{5,0,0,0,5},
				{5,0,0,0,5},
				{4,5,5,5,4}},

			   {{17,17,17,17,17},
				{17,17,17,65,17},
				{17,17,17,17,17},
				{17,17,17,17,17},
				{17,17,17,17,17}},

			   {{85,85,85,85,85},
				{85,0,0,0,85},
				{85,0,0,0,85},
				{85,0,0,0,85},
				{85,85,85,85,85}},

			};
	
	
	public Building(World world, int y, int z,int x)
	{
		int side = world.getBlockMetadata(y, z, x);
    	
    	for (int rz=0;rz<6;rz++){
    		for (int ry=0;ry<5;ry++){
    			for (int rx=0;rx<5;rx++){
    				if (side == 2) PlaceBlock(world,y+ry-2, z+rz-1, x+rx+1, blocks[rz][ry][rx],2);
    				if (side == 4) PlaceBlock(world,y+ry+1, z+rz-1, x+rx-2, blocks[rz][rx][ry],4);
    				if (side == 3) PlaceBlock(world,y+ry-2, z+rz-1, x+rx-5, blocks[rz][4-ry][4-rx],3);
    				if (side == 5) PlaceBlock(world,y+ry-5, z+rz-1, x+rx-2, blocks[rz][4-rx][4-ry],5);
    			}
    		}
    	}
	}
	
    private void PlaceBlock(World world, int y, int z, int x, int id, int v)
    {
    	if (id==65)
    		world.setBlockAndMetadataWithNotify(y, z, x, id, v);
    	else
    		world.setBlock(y, z, x, id);
    }
}
