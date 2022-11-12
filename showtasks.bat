call runcrud.bat

if "%ERRORLEVEL%" == "0" goto runbrowser
echo.
echo ERROR. Cannot execute runcrud.bat - breaking work
goto fail

:runbrowser
start http://localhost:8080/crud/v1/tasks
if "%ERRORLEVEL%" == "0" goto end
echo ERROR. Cannot open browser - breaking work
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.
