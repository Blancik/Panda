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

package org.panda_lang.panda.language.structure.prototype.structure.method;

import org.panda_lang.panda.core.structure.dynamic.Executable;
import org.panda_lang.panda.core.structure.dynamic.ScopeInstance;
import org.panda_lang.panda.core.structure.wrapper.StatementCell;
import org.panda_lang.panda.core.structure.value.Value;
import org.panda_lang.panda.core.structure.wrapper.Scope;
import org.panda_lang.panda.language.runtime.ExecutableBranch;

public class MethodScopeInstance implements ScopeInstance {

    private final MethodScope methodWrapper;
    private final Value[] variables;

    public MethodScopeInstance(MethodScope methodWrapper) {
        this.methodWrapper = methodWrapper;
        this.variables = new Value[methodWrapper.getVariables().size()];
    }

    @Override
    public void execute(ExecutableBranch branch) {
        for (StatementCell statementCell : methodWrapper.getStatementCells()) {
            if (!statementCell.isExecutable()) {
                continue;
            }

            Executable executable = (Executable) statementCell.getStatement();
            branch.call(executable);
        }
    }

    @Override
    public Value[] getVariables() {
        return variables;
    }

    @Override
    public Scope getScope() {
        return methodWrapper;
    }

}
