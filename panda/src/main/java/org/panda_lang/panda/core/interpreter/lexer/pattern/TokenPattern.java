/*
 * Copyright (c) 2015-2017 Dzikoysk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.panda_lang.panda.core.interpreter.lexer.pattern;

import org.panda_lang.panda.core.interpreter.lexer.extractor.prepared.PreparedExtractor;
import org.panda_lang.panda.framework.language.interpreter.token.TokenizedSource;
import org.panda_lang.panda.framework.language.interpreter.token.extractor.Extractor;
import org.panda_lang.panda.framework.language.interpreter.token.reader.TokenReader;

import java.util.List;

public class TokenPattern {

    private final TokenPatternUnit[] units;
    private boolean keepingOpposites;

    protected TokenPattern(TokenPatternUnit[] units, boolean keepOpposites) {
        this.units = units;
        this.keepingOpposites = keepOpposites;
    }

    public List<TokenizedSource> match(TokenReader tokenReader) {
        int index = tokenReader.getIndex();
        Extractor extractor = extractor();
        List<TokenizedSource> result = extractor.extract(tokenReader);

        tokenReader.setIndex(index);
        return result;
    }

    public Extractor extractor() {
        return new PreparedExtractor(this);
    }

    public boolean isKeepingOpposites() {
        return keepingOpposites;
    }

    public TokenPatternUnit[] getUnits() {
        return units;
    }

    public static TokenPatternBuilder builder() {
        return new TokenPatternBuilder();
    }

}
