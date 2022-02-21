package org.metahut.octopus.meta.parser.core.function;

import java.util.Arrays;

/**
 * StringBuilder helper
 */
final class LineStringBuilder implements LineAppender,Appendable {

    private final StringBuilder buffer;

    LineStringBuilder() {this.buffer = new StringBuilder();}

    @Override
    public LineStringBuilder appendLine(String... lines) {
        Arrays.stream(lines).forEach(line -> buffer.append(line));
        return this;
    }

    @Override
    public LineStringBuilder appendLine(String line) {
        buffer.append(line);
        return this;
    }

    @Override
    public LineStringBuilder append(CharSequence csq) {
        buffer.append(csq);
        return this;
    }

    @Override
    public LineStringBuilder append(CharSequence csq, int start, int end) {
        buffer.append(csq,start,end);
        return this;
    }

    @Override
    public LineStringBuilder append(char c) {
        buffer.append(c);
        return this;
    }

    @Override
    public String toString() {
        return buffer.toString();
    }

    public LineStringBuilder union(LineStringBuilder other) {
        buffer.append(other.buffer);
        return this;
    }
}
