package com.fabiogrossi.blockinteractactions.data;

import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.List;

public class BlockCache {

    private final List<ClickableBlock> clickableBlocks = new ArrayList<>();

    public void addClickableBlock(ClickableBlock clickableBlock) {
        clickableBlocks.add(clickableBlock);
    }

    public boolean isAClickableBlock(Block block) {
        for (ClickableBlock clickableBlock : clickableBlocks) {
            if (clickableBlock.getBlock().getLocation().equals(block.getLocation())) {
                return true;
            }
        }
        return false;
    }

    public ClickableBlock getClickableBlock(Block block) {
        if (!isAClickableBlock(block)) {
            return null;
        }
        for (ClickableBlock clickableBlock : clickableBlocks) {
            if (clickableBlock.getBlock().getLocation().equals(block.getLocation())) {
                return clickableBlock;
            }
        }
        return null;
    }

}
