package com.github.nurseangel.enhancedshears;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Level;

import com.github.nurseangel.enhancedshears.proxy.CommonProxy;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class ModEnhancedShears {
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	public static boolean isTest;
	public static int textureOffset;

	public static Item itemEnhancedShears1;
	public static Item itemEnhancedShears2;
	public static Item itemEnhancedShears3;
	public static Item itemEnhancedShears4;
	public static Item itemEnhancedShears5;
	public static Item itemEnhancedShearsInfinity;

	/**
	 * コンストラクタ的なもの
	 *
	 * @param event
	 */
	@Mod.EventHandler
	public void myPreInitMethod(FMLPreInitializationEvent event) {
		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());

		int itemIdStart = 5300;

		try {
			cfg.load();
			isTest = cfg.get(Configuration.CATEGORY_GENERAL, "isTest", false, "Always false").getBoolean(false);
			textureOffset = cfg.get(Configuration.CATEGORY_GENERAL, "textureOffset", 0,
					"0:show grade in texture / 1:no grade").getInt();
		} catch (Exception e) {
			FMLLog.log(Level.INFO, " EnhancedShears loadding configuration failure");
		} finally {
			cfg.save();
		}

	}

	/**
	 * load()なもの
	 *
	 * @param event
	 */
	@Mod.EventHandler
	public void myInitMethod(FMLInitializationEvent event) {
		this.addEnhancedShears();
	}

	public void addEnhancedShears() {

		itemEnhancedShears1 = new ItemEnhancedShears(0, textureOffset, 600).setUnlocalizedName("enhancedShears");
		itemEnhancedShears2 = new ItemEnhancedShears(1, textureOffset, 2000).setUnlocalizedName("enhancedShears2");
		itemEnhancedShears3 = new ItemEnhancedShears(2, textureOffset, 6000).setUnlocalizedName("enhancedShears3");
		itemEnhancedShears4 = new ItemEnhancedShears(3, textureOffset, 20000).setUnlocalizedName("enhancedShears4");
		itemEnhancedShears5 = new ItemEnhancedShears(4, textureOffset, 65535).setUnlocalizedName("enhancedShears5");
		itemEnhancedShearsInfinity = new ItemEnhancedShears(5, textureOffset, -1)
				.setUnlocalizedName("enhancedShearsInfinity");

		// 登録しないといけない
		GameRegistry.registerItem(itemEnhancedShears1, "enhancedShears");
		GameRegistry.registerItem(itemEnhancedShears2, "enhancedShears2");
		GameRegistry.registerItem(itemEnhancedShears3, "enhancedShears3");
		GameRegistry.registerItem(itemEnhancedShears4, "enhancedShears4");
		GameRegistry.registerItem(itemEnhancedShears5, "enhancedShears5");
		GameRegistry.registerItem(itemEnhancedShearsInfinity, "enhancedShearsInfinity");

		// レシピ
		GameRegistry.addRecipe(new ItemStack(itemEnhancedShears1, 1), new Object[] { "XX ", "XX ", 'X', Items.shears });
		GameRegistry.addRecipe(new ItemStack(itemEnhancedShears2, 1), new Object[] { "XX ", "XX ", 'X',
				itemEnhancedShears1 });
		GameRegistry.addRecipe(new ItemStack(itemEnhancedShears3, 1), new Object[] { "XX ", "XX ", 'X',
				itemEnhancedShears2 });
		GameRegistry.addRecipe(new ItemStack(itemEnhancedShears4, 1), new Object[] { "XX ", "XX ", 'X',
				itemEnhancedShears3 });
		GameRegistry.addRecipe(new ItemStack(itemEnhancedShears5, 1), new Object[] { "XX ", "XX ", 'X',
				itemEnhancedShears4 });
		GameRegistry.addRecipe(new ItemStack(itemEnhancedShearsInfinity, 1), new Object[] { "XX ", "XX ", 'X',
				itemEnhancedShears5 });

		if (isTest) {
			GameRegistry.addRecipe(new ItemStack(Items.shears, 1), new Object[] { "X", 'X', itemEnhancedShears1 });
			GameRegistry.addRecipe(new ItemStack(itemEnhancedShears1, 1), new Object[] { "X", 'X', Blocks.dirt });
			GameRegistry.addRecipe(new ItemStack(itemEnhancedShears2, 1), new Object[] { "XX", 'X', Blocks.dirt });
			GameRegistry.addRecipe(new ItemStack(itemEnhancedShears3, 1), new Object[] { "XXX", 'X', Blocks.dirt });
			GameRegistry.addRecipe(new ItemStack(itemEnhancedShears4, 1), new Object[] { "X", 'X', Blocks.leaves });
			GameRegistry.addRecipe(new ItemStack(itemEnhancedShears5, 1), new Object[] { "XX", 'X', Blocks.leaves });
			GameRegistry.addRecipe(new ItemStack(itemEnhancedShearsInfinity, 1), new Object[] { "XXX", 'X',
					Blocks.leaves });
		}
	}
}