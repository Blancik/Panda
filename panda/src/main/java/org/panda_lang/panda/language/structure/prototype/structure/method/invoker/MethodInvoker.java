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

package org.panda_lang.panda.language.structure.prototype.structure.method.invoker;

import org.panda_lang.panda.implementation.structure.dynamic.Executable;
import org.panda_lang.panda.implementation.structure.value.Value;
import org.panda_lang.panda.language.runtime.ExecutableBridge;
import org.panda_lang.panda.language.structure.expression.Expression;
import org.panda_lang.panda.language.structure.expression.ExpressionUtils;
import org.panda_lang.panda.language.structure.prototype.ClassInstance;
import org.panda_lang.panda.language.structure.prototype.structure.method.Method;

public class MethodInvoker implements Executable {

    private final Method method;
    private final ClassInstance instance;
    private final Expression[] arguments;

    public MethodInvoker(Method method, ClassInstance instance, Expression[] arguments) {
        this.method = method;
        this.instance = instance;
        this.arguments = arguments;
    }

    @Override
    public void execute(ExecutableBridge bridge) {
        Value[] values = ExpressionUtils.getValues(bridge, arguments);
        method.invoke(instance, values);
    }

}
