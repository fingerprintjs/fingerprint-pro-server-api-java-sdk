#!/bin/bash

curl -o ./res/fingerprint-server-api.yaml https://fingerprintjs.github.io/fingerprint-pro-server-api-openapi/schemes/fingerprint-server-api.yaml

examplesList=(
  'visits_limit_500.json'
  'visits_403_error.json'
  'visits_too_many_requests_error.json'
  'get_event_extra_fields.json'
  'get_event.json'
  'get_event_all_errors.json'
  'get_event_403_error.json'
  'get_event_404_error.json'
  'get_event_botd_failed_error.json'
  'get_event_botd_too_many_requests_error.json'
  'get_event_extra_fields.json'
  'get_event_identification_failed_error.json'
  'get_event_identification_too_many_requests_error.json'
)

for example in ${examplesList[*]}; do
  curl -o ./src/test/resources/mocks/"$example" https://fingerprintjs.github.io/fingerprint-pro-server-api-openapi/examples/"$example"
done

./scripts/generate.sh
