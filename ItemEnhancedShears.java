package com.github.nurseangel.enhancedshears;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemShears;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemEnhancedShears extends ItemShears {

	private int grade;
	private int textureIndex;

	/**
	 * コンストラクタ
	 *
	 * @param grade
	 *            グレード、0から5
	 * @param textureIndex
	 *            テクスチャ番号、0から1
	 * @param maxDamage
	 */
	public ItemEnhancedShears( int grade, int textureIndex, int maxDamage) {
		super();
		this.setMaxDamage(maxDamage);
		this.setTextureName(Reference.TEXTURE_PATH);

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
	public void registerIcons(IIconRegister par1IconRegister) {

		this.itemIcon = par1IconRegister.registerIcon(Reference.TEXTURE_PATH + textureIndex + grade);
	}

}
