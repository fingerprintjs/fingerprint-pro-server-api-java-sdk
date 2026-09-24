#!/usr/bin/env bash
set -euo pipefail

# Resolve paths relative to the repository root, so the script can be run from
# any working directory.
cd "$(dirname "${BASH_SOURCE[0]}")/.."

schemaUrl="${1:-https://fingerprintjs.github.io/openapi/schemas/fingerprint-server-api-compact.yaml}"

CURL_OPTS=(-fSL --retry 3 --proto-redir '=https' --connect-timeout 10 --max-time 300)
if [[ "${TRACE:-}" != "true" && "${ACTIONS_STEP_DEBUG:-}" != "true" ]]; then
  CURL_OPTS+=(-s)
fi

mkdir -p ./res

# Download latest schema. Examples are no longer published at the upstream URL
# (fingerprintjs.github.io/.../examples/ returns 404). Mock files in
# sdk/src/test/resources/mocks/ are maintained locally.
echo "Downloading $schemaUrl"
curl "${CURL_OPTS[@]}" -o ./res/fingerprint-server-api.yaml "$schemaUrl"

echo "OpenAPI schema download complete."

./scripts/generate.sh
