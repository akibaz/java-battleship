# java-battleship

CLI Battleship game based on modified Head First Java book example.


## Game description

This is the screen that you will see when you start the game:

```
Welcome to Battleships!

The goal is to sink all three battleships.
The fewer guesess, the better.
The ships are named: 
                1) cabista
                2) hacqui
                3) poniez


What is your guess:
```

Three battleships will be **randomly** placed on seven times seven greed. Battleships are three cells long. The columns are marked as **numbers** from 1 to 7 and rows as **letters** from a to g.

 |   | 1 | 2 | 3 | 4 | 5 | 6 | 7 |
 |---|---|---|---|---|---|---|---| 
 | a | - | - | X | - | - | - | - |
 | b | - | - | X | - | - | - | - |
 | c | - | - | X | - | - | - | - |
 | d | - | - | - | - | - | - | - |
 | e | - | - | X | X | X | - | X |
 | f | - | - | - | - | - | - | X |
 | g | - | - | - | - | - | - | X |

Example from above:
  * battleship one is a3, b3, c3
  * battleship two is e3, e4, e5
  * battleship three is e7, f7, g7
  
Battleship cells are consecutive, and can't overflow to another row or column.

Than you enter your guess, which is a letter from a to g plus number from 1 to 7. For example b6:
```
What is your guess: b6
```
If your guess is right and you have correct cell value, the ouptut will be
```
hit
```
if you guessed right all three battleship cells the output will be
```
You destroyed cabista.
```
if you missed, the output will be 
```
miss
```

When you guessed all battleships cells (destroyed battleships), the output will be 
```
You destroyed all battleships!
It took you 9 guesses.

Excellent sailor!
```

## How to play

1. Download files

2. Compile BattleshipGame.java
```
javac BattleshipGame.java
```
3. Start game
```
java BattleshipGame
```
4. Play and have fun
