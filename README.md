## LaserSquad
CLI based game.
##How to run: 
```
Windows users: start_game.bat
Unix users:start_game.sh
Script is going to compile the classes, pack a JAR and run it. Please make sure java is added to the PATH.
```

## Description
```
LaserSquad is CLI game, with simple idea.  

You are part of a mission where goal is to reach the star gate. On the map looks for star gate described as 'O'.

You can move left/up/right/down and along the way there are obstacles. YOu can't leave the maze.

You can fire towards obstacles using weapon you selected. Each weapon have different range and some of them are direction dependand(for example if your last move was going to the right, then shooting from sniper rifle it will have effect only on the right side of x-axis).
When you destroy one obstacle you gain 1 point.

You have 30 moves to reach the star gate and to gain as much points as possible(by crushing obstacles)
```

## Commands
```
1. Movement
  1. Left - 4
  2. Up - 8
  3. Right - 6
  4. Down - 2
2. Draw the map - d
3. Save game - s
4. Fire - f
5. Map description
  1. 0 - star gate
  2. @ - obstacle
  3. > or < or ^ represents your last movement and direction you're heading into
  4. * - representing walls of the missiong, you can reach them but you can't cross over them
```

## Weapons
```
1. Rocket Launcher - direction dependant, range=5 (it can reach obstacle 5 points longer then your current position)
2. Sniper Rifle - direction dependant, range=5 (it can reach obstacle 10 points longer then your current position)
3. A75 grenade - direction not dependant, range=5 (it can reach obstacle 5 points longer in any x/y direction)
```


