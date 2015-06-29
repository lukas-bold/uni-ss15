
data Brotzeit = Leberkas | Weisswurscht Int | Breze Brotzeit
	deriving (Show, Eq)

class Messbar a where
	messen :: a -> Double

instance Messbar Brotzeit where
	messen (Leberkas) = 1.0
	messen (Breze b) = 1 + messen b
	messen (Weisswurscht i) = realToFrac i / 2.0

instance Ord Brotzeit where
	compare a b = messen a `compare` messen b
