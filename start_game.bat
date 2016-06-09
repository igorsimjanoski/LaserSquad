IF exist classes ( echo classes exists ) ELSE ( mkdir classes && echo classes created)
javac -d classes src/main/java/com/game/engine/*.java src/main/java/com/game/main/*.java src/main/java/com/game/mission/*.java src/main/java/com/game/model/*.java src/main/java/com/game/utils/*.java
cd classes
jar cvfe ../game.jar com.game.main.Main com/game/engine/*.class com/game/main/*.class com/game/mission/*.class com/game/model/*.class com/game/utils/*.class
cd ..
cls
java -jar game.jar