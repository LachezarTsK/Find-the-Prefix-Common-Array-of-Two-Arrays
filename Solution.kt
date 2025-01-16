
class Solution {
    
    fun findThePrefixCommonArray(firstInput: IntArray, secondInput: IntArray): IntArray {
        val numberOfElements = firstInput.size
        val prefixCommonArray = IntArray(numberOfElements)

        var bitStampOccurenceOfElementsInFirstInput: Long = 0
        var bitStampOccurenceOfElementsInSecondInput: Long = 0

        for (i in 0..<numberOfElements) {
            bitStampOccurenceOfElementsInFirstInput =
                (bitStampOccurenceOfElementsInFirstInput xor (1L shl firstInput[i]))
            bitStampOccurenceOfElementsInSecondInput =
                (bitStampOccurenceOfElementsInSecondInput xor (1L shl secondInput[i]))

            val overlaps = bitStampOccurenceOfElementsInFirstInput and bitStampOccurenceOfElementsInSecondInput
            prefixCommonArray[i] = countNumberOfBitsSetToOne(overlaps)
        }
        return prefixCommonArray
    }

    private fun countNumberOfBitsSetToOne(value: Long): Int {
        var value = value
        var numberOfBitsSetToOne: Long = 0
        while (value > 0) {
            numberOfBitsSetToOne += value and 1
            value = value shr 1
        }
        return numberOfBitsSetToOne.toInt()
    }
}
