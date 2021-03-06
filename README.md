# BRand
Collection of useful static shortcuts that come handy when randomization is needed.
Do you always have to write loops and store arrays to get a random value different from the previous ones, or to shuffle some integers, or even to get a chance of win that is not simply 50%?
There's nothing difficult in that, but you may find it faster to use this small library, that makes all the random calculations for you.

[![Release](https://jitpack.io/v/BeppiMenozzi/BRand.svg)](https://jitpack.io/#BeppiMenozzi/BRand)

### Setup (Gradle)
Add **maven { url "https://jitpack.io" }** in project's build.gradle file.

Add **compile 'com.github.BeppiMenozzi:BRand:1.0.0'** in module's build.gradle file.

### Usage
BRand is a class with static methods, so you don't have to declare, initialize or instantiate anything.

* getInt() : returns an evenly distributed int in the expressed range. See also getIntRange()

* getFloat() : returns an evenly distributed float in the expressed range. See also getFloatRange()

* getDouble() : returns an evenly distributed double in the expressed range. See also getDoubleRange()

* getBoolean() : returns true with the expressed change. See also getBoolean100()

* getIntDifferentFrom() : returns an evenly distributed int, that is different from a list of given ints. Use also getIntCountDifferentFrom() and getIntRangeDifferentFrom()

* getIntArray() : returns an array of elements generated with getInt(). See also getIntRangeArray(), getFloatArray(), getFloatRangeArray(), getDoubleArray(), getDoubleRangeArray(), getBooleanArray(), getBoolean100Array(), getIntArrayDifferentFrom(), getIntCountArrayDifferentFrom(), getIntRangeArrayDifferentFrom(), getIntArrayAllDifferent()

* getAllNumbersShuffled() : returns an array of all n integers in a range, shuffled. See also getAllNumbersRangeShuffled()

### Examples
<img src="Snap269.png">

### Todo
Geometrical random generator

### LICENSE

This software is provided under the MIT license:<br />
http://opensource.org/licenses/mit-license.php

### Author

[Beppi Menozzi](http://www.beppi.it)
