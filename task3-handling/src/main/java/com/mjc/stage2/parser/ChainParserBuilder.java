package com.mjc.stage2.parser;

import java.util.ArrayList;
import java.util.List;

public class ChainParserBuilder {
    private List<AbstractTextParser> parsers = new ArrayList<>();

    public ChainParserBuilder() {
    }

    @Override
    public String toString() {
        return "ChainParserBuilder{" + "parsers=" + parsers + '}';
    }

    public ChainParserBuilder setParser(AbstractTextParser abstractTextParser) {
        parsers.add(abstractTextParser);
        return this;
    }

    public AbstractTextParser build() {
        if (parsers.isEmpty()) {
            return null;
        }
        for (int i = 0; i < parsers.size() - 1; i++) {
            parsers.get(i).setNextParser(parsers.get(i + 1));
        }
        return parsers.get(0);
    }
}
