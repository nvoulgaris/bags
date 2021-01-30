#!/bin/bash

function commit() {
  echo "Committing and pushing changes"
  git add . && git commit -m "WIP" && git push
}
