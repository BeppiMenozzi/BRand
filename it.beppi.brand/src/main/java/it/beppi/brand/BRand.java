package it.beppi.brand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by Beppi on 04/11/2016.
 * Small library to allow a quicker use of randomization functions
 * It has a collection of static shortcuts and does not need any allocation / initialization.
 */

public class BRand {
    private static Random rnd = new Random();

    // classic and range functions made static

    //--- int ---
    
    /**
     * @param max
     * @return an <tt>integer</tt> between <tt>0</tt> and <tt>max</tt> excluded
     */
    public static int getInt(int max) {
        return rnd.nextInt(max);
    }

    /**
     * @param min
     * @param count
     * @return an <tt>integer</tt> between <tt>min</tt> and <tt>(min+count)</tt> excluded
     */
    public static int getInt(int min, int count) { return min + rnd.nextInt(count); }

    /**
     * @param min
     * @param max
     * @return an <tt>integer</tt> between <tt>min</tt> and <tt>max</tt> excluded
     */
    public static int getIntRange(int min, int max) { return min + rnd.nextInt(max-min); }

    //--- float ---
    
    /**
     * @return a <tt>float</tt> between <tt>0</tt> and <tt>1</tt> excluded
     */
    public static float getFloat() {
        return rnd.nextFloat();
    }

    /**
     * @param max
     * @return a <tt>float</tt> between <tt>0</tt> and <tt>max</tt> excluded
     */
    public static float getFloat(float max) { return rnd.nextFloat() * max; }

    /**
     * @param min
     * @param distance
     * @return a <tt>float</tt> between <tt>min</tt> and <tt>(min+distance)</tt> excluded
     */
    public static float getFloat(float min, float distance) { return min + rnd.nextFloat() * distance; }

    /**
     * @param min
     * @param max
     * @return a <tt>float</tt> between <tt>min</tt> and <tt>max</tt> excluded
     */
    public static float getFloatRange(float min, float max) { return min + rnd.nextFloat() * (max-min); }

    //--- double ---

    /**
     * @return a <tt>double</tt> between <tt>0</tt> and <tt>1</tt> excluded
     */
    public static double getDouble() {
        return rnd.nextDouble();
    }

    /**
     * @param max
     * @return a <tt>double</tt> between <tt>0</tt> and <tt>max</tt> excluded
     */
    public static double getDouble(double max) { return rnd.nextDouble() * max; }

    /**
     * @param min
     * @param distance
     * @return a <tt>double</tt> between <tt>min</tt> and <tt>(min+distance)</tt> excluded
     */
    public static double getDouble(double min, double distance) { return min + rnd.nextDouble() * distance; }

    /**
     * @param min
     * @param max
     * @return a <tt>double</tt> between <tt>min</tt> and <tt>max</tt> excluded
     */
    public static double getDoubleRange(double min, double max) { return min + rnd.nextDouble() * (max-min); }

    //--- boolean ---

    /**
     * @return <tt>true</tt> with a probability of <tt>0.5</tt>
     */
    public static boolean getBoolean() { return rnd.nextBoolean(); }

    /**
     * @param chance
     * @return <tt>true</tt> with a certain probability <tt>chance</tt> between <tt>0</tt> and <tt>1</tt> excluded
     */
    public static boolean getBoolean(double chance) { return (rnd.nextDouble() < chance); }

    /**
     * @param chance
     * @return <tt>true</tt> with a certain probability <tt>chance</tt> between <tt>0</tt> and <tt>1</tt> excluded
     */
    public static boolean getBoolean(float chance) { return (rnd.nextFloat() < chance); }

    /**
     * @param perc
     * @return <tt>true</tt> with a certain probability <tt>perc</tt>, expressed in percent
     */
    public static boolean getBoolean100(double perc) { return (100d*rnd.nextDouble() < perc); }

    /**
     * @param perc
     * @return <tt>true</tt> with a certain probability <tt>perc</tt>, expressed in percent
     */
    public static boolean getBoolean100(float perc) { return (100f*rnd.nextFloat() < perc); }

    /**
     * @param perc
     * @return <tt>true</tt> with a certain probability <tt>perc</tt>, expressed in percent
     */
    public static boolean getBoolean100(int perc) { return (100*rnd.nextInt(perc) < perc); }


    // Exclusions

    /**
     * @param max
     * @param excluding
     * @return an <tt>integer</tt> between <tt>0</tt> and <tt>max</tt> excluded, that is possibly different from any element in <tt>excluding</tt>
     */
    public static int getIntDifferentFrom(int max, Integer... excluding) {
        return getIntCountDifferentFrom(0, max, excluding);
    }

    /**
     * @param min
     * @param count
     * @param excluding
     * @return an <tt>integer</tt> between <tt>min</tt> and <tt>(min+count)</tt> excluded, that is possibly different from any element in <tt>excluding</tt>
     */
    public static int getIntCountDifferentFrom(int min, int count, Integer... excluding) {
        if (count==1) return min;  // extreme case
        // Warning: no infinite loop check is performed
        int choice;
        Set<Integer> mSet = new HashSet<Integer>(Arrays.asList(excluding)); // convert into HashSet for faster search in case of long arrays
        do { choice = min + rnd.nextInt(count); } while (mSet.contains(choice));
        return choice;
    }

    /**
     * @param min
     * @param max
     * @param excluding
     * @return an <tt>integer</tt> between <tt>min</tt> and <tt>max</tt> excluded, that is possibily different from any element in <tt>excluding</tt>
     */
    public static int getIntRangeDifferentFrom(int min, int max, Integer... excluding) {
        return getIntCountDifferentFrom(min, max-min, excluding);
    }


    // All what's before, but returning Arrays

    /**
     * @param max
     * @param length
     * @return a generated array of <tt>Integer</tt>s of length <tt>length</tt>, each element being between <tt>0</tt> and <tt>max</tt> excluded
     */
    public static Integer[] getIntArray(int max, int length) {
        Integer[] mArray = new Integer[length];
        for (int w=0; w<length; w++) mArray[w] = getInt(max);
        return mArray;
    }

    /**
     * @param min
     * @param count
     * @param length
     * @return a generated array of <tt>Integer</tt>s of length <tt>length</tt>, each element being between <tt>min</tt> and <tt>(min+count)</tt> excluded
     */
    public static Integer[] getIntArray(int min, int count, int length) {
        Integer[] mArray = new Integer[length];
        for (int w=0; w<length; w++) mArray[w] = getInt(min, count);
        return mArray;
    }

    /**
     * @param min
     * @param max
     * @param length
     * @return a generated array of <tt>Integer</tt>s of length <tt>length</tt>, each element being between <tt>min</tt> and <tt>max</tt> excluded
     */
    public static Integer[] getIntRangeArray(int min, int max, int length) {
        Integer[] mArray = new Integer[length];
        for (int w=0; w<length; w++) mArray[w] = getIntRange(min, max);
        return mArray;
    }

    /**
     * @param length
     * @return a generated array of <tt>Float</tt>s of length <tt>length</tt>, each element being between <tt>0</tt> and <tt>1</tt> excluded
     */
    public static Float[] getFloatArray(int length) {
        Float[] mArray = new Float[length];
        for (int w=0; w<length; w++) mArray[w] = getFloat();
        return mArray;
    }

    /**
     * @param max
     * @param length
     * @return a generated array of <tt>Float</tt>s of length <tt>length</tt>, each element being between <tt>0</tt> and <tt>max</tt> excluded
     */
    public static Float[] getFloatArray(float max, int length) {
        Float[] mArray = new Float[length];
        for (int w=0; w<length; w++) mArray[w] = getFloat(max);
        return mArray;
    }

    /**
     * @param min
     * @param distance
     * @param length
     * @return a generated array of <tt>Float</tt>s of length <tt>length</tt>, each element being between <tt>min</tt> and <tt>(min+distance)</tt> excluded
     */
    public static Float[] getFloatArray(float min, float distance, int length) {
        Float[] mArray = new Float[length];
        for (int w=0; w<length; w++) mArray[w] = getFloat(min, distance);
        return mArray;
    }

    /**
     * @param min
     * @param max
     * @param length
     * @return a generated array of <tt>Float</tt>s of length <tt>length</tt>, each element being between <tt>min</tt> and <tt>max</tt> excluded
     */
    public static Float[] getFloatRangeArray(float min, float max, int length) {
        Float[] mArray = new Float[length];
        for (int w=0; w<length; w++) mArray[w] = getFloatRange(min, max);
        return mArray;
    }

    /**
     * @param length
     * @return a generated array of <tt>Double</tt>s of length <tt>length</tt>, each element being between <tt>0</tt> and <tt>1</tt> excluded
     */
    public static Double[] getDoubleArray(int length) {
        Double[] mArray = new Double[length];
        for (int w=0; w<length; w++) mArray[w] = getDouble();
        return mArray;
    }

    /**
     * @param max
     * @param length
     * @return a generated array of <tt>Double</tt>s of length <tt>length</tt>, each element being between <tt>0</tt> and <tt>max</tt> excluded
     */
    public static Double[] getDoubleArray(double max, int length) {
        Double[] mArray = new Double[length];
        for (int w=0; w<length; w++) mArray[w] = getDouble(max);
        return mArray;
    }

    /**
     * @param min
     * @param distance
     * @param length
     * @return a generated array of <tt>Double</tt>s of length <tt>length</tt>, each element being between <tt>min</tt> and <tt>(min+distance)</tt> excluded
     */
    public static Double[] getDoubleArray(double min, double distance, int length) {
        Double[] mArray = new Double[length];
        for (int w=0; w<length; w++) mArray[w] = getDouble(min, distance);
        return mArray;
    }

    /**
     * @param min
     * @param max
     * @param length
     * @return a generated array of <tt>Double</tt>s of length <tt>length</tt>, each element being between <tt>min</tt> and <tt>max</tt> excluded
     */
    public static Double[] getDoubleRangeArray(double min, double max, int length) {
        Double[] mArray = new Double[length];
        for (int w=0; w<length; w++) mArray[w] = getDoubleRange(min, max);
        return mArray;
    }

    /**
     * @param length
     * @return a generated array of <tt>Boolean</tt>s of length <tt>length</tt>, each element having 0.5 chance of being <tt>true</tt> equally distributed
     */
    public static Boolean[] getBooleanArray(int length) {
        Boolean[] mArray = new Boolean[length];
        for (int w=0; w<length; w++) mArray[w] = getBoolean();
        return mArray;
    }

    /**
     * @param chance
     * @param length
     * @return a generated array of <tt>Boolean</tt>s of length <tt>length</tt>, each element having <tt>chance</tt> chance of being <tt>true</tt> equally distributed
     */
    public static Boolean[] getBooleanArray(double chance, int length) {
        Boolean[] mArray = new Boolean[length];
        for (int w=0; w<length; w++) mArray[w] = getBoolean(chance);
        return mArray;
    }

    /**
     * @param chance
     * @param length
     * @return a generated array of <tt>Boolean</tt>s of length <tt>length</tt>, each element having <tt>chance</tt> chance of being <tt>true</tt> equally distributed
     */
    public static Boolean[] getBooleanArray(float chance, int length) {
        Boolean[] mArray = new Boolean[length];
        for (int w=0; w<length; w++) mArray[w] = getBoolean(chance);
        return mArray;
    }

    /**
     * @param perc
     * @param length
     * @return a generated array of <tt>Boolean</tt>s of length <tt>length</tt>, each element having <tt>chance</tt> chance of being <tt>true</tt>, expressed in percent, equally distributed
     */
    public static Boolean[] getBoolean100Array(double perc, int length) {
        Boolean[] mArray = new Boolean[length];
        for (int w=0; w<length; w++) mArray[w] = getBoolean100(perc);
        return mArray;
    }

    /**
     * @param perc
     * @param length
     * @return a generated array of <tt>Boolean</tt>s of length <tt>length</tt>, each element having <tt>chance</tt> chance of being <tt>true</tt>, expressed in percent, equally distributed
     */
    public static Boolean[] getBoolean100Array(float perc, int length) {
        Boolean[] mArray = new Boolean[length];
        for (int w=0; w<length; w++) mArray[w] = getBoolean100(perc);
        return mArray;
    }

    /**
     * @param perc
     * @param length
     * @return a generated array of <tt>Boolean</tt>s of length <tt>length</tt>, each element having <tt>chance</tt> chance of being <tt>true</tt>, expressed in percent, equally distributed
     */
    public static Boolean[] getBoolean100Array(int perc, int length) {
        Boolean[] mArray = new Boolean[length];
        for (int w=0; w<length; w++) mArray[w] = getBoolean100(perc);
        return mArray;
    }

    /**
     * @param max
     * @param length
     * @param excluding
     * @return a generated array of <tt>Integer</tt>s of length <tt>length</tt>, excluding any element in <tt>excluding</tt>, equally distributed
     */
    public static Integer[] getIntArrayDifferentFrom(int max, int length, Integer... excluding) {
        Integer[] mArray = new Integer[length];
        for (int w=0; w<length; w++) mArray[w] = getIntDifferentFrom(max, excluding);
        return mArray;
    }

    /**
     * @param min
     * @param count
     * @param length
     * @param excluding
     * @return a generated array of <tt>Integer</tt>s of length <tt>length</tt>, each one between <tt>min</tt> and <tt>(min+count)</tt> excluded, excluding any element in <tt>excluding</tt>, equally distributed
     */
    public static Integer[] getIntCountArrayDifferentFrom(int min, int count, int length, Integer... excluding) {
        Integer[] mArray = new Integer[length];
        for (int w=0; w<length; w++) mArray[w] = getIntCountDifferentFrom(min, count, excluding);
        return mArray;
    }

    /**
     * @param min
     * @param max
     * @param length
     * @param excluding
     * @return a generated array of <tt>Integer</tt>s of length <tt>length</tt>, each one between <tt>min</tt> and <tt>max</tt> excluded, excluding any element in <tt>excluding</tt>, equally distributed
     */
    public static Integer[] getIntRangeArrayDifferentFrom(int min, int max, int length, Integer... excluding) {
        Integer[] mArray = new Integer[length];
        for (int w=0; w<length; w++) mArray[w] = getIntRangeDifferentFrom(min, max, excluding);
        return mArray;
    }

    // more functions returning Arrays

    /**
     * @param max
     * @param length
     * @return a generated array of <tt>Integer</tt>s of length <tt>length</tt>, each one between <tt>0</tt> and <tt>max</tt> excluded, each one different, equally distributed
     */
    public static Integer[] getIntArrayAllDifferent(int max, int length) {
        // Warning: no infinite loop check is performed
        Set<Integer> mSet = new HashSet<Integer>();
        int choice;
        for (int w=0; w<length; w++)
            do choice = getInt(max);
            while (mSet.contains(choice));
        return (Integer[])mSet.toArray();
    }

    /**
     * @param min
     * @param count
     * @param length
     * @return a generated array of <tt>Integer</tt>s of length <tt>length</tt>, each one between <tt>min</tt> and <tt>(min+count)</tt> excluded, each one different, equally distributed
     */
    public static Integer[] getIntCountArrayAllDifferent(int min, int count, int length) {
        // Warning: no infinite loop check is performed
        Set<Integer> mSet = new HashSet<Integer>();
        int choice;
        for (int w=0; w<length; w++)
            do choice = getInt(min, count);
            while (mSet.contains(choice));
        return (Integer[])mSet.toArray();
    }

    /**
     * @param min
     * @param max
     * @param length
     * @return a generated array of <tt>Integer</tt>s of length <tt>length</tt>, each one between <tt>min</tt> and <tt>max</tt> excluded, each one different, equally distributed
     */
    public static Integer[] getIntRangeArrayAllDifferent(int min, int max, int length) {
        // Warning: no infinite loop check is performed
        Set<Integer> mSet = new HashSet<Integer>();
        int choice;
        for (int w=0; w<length; w++)
            do choice = getIntRange(min, max);
            while (mSet.contains(choice));
        return (Integer[])mSet.toArray();
    }

    /**
     * @param max
     * @return a generated array of all <tt>Integer</tt>s between <tt>0</tt> and <tt>max</tt> excluded, shuffled
     */
    public static Integer[] getAllNumbersShuffled(int max) {
        ArrayList<Integer> mList = new ArrayList<Integer>();
        for (int w=0; w<max; w++) mList.add(w);
        Collections.shuffle(mList);
        return (Integer[])mList.toArray();
    }

    /**
     * @param min
     * @param count
     * @return a generated array of all <tt>Integer</tt>s between <tt>min</tt> and <tt>(min+count)</tt> excluded, shuffled
     */
    public static Integer[] getAllNumbersShuffled(int min, int count) {
        ArrayList<Integer> mList = new ArrayList<Integer>();
        for (int w=min; w<min+count; w++) mList.add(w);
        Collections.shuffle(mList);
        return (Integer[])mList.toArray();
    }

    /**
     * @param min
     * @param max
     * @return a generated array of all <tt>Integer</tt>s between <tt>min</tt> and <tt>max</tt> excluded, shuffled
     */
    public static Integer[] getAllNumbersRangeShuffled(int min, int max) {
        ArrayList<Integer> mList = new ArrayList<Integer>();
        for (int w=min; w<max; w++) mList.add(w);
        Collections.shuffle(mList);
        return (Integer[])mList.toArray();
    }

    // geometric

    // vectors
}
