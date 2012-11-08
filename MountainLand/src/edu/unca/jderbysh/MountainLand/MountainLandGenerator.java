package edu.unca.jderbysh.MountainLand;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.util.noise.SimplexOctaveGenerator;


public class MountainLandGenerator extends ChunkGenerator{
	MountainLand plugin;
	public MountainLandGenerator(MountainLand instance) {
		this.plugin = instance;
	}
	
	public List<BlockPopulator> getDefaultPopulators(World world) {
		ArrayList<BlockPopulator> populators = new ArrayList<BlockPopulator>();
		populators.add(new MountainLandGrassPopulator());
		return populators;
	}
	
	public Location getFixedSpawnLocation(World world, Random random) {
		return new Location(world,0,world.getHighestBlockYAt(0, 0),0);
	}
	
	private int coordsToByte(int x, int y, int z) {
		return (x*16+z) * 128 + y;
	}
	
	public byte[] generate(World world, Random random, int chunkX, int chunkZ) {
		byte[] blocks = new byte[32768];
		int x,y,z;
		
		Random rand = new Random(world.getSeed());
		
		SimplexOctaveGenerator octave = new SimplexOctaveGenerator(rand, 8);
		
		octave.setScale(1.0 / 64.0);
		
		for(x = 0; x<16; x++) {
			for(z = 0; z<16; z++) {
				blocks[coordsToByte(x,0,z)] = (byte) Material.BEDROCK.getId();
				
				double noise = octave.noise(x + chunkX*16, z + chunkZ*16, .01, .5) * 30;
				
				for(y = 1; y<64 + noise; y++) {
					blocks[this.coordsToByte(x,y,z)] = (byte) Material.DIRT.getId();
				}
				blocks[this.coordsToByte(x, y, z)] = (byte) Material.GRASS.getId();
			}
		}
		
		return blocks;
	}
}
