module H51 (H51.length, H51.reverse)
  where
  length :: [a] -> Int
  length a = foldl (\x _ -> x+ 1) 0 a

  reverse :: [a] -> [a]
  reverse a = foldl (\x y -> y:x) [] a
