module Bar(foo1, foo2) where
  foo1 f p xs = [f x | x <- xs, x >= 0, p x]

  foo2 :: (a -> a) -> (a -> Bool) -> [a] -> [a]
  foo2 f p = map f . filter p . filter (>=0)
