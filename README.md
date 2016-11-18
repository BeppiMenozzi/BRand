# BRand
Collection of useful static shortcuts that come handy when randomization is needed.
Do everything you need with one command!

### Setup:
Add **maven { url "https://jitpack.io" }** in project's build.gradle file.

Add **compile 'com.github.BeppiMenozzi:BRand:1.0.0'** in module's build.gradle file.

### Usage:
BRand is a class with static methods, so you don't have to declare, initialize or instantiate anything.

* getInt() : returns an evenly distributed int in the expressed range. See also getIntRange()

* getFloat() : returns an evenly distributed float in the expressed range. See also getFloatRange()

* getDouble() : returns an evenly distributed double in the expressed range. See also getDoubleRange()

* getBoolean() : returns true with the expressed change. See also getBoolean100()

* getIntDifferentFrom() : returns an evenly distributed int, that is different from a list of given ints. Use also getIntCountDifferentFrom() and getIntRangeDifferentFrom()

* getIntArray() : returns an array of elements generated with getInt(). See also getIntRangeArray(), getFloatArray(), getFloatRangeArray(), getDoubleArray(), getDoubleRangeArray(), getBooleanArray(), getBoolean100Array(), getIntArrayDifferentFrom(), getIntCountArrayDifferentFrom(), getIntRangeArrayDifferentFrom()

### Todo:
Geometrical random generator
