class RomanNumerals {
    RomanNumerals() {
        Integer.metaClass.getRoman = { ->

            def romanRepresentation = ''
            def arabicValueToRepresent = delegate

            def romanNumerals = [ 1000:"M", 500:"D", 100:"C", 50:"L", 10:"X", 5:"V", 1:"I" ]
            def numeralsBeginingWithFive = ["D", "L", "V"]

            romanNumerals.eachWithIndex {numeralValue, numeralSign, i ->

                def intDivisionResult = arabicValueToRepresent.intdiv(numeralValue)

                def leftSideNumeralIndex = numeralsBeginingWithFive.contains(numeralSign) ? i + 1 : i + 2
                def leftSideNumeralValue = romanNumerals.keySet()[leftSideNumeralIndex]

                if (intDivisionResult > 0 && intDivisionResult <= 3) {

                    romanRepresentation += numeralSign * intDivisionResult
                    arabicValueToRepresent = arabicValueToRepresent % numeralValue
                }

                else if (leftSideNumeralValue && (arabicValueToRepresent + leftSideNumeralValue).intdiv(numeralValue) == 1){

                    romanRepresentation += romanNumerals[leftSideNumeralValue]
                    romanRepresentation += numeralSign

                    arabicValueToRepresent -= numeralValue
                    arabicValueToRepresent += leftSideNumeralValue
                }
            }

            return romanRepresentation
        }
    }
}
