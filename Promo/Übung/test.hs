myAnd :: Bool (Bool -> Bool)
myAnd True True = True
myAnd _     _   = False


myAnd :: Bool -> Bool -> Bool
myAnd x y   | x         = y
            | otherwise = False

myAnd ::  Bool -> Bool -> Bool
myAnd x y = if x then y else False