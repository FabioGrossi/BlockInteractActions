package com.fabiogrossi.blockinteractactions.action;

import lombok.NonNull;
import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class ActionsManager {

    private final Map<String, Class<? extends Action>> actions = new HashMap<>();

    public void addAction(Class<? extends Action> action) {
        actions.put(action.getSimpleName().toUpperCase(Locale.ROOT), action);
    }

    public Class<? extends Action> getAction(String name) {
        return actions.get(name.toUpperCase(Locale.ROOT));
    }

    public void loadActions() {
        Reflections reflections = new Reflections(getClass().getPackage().getName() + ".actions");
        Set<Class<? extends Action>> actionClasses = reflections.getSubTypesOf(Action.class);
        for (Class<? extends Action> actionClass : actionClasses) {
            if (actionClass.isInterface() || Modifier.isAbstract(actionClass.getModifiers())) {
                continue;
            }
            addAction(actionClass);
        }
    }

    @SneakyThrows
    @SuppressWarnings("deprecation")
    public Action instantiateAction(@NonNull final Class<? extends Action> clazz, String actionData) {
        Constructor<? extends Action> constructor = clazz.getDeclaredConstructor(String.class);
        boolean accessible = constructor.isAccessible();
        Action action = constructor.newInstance(actionData);
        constructor.setAccessible(accessible);
        return action;
    }

}
