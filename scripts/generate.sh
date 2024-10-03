#!/bin/bash

VERSION=$(jq -r '.version' package.json)

while getopts "v:" arg; do
  case $arg in
    v)
      VERSION=$OPTARG
      ;;
  esac
done

if [[ $VERSION == *"develop"* ]]; then
  SANITIZED_VERSION=$(sed 's/-develop//g' <<< $VERSION)
  SANITIZED_VERSION=$(sed 's/\.[0-9]*$//g' <<< $SANITIZED_VERSION)
  BUILD_VERSION=$(grep -o '[0-9]*$' <<< $VERSION)
  VERSION="dev-$SANITIZED_VERSION-$BUILD_VERSION"
fi

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
