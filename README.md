# PaintCalculator

Simple utility to calculate the quanity and price of paint required to paint an interior room based on room specifications provided by the user

## Getting Started

TODO: Provide Prerequisistes

### Prerequisites

TODO: Provide Prerequisistes

### Installing

TODO: Provide Installation steps

## Running the app

The current version is executed via command line.  The room specifications are defined as arguments using the following elements any number of times: wall, door, window, trim.

The properties of the paint product are defined with the following arguments: paintCoverage, paintPrice, PaintSku

Example:
```
PaintCalculator -wall 60|10 -door 3|7 -window 3|5 -paintPrice 50 -paintSku 12345 -paintCoverage 350
```

```
PaintCalculator -wall 20|10 -wall 25|10 -wall 20|10 -wall 25|10 -door 3|7 -window 3|5 -window 3|5 -window 5|7 -paintPrice 50 -paintSku 12345 -paintCoverage 350
```

## Options
```
  Options:
    -door            Width and Height of a door in a pipe separated format (ex:
                     for a door measuing 3x7 use: '-door 3|6')
                     Default: []
  * -paintCoverage   The coverage per gallon of paint (in square feet)
  * -paintPrice      The price per gallon of the paint product
  * -paintSku        The sku of the paint product
    -trim            Width and Height of trim in a pipe separated format (ex:
                     for trim on a wall measuing 10x20 use: '-trim 10|20')
                     Default: []
  * -wall            Width and Height of a Wall in a pipe separated format (ex:
                     for a wall measuing 10x20 use: '-wall 10|20')
                     Default: []
    -window          Width and Height of a window in a pipe separated format
                     (ex: for a window measuing 3x5 use: '-window 3|5')
                     Default: []
```

## Running the tests

Use the included JUnit test class: PaintCalculatorTest.java
