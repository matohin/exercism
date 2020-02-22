class Hamming {

    def distance(strand1, strand2) {

        if (strand1.length() != strand2.length()) {
            throw new ArithmeticException('Strings must be of an equal length')
        }

        def comparisonResult = 0

        strand1.eachWithIndex{
            element, i ->
            comparisonResult += (element == strand2[i]) ? 0 : 1
        }

        return comparisonResult
    }

}
