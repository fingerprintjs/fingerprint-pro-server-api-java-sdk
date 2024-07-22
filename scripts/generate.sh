#!/bin/bash

VERSION='5.1.1'

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

sed -i "s/projectVersion: .*/projectVersion: $VERSION/g" gradle.properties
sed -i "s/^VERSION=.*/VERSION='$VERSION'/g" ./scripts/generate.sh
./gradlew openApiGenerate copyDocs removeWrongDocumentationLinks jar test