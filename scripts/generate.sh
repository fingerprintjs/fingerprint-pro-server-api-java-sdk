#!/bin/bash

VERSION='0.0.0'

while getopts "v:" arg; do
  case $arg in
    v)
      VERSION=$OPTARG
      ;;
  esac
done

# jar was downloaded from here https://repo1.maven.org/maven2/io/swagger/codegen/v3/swagger-codegen-cli/3.0.34/

if [[ $VERSION == *"develop"* ]]; then
  SANITIZED_VERSION=$(sed 's/-develop//g' <<< $VERSION)
  SANITIZED_VERSION=$(sed 's/\.[0-9]*$//g' <<< $SANITIZED_VERSION)
  BUILD_VERSION=$(grep -o '[0-9]*$' <<< $VERSION)
  VERSION="dev-$SANITIZED_VERSION-$BUILD_VERSION"
fi

echo "VERSION: $VERSION"

sed -i "s/\"artifactVersion\": \".*\"/\"artifactVersion\": \"$VERSION\"/g" config.json

rm -rf pom.xml README.md build.gradle settings.gradle gradle.properties

java -jar ./bin/swagger-codegen-cli.jar generate -t ./template -l java -i ./res/fingerprint-server-api.yaml -o ./ -c config.json