package com.gijinkakunitems;

import com.gijinkakunitems.items.*;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.RecipeChoice;

public class CustomRecipes {

    public static void registerRecipes(GijinkakunItems plugin) {
        addMythrilbreakerRecipe(plugin);
        addEarthshaperRecipe(plugin);
        addTimbercleaverRecipe(plugin);
        addShroomBladeRecipe(plugin);
        addChickenShooterRecipe(plugin);
        addInfernoBowRecipe(plugin);
        addTidecallerBowRecipe(plugin);
        addArcaneDetonatorRecipe(plugin);
        addStormstrikerRecipe(plugin);
        addStringOfSacrificeRecipe(plugin);
        addTempestScytheRecipe(plugin);
        addVerdantPurifierRecipe(plugin);
        addAmethyriteEdgeRecipe(plugin);
        addBloodrenderRecipe(plugin);
        addLuminaDustRecipe(plugin);
    }

    private static void addLuminaDustRecipe(GijinkakunItems plugin) {
        ItemStack item = LuminaDust.create(plugin);
        NamespacedKey key = new NamespacedKey(plugin, "luminadust");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape(" E ", "DSD", " D ");
        recipe.setIngredient('E', Material.ECHO_SHARD);
        recipe.setIngredient('S', Material.BLAZE_POWDER);
        recipe.setIngredient('D', Material.DIAMOND);
        Bukkit.addRecipe(recipe);
    }

    private static void addMythrilbreakerRecipe(GijinkakunItems plugin) {
        ItemStack item = Mythrilbreaker.create(plugin);
        NamespacedKey key = new NamespacedKey(plugin, "mythrilbreaker");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("DLD", " S ", " S ");
        recipe.setIngredient('L', new RecipeChoice.ExactChoice(LuminaDust.create(plugin)));
        recipe.setIngredient('S', Material.STICK);
        recipe.setIngredient('D', Material.DIAMOND);
        Bukkit.addRecipe(recipe);
    }

    private static void addEarthshaperRecipe(GijinkakunItems plugin) {
        ItemStack item = Earthshaper.create(plugin);
        NamespacedKey key = new NamespacedKey(plugin, "earthshaper");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape(" L ", " D ", " S ");
        recipe.setIngredient('L', new RecipeChoice.ExactChoice(LuminaDust.create(plugin)));
        recipe.setIngredient('S', Material.STICK);
        recipe.setIngredient('D', Material.DIAMOND);
        Bukkit.addRecipe(recipe);
    }

    private static void addTimbercleaverRecipe(GijinkakunItems plugin) {
        ItemStack item = Timbercleaver.create(plugin);
        NamespacedKey key = new NamespacedKey(plugin, "timbercleaver");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("DD ", "LS ", " S ");
        recipe.setIngredient('L', new RecipeChoice.ExactChoice(LuminaDust.create(plugin)));
        recipe.setIngredient('S', Material.STICK);
        recipe.setIngredient('D', Material.DIAMOND);
        Bukkit.addRecipe(recipe);
    }

    private static void addShroomBladeRecipe(GijinkakunItems plugin) {
        ItemStack item = ShroomBlade.create(plugin);
        NamespacedKey key = new NamespacedKey(plugin, "shroomblade");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("ILI", "MSM", " S ");
        recipe.setIngredient('M', Material.MUSHROOM_STEW);
        recipe.setIngredient('L', new RecipeChoice.ExactChoice(LuminaDust.create(plugin)));
        recipe.setIngredient('S', Material.STICK);
        recipe.setIngredient('I', Material.IRON_INGOT);
        Bukkit.addRecipe(recipe);
    }

    private static void addChickenShooterRecipe(GijinkakunItems plugin) {
        ItemStack item = ChickenShooter.create(plugin);
        NamespacedKey key = new NamespacedKey(plugin, "chickenshooter");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("FSE", "FLS", "FSE");
        recipe.setIngredient('L', new RecipeChoice.ExactChoice(LuminaDust.create(plugin)));
        recipe.setIngredient('S', Material.STICK);
        recipe.setIngredient('F', Material.STRING);
        recipe.setIngredient('E', Material.EGG);
        Bukkit.addRecipe(recipe);
    }

    private static void addInfernoBowRecipe(GijinkakunItems plugin) {
        ItemStack item = InfernoBow.create(plugin);
        NamespacedKey key = new NamespacedKey(plugin, "infernobow");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("FSB", "FLS", "FSB");
        recipe.setIngredient('L', new RecipeChoice.ExactChoice(LuminaDust.create(plugin)));
        recipe.setIngredient('S', Material.STICK);
        recipe.setIngredient('F', Material.STRING);
        recipe.setIngredient('B', Material.LAVA_BUCKET);
        Bukkit.addRecipe(recipe);
    }

    private static void addTidecallerBowRecipe(GijinkakunItems plugin) {
        ItemStack item = TidecallerBow.create(plugin);
        NamespacedKey key = new NamespacedKey(plugin, "tidecallerbow");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("FSW", "FLS", "FSW");
        recipe.setIngredient('L', new RecipeChoice.ExactChoice(LuminaDust.create(plugin)));
        recipe.setIngredient('S', Material.STICK);
        recipe.setIngredient('F', Material.STRING);
        recipe.setIngredient('W', Material.WATER_BUCKET);
        Bukkit.addRecipe(recipe);
    }

    private static void addArcaneDetonatorRecipe(GijinkakunItems plugin) {
        ItemStack item = ArcaneDetonator.create(plugin);
        NamespacedKey key = new NamespacedKey(plugin, "arcanedetonator");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("FST", "FLS", "FST");
        recipe.setIngredient('L', new RecipeChoice.ExactChoice(LuminaDust.create(plugin)));
        recipe.setIngredient('S', Material.STICK);
        recipe.setIngredient('F', Material.STRING);
        recipe.setIngredient('T', Material.TNT);
        Bukkit.addRecipe(recipe);
    }

    private static void addStormstrikerRecipe(GijinkakunItems plugin) {
        ItemStack item = Stormstriker.create(plugin);
        NamespacedKey key = new NamespacedKey(plugin, "stormstriker");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("FSR", "FLS", "FSR");
        recipe.setIngredient('L', new RecipeChoice.ExactChoice(LuminaDust.create(plugin)));
        recipe.setIngredient('S', Material.STICK);
        recipe.setIngredient('F', Material.STRING);
        recipe.setIngredient('R', Material.LIGHTNING_ROD);
        Bukkit.addRecipe(recipe);
    }

    private static void addStringOfSacrificeRecipe(GijinkakunItems plugin) {
        ItemStack item = StringOfSacrifice.create(plugin);
        NamespacedKey key = new NamespacedKey(plugin, "stringofsacrifice");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape(" S ", "SLS", " S ");
        recipe.setIngredient('L', new RecipeChoice.ExactChoice(LuminaDust.create(plugin)));
        recipe.setIngredient('S', Material.STRING);
        Bukkit.addRecipe(recipe);
    }

    private static void addTempestScytheRecipe(GijinkakunItems plugin) {
        ItemStack item = TempestScythe.create(plugin);
        NamespacedKey key = new NamespacedKey(plugin, "tempestscythe");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("LD ", " S ", " S ");
        recipe.setIngredient('L', new RecipeChoice.ExactChoice(LuminaDust.create(plugin)));
        recipe.setIngredient('S', Material.STICK);
        recipe.setIngredient('D', Material.DIAMOND);
        Bukkit.addRecipe(recipe);
    }

    private static void addVerdantPurifierRecipe(GijinkakunItems plugin) {
        ItemStack item = VerdantPurifier.create(plugin);
        NamespacedKey key = new NamespacedKey(plugin, "verdantpurifier");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape(" E ", "LSL", " E ");
        recipe.setIngredient('L', new RecipeChoice.ExactChoice(LuminaDust.create(plugin)));
        recipe.setIngredient('E', Material.EMERALD);
        recipe.setIngredient('S', Material.STICK);
        Bukkit.addRecipe(recipe);
    }

    private static void addAmethyriteEdgeRecipe(GijinkakunItems plugin) {
        ItemStack item = AmethyriteEdge.create(plugin);
        NamespacedKey key = new NamespacedKey(plugin, "amethyriteedge");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("ALA", " S ", " S ");
        recipe.setIngredient('A', Material.AMETHYST_SHARD);
        recipe.setIngredient('L', new RecipeChoice.ExactChoice(LuminaDust.create(plugin)));
        recipe.setIngredient('S', Material.STICK);
        Bukkit.addRecipe(recipe);
    }

    private static void addBloodrenderRecipe(GijinkakunItems plugin) {
        ItemStack item = Bloodrender.create(plugin);
        NamespacedKey key = new NamespacedKey(plugin, "bloodrender");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("GL ", "GS ", " S ");
        recipe.setIngredient('L', new RecipeChoice.ExactChoice(LuminaDust.create(plugin)));
        recipe.setIngredient('S', Material.STICK);
        recipe.setIngredient('G', Material.GOLD_INGOT);
        Bukkit.addRecipe(recipe);
    }
}
