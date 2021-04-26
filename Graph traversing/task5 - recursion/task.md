# Task 5 - find the path with recursion

In the previous task use the repeat-times loop.
Gremlin support also while and do-while loops.
With such loops you can build recursive traversals, e.g.

```
g.V()
    .has("firstName", firstName)
    .repeat(
        both('friendOf')
    )
    .until(V().has('firstName', 'Adel'))
```

The above query will search the graph recursively, however, it needs improvement:

1. due to cyclical dependencies, it will never end (until heap error)
2. the outputs are vertices from the last state so the result doesn't contain the path

Add execution steps so that the result includes the path from the first vertex to the last.

<div class="hint">Use path ans simplePath method.</div>

<div class="hint">Use the `by` method in combination with the `path` method just like sorting the results.</div>
