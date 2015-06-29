module Expr where

import Prelude hiding (lex)
import Data.Char
import Data.Maybe

data Expr = Const Integer
          | Plus  Expr Expr
          | Times Expr Expr
  deriving (Eq)

instance Show Expr where
  show (Const i)     = show i
  show (Plus  e1 e2) = "("++ show e1 ++ "+" ++ show e2 ++")"
  show (Times e1 e2) = "("++ show e1 ++ "*" ++ show e2 ++")"

instance Read Expr where
  readsPrec _ s = let (e,t) = parseExpr $ lex s in [(e,concatMap show t)]

-- Beispiel:
a2 = Times (Plus (Const 5) (Const 3)) (Const 2)

eval :: Expr -> Integer
eval (Const     n)  = n
eval (Plus  l r)    = eval l + eval r
eval (Times l r)    = eval l * eval r

data Token
  = CONST Integer
  | LPAREN | RPAREN | PLUS | TIMES

instance Show Token where
  show (CONST i) = show i
  show LPAREN  = "("
  show RPAREN  = ")"
  show PLUS    = "+"
  show TIMES   = "*"


-- Beispiel:
s1 = [CONST 3, TIMES, LPAREN, CONST 8, PLUS, CONST 3, RPAREN, PLUS, CONST 5, TIMES, CONST 4]


-- Lexikalische Analyse
lex :: String -> [Token]
lex "" = []
lex (' ':s) = lex s
lex ('(':s) = LPAREN  : lex s
lex (')':s) = RPAREN  : lex s
lex ('+':s) = PLUS    : lex s
lex ('*':s) = TIMES   : lex s
lex s =
  case lexInt s of
    Just (i, r) -> (CONST i) : (lex r)
    Nothing    -> error $ (show $ head s) ++ "ist kein guetliges Zeichen. "


lexInt :: String -> Maybe (Integer, String)
lexInt s | null num  = Nothing
         | otherwise = Just (read num, rest)
  where
    (num,rest) = span (`elem` '-':['0'..'9']) s

-- Variante
lexInt1 :: String -> Maybe (Integer, String)
lexInt1 = listToMaybe . reads

-- Natürlich könnte man das auch komplett zu Fuss implementieren:
-- lexInt2 ('0':s) = ...
-- lexInt2 ('1':s) = ...
--  ...



-- Syntaxanalyse
parseExpr   :: [Token] -> (Expr,[Token])
parseProd   :: [Token] -> (Expr,[Token])
parseFactor :: [Token] -> (Expr,[Token])

parseExpr l  = let (summand1,rest1) = parseProd l in
    case rest1 of
      PLUS:rest2 -> let (summand2,rest3) = parseExpr rest2
                    in  (Plus summand1 summand2, rest3)
      _other     -> (summand1,rest1)

parseProd l  = let (fac1,rest1) = parseFactor l in
    case rest1 of
      TIMES:rest2 -> let (fac2,rest3) = parseExpr rest2
                    in  (Times fac1 fac2, rest3)
      _other     -> (fac1,rest1)

parseFactor ((CONST a):l) = (Const a, l)
parseFactor ((LPAREN):l) = let (expr, rest) = parseExpr l in
    case head rest of
        RPAREN -> (expr, tail rest)
        otherwise -> error "ungülter Klammerausdruck"

test :: Expr -- query GHCI for "test" to test your solution
test = read "1 * (2 + 3 * 4) + 5 * 6 + 7 + 8 * 9"
