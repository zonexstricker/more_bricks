package zonexstricker.more.bricks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MoreBricks implements ModInitializer {

    public static final Item CINDER_BRICK = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static final Block CINDER_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).strength(15.0F, 60.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES).requiresTool());
    public static final Block SAND_LIME_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).strength(15.0F, 60.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES).requiresTool());
    public static final Block DARK_GREY_SAND_LIME_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).strength(15.0F, 60.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES).requiresTool());
	public static final Block LIGHT_GREY_SAND_LIME_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).strength(15.0F, 60.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES).requiresTool());
    public static final Block YELLOW_SAND_LIME_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).strength(15.0F, 60.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES).requiresTool());
    public static final Item CINDER_TOFFEE = new Item(new Item.Settings().group(ItemGroup.FOOD).food(BrickFoodComponents.CINDER_TOFFEE));
    public static final Block BRICK_FORMER = new Block(FabricBlockSettings.of(Material.REPAIR_STATION).strength(15.0F, 60.0F).sounds(BlockSoundGroup.DEEPSLATE).breakByTool(FabricToolTags.PICKAXES));

    @Override
    public void onInitialize() {


        Registry.register(Registry.ITEM, new Identifier("morebricks", "cinder_brick"), CINDER_BRICK);
        Registry.register(Registry.BLOCK, new Identifier("morebricks", "cinder_bricks"), CINDER_BRICKS);
        Registry.register(Registry.BLOCK, new Identifier("morebricks", "sand_lime_bricks"), SAND_LIME_BRICKS);
        Registry.register(Registry.BLOCK, new Identifier("morebricks", "yellow_sand_lime_bricks"), YELLOW_SAND_LIME_BRICKS);
        Registry.register(Registry.BLOCK, new Identifier("morebricks", "dark_grey_sand_lime_bricks"), DARK_GREY_SAND_LIME_BRICKS);
		Registry.register(Registry.BLOCK, new Identifier("morebricks", "light_grey_sand_lime_bricks"), LIGHT_GREY_SAND_LIME_BRICKS);
        Registry.register(Registry.ITEM, new Identifier("morebricks", "cinder_bricks"), new BlockItem(CINDER_BRICKS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("morebricks", "light_grey_sand_lime_bricks"), new BlockItem(LIGHT_GREY_SAND_LIME_BRICKS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("morebricks", "dark_grey_sand_lime_bricks"), new BlockItem(DARK_GREY_SAND_LIME_BRICKS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("morebricks", "sand_lime_bricks"), new BlockItem(SAND_LIME_BRICKS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("morebricks", "yellow_sand_lime_bricks"), new BlockItem(YELLOW_SAND_LIME_BRICKS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("morebricks", "cinder_toffee"), CINDER_TOFFEE);
        Registry.register(Registry.BLOCK, new Identifier("morebricks", "brick_former"), BRICK_FORMER);
        Registry.register(Registry.ITEM, new Identifier("morebricks", "brick_former"), new BlockItem(BRICK_FORMER, new Item.Settings().group(ItemGroup.TOOLS)));

    }
}
