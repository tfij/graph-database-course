# Task 3 - find friends of friends with loop

In the previous task, you write a function that returns friends of friends.
Now we will refactor that function and reducing code duplication.

Gremlin provides loops by `repete` step.
`repete` takes nested traverse as an argument, e.g.

```
g().V()
    .repeat(
        both('friendOf')
    )
    .times(2)
    .values('firstName')
```

Write a code that returns all friends names using a loop based on the above example.
Deep of friends searching is configured by the function `n` parameter.

<div class="hint">In the repeat function, you have to import and use `__` an anonymous GraphTraversal.</div>

<div class="hint">Underscore is a special character in kotlin and you have to alias it.</div>
