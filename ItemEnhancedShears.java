package nurseangel.EnhancedShears;

import net.minecraft.item.ItemShears;

public class ItemEnhancedShears extends ItemShears
{
    //コンストラクタ
    public ItemEnhancedShears(int par1, int textureIndex, int maxDamage)
    {
        super(par1);
        this.setMaxDamage(maxDamage);
        setIconIndex(textureIndex);
        setTextureFile(Reference.TEXTURE_FILE);
    }

    // 使用するテクスチャファイル
    @Override
    public String getTextureFile()
    {
        return Reference.TEXTURE_FILE;
    }
}
