#!/bin/bash

function revert() {
  echo "Reverting changes"
  git checkout .
}
