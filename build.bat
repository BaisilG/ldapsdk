@echo off

rem Copyright 2007-2020 Ping Identity Corporation
rem All Rights Reserved.
rem
rem -----
rem
rem Copyright (C) 2007-2020 Ping Identity Corporation
rem This program is free software; you can redistribute it and/or modify
rem it under the terms of the GNU General Public License (GPLv2 only)
rem or the terms of the GNU Lesser General Public License (LGPLv2.1 only)
rem as published by the Free Software Foundation.
rem
rem This program is distributed in the hope that it will be useful,
rem but WITHOUT ANY WARRANTY; without even the implied warranty of
rem MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
rem GNU General Public License for more details.
rem
rem You should have received a copy of the GNU General Public License


setlocal
set SCRIPT_DIR=%~dP0

set ANT_HOME=%SCRIPT_DIR%\ext\ant
"%ANT_HOME%\bin\ant" %*

