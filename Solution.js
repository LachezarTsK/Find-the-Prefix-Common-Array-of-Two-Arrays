
/**
 * @param {number[]} firstInput
 * @param {number[]} secondInput
 * @return {number[]}
 */
var findThePrefixCommonArray = function (firstInput, secondInput) {
    let totalMatches = 0;
    const numberOfElements = firstInput.length;
    const frequency = new Array(numberOfElements + 1).fill(0);
    const prefixCommonArray = new Array(numberOfElements);

    for (let i = 0; i < numberOfElements; ++i) {
        ++frequency[firstInput[i]];
        ++frequency[secondInput[i]];

        totalMatches += Math.floor(frequency[firstInput[i]] / 2);
        if (firstInput[i] !== secondInput[i]) {
            totalMatches += Math.floor(frequency[secondInput[i]] / 2);
        }

        prefixCommonArray[i] = totalMatches;
    }
    return prefixCommonArray;
};
