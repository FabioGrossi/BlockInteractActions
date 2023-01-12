package com.fabiogrossi.blockinteractactions;

import co.aikar.commands.PaperCommandManager;
import com.fabiogrossi.blockinteractactions.action.ActionsManager;
import com.fabiogrossi.blockinteractactions.commands.BlockActionCommand;
import com.fabiogrossi.blockinteractactions.data.BlockCache;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class BlockActions extends JavaPlugin {

    @Getter
    private EventManager eventManager;

    @Getter
    private ActionsManager actionsManager;

    @Getter
    private BlockCache blockCache;

    @Override
    public void onEnable() {
        eventManager = new EventManager(this);
        getServer().getPluginManager().registerEvents(eventManager, this);

        actionsManager = new ActionsManager();
        actionsManager.loadActions();

        blockCache = new BlockCache();

        PaperCommandManager paperCommandManager = new PaperCommandManager(this);
        paperCommandManager.registerCommand(new BlockActionCommand(this));

    }
}
