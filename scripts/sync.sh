#!/bin/bash

# Download latest schema. Examples are no longer published at the upstream URL
# (fingerprintjs.github.io/.../examples/ returns 404). Mock files in
# sdk/src/test/resources/mocks/ are maintained locally.
curl -o ./res/fingerprint-server-api.yaml https://fingerprintjs.github.io/fingerprint-pro-server-api-openapi/schemas/fingerprint-server-api-compact.yaml

./scripts/generate.sh
