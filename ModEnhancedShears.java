package nurseangel.EnhancedShears;

import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import nurseangel.EnhancedShears.proxy.CommonProxy;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class ModEnhancedShears
{
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    public static boolean isTest;
    public static int itemEnhancedShears1ID;
    public static int itemEnhancedShears2ID;
    public static int itemEnhancedShears3ID;
    public static int itemEnhancedShears4ID;
    public static int itemEnhancedShears5ID;
    public static int itemEnhancedShearsInfinityID;
    public static int textureOffset;

    // コンストラクタ的なもの
    @Mod.PreInit
    public void myPreInitMethod(FMLPreInitializationEvent event)
    {
        // event.getModMetadata().version = Version.getVersion();
        Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());

        try
        {
            cfg.load();
            itemEnhancedShears1ID = cfg.getItem("itemEnhancedShears1ID", 5300).getInt();
            itemEnhancedShears2ID = cfg.getItem("itemEnhancedShears2ID", 5301).getInt();
            itemEnhancedShears3ID = cfg.getItem("itemEnhancedShears3ID", 5302).getInt();
            itemEnhancedShears4ID = cfg.getItem("itemEnhancedShears4ID", 5303).getInt();
            itemEnhancedShears5ID = cfg.getItem("itemEnhancedShears5ID", 5304).getInt();
            itemEnhancedShearsInfinityID = cfg.getItem("itemEnhancedShearsInfinityID", 5305).getInt();
            isTest = cfg.get(Configuration.CATEGORY_GENERAL, "isTest", false, "Always false").getBoolean(false);
            textureOffset = cfg.get(Configuration.CATEGORY_GENERAL, "textureOffset", 0, "0 or 1").getInt();
        }
        catch (Exception e)
        {
            FMLLog.log(Level.SEVERE, e, " EnhancedShears loadding configuration failure");
        }
        finally
        {
            cfg.save();
        }

        proxy.registerRenderers();
    }

    // load()なもの
    @Mod.Init
    public void myInitMethod(FMLInitializationEvent event)
    {
        this.addEnhancedShears();
    }

    public void addEnhancedShears()
    {
        // はさみ
        Item itemEnhancedShears1 = new ItemEnhancedShears(itemEnhancedShears1ID, textureOffset * 16, 600).setItemName("EnhancedShears");
        Item itemEnhancedShears2 = new ItemEnhancedShears(itemEnhancedShears2ID, textureOffset * 16 + 1, 2000).setItemName("EnhancedShears2");
        Item itemEnhancedShears3 = new ItemEnhancedShears(itemEnhancedShears3ID, textureOffset * 16 + 2, 6000).setItemName("EnhancedShears3");
        Item itemEnhancedShears4 = new ItemEnhancedShears(itemEnhancedShears4ID, textureOffset * 16 + 3, 20000).setItemName("EnhancedShears4");
        Item itemEnhancedShears5 = new ItemEnhancedShears(itemEnhancedShears5ID, textureOffset * 16 + 4, 65535).setItemName("EnhancedShears5");
        Item itemEnhancedShearsInfinity = new ItemEnhancedShears(itemEnhancedShearsInfinityID, textureOffset * 16 + 5, -1).setItemName("EnhancedShearsInfinity");
        LanguageRegistry.addName(itemEnhancedShears1, "Enhanced Shears");
        LanguageRegistry.addName(itemEnhancedShears2, "Enhanced Shears 2");
        LanguageRegistry.addName(itemEnhancedShears3, "Enhanced Shears 3");
        LanguageRegistry.addName(itemEnhancedShears4, "Enhanced Shears 4");
        LanguageRegistry.addName(itemEnhancedShears5, "Enhanced Shears 5");
        LanguageRegistry.addName(itemEnhancedShearsInfinity, "Enhanced Shears Infinity");
        GameRegistry.addRecipe(new ItemStack(itemEnhancedShears1, 1), new Object[] { "XX ", "XX ", 'X', Item.shears });
        GameRegistry.addRecipe(new ItemStack(itemEnhancedShears2, 1), new Object[] { "XX ", "XX ", 'X', itemEnhancedShears1 });
        GameRegistry.addRecipe(new ItemStack(itemEnhancedShears3, 1), new Object[] { "XX ", "XX ", 'X', itemEnhancedShears2 });
        GameRegistry.addRecipe(new ItemStack(itemEnhancedShears4, 1), new Object[] { "XX ", "XX ", 'X', itemEnhancedShears3 });
        GameRegistry.addRecipe(new ItemStack(itemEnhancedShears5, 1), new Object[] { "XX ", "XX ", 'X', itemEnhancedShears4 });
        GameRegistry.addRecipe(new ItemStack(itemEnhancedShearsInfinity, 1), new Object[] { "XX ", "XX ", 'X', itemEnhancedShears5 });

        if (isTest)
        {
            GameRegistry.addRecipe(new ItemStack(Item.shears, 1), new Object[] { "X", 'X', itemEnhancedShears1 });
            GameRegistry.addRecipe(new ItemStack(itemEnhancedShears1, 1), new Object[] { "X", 'X', Block.dirt });
            GameRegistry.addRecipe(new ItemStack(itemEnhancedShears2, 1), new Object[] { "XX", 'X', Block.dirt });
            GameRegistry.addRecipe(new ItemStack(itemEnhancedShears3, 1), new Object[] { "XXX", 'X', Block.dirt });
            GameRegistry.addRecipe(new ItemStack(itemEnhancedShears4, 1), new Object[] { "X", 'X', Block.leaves });
            GameRegistry.addRecipe(new ItemStack(itemEnhancedShears5, 1), new Object[] { "XX", 'X', Block.leaves });
            GameRegistry.addRecipe(new ItemStack(itemEnhancedShearsInfinity, 1), new Object[] { "XXX", 'X', Block.leaves });
        }
    }
}