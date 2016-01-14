#! /usr/bin/env bash

if [ "$1" == "test" ];
then
  lein test
  exit "$?"
fi

if [ "$1" == "run" ];
then
  lein run
  exit "$?"
fi

if [ "$1" == "run-jar" ];
then
  java -jar target/alphabet-diamond-0.1.0-SNAPSHOT-standalone.jar
  exit "$?"
fi

echo "Usage"
echo "./go.sh test|run|run-jar"
