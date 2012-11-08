package edu.unca.jderbysh.MountainLand;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;

public class MountainLandGrassPopulator extends BlockPopulator{
	public void populate(World world, Random random, Chunk chunk) {
		int x,y,z;
		
		Block block;
		
		for(x = 0; x<16; x++) {
			for(z = 0; z<16;z++) {
				if(random.nextInt(100) < 6) {
					for(y = 95; chunk.getBlock(x, y, z).getType()==Material.AIR; y--) {
						//find the correct y val
					}
					block = chunk.getBlock(x, y+1, z);
					block.setType(Material.LONG_GRASS);
					block.setData((byte)1);
				}
				else if(random.nextInt(1000)<20) {
					for(y = 70; chunk.getBlock(x, y, z).getType()!=Material.AIR; y++) {
						//find the correct y val
					}
					//create iron golem.
					if(chunk.getBlock(x,y-1,z).getType()==Material.GRASS){ 
						block = chunk.getBlock(x,y,z);
						block.setType(Material.IRON_BLOCK);
						block = chunk.getBlock(x,y+1,z);
						block.setType(Material.IRON_BLOCK);
						block = chunk.getBlock(x,y+1,z-1);
						block.setType(Material.IRON_BLOCK);
						block = chunk.getBlock(x,y+1,z+1);
						block.setType(Material.IRON_BLOCK);
						block = chunk.getBlock(x,y+2,z);
						block.setType(Material.PUMPKIN);
					}
				}
			}
		}
	}
}
