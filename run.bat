@echo off
title JavaFX Application Runner

echo ========================================
echo    JavaFX Application - Clean Build
echo ========================================

REM Clean everything
echo Cleaning...
if exist bin rmdir /s /q bin
mkdir bin

echo.
echo [1/3] Compiling Java files...
javac --module-path "lib" --add-modules javafx.controls,javafx.fxml,javafx.graphics -d bin src\*.java

if errorlevel 1 (
    echo ERROR: Compilation failed!
    pause
    exit /b 1
)

echo [2/3] Copying resource files...
if exist src\resources (
    xcopy /E /I /Y "src\resources" "bin\resources" >nul
    echo Resources copied.
)

echo [3/3] Running application...
echo ========================================

java -Djava.library.path="lib" ^
     -Dprism.order=sw ^
     --module-path "lib" ^
     --add-modules javafx.controls,javafx.fxml,javafx.graphics ^
     -cp "bin;lib\*" ^
     App

echo.
echo ========================================
echo Application finished.
pause