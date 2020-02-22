class RomanNumerals {
    RomanNumerals() {
        Integer.metaClass.getRoman = { ->

            def romanRepresentation = ''

            def arabicValueToRepresent = delegate

            def romanNumerals = [ 1000:"M", 500:"D", 100:"C", 50:"L", 10:"X", 5:"V", 1:"I" ]

            romanNumerals.eachWithIndex{numeralValue, numeralSign, i ->

                def intDivisionResult = arabicValueToRepresent.intdiv(numeralValue)

                println intDivisionResult
                println arabicValueToRepresent % numeralValue
                println '================='

                if (numeralValue - arabicValueToRepresent == 1){
                    romanRepresentation += romanNumerals.values()[i+2]
                    romanRepresentation += numeralSign
                }

                else if (intDivisionResult <= 3){
                    romanRepresentation += numeralSign * intDivisionResult
                    arabicValueToRepresent = arabicValueToRepresent % numeralValue
                }


            }

            return romanRepresentation
        }
    }
}
