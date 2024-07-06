#!/usr/bin/env bash
docker compose down
docker compose -f compose-pg.yaml up -d
docker build -t docker.io/sidneyaquino/fiappostech-fastfood:0.4.2 -f ./Dockerfile.cds --network=host .
docker compose -f compose-pg.yaml down