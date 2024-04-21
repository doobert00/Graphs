# Graphs
Playing around with shortest path algorithms on weighted directed graphs.

## Notes
- Currently, `Dijkstra` and `Bellman-Ford` algorithms work, but `Floyd-Warshall` does not.
- We have tests for our algorithms but should build out more.
- Need to decide what to do with our GraphFactory bc the Factory Pattern is cool but not getting love atm.
- Similarly for PathSolver singleton, can probably be deprecated.
- Other in TestSuite for posterity.
- Delete the main function.

## Testing
If there is something you would like to run from main you can use:
```
gradle run
```
More tests are coming, don't you worry. As they develop, they can be run with:
```
gradle test
```
