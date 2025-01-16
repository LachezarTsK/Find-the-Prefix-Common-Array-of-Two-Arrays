
package main

func findThePrefixCommonArray(firstInput []int, secondInput []int) []int {
    numberOfElements := len(firstInput)
    prefixCommonArray := make([]int, numberOfElements)

    var bitStampOccurenceOfElementsInFirstInput int64 = 0
    var bitStampOccurenceOfElementsInSecondInput int64 = 0

    for i := range numberOfElements {
        bitStampOccurenceOfElementsInFirstInput ^= int64(1) << firstInput[i]
        bitStampOccurenceOfElementsInSecondInput ^= int64(1) << secondInput[i]

        var overlaps int64 = bitStampOccurenceOfElementsInFirstInput & bitStampOccurenceOfElementsInSecondInput
        prefixCommonArray[i] = countNumberOfBitsSetToOne(overlaps)
    }
    return prefixCommonArray
}

func countNumberOfBitsSetToOne(value int64) int {
    var numberOfBitsSetToOne int64 = 0
    for value > 0 {
        numberOfBitsSetToOne += value & 1
        value >>= 1
    }
    return int(numberOfBitsSetToOne)
}
