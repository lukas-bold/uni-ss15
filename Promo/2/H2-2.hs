
type Position = Int
type Move = (Position,Position)
type Towers = ([Int],[Int],[Int])

hanoi :: Int -> Position -> Position -> [Move]
hanoi 1 i j = [(i,j)]
hanoi n i j = hanoi n' i otherT ++ [(i,j)] ++ hanoi n' otherT j
	where 
		n' = n-1
		otherT = 1+2+3-i-j

move ::([Move],Towers) -> ([Move],Towers)
move ((from,to):ms, t) =
	if verifyMove t (from, to)
		then (ms, dest)
		else error "Unbekannter Fehler"
	where
		token = head (getTowerByID t from)
		removedE = popTower(t, from)
		dest = addToTower (removedE, to, token)

verifyMove :: Towers -> Move -> Bool
verifyMove t (a,b)
	| not (elem a range && elem b  range)				= error "ungueltige Turm-Position"
	| null (getTowerByID t a)							= error "Keine Scheibe zum Verschieben vorhanden"
	| a == b 											= True
	| null (getTowerByID t b)							= True
	| head (getTowerByID t a) < head (getTowerByID t b)	= True
	| otherwise 										= error "Scheibe zu gross"
	where
		range = [1,2,3]

popTower :: (Towers, Position) -> Towers
popTower ((a, b, c), 1) = (tail a, b, c)
popTower ((a, b, c), 2) = (a,tail b, c)
popTower ((a, b, c), 3) = (a, b,tail c)

addToTower :: (Towers, Position, Int) -> Towers
addToTower ((a, b, c), 1, x) = (x:a, b, c)
addToTower ((a, b, c), 2, x) = (a, x:b, c)
addToTower ((a, b, c), 3, x) = (a, b, x:c)

getTowerByID :: Towers -> Position -> [Int]
getTowerByID (x, _, _) 1 = x
getTowerByID (_, x, _) 2 = x
getTowerByID (_, _, x) 3 = x

game :: ([Move], Towers) -> Towers
game ([], t) = t
game (m, t) = game ( move (m,t) )