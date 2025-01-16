
#include <vector>
using namespace std;

class Solution {

public:
    vector<int> findThePrefixCommonArray(const vector<int>& firstInput, const vector<int>& secondInput) const {
        size_t numberOfElements = firstInput.size();
        vector<int> prefixCommonArray(numberOfElements);

        long long bitStampOccurenceOfElementsInFirstInput = 0;
        long long bitStampOccurenceOfElementsInSecondInput = 0;
       
        for (int i = 0; i < numberOfElements; ++i) {
            bitStampOccurenceOfElementsInFirstInput ^= 1LL << firstInput[i];
            bitStampOccurenceOfElementsInSecondInput ^= 1LL << secondInput[i];

            long long overlaps = bitStampOccurenceOfElementsInFirstInput & bitStampOccurenceOfElementsInSecondInput;
            prefixCommonArray[i] = countNumberOfBitsSetToOne(overlaps);
        }
        return prefixCommonArray;
    }

private:
    int countNumberOfBitsSetToOne(long long value) const {
        int numberOfBitsSetToOne = 0;
        while (value > 0) {
            numberOfBitsSetToOne += value & 1;
            value >>= 1;
        }
        return numberOfBitsSetToOne;
    }
};
