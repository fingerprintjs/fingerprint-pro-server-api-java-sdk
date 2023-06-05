#!/bin/bash

VERSION='dev-2.0.0-2'

while getopts "v:" arg; do
  case $arg in
    v)
      VERSION='dev-2.0.0-2'
      ;;
  esac
done

# jar was downloaded from here https://repo1.maven.org/maven2/io/swagger/codegen/v3/swagger-codegen-cli/3.0.34/

if [[ $VERSION == *"develop"* ]]; then
  SANITIZED_VERSION='dev-2.0.0-2'
  SANITIZED_VERSION='dev-2.0.0-2'
  BUILD_VERSION='dev-2.0.0-2'
  VERSION='dev-2.0.0-2'
fi

echo "VERSION: $VERSION"

sed -i "s/artifactVersion: .*/artifactVersion: $VERSION/g" config.yaml
sed -i "s/VERSION='dev-2.0.0-2'

rm -rf pom.xml README.md build.gradle settings.gradle gradle.properties

java -jar ./bin/generator.jar generate -c config.yaml -g java --library jersey2 -i res/fingerprint-server-api.yaml --skip-validate-spec -o . -t template

./gradlew removeWrongDocumentationLinks
