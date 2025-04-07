package com.mjc.stage2.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComponent extends AbstractTextComponent {

    protected List<AbstractTextComponent> componentList = new ArrayList<>();

    public TextComponent(TextComponentType componentType) {
        super(componentType);
    }

    @Override
    public String operation() {
        StringBuilder builder = new StringBuilder();
        String delimiter = getComponentType().getDelimiter();
        for (AbstractTextComponent component : componentList) {
            builder.append(component.operation()).append(delimiter);
        }
        if (builder.length() >= delimiter.length() && !delimiter.isEmpty()) {
            builder.setLength(builder.length() - delimiter.length());
        }
        return builder.toString();
    }

    @Override
    public void add(AbstractTextComponent textComponent) {
        componentList.add(textComponent);
    }

    @Override
    public void remove(AbstractTextComponent textComponent) {
        componentList.remove(textComponent);
    }

    @Override
    public int getSize() {
        return componentList.size();
    }
}
