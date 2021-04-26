# Task 4 - find the path with recursion

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



<div class="hint">TODO</div>