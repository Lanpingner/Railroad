package io.github.railroad.PluginManager;

import java.util.EventObject;

public class PluginManagerErrorEvent extends EventObject {
    private Plugin plugin;
    private pluginPhaseResult phaseResult;
    private String message;

    public PluginManagerErrorEvent(Object source, Plugin plugin, String message, pluginPhaseResult phaseResult) {
        super(source);
        this.message = message;
        this.plugin = plugin;
        this.phaseResult = phaseResult;
    }

    public String getMessage() {
        return message;
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public pluginPhaseResult getPhaseResult() {
        return phaseResult;
    }
}
