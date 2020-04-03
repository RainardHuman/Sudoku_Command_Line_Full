mvnw clean compile assembly:single

xcopy.exe /s/e src\main\java\human\rainard\Games target\Games\
xcopy.exe /s/e src\main\java\human\rainard\Saves target\Saves\

pause