package io.github.railroad.ui.localized;

import io.github.railroad.utility.localization.L18n;
import javafx.scene.control.Label;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class LocalizedLabel extends Label {
    private String currentKey;
    private final AtomicReference<String> argString = new AtomicReference<>("");

    public LocalizedLabel(String key, String... args) {
        super();
        Arrays.stream(args).toList().forEach(e -> argString.set(argString + e));

        setKey(key);
        setText(L18n.localize(key) + argString);
    }

    public void setKey(String key) {
        currentKey = key;
        L18n.currentLanguageProperty().addListener((observable, oldValue, newValue) ->
                setText(L18n.localize(key) + argString));
        setText(L18n.localize(currentKey) + argString);
    }

    public void setArgs(String... args) {
        Arrays.stream(args).toList().forEach(e -> argString.set(argString + e));
    }

    public String getKey() {
        return currentKey;
    }
}