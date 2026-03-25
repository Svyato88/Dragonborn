package cws.dragonborn.block;

import cws.dragonborn.Dragonborn;
import cws.dragonborn.block.custom.*;
import cws.dragonborn.block.custom.exclusive.*;
import cws.dragonborn.block.entity.Target;
import cws.dragonborn.block.custom.ModLogs;
import cws.dragonborn.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Dragonborn.MOD_ID);






    public static final RegistryObject<Block> COBBLESTONE_WALL = registryBlock("cobblestone_wall",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> COBBLESTONE_WALL_SLAB = registryBlock("cobblestone_wall_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> COBBLESTONE_WALL_STAIRS = registryBlock("cobblestone_wall_stairs",
            () -> new StairBlock(() -> ModBlocks.COBBLESTONE_WALL.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> COBBLESTONE_WALL_WALL = registryBlock("cobblestone_wall_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> MOSSY_COBBLESTONE_WALL = registryBlock("mossy_cobblestone_wall",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> MOSSY_COBBLESTONE_WALL_SLAB = registryBlock("mossy_cobblestone_wall_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> MOSSY_COBBLESTONE_WALL_STAIRS = registryBlock("mossy_cobblestone_wall_stairs",
            () -> new StairBlock(() -> ModBlocks.COBBLESTONE_WALL.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> MOSSY_COBBLESTONE_WALL_WALL = registryBlock("mossy_cobblestone_wall_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> PAVEMENT = registryBlock("pavement",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COARSE_DIRT)));

    public static final RegistryObject<Block> PAVEMENT_SLAB = registryBlock("pavement_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COARSE_DIRT)));

    public static final RegistryObject<Block> PAVEMENT_BORDER = registryBlock("pavement_border",
            () -> new Pavement_border(BlockBehaviour.Properties.copy(Blocks.COARSE_DIRT)));

    public static final RegistryObject<Block> PAVEMENT_SLAB_BORDER = registryBlock("pavement_slab_border",
            () -> new Pavement_border(BlockBehaviour.Properties.copy(Blocks.COARSE_DIRT)));



    public static final RegistryObject<Block> GRAY_DIRT = registryBlock("gray_dirt",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COARSE_DIRT)));

    public static final RegistryObject<Block> GRAY_DIRT_LITTLE_ROCKS = registryBlock("gray_dirt_little_rocks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COARSE_DIRT)));

    public static final RegistryObject<Block> WHITE_DIRT = registryBlock("white_dirt",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COARSE_DIRT)));

    public static final RegistryObject<Block> DARK_DIRT = registryBlock("dark_dirt",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COARSE_DIRT)));

    public static final RegistryObject<Block> PODZOL = registryBlock("podzol",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.PODZOL)));

    public static final RegistryObject<Block> PODZOL_LUSH = registryBlock("podzol_lush",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.PODZOL)));

    public static final RegistryObject<Block> GRASS_BLOCK = registryBlock("grass_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK)));

    public static final RegistryObject<Block> GRASS_BLOCK_FULL = registryBlock("grass_block_full",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK)));

    public static final RegistryObject<Block> GRASS_BLOCK_FULL_FLOWERS = registryBlock("grass_block_full_flowers",
            () -> new ModGrassBlockWithVariants(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK)));

    public static final RegistryObject<Block> GRAY_DIRT_ROAD = registryBlock("gray_dirt_road",
            () -> new ModFacing(BlockBehaviour.Properties.copy(Blocks.COARSE_DIRT)));

    public static final RegistryObject<Block> GRAY_DIRT_ROCKS = registryBlock("gray_dirt_rocks",
            () -> new ModFacing(BlockBehaviour.Properties.copy(Blocks.COARSE_DIRT)));

    public static final RegistryObject<Block> STONE = registryBlock("stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> STONE_SLAB = registryBlock("stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> STONE_STAIRS = registryBlock("stone_stairs",
            () -> new StairBlock(() -> ModBlocks.STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> LITTLE_ROCKS = registryBlock("little_rocks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_PRESSURE_PLATE).noOcclusion()));



    public static final RegistryObject<Block> MOSSY_STONE = registryBlock("mossy_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> MOSSY_STONE_SLAB = registryBlock("mossy_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> MOSSY_STONE_STAIRS = registryBlock("mossy_stone_stairs",
            () -> new StairBlock(() -> ModBlocks.STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    
    public static final RegistryObject<Block> MOSS_YELLOW = registryBlock("moss_yellow",
            () -> new ModLichen(BlockBehaviour.Properties.copy(Blocks.MOSS_CARPET).noOcclusion()));


    public static final RegistryObject<Block> GRASS_BUSH_GRAY = registryBlock("grass_bush_gray",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRASS).noOcclusion()));

    public static final RegistryObject<Block> GRASS_BUSH_ORANGE = registryBlock("grass_bush_orange",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRASS).noOcclusion()));

    public static final RegistryObject<Block> GRASS_BUSH_ORANGE_TALL = registryBlock("grass_bush_orange_tall",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS).noOcclusion()));

    public static final RegistryObject<Block> GRASS_BUSH_YELLOW = registryBlock("grass_bush_yellow",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRASS).noOcclusion()));

    public static final RegistryObject<Block> GRASS_FOREST = registryBlock("grass_forest",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRASS).noOcclusion()));

    public static final RegistryObject<Block> GRASS_FOREST_FLOWERS = registryBlock("grass_forest_flowers",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRASS).noOcclusion()));

    public static final RegistryObject<Block> GRASS_DRY = registryBlock("grass_dry",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRASS).noOcclusion()));

    public static final RegistryObject<Block> SNOWY_GRASS_DRY = registryBlock("snowy_grass_dry",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRASS).noOcclusion()));

    public static final RegistryObject<Block> SNOWY_BUSH_DRY = registryBlock("snowy_bush_dry",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRASS).noOcclusion()));

    public static final RegistryObject<Block> BUSH_DRY = registryBlock("bush_dry",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRASS).noOcclusion()));

    public static final RegistryObject<Block> ASARUM = registryBlock("asarum",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEAD_BUSH).noOcclusion()));

    public static final RegistryObject<Block> ASARUM_DRY = registryBlock("asarum_dry",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEAD_BUSH).noOcclusion()));

    public static final RegistryObject<Block> FALLEN_SPRUCE_BRANCH = registryBlock("fallen_spruce_branch",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEAD_BUSH).noOcclusion()));

    public static final RegistryObject<Block> FERN = registryBlock("fern",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRASS).noOcclusion()));

    public static final RegistryObject<Block> FERN_BUSH = registryBlock("fern_bush",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRASS).noOcclusion()));

    public static final RegistryObject<Block> FERN_BUSH_DRY = registryBlock("fern_bush_dry",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRASS).noOcclusion()));

    public static final RegistryObject<Block> PRICKLY_PLANT = registryBlock("prickly_plant",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRASS).noOcclusion()));

    public static final RegistryObject<Block> TREE_BUSH = registryBlock("tree_bush",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRASS).noOcclusion()));


    public static final RegistryObject<Block> COTTON = registryBlock("cotton",
            () -> new Cotton(BlockBehaviour.Properties.copy(Blocks.GRASS).noOcclusion()));

    public static final RegistryObject<Block> LAVENDER = registryBlock("lavender",
            () -> new Lavender(BlockBehaviour.Properties.copy(Blocks.GRASS).noOcclusion()));

    public static final RegistryObject<Block> MOUNTAIN_FLOWER = registryBlock("mountain_flower",
            () -> new Mountain_flower(BlockBehaviour.Properties.copy(Blocks.GRASS).noOcclusion()));

    public static final RegistryObject<Block> MOUNTAIN_FLOWER_ORANGE = registryBlock("mountain_flower_orange",
            () -> new Mountain_flower_orange(BlockBehaviour.Properties.copy(Blocks.GRASS).noOcclusion()));

    public static final RegistryObject<Block> THISTLE_BUSH = registryBlock("thistle_bush",
            () -> new Thistle_bush(BlockBehaviour.Properties.copy(Blocks.GRASS).noOcclusion()));

    public static final RegistryObject<Block> SNOWBERRIES_BUSH = registryBlock("snowberries_bush",
            () -> new Snowberries_bush(BlockBehaviour.Properties.copy(Blocks.GRASS).noOcclusion()));




    public static final RegistryObject<Block> BIG_SKULL = registryBlock("big_skull",
            () -> new ModFacing(BlockBehaviour.Properties.copy(Blocks.SKELETON_SKULL).noOcclusion()));

    public static final RegistryObject<Block> BIG_BONES = registryBlock("big_bones",
            () -> new ModFacing(BlockBehaviour.Properties.copy(Blocks.SKELETON_SKULL).noOcclusion()));





    public static final RegistryObject<Block> PLANKS_PLATFORM = registryBlock("planks_platform",
            () -> new ModPlatform(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final RegistryObject<Block> PLANKS_PILLAR = registryBlock("planks_pillar",
            () -> new ModPillar(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final RegistryObject<Block> PLANKS_ROOF = registryBlock("planks_roof",
            () -> new ModRoof(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final RegistryObject<Block> PLANKS_ROOF_BORDER = registryBlock("planks_roof_border",
            () -> new ModRoofBorder(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final RegistryObject<Block> PLANKS_ROOF_TOP_PLANK = registryBlock("planks_roof_top_plank",
            () -> new ModFacing(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final RegistryObject<Block> PLANKS_ROOF_BORDER_TOP = registryBlock("planks_roof_border_top",
            () -> new ModFacing(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final RegistryObject<Block> PLANKS_WALL = registryBlock("planks_wall",
            () -> new ModPlanksWall(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final RegistryObject<Block> PLANKS_WALL_FLAT = registryBlock("planks_wall_flat",
            () -> new ModStrippedLogs(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final RegistryObject<Block> RAW_PLANKS_PLATFORM = registryBlock("raw_planks_platform",
            () -> new RawPlanksPlatform(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final RegistryObject<Block> HAY_ROOF = registryBlock("hay_roof",
            () -> new ModRoof(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));


    public static final RegistryObject<Block> WOODEN_WINDOWS = registryBlock("wooden_windows",
            () -> new Pavement_border(BlockBehaviour.Properties.copy(Blocks.GLASS)));




    public static final RegistryObject<Block> SPRUCE_LOG = registryBlock("spruce_log",
            () -> new ModLogs(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> SPRUCE_LOG_BIG = registryBlock("spruce_log_big",
            () -> new ModLogs(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> SPRUCE_LOG_SMALL = registryBlock("spruce_log_small",
            () -> new ModLogs(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final RegistryObject<Block> SPRUCE_LOG_MINI = registryBlock("spruce_log_mini",
            () -> new ModLogs(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final RegistryObject<Block> STRIPPED_SPRUCE_LOG = registryBlock("stripped_spruce_log",
            () -> new ModStrippedLogs(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> STRIPPED_SPRUCE_LOG_SMALL = registryBlock("stripped_spruce_log_small",
            () -> new ModStrippedLogs(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final RegistryObject<Block> STRIPPED_SPRUCE_LOG_MINI = registryBlock("stripped_spruce_log_mini",
            () -> new ModStrippedLogs(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final RegistryObject<Block> SPRUCE_LEAVES = registryBlock("spruce_leaves",
            () -> new Spruce_Leaves(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).noOcclusion()));

    public static final RegistryObject<Block> SPRUCE_BRANCH = registryBlock("spruce_branch",
            () -> new ModFacing(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).noOcclusion()));

    public static final RegistryObject<Block> SPRUCE_BRANCH_MEDIUM = registryBlock("spruce_branch_medium",
            () -> new ModBranch(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).noOcclusion()));

    public static final RegistryObject<Block> SPRUCE_ROOTS = registryBlock("spruce_roots",
            () -> new ModBigStump(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final RegistryObject<Block> SPRUCE_ROOTS_BIG = registryBlock("spruce_roots_big",
            () -> new ModFacing(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final RegistryObject<Block> SPRUCE_STUMP_TOP = registryBlock("spruce_stump_top",
            () -> new ModFacing(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final RegistryObject<Block> SPRUCE_SAPLING = registryBlock("spruce_sapling",
            () -> new SaplingBlock(new SpruceSapling(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).noOcclusion()));



    public static final RegistryObject<Block> SNOWY_SPRUCE_LOG = registryBlock("snowy_spruce_log",
            () -> new ModLogs(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> SNOWY_SPRUCE_LOG_BIG = registryBlock("snowy_spruce_log_big",
            () -> new ModLogs(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> SNOWY_SPRUCE_LOG_SMALL = registryBlock("snowy_spruce_log_small",
            () -> new ModLogs(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final RegistryObject<Block> SNOWY_SPRUCE_LOG_MINI = registryBlock("snowy_spruce_log_mini",
            () -> new ModLogs(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final RegistryObject<Block> SNOWY_SPRUCE_LEAVES = registryBlock("snowy_spruce_leaves",
            () -> new Spruce_Leaves(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).noOcclusion()));

    public static final RegistryObject<Block> SNOWY_SPRUCE_BRANCH = registryBlock("snowy_spruce_branch",
            () -> new ModFacing(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).noOcclusion()));

    public static final RegistryObject<Block> SNOWY_SPRUCE_BRANCH_MEDIUM = registryBlock("snowy_spruce_branch_medium",
            () -> new ModBranch(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).noOcclusion()));

    public static final RegistryObject<Block> SNOWY_SPRUCE_ROOTS = registryBlock("snowy_spruce_roots",
            () -> new ModFacing(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final RegistryObject<Block> SNOWY_SPRUCE_ROOTS_BIG = registryBlock("snowy_spruce_roots_big",
            () -> new ModBigStump(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final RegistryObject<Block> SNOWY_SPRUCE_STUMP_TOP = registryBlock("snowy_spruce_stump_top",
            () -> new ModFacing(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));



    public static final RegistryObject<Block> DRY_LOG = registryBlock("dry_log",
            () -> new ModLogs(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final RegistryObject<Block> DRY_LOG_SMALL = registryBlock("dry_log_small",
            () -> new ModBlockSmallBranch(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final RegistryObject<Block> DRY_LOG_MINI = registryBlock("dry_log_mini",
            () -> new ModBlockMiniBranch(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final RegistryObject<Block> DRY_BRANCH_BLOCK = registryBlock("dry_branch_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).noOcclusion()));

    public static final RegistryObject<Block> DRY_TREE_BRANCH = registryBlock("dry_tree_branch",
            () -> new ModFacing(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final RegistryObject<Block> DRY_TREE_BRANCH_MEDIUM = registryBlock("dry_tree_branch_medium",
            () -> new ModFacing(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final RegistryObject<Block> DRY_TREE_ROOTS_SMALL = registryBlock("dry_tree_roots_small",
            () -> new ModFacing(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));



    public static final RegistryObject<Block> STONE_BORDER = registryBlock("stone_border",
            () -> new ModBorder(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noOcclusion()));

    public static final RegistryObject<Block> STONE_BORDER_BLOCK = registryBlock("stone_border_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> STONE_BORDER_BLOCK_SLAB = registryBlock("stone_border_block_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> STONE_BORDER_BLOCK_STAIRS = registryBlock("stone_border_block_stairs",
            () -> new StairBlock(() -> ModBlocks.STONE_BORDER_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> STONE_TINY_STAIRS = registryBlock("stone_tiny_stairs",
            () -> new ModBorder(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noOcclusion()));

    public static final RegistryObject<Block> STONE_BEAM = registryBlock("stone_beam",
            () -> new ModStoneBeam(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noOcclusion()));



    public static final RegistryObject<Block> TOWER_WALL = registryBlock("tower_wall",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> WHILE_TOWER_WALL = registryBlock("while_tower_wall",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> TOWER_WALL_SLAB = registryBlock("tower_wall_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> TOWER_WALL_STAIRS = registryBlock("tower_wall_stairs",
            () -> new StairBlock(() -> ModBlocks.TOWER_WALL.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> TOWER_WINDOW = registryBlock("tower_window",
            () -> new ModFacing(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noOcclusion().isViewBlocking((state, world, pos) -> false)));

    public static final RegistryObject<Block> MOSSY_TOWER_WALL = registryBlock("mossy_tower_wall",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> MOSSY_TOWER_WALL_SLAB = registryBlock("mossy_tower_wall_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> MOSSY_TOWER_WALL_STAIRS = registryBlock("mossy_tower_wall_stairs",
            () -> new StairBlock(() -> ModBlocks.MOSSY_TOWER_WALL.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));


    public static final RegistryObject<Block> TOWER_FLOR = registryBlock("tower_flor",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> TOWER_FLOR_SLAB = registryBlock("tower_flor_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> TOWER_FLOR_STAIRS = registryBlock("tower_flor_stairs",
            () -> new StairBlock(() -> ModBlocks.TOWER_FLOR.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));


    public static final RegistryObject<Block> TOWER_FLOOR = registryBlock("tower_floor",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> TOWER_FLOOR_SLAB = registryBlock("tower_floor_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> TOWER_FLOOR_STAIRS = registryBlock("tower_floor_stairs",
            () -> new StairBlock(() -> ModBlocks.TOWER_FLOOR.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));


    public static final RegistryObject<Block> TOWER_PILLAR = registryBlock("tower_pillar",
            () -> new TowerPillar(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noOcclusion()));

    public static final RegistryObject<Block> TOWER_PILLAR_STONE = registryBlock("tower_pillar_stone",
            () -> new TowerPillar(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> TOWER_PILLAR_STONE_SLAB = registryBlock("tower_pillar_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> TOWER_PILLAR_STONE_STAIRS = registryBlock("tower_pillar_stone_stairs",
            () -> new StairBlock(() -> ModBlocks.TOWER_PILLAR.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> TOWER_PILLAR_STONE_BEAM = registryBlock("tower_pillar_stone_beam",
            () -> new ModStoneBeam(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noOcclusion()));



    public static final RegistryObject<Block> NORDIC_STONE_SMOOTH = registryBlock("nordic_stone_smooth",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> NORDIC_STONE_SMOOTH_HORIZONTAL_SLAB = registryBlock("nordic_stone_smooth_horizontal_slab",
            () -> new ModHorizontalSlab(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> NORDIC_STONE_SMOOTH_BORDER = registryBlock("nordic_stone_smooth_border",
            () -> new NordicStoneBorder(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noOcclusion()));

    public static final RegistryObject<Block> NORDIC_STONE_SMOOTH_BORDER_HORIZONTAL_SLAB = registryBlock("nordic_stone_smooth_border_horizontal_slab",
            () -> new NordicStoneBorderHorizontalSlab(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noOcclusion()));

    public static final RegistryObject<Block> NORDIC_STONE_BRICKS = registryBlock("nordic_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> NORDIC_STONE_BRICKS_SLAB = registryBlock("nordic_stone_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> NORDIC_STONE_BRICKS_HORIZONTAL_SLAB = registryBlock("nordic_stone_bricks_horizontal_slab",
            () -> new ModHorizontalSlab(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> NORDIC_STONE_BRICKS_BEAM = registryBlock("nordic_stone_bricks_beam",
            () -> new ModBlockBeam(() -> ModBlocks.NORDIC_STONE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> NORDIC_STONE_BEAM_HORIZONTAL = registryBlock("nordic_stone_beam_horizontal",
            () -> new ModHorizontalSlab(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> NORDIC_STONE_BRICKS_STAIRS = registryBlock("nordic_stone_bricks_stairs",
            () -> new StairBlock(() -> ModBlocks.NORDIC_STONE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));



    public static final RegistryObject<Block> COBBLED_LIMESTONE = registryBlock("cobbled_limestone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> COBBLED_LIMESTONE_SLAB = registryBlock("cobbled_limestone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> COBBLED_LIMESTONE_HORIZONTAL_SLAB = registryBlock("cobbled_limestone_horizontal_slab",
            () -> new ModHorizontalSlab(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> COBBLED_LIMESTONE_BEAM = registryBlock("cobbled_limestone_beam",
            () -> new ModBlockBeam(() -> ModBlocks.COBBLED_LIMESTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> COBBLED_LIMESTONE_STAIRS = registryBlock("cobbled_limestone_stairs",
            () -> new StairBlock(() -> ModBlocks.COBBLED_LIMESTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));



    public static final RegistryObject<Block> SMOOTH_LIMESTONE = registryBlock("smooth_limestone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> SMOOTH_LIMESTONE_SLAB = registryBlock("smooth_limestone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> SMOOTH_LIMESTONE_HORIZONTAL_SLAB = registryBlock("smooth_limestone_horizontal_slab",
            () -> new ModHorizontalSlab(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> SMOOTH_LIMESTONE_BEAM = registryBlock("smooth_limestone_beam",
            () -> new ModBlockBeam(() -> ModBlocks.SMOOTH_LIMESTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> SMOOTH_LIMESTONE_STAIRS = registryBlock("smooth_limestone_stairs",
            () -> new StairBlock(() -> ModBlocks.SMOOTH_LIMESTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));



    public static final RegistryObject<Block> MOSSY_SMOOTH_LIMESTONE = registryBlock("mossy_smooth_limestone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> MOSSY_SMOOTH_LIMESTONE_SLAB = registryBlock("mossy_smooth_limestone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> MOSSY_SMOOTH_LIMESTONE_HORIZONTAL_SLAB = registryBlock("mossy_smooth_limestone_horizontal_slab",
            () -> new ModHorizontalSlab(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> MOSSY_SMOOTH_LIMESTONE_BEAM = registryBlock("mossy_smooth_limestone_beam",
            () -> new ModBlockBeam(() -> ModBlocks.SMOOTH_LIMESTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> MOSSY_SMOOTH_LIMESTONE_STAIRS = registryBlock("mossy_smooth_limestone_stairs",
            () -> new StairBlock(() -> ModBlocks.SMOOTH_LIMESTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));


    public static final RegistryObject<Block> SMOOTH_LIMESTONE_WALL_BEAM = registryBlock("smooth_limestone_wall_beam",
            () -> new LimestoneWallBeam(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noOcclusion()));



    public static final RegistryObject<Block> LIMESTONE_PILLAR_SOLID = registryBlock("limestone_pillar_solid",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));


    public static final RegistryObject<Block> LIMESTONE_PILLAR = registryBlock("limestone_pillar",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> LIMESTONE_PILLAR_SLAB = registryBlock("limestone_pillar_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> LIMESTONE_PILLAR_HORIZONTAL_SLAB = registryBlock("limestone_pillar_horizontal_slab",
            () -> new ModHorizontalSlab(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> LIMESTONE_PILLAR_BEAM = registryBlock("limestone_pillar_beam",
            () -> new ModBlockBeam(() -> ModBlocks.SMOOTH_LIMESTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> LIMESTONE_PILLAR_STAIRS = registryBlock("limestone_pillar_stairs",
            () -> new StairBlock(() -> ModBlocks.SMOOTH_LIMESTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));


    public static final RegistryObject<Block> MOSS_WALL = registryBlock("moss_wall",
            () -> new ModLichen(BlockBehaviour.Properties.copy(Blocks.MOSS_CARPET).noOcclusion()));

    public static final RegistryObject<Block> DRY_ROOTS_FLOOR = registryBlock("dry_roots_floor",
            () -> new ModLichen(BlockBehaviour.Properties.copy(Blocks.MOSS_CARPET).noOcclusion()));


    public static final RegistryObject<Block> NORDIC_DOOR_METAL = registryBlock("nordic_door_metal",
            () -> new Nordic_door_metal(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noOcclusion()));

    public static final RegistryObject<Block> NORDIC_BOOKCASE = registryBlock("nordic_bookcase",
            () -> new NordicBookcase(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noOcclusion()));

    public static final RegistryObject<Block> NORDIC_BRAZIER_BASE = registryBlock("nordic_brazier_base",
            () -> new NordicBrazierBase(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noOcclusion()));



    public static final RegistryObject<Block> STONE_WALL = registryBlock("stone_wall",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> STONE_WALL_STAIRS = registryBlock("stone_wall_stairs",
            () -> new StairBlock(() -> ModBlocks.STONE_WALL.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> STONE_WALL_SLAB = registryBlock("stone_wall_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> STONE_WALL_BRICK = registryBlock("stone_wall_brick",
            () -> new ModFacing(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> STONE_DOOR_BORDER = registryBlock("stone_door_border",
            () -> new StoneDoorBorder(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noOcclusion()));



    public static final RegistryObject<Block> WOODEN_WALL = registryBlock("wooden_wall",
            () -> new ModStrippedLogs(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final RegistryObject<Block> WOODEN_BEAM_HORIZONTAL = registryBlock("wooden_beam_horizontal",
            () -> new WoodenBeamHorizontal(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final RegistryObject<Block> COLD_HAY_ROOF = registryBlock("cold_hay_roof",
            () -> new ModRoof(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));




    public static final RegistryObject<Block> BRAZIER = registryBlock("brazier",
            () -> new Brazier(BlockBehaviour.Properties.copy(Blocks.CHAIN)));

    public static final RegistryObject<Block> BRAZIER_STAND = registryBlock("brazier_stand",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CHAIN)));

    public static final RegistryObject<Block> LATERN1 = registryBlock("latern1",
            () -> new ModFacing(BlockBehaviour.Properties.copy(Blocks.CHAIN).noOcclusion()));

    public static final RegistryObject<Block> TORCH_STAND = registryBlock("torch_stand",
            () -> new ModFacing(BlockBehaviour.Properties.copy(Blocks.CHAIN).noOcclusion()));

    public static final RegistryObject<Block> HORN_LANTERN = registryBlock("horn_lantern",
            () -> new HornLantern(BlockBehaviour.Properties.copy(Blocks.CHAIN).noOcclusion()));

    public static final RegistryObject<Block> HORN_CHANDELIER = registryBlock("horn_chandelier",
            () -> new HornChandelier(BlockBehaviour.Properties.copy(Blocks.CHAIN).noOcclusion()));

    public static final RegistryObject<Block> HORN_CANDLESTICK = registryBlock("horn_candlestick",
            () -> new Horn_candlestick(BlockBehaviour.Properties.copy(Blocks.CHAIN)));



    public static final RegistryObject<Block> HAY_BLOCK = registryBlock("hay_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK).noOcclusion()));


    public static final RegistryObject<Block> TABLE_PLANKS = registryBlock("table_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));


    public static final RegistryObject<Block> CARPET_BROWN = registryBlock("carpet_brown",
            () -> new ModFacing(BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET).noOcclusion()));


    public static final RegistryObject<Block> LEATHER_SLEEPING_BAG = registryBlock("leather_sleeping_bag",
            () -> new ModFacing(BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET).noOcclusion()));


    public static final RegistryObject<Block> WHITERUN_BANNER = registryBlock("whiterun_banner",
            () -> new Whiterun_banner(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).noOcclusion()));

    public static final RegistryObject<Block> SKYRIM_BANNER = registryBlock("skyrim_banner",
            () -> new Skyrim_banner(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).noOcclusion()));


    public static final RegistryObject<Block> TARGET = registryBlock("target",
            () -> new Target(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK).noOcclusion()));


    public static final RegistryObject<Block> CAGE = registryBlock("cage",
            () -> new ModFacing(BlockBehaviour.Properties.copy(Blocks.CHAIN).noOcclusion()));




    public static final RegistryObject<Block> FIRERESISTANT_BRICKS = registryBlock("fireresistant_bricks",
            () -> new FireresistantBricks(BlockBehaviour.Properties.of().randomTicks().noOcclusion()));

    public static final RegistryObject<Block> SMITHING_SMELTER_WALL = registryBlock("smithing_smelter_wall",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS)));

    public static final RegistryObject<Block> SMITHING_SMELTER_HANDCONTROL_OUTLET = registryBlock("smithing_smelter_handcontrol_outlet",
            () -> new SmithingSmelterHandcontrolOutlet(BlockBehaviour.Properties.copy(Blocks.BRICKS).noOcclusion()));

    public static final RegistryObject<Block> SMITHING_SMELTER = registryBlock("smithing_smelter",
            () -> new SmithingSmelter(BlockBehaviour.Properties.copy(Blocks.BRICKS).noOcclusion()));


    public static final RegistryObject<Block> MULTIPART_BLOCK = registryBlock("multipart_block",
            () -> new MultiPartBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS).noOcclusion()));

    private static <T extends Block> RegistryObject<T> registryBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registryBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registryBlockItem(String name,RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
