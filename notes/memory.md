## Variables System

```javascript
main {                                  // Wrapper: main, Variables: 3 -> WrapperInstance/WI (main, 3) -> execute(Bridge)
    var1 = "a"                          // WI.variables[0] = "a"
    var2 = "b"                          // WI.variables[1] = "b"
    var3 = new Class(var1)              // Class.prototype.constructor::call(WrapperInstance.variables[0] -> WrapperInstance.variables[2] = instance

    var3.call(var2)                     // WI.variables[2] -> call(WI.variables[1])
}

Class {                                 // ClassReference: ClassPrototype 'Class' -> ClassInstance/CI (~ WrapperInstance), Variables: 1

    var                                 // Field 'var' -> CI.variables <=> WI.variables

    constructor(var1) {                 // Constructor, ConstructorInstance/CI (~ WrapperInstance), parameter[0] = var1, variables: 1
        var = var1                      // instance.variables[0] = CI.variables[0]
    }

    call(var2) {                        // Method, MethodInstance/MI (~ WrapperInstance), parameter[0] = var2, variables: 1
        print var + var2                // print instance.variables[0] + MI.variables[0]
    }

}
```