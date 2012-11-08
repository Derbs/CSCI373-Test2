package edu.unca.jderbysh.MountainLand;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;

public class MountainLandGolemPopulator extends BlockPopulator{
	public void populate(World world, Random random, Chunk chunk) {
		Block block;
		int x,y,z;
		for(x = 1; x<15; x++) {
			for(z = 1; z<15; z++) {
				if(random.nextInt(1000)<2) {
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
