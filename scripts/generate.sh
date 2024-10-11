#!/bin/bash

VERSION=$(jq -r '.version' package.json)

while getopts "v:" arg; do
  case $arg in
    v)
      VERSION=$OPTARG
      ;;
  esac
done

echo "VERSION: $VERSION"

platform=$(uname)
(
  if [ "$platform" = "Darwin" ]; then
    sed -i '' -e "s/projectVersion = .*$/projectVersion = $VERSION/g" ./gradle.properties
  else
    sed -i "s/projectVersion = .*$/projectVersion = $VERSION/g" ./gradle.properties
  fi
)
./gradlew build test
