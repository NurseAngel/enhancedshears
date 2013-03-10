package nurseangel.EnhancedShears.proxy;

import net.minecraftforge.client.MinecraftForgeClient;
import nurseangel.EnhancedShears.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy
{
    @Override
    public void registerRenderers()
    {
        MinecraftForgeClient.preloadTexture(Reference.TEXTURE_FILE);
    }
}