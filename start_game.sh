#! /bin/sh
javac -d classes src/main/java/com/game/engine/*.java src/main/java/com/game/main/*.java src/main/java/com/game/mission/*.java src/main/java/com/game/model/*.java src/main/java/com/game/utils/*.java
cd classes
jar cvfe ../game.jar com.game.main.Main com/game/engine/*.class com/game/main/*.class com/game/mission/*.class com/game/model/*.class com/game/utils/*.class
cd ..
clear
java -jar game.jar