
myconcat :: [[a]] -> [a]
myconcat [x] = x
myconcat (x:xs) =  x ++ myconcat xs