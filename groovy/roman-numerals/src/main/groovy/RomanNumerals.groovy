class RomanNumerals {
    RomanNumerals() {
        Integer.metaClass.getRoman = { ->

            def romanRepresentation = ''

            def arabicValueToRepresent = delegate

            def romanNumerals = [ 1000:"M", 500:"D", 100:"C", 50:"L", 10:"X", 5:"V", 1:"I" ]
            def numeralsBeginingWithFive = ["D", "L", "V"]

            romanNumerals.eachWithIndex {numeralValue, numeralSign, i ->

                def intDivisionResult = arabicValueToRepresent.intdiv(numeralValue)

                def leftSideNumeralIndex = numeralsBeginingWithFive.contains(numeralSign) ? (i + 1) : (i + 2)
                def leftSideNumeralValue = romanNumerals.keySet()[leftSideNumeralIndex]

                if ((intDivisionResult <= 3) && (intDivisionResult > 0)) {
                    romanRepresentation += numeralSign * intDivisionResult
                    arabicValueToRepresent = arabicValueToRepresent % numeralValue
                }

                else if (leftSideNumeralValue && ((arabicValueToRepresent + leftSideNumeralValue).intdiv(numeralValue)) == 1){
                    romanRepresentation += romanNumerals.values()[leftSideNumeralIndex]
                    romanRepresentation += numeralSign

                    arabicValueToRepresent -= numeralValue
                    arabicValueToRepresent += romanNumerals.keySet()[leftSideNumeralIndex]
                }
            }
            return romanRepresentation
        }
    }
}
