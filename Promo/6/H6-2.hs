{-
  "Programmierung und Modellierung", LMU München, Sommersemester 2015, Lehrstuhl TCS

  Vorlage Aufgabe H6-2

  Bitte nichts verändern was oberhalb von "NUR AB HIER BEARBEITEN"
  steht! Also nur ab Zeile 123 editieren!

  Zuerst zeigen wir als Beispiel die Lösung zu der analogen Aufgabe
  mit unseren selbst-definierten Listentyp.
-}


data List a = Leer | Element a (List a)

instance (Show a) => Show (List a) where
  show = printList

printList :: (Show a) => List a -> String
printList l = printLaux 0 l
  where
    printLaux n Leer = replicate n ' ' ++ "[]"
    printLaux n (Element h t)
      = replicate n ' ' ++ show h ++ ":"
        ++ newline ++ printLaux (n+1) t

{- HINWEIS zu "newline" und Ausgabe:

Verwenden Sie "putStrLn", falls GHCI das Zeichen
zum Zeilenvorschub bei der Ausgabe in GHCI nicht ausführt:

*Main> Element 1 $ Element 2 $ Element 3 $ Leer
1:
 2:
  3:
   []

*Main> printList $ Element 1 $ Element 2 $ Element 3 $ Leer
"1:\n 2:\n  3:\n   []"

*Main> putStrLn $ printList $ Element 1 $ Element 2 $ Element 3 $ Leer
1:
 2:
  3:
   []

-}



----------------------------------
-- Eventuell nützliche Konstanten:

newline :: String
newline = "\n"

newline_char :: Char
newline_char = '\n'

slash :: String
slash = "/"

slash_char :: Char
slash_char = '/'

backslash :: String    -- Backslash Char signals Escape;
backslash = "\\"       -- '\\' is interpreted as \

backslash_char :: Char
backslash_char = '\\'

vert :: String
vert = "|"

vert_char :: Char
vert_char = '|'


string_demo :: String
string_demo = 'A':slash_char:'-':vert_char:'-':backslash_char:'-':newline_char:'Z':newline_char:
              "DEMO " ++ backslash ++ "- " ++ vert ++ "- " ++ slash ++ "- " ++ newline ++ " DEMO "

---------------------------------
-- Datentypdeklaration für Bäume:

data Tree a = Empty | Node { label :: a, left,right :: Tree a }

leaf :: a -> Tree a
leaf a = Node a Empty Empty



-----------------------------
-- Ein paar Bäume zum Testen:


t0 = Node 1 (Node 2 (leaf 3) (leaf 4))
            (Node 5 (leaf 6) (leaf 7))

t1 = Node 6 (Node 3 (leaf 2) (Node 8 (leaf 5) Empty))
            (Node 8 Empty (leaf 4))

t2 = Node 1 (Node 2 (Node 3 (leaf 3) Empty) Empty) Empty

t3 = Node 1 Empty (Node 2 Empty (Node 3 Empty (leaf 4)))

t4 = Node 1 (Node 2 (Node 3 (leaf 4) Empty) Empty)
            (Node 5 Empty (Node 6 Empty (leaf 7)))

t5 = Node 1 (Node 2 (Node 3 Empty (leaf 4)) Empty)
            (Node 5 Empty (Node 6 (leaf 7) Empty))

t6 = Node 69 (leaf 77) (Node 44 (leaf 64) (leaf 7))

t7 = Node 6 (Node 3 (leaf 2) (Node 4 (leaf 5) Empty))
            (Node 7 Empty (Node 9 (leaf 8) Empty))



-----------------------------------------
---- !!!! NUR AB HIER BEARBEITEN !!! ----
-----------------------------------------

-- TODO: Instanzdeklaration von Tree a für Show?!

printTree :: (Show a) => Tree a -> String
printTree a = printTreeHelper a ""

printTreeHelper :: (Show a) => Tree a -> String -> String
printTreeHelper (Node a Empty Empty) prefix =
  prefix ++ show a ++ newline
printTreeHelper (Node a Empty r) prefix =
  prefix ++ show a ++ newline ++
  prefix ++"  \\" ++ newline ++
  printTreeHelper r (prefix ++ "   ")
printTreeHelper (Node a l Empty) prefix =
 prefix ++ show a ++ newline ++
 prefix ++ "|  " ++ newline ++
 printTreeHelper l (prefix)
printTreeHelper (Node a l r) prefix =
  prefix ++ show a ++ newline ++
  prefix ++"| \\" ++ newline ++
  printTreeHelper r (prefix ++ "|  ") ++
  printTreeHelper l (prefix)
