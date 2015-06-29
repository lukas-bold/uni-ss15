
seekMaxMin :: [Double] -> (Double, Double)
seekMaxMin null   = (0,0)
seekMaxMin (x:xs) = minMax xs (x, x);

minMax :: [Double] -> (Double, Double) -> (Double, Double)
minMax (x:xs) (min, max)| x < min 	= minMax xs (x, max)
						| x > max 	= minMax xs (min, x)
						| null xs	= (min, max)
						| otherwise = minMax xs (min, max)

