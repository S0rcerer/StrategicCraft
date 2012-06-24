package net.minecraft.src.StrategicCraft;

import java.util.ArrayList;

import net.minecraft.src.*;

public class TowerPackageBlock extends Block{
	
	private Building building;
	
	
	
	
	
	
	
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
	        BuildFencing(world, y, z, x);
	        
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
	    	building = new Building(world, y, z, x);
	    	//this.removeBlockByPlayer(world, player, );
	    	world.setBlockWithNotify(y, z, x, 0);
	    	return true;
	    }
	    
	    public void addCreativeItems(ArrayList itemList)
	    {
	    	itemList.add(new ItemStack(this));
	    }
	    
	    private void BuildFencing (World world, int y, int z, int x)
	    {
	    	int side = world.getBlockMetadata(y, z, x);
	    	
	     	for (int i=0;i<7;i++)
	     	{
	    	  SideKoord(world, i, 0, 3, side, y, z, x);
	    	  SideKoord(world, i, 0, -3, side, y, z, x);
	     	}
	     	for (int j=-2;j<3;j++)
	     	{
	     		if (j!=0) SideKoord(world, 0, 0, j, side, y, z, x);
	     		SideKoord(world, 6, 0, j, side, y, z, x);
	     	}
	    
	    }
	    
	    private void SideKoord(World world, int y, int z, int x, int side,int ry, int rz, int rx)
	    {
	    	switch (side) {
			case 2:
				world.setBlock(ry-x, rz, rx+y , 85);
				break;
			case 3:
				world.setBlock(ry+x, rz, rx-y , 85);
				break;
			case 4:
				world.setBlock(ry+y, rz, rx + x, 85);
				break;
			case 5:
				world.setBlock(ry-y, rz, rx - x, 85);
				break;
			default:
				break;
			}
	    	
	    	
	    
	    }
	    
	    

}
