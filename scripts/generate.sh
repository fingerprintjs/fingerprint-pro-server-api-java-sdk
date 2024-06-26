#!/bin/bash

VERSION='5.1.1'

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

sed -i "s/artifactVersion: .*/artifactVersion: $VERSION/g" config.yaml
sed -i "s/^VERSION=.*/VERSION='$VERSION'/g" ./scripts/generate.sh

rm -f README.md build.gradle settings.gradle gradle.properties ./src/main/java/com/fingerprint/model/*
find ./docs -type f ! -name "DecryptionKey.md" ! -name "Sealed.md" -exec rm {} +

java -jar ./bin/generator.jar generate -c config.yaml -g java --library jersey2 -i res/fingerprint-server-api.yaml --skip-validate-spec -o . -t template

./gradlew removeWrongDocumentationLinks

./gradlew jar
