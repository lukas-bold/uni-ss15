module Warteschlange (leer, einstellen, abholen, fanwenden) where

  data Warteschlange a = Warteschlange ([a], [a])
   deriving Show

  leer :: Warteschlange a
  leer = Warteschlange ([], [])

  einstellen :: a -> Warteschlange a -> Warteschlange a
  einstellen a (Warteschlange (c,d)) = Warteschlange (a:c, d)

  abholen :: Warteschlange a -> (Maybe a, Warteschlange a)
  abholen (Warteschlange ([], []) ) = (Nothing, leer)
  abholen (Warteschlange (c, [])  ) = abholen (Warteschlange ([], reverse c))
  abholen (Warteschlange (c, d:ds)) = (Just d, Warteschlange (c, ds))

  fanwenden :: (a -> b) -> Warteschlange a -> Warteschlange b
  fanwenden f (Warteschlange (a,b)) = Warteschlange (map f a, map f b)
