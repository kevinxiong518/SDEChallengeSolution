# PaytmLabs SDE Challenge

## Coding Question

Write an interface for a data structure that can provide the moving average of the last N elements added, add elements to the structure and get access to the elements. Provide an efficient implementation of the interface for the data structure.

### Minimum Requirements

1. Provide a separate interface (IE `interface`/`trait`) with documentation for the data structure
2. Provide an implementation for the interface
3. Provide any additional explanation about the interface and implementation in a README file.

Implementation:

I decided to use ArrayList as we only need to add elements to the end of the list (no deletion or insertion),
also because we need to access individual elements by their indexes for this implementation which I will explain later. For simplicity I used double as the data type.
The constructor takes in a parameter called subsetSize which is the number of last added elements (N in the question) of which you want to calculate the moving average.
subsetSize must be bigger than 0, if you try to instantiate an object with a negative or zero subsetSize, an exception will be thrown.
In order to calculate the moving average, we need to have at least N number of elements in the data structure (subsetSize >= number of elements).
If you try to calculate the moving average with not enough elements in the data structure, an exception will be thrown.

An average is normally calculated by summing up all the N elements then divide the sum by N, the first moving average will be calculated this way:
(E0 + E1 + E2 + ... + En-1) / N and sum = E0 + E1 + E2 + ... En-1
Whenever we add a new elements to the list, we can just add it to the sum until we have N elements in the list.
Notice that when we have N+1 elements in the list, the new sum will be E1 + E2 + ... + En-1 + En .
The only different elements between these two sums are E0 and En, so we can calculate the new sum by just adding the difference of the two elements to the old sum:
newSum = oldSum + (En - E0)
And we apply the same formula to the new elements when we have more than N elements in the list (subsetSize > number of elements).

MovingAverageService is the interface and MovingAverageService is the implementation of the interface. MovingAverageServiceImpl contains the unit tests for implemented methods.


## Design Question

Design A Google Analytic like Backend System.
We need to provide Google Analytic like services to our customers. Please provide a high level solution design for the backend system. Feel free to choose any open source tools as you want.

### Requirements

1. Handle large write volume: Billions of write events per day.
2. Handle large read/query volume: Millions of merchants wish to gain insight into their business. Read/Query patterns are time-series related metrics.
3. Provide metrics to customers with at most one hour delay.
4. Run with minimum downtime.
5. Have the ability to reprocess historical data in case of bugs in the processing logic.

See design in GoogleAnalyticsLikeService_Design.pdf.
