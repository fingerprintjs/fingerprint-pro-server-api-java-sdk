#!/bin/bash

curl -o ./res/fingerprint-server-api.yaml https://fingerprintjs.github.io/fingerprint-pro-server-api-openapi/schemes/fingerprint-server-api.yaml

examplesList=(
  'visits_limit_500.json'
  'get_event_extra_fields.json'
  'get_event.json'
)

for example in ${examplesList[*]}; do
  curl -o ./src/test/resources/mocks/"$example" https://fingerprintjs.github.io/fingerprint-pro-server-api-openapi/examples/"$example"
done

./scripts/generate.sh
