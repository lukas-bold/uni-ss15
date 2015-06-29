data List a = Leer | Element a (List a)
	deriving Show

verketten :: List a -> List a -> List a
verketten (Leer) (b) = b
verketten (Element a as) (bs) = Element a (verketten as bs)

