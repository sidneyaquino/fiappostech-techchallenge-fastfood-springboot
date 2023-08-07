#!/bin/bash
for i in {1..10000}; do
  curl -i -X GET "http://fastfood.apps.sandbox-m4.g2pi.p1.openshiftapps.com/customers?personalId=12345678902"
  # curl -i -X GET "http://localhost:8080/customers?personalId=12345678902"
  sleep $1
done