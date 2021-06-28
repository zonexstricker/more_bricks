package zonexstricker.more.bricks;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.block.enums.SlabType;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

import static net.minecraft.block.SlabBlock.TYPE;

public class PavementBlock extends Block implements Waterloggable {
    public static final BooleanProperty WATERLOGGED;
    protected static final VoxelShape BOTTOM_SHAPE;
    protected static final VoxelShape TOP_SHAPE;

    public PavementBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.getDefaultState().with(TYPE, SlabType.BOTTOM)).with(WATERLOGGED, false));
    }

    public boolean hasSidedTransparency(BlockState state) {
        return state.get(TYPE) != SlabType.DOUBLE;
    }

    protected void appendProperties(Builder<Block, BlockState> builder) {
        builder.add(TYPE, WATERLOGGED);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        SlabType slabType = (SlabType)state.get(TYPE);
        return switch (slabType) {
            case DOUBLE -> VoxelShapes.fullCube();
            case TOP -> TOP_SHAPE;
            default -> BOTTOM_SHAPE;
        };
    }




    public FluidState getFluidState(BlockState state) {
        return (Boolean)state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }


    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if ((Boolean)state.get(WATERLOGGED)) {
            world.getFluidTickScheduler().schedule(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return switch (type) {
            case LAND -> false;
            case WATER -> world.getFluidState(pos).isIn(FluidTags.WATER);
            case AIR -> false;
        };
    }

    static {
        WATERLOGGED = Properties.WATERLOGGED;
        BOTTOM_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D);
        TOP_SHAPE = Block.createCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    }
}

