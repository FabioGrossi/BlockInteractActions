package com.fabiogrossi.blockinteractactions.action;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

public abstract class Action {

    @Getter
    @Setter
    private String actionData;

    protected Action(String actionData) {
        this.actionData = actionData;
    }

    public abstract void run(Player clicker);

}
