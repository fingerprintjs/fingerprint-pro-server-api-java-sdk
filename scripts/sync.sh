#!/bin/bash

curl -o ./res/fingerprint-server-api.yaml https://fingerprintjs.github.io/fingerprint-pro-server-api-openapi/schemas/fingerprint-server-api-v4.yaml

examplesList=(
  'webhook/webhook_event.json'
  'events/get_event_200.json'
  'events/search/get_event_search_200.json'
  'errors/404_event_not_found.json'
  'errors/404_visitor_not_found.json'
  'errors/403_feature_not_enabled.json'
  'errors/400_visitor_id_invalid.json'
  'errors/429_too_many_requests.json'
  'errors/400_request_body_invalid.json'
  'errors/409_state_not_ready.json'
)

for example in ${examplesList[*]}; do
  curl -o ./sdk/src/test/resources/mocks/"$example" https://fingerprintjs.github.io/fingerprint-pro-server-api-openapi/examples/"$example"
done

./scripts/generate.sh
