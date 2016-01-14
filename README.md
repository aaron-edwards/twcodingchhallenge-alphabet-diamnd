# alphabet-diamond

###The Challienge
Write a program which draws a diamond of the form illustrated below. The letter which is to appear at the widest point of the figure (E in the example) is to be specified as input data (CLI arg, keyboard read-in, etc).

                      A
                     B B

                    C   C

                   D     D

                  E       E

                   D     D

                    C   C

                     B B

                      A

Inputs are [a-zA-Z] (e.g. letters only, upper or lower case). Output is upper case only.
Edge cases:
If you input "a" or "A", then he output is simply "A".
If the input is invalid, then the output is "INVALID INPUT". If you read from keyboard input you may ask the user for a new input.


###Requirements

- [Lein](http://leiningen.org/) is required to run (I believe it is on brew)

### How to run

`./go.sh run`

You will then be prompted for input (after the clojure repl boots up)


I have also *gasp* checked in a jar file if you don't want to install lein (you should totaly install lein and play with Clojure though)
run the jar with `./go.sh run-jar`
