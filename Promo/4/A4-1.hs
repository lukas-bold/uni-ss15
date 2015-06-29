
data List a = Leer | Element a (List a) deriving Show

class Messbar a where
	messen :: a -> Double

instance Messbar (List a) where
	messen Leer		 = 0
	messen (Element a as) = 1 + messen as

instance Eq a => Eq (List a) where
	(==) Leer Leer = True
	(==) (Element x xs) (Element y ys) = (x==y) && (xs==ys)
	(==) _ _ = False

vergleiche :: (Messbar a, Messbar b) => a -> b -> Ordering
vergleiche x y = messen x `compare` messen y