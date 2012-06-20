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
	
	
	
	
	
	
	
	int texture;
	
	protected TowerPackageBlock(int par1, int par2) {
		super(par1, par2, Material.wood);
		texture = par2;
		
		
	}
	
	 public void onBlockPlacedBy(World world, int y, int z, int x, EntityLiving placer)
	    {
	        int var6 = MathHelper.floor_double((double)(placer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

	        if (var6 == 0)
	        {
	            world.setBlockMetadataWithNotify(y, z, x, 2);
	        }

	        if (var6 == 1)
	        {
	            world.setBlockMetadataWithNotify(y, z, x, 5);
	        }

	        if (var6 == 2)
	        {
	            world.setBlockMetadataWithNotify(y, z, x, 3);
	        }

	        if (var6 == 3)
	        {
	            world.setBlockMetadataWithNotify(y, z, x, 4);
	        }
	        
	        //
	        EntityPlayer p = (EntityPlayer)placer;
	        p.addChatMessage(Integer.toString(var6));
	    }
	    
	    public int getBlockTexture(IBlockAccess par1IBlockAccess, int y, int z, int x, int side)
	    {
	        if (side == 1)
	        {
	            return 43;
	        }
	        else if (side == 0)
	        {
	            return 43;
	        }
	        else
	        {
	            int var6 = par1IBlockAccess.getBlockMetadata(y, z, x);
	            return side != var6 ? 43 : texture;
	        }
	    }
		
	    public boolean blockActivated(World world, int y, int z, int x, EntityPlayer player)
	    {
	    	//   x  y  z
	    	//   y  z  x
	    	int side = world.getBlockMetadata(y, z, x);
	    	player.addChatMessage(Integer.toString(side));
	    	
	    	for (int rz=0;rz<6;rz++){
	    		for (int ry=0;ry<5;ry++){
	    			for (int rx=0;rx<5;rx++){
	    				if (side == 2) PlaceBlock(world,y+ry-2, z+rz, x+rx+1, blocks[rz][ry][rx],2);
	    				if (side == 4) PlaceBlock(world,y+ry+1, z+rz, x+rx-2, blocks[rz][rx][ry],4);
	    				if (side == 3) PlaceBlock(world,y+ry-2, z+rz, x+rx-5, blocks[rz][4-ry][4-rx],3);
	    				if (side == 5) PlaceBlock(world,y+ry-5, z+rz, x+rx-2, blocks[rz][4-rx][4-ry],5);
	    			}
	    		}
	    	}
	        return true;
	    }
	    
	    private void PlaceBlock(World world, int y, int z, int x, int id, int v)
	    {
	    	if (id==65)
	    		world.setBlockAndMetadataWithNotify(y, z, x, id, v);
	    	else
	    		world.setBlock(y, z, x, id);
	    }
}
