class Hamming {

    def distance(strand1, strand2) {

        if (strand1.length() != strand2.length()) {
            throw new ArithmeticException('Strings must be of an equal length')
        }

        def transposedStrands = [ strand1.toList(), strand2.toList() ].transpose()

        def comparisonResult = transposedStrands.collect{ it.unique().size() - 1 }

        comparisonResult ? comparisonResult.sum() : 0
    }

}
