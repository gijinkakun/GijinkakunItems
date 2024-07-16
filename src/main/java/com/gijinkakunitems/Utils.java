package com.gijinkakunitems;

import org.bukkit.Material;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Utils {

    public static final Set<Material> allowedBlocks = new HashSet<>(Arrays.asList(
            Material.STONE, Material.COBBLESTONE, Material.MOSSY_COBBLESTONE, Material.GRANITE,
            Material.DIORITE, Material.ANDESITE, Material.DEEPSLATE, Material.COBBLED_DEEPSLATE,
            Material.TUFF, Material.SANDSTONE, Material.RED_SANDSTONE, Material.PRISMARINE,
            Material.DARK_PRISMARINE, Material.NETHERRACK, Material.BASALT, Material.BLACKSTONE,
            Material.END_STONE));

    public static final Set<Material> allowedShovelBlocks = new HashSet<>(Arrays.asList(
            Material.SAND, Material.DIRT, Material.CLAY, Material.GRAVEL, Material.GRASS_BLOCK, Material.RED_SAND));

    public static final Set<Material> logBlocks = new HashSet<>(Arrays.asList(
            Material.OAK_LOG, Material.SPRUCE_LOG, Material.BIRCH_LOG, Material.JUNGLE_LOG,
            Material.ACACIA_LOG, Material.DARK_OAK_LOG, Material.MANGROVE_LOG, Material.CRIMSON_STEM,
            Material.WARPED_STEM));
}
