package com.fabiogrossi.blockinteractactions.action.actions;

import com.fabiogrossi.blockinteractactions.action.Action;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class PlayerMessageAction extends Action {

    public PlayerMessageAction(String actionData) {
        super(actionData);
    }

    @Override
    public void run(Player clicker) {
        clicker.sendMessage(ChatColor.translateAlternateColorCodes('&', getActionData()));
    }


}
