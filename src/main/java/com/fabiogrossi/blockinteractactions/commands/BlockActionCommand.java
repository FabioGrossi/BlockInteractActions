package com.fabiogrossi.blockinteractactions.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import com.fabiogrossi.blockinteractactions.BlockActions;
import com.fabiogrossi.blockinteractactions.action.Action;
import com.fabiogrossi.blockinteractactions.data.ClickableBlock;
import com.fabiogrossi.blockinteractactions.utils.StringUtils;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

@CommandAlias("ba")
@CommandPermission("blockaction.admin")
public class BlockActionCommand extends BaseCommand {

    private final BlockActions blockActions;

    public BlockActionCommand(BlockActions blockActions) {
        this.blockActions = blockActions;
    }

    @Subcommand("create")
    @Syntax("<name> <action_type> <action_data> - Create a clickable block")
    @CommandCompletion("")
    public void onCreateBlockAction(Player player, String name, String actionType, String[] actionData) {
        Block block = player.getTargetBlockExact(20);
        Action action = blockActions.getActionsManager().instantiateAction(blockActions.getActionsManager().getAction(actionType), StringUtils.createPhrase(actionData));
        ClickableBlock clickableBlock = new ClickableBlock(name, block, action);
        blockActions.getBlockCache().addClickableBlock(clickableBlock);
    }

}
