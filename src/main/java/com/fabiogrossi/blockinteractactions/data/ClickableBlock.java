package com.fabiogrossi.blockinteractactions.data;

import com.fabiogrossi.blockinteractactions.action.Action;
import lombok.Getter;
import org.bukkit.block.Block;

public class ClickableBlock {

    @Getter
    private final String name;

    @Getter
    private final Block block;

    @Getter
    private final Action action;

    public ClickableBlock(String name, Block block, Action action) {
        this.name = name;
        this.block = block;
        this.action = action;
    }
}
