#!/bin/bash
source .env
for i in {1..10000}; do
  curl -i -X GET $HOST_NAME"/customers?personalId=12345678902"
  sleep $1
done