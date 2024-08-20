#!/bin/bash

VERSION='dev-6.0.1-1'

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
    sed -i '' -e "s/^VERSION=.*$/VERSION='$VERSION'/g" ./scripts/generate.sh
  else
    sed -i "s/projectVersion = .*$/projectVersion = $VERSION/g" ./gradle.properties
    sed -i "s/^VERSION=.*$/VERSION='$VERSION'/g" ./scripts/generate.sh
  fi 
)
./gradlew build test
