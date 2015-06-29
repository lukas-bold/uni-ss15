data Vergleich = Schlechter | Gleich | Besser deriving Show
data Spiel = Brettspiel String Int | Bausatz Int deriving Show

vergleiche :: Spiel -> Spiel -> Vergleich
vergleiche a b
	| gameScore a >  gameScore b = Besser
	| gameScore a == gameScore b = Gleich
	| gameScore a <  gameScore b = Schlechter


gameScore :: Spiel -> Int
gameScore (Brettspiel _ a) = a
gameScore (Bausatz a) = a `div` 50