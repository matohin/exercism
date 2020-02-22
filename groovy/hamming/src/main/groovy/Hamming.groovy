class Hamming {

    def distance(strand1, strand2) {
        if (strand1.length() != strand2.length()) {
            throw new ArithmeticException('Strings must be of an equal length')
        }

        def comparisonResult = []

        for (def i = 0; i < strand1.length(); i++){
            comparisonResult.add(strand1[i] == strand2[i])
        }

        return comparisonResult.count(false)

    }

}
