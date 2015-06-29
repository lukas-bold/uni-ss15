module Main where

main :: IO ()
main = go []


go ::  String -> IO ()
go buffer = do
  putStrLn "---"
  (name, eigenschaft) <- handleInput
  let eigentschaften = (buffer ++ " " ++ eigenschaft)
  if null name
    then do
      promptUser (name, eigenschaft)
      go eigentschaften
    else do
      promptUser (name, eigentschaften)
      go []


handleInput :: IO (String, String)
handleInput = do
  putStrLn "Hi! Gib bitte zuerst Dein Lieblingstier und dann in die naechste Zeile Deine Lieblingseigenschaft ein:"
  name <- getLine
  eigenschaft <- getLine
  return (name, eigenschaft)

promptUser :: (String, String) -> IO ()
promptUser ([], []) = putStrLn "Spielverderber"
promptUser ([], _)  = putStrLn "Tier eingeben!"
promptUser (name, eigenschaft) = putStrLn $ "Willst du ein " ++ eigenschaft ++ " " ++ name ++ " kaufen?"
