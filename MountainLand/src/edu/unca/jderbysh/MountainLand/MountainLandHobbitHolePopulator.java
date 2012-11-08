package edu.unca.jderbysh.MountainLand;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.plugin.PluginDescriptionFile;

public class MountainLandHobbitHolePopulator extends BlockPopulator{
	public void populate(World world, Random random, Chunk chunk) {
		Block block;
		int x,y,z;
		for(x = 2; x<14; x++) {
			for(z = 2; z<14; z++) {
				if(world.getHighestBlockAt(x + chunk.getX()*16,z + chunk.getZ()*16).getY()<35) {
					if(random.nextInt(1000)<2) {
						block = world.getHighestBlockAt(x + chunk.getX()*16, z + chunk.getZ()*16);
						y= block.getY();
						block.setTypeId(Material.TRAP_DOOR.getId());
						block.setData((byte)0x0);
						block = chunk.getBlock(x, y+10, z);
						block.setType(Material.GLOWSTONE);
						block = chunk.getBlock(x, y+11, z);
						block.setType(Material.GLOWSTONE);
						block = chunk.getBlock(x, y+12, z);
						block.setType(Material.GLOWSTONE);
						block = chunk.getBlock(x, y+13, z);
						block.setType(Material.GLOWSTONE);
						block = chunk.getBlock(x, y+14, z);
						block.setType(Material.GLOWSTONE);
						int yLim = y-5;
						for(y=y-1; y>yLim; y--) {
							block = chunk.getBlock(x,y,z);
							block.setType(Material.LADDER);
							block.setData((byte)0x2);
						}
						y=yLim;
						yLim -= 5;
						
						for(int i = 2; i<14; i++) {
							for(int j = 2; j<14; j++) {
								for(y=y; y>yLim; y--) {
									chunk.getBlock(i,y,j).setTypeId(Material.AIR.getId());
									//block.setType(Material.AIR);
								}
								chunk.getBlock(i,y,j).setTypeId(Material.WOOD.getId());
								
								if(i == j) {
									chunk.getBlock(i,y,j).setTypeId(Material.GLOWSTONE.getId());
								}
							}
						}
						
					}
				}
				
				/*if(chunk.getBlock(x, 40,z).getType() == Material.AIR) {
					for(y = 40; chunk.getBlock(x, y, z).getType() == Material.AIR; y--) {
					//finding block.
					}
				}
				else {
					continue;
				}
				if(chunk.getBlock(x, y, z).getType() == Material.DIRT && chunk.getBlock(x,y+1,z).getType() == Material.AIR) {
					
					chunk.getBlock(x,y,z).setType(Material.TRAP_DOOR);
					for(y = y; y> 25; y--) {
						chunk.getBlock(x,y,z).setType(Material.LADDER);
					}
					for(int i = 2; i<14; i++) {
						for(int j = 2; j<14; j++) {
							for(y=25; y>22; y--) {
								chunk.getBlock(i,y,j).setType(Material.AIR);
							}
							chunk.getBlock(i,y,j).setType(Material.WOOD);
						}
					}
					return; // only create one per chunk, if possible.
				}*/
			}
		}
	}
}
