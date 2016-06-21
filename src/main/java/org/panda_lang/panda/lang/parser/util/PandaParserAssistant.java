package org.panda_lang.panda.lang.parser.util;

import org.panda_lang.panda.core.parser.redact.divider.Divider;
import org.panda_lang.panda.core.parser.redact.divider.DividerRules;
import org.panda_lang.panda.core.parser.redact.formatter.Formatter;
import org.panda_lang.panda.core.parser.redact.formatter.FormatterRules;
import org.panda_lang.panda.lang.syntax.PandaLiteral;
import org.panda_lang.panda.lang.syntax.PandaSeparator;

public class PandaParserAssistant {

    public static Divider getDefaultDivider(String source) {
        DividerRules dividerRules = new DividerRules();
        for (PandaSeparator pandaSeparator : PandaSeparator.values()) {
            dividerRules.addLineSeparator(pandaSeparator.getSeparator());
        }
        for (PandaLiteral pandaLiteral : PandaLiteral.values()) {
            dividerRules.addLiteral(pandaLiteral.getLiteral());
        }

        return new Divider(source, dividerRules);
    }

    public static Formatter getDefaultFormatter() {
        FormatterRules formatterRules = new FormatterRules();
        formatterRules.enableWhitespaceControl();
        formatterRules.enableTrim();

        for (PandaLiteral pandaLiteral : PandaLiteral.values()) {
            formatterRules.addLiteral(pandaLiteral.getLiteral());
        }

        return new Formatter(formatterRules);
    }

}
