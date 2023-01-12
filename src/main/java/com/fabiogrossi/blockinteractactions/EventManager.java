package com.fabiogrossi.blockinteractactions;

import com.fabiogrossi.blockinteractactions.data.ClickableBlock;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class EventManager implements Listener {

    private final BlockActions blockActions;

    public EventManager(BlockActions blockActions) {
        this.blockActions = blockActions;
    }

    @EventHandler
    public void onPlayerInteractWithBlock(PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        Block block = event.getClickedBlock();
        Player player = event.getPlayer();

        ClickableBlock clickableBlock = blockActions.getBlockCache().getClickableBlock(block);

        if (clickableBlock == null) {
            return;
        }

        clickableBlock.getAction().run(player);

    }

}
