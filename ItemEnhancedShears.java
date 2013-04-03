package mods.nurseangel.enhancedshears;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemShears;

public class ItemEnhancedShears extends ItemShears {

	private int grade;
	private int textureIndex;

	/**
	 * コンストラクタ
	 *
	 * @param par1
	 *            アイテムID
	 * @param grade
	 *            グレード、0から5
	 * @param textureIndex
	 *            テクスチャ番号、0から1
	 * @param maxDamage
	 */
	public ItemEnhancedShears(int par1, int grade, int textureIndex, int maxDamage) {
		super(par1);
		this.setMaxDamage(maxDamage);

		this.grade = grade;
		this.textureIndex = textureIndex;
	}

	/**
	 * 使用するテクスチャ
	 *
	 * @param IconRegister
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void updateIcons(IconRegister par1IconRegister) {
		/**
		 * ファイル名は "shear"+textureIndex+グレード+".png" <br />
		 * 例として"shear05.png"など
		 */
		String str = Reference.TEXTURE_PATH + "shear" + textureIndex + grade;
		this.iconIndex = par1IconRegister.registerIcon(str);
	}
}
