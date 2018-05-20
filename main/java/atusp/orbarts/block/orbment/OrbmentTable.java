package atusp.orbarts.block.orbment;

import atusp.orbarts.OrbArtsMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class OrbmentTable extends Block{
	public OrbmentTable() {
		super(Material.rock);
		this.setHardness(1.5F);
		this.setCreativeTab(OrbArtsMain.orbartsTab);
		this.setHarvestLevel("pickaxe", 1);
		this.setLightLevel(0.5F);
		this.setUnlocalizedName("orbmentTable");
	}
	
	//设定方块的碰撞盒，可用于检测实体碰撞，此处纯复制
	 public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state) {
	     return new AxisAlignedBB((double)pos.getX() + this.minX, (double)pos.getY() + this.minY, (double)pos.getZ() + this.minZ, (double)pos.getX() + this.maxX, (double)pos.getY() + this.maxY, (double)pos.getZ() + this.maxZ);
	 }
	 
	 //设定实体碰撞到碰撞盒触发的函数，此处纯复制
	 public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, Entity entityIn) {}
	 
	 //当被右键时
	 public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
		    /**
		     * Opens a GUI with this player, uses FML's IGuiHandler system.
		     * Allows for extension by modders.
		     *
		     * @param mod The mod trying to open a GUI
		     * @param modGuiId GUI ID
		     * @param world Current World
		     * @param x Passed directly to IGuiHandler, data meaningless Typically world X position
		     * @param y Passed directly to IGuiHandler, data meaningless Typically world Y position
		     * @param z Passed directly to IGuiHandler, data meaningless Typically world Z position
		     */
		 playerIn.openGui(OrbArtsMain.INSTANCE, OrbArtsMain.orbmentTableGUIId, worldIn, pos.getX(),pos.getY(),pos.getZ());
	     return super.onBlockActivated(worldIn, pos, state, playerIn, side, hitX, hitY, hitZ);
	 }
}
