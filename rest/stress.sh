#!/bin/bash
source .env
export APP_ENDPOINT="customers?personalId=12345678902"

for i in {1..10000}; do
  echo $HOST_NAME/$APP_ENDPOINT
  curl -i -X GET $HOST_NAME/$APP_ENDPOINT
  sleep $1
done