class FirstClass {
    private def anyVar = "test"
    private Integer number = 6

    FirstClass(def var, Integer num) {
        anyVar = var
        number = num
    }

    public getVar() {
        return anyVar
    }

    public setVar(def var) {
        anyVar = var
    }

    public Integer getNumber(){
        number
    }

}
