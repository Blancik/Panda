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

import org.panda_lang.panda.implementation.structure.dynamic.ScopeInstance;
import org.panda_lang.panda.implementation.structure.util.AbstractScope;
import org.panda_lang.panda.language.structure.prototype.structure.parameter.Parameter;

import java.util.List;

public class MethodScope extends AbstractScope {

    private final String methodName;
    private final List<Parameter> parameters;

    public MethodScope(String methodName, List<Parameter> parameters) {
        this.methodName = methodName;
        this.parameters = parameters;
    }

    @Override
    public ScopeInstance createInstance() {
        return new MethodScopeInstance(this);
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public String getMethodName() {
        return methodName;
    }

}
