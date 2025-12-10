#!/bin/sh
set -e

echo $'Running pre-push checks ...\n'
./gradlew check

set +e
