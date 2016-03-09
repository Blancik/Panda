package org.panda_lang.panda.core.parser.essential;

import org.panda_lang.panda.Panda;
import org.panda_lang.panda.core.parser.Atom;
import org.panda_lang.panda.core.parser.Parser;
import org.panda_lang.panda.core.parser.ParserLayout;
import org.panda_lang.panda.core.parser.essential.util.EssentialPriority;
import org.panda_lang.panda.core.parser.util.match.parser.PatternExtractor;
import org.panda_lang.panda.core.syntax.Continue;

public class ContinueParser implements Parser {

    @Override
    public Continue parse(Atom atom) {
        return new Continue();
    }

    public static void initialize(Panda panda) {
        ContinueParser continueParser = new ContinueParser();
        ParserLayout parserLayout = new ParserLayout(continueParser);
        parserLayout.pattern("continue;", EssentialPriority.CONTINUE.getPriority(), EssentialPriority.CONTINUE.getPriority() * 10, PatternExtractor.FULL);
        panda.getPandaCore().registerParser(parserLayout);
    }

}
