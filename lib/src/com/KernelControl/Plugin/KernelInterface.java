/*
 * Copyright 2013 Benedikt Boss
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.KernelControl.Plugin;

import java.util.ArrayList;
import java.util.List;

public class KernelInterface {
    public final static int TYPE_SEEKBAR = 1;
    public final static int TYPE_SWITCH = 2;
    public final static int TYPE_EDITTEXT = 3;
    public final static int TYPE_CATEGORY = 4;
    public final static int TYPE_SPINNER = 5;

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // PUBLIC METHODS
    ////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Creates a SeekBar
     */
    public static class SeekBarKernelInterface extends SelectableValue {

        /**
         * Create a SeekBar with possible stepping (increse/decrese in fe. 25 steps)
         *
         * @param ID an unique ID
         * @param interfaceName the name of the interface
         * @param interfacePath the path to the interface
         * @param summary a small description about the interface
         * @param possibleStep the possible steps for the interface. Like only +/-25 steps
         * @param minValue the minimum possible/safe value for the interface
         * @param maxValue the maximum possible/safe value for the interface
         */
        public SeekBarKernelInterface(int ID, String interfaceName, String interfacePath,
                                      String summary, int possibleStep, int minValue, int maxValue) {
            super(ID, interfaceName, interfacePath, summary, " ", " ", TYPE_SEEKBAR,
                    possibleStep, minValue, maxValue);
        }

        /**
         * Create a SeekBar
         *
         * @param ID an unique ID
         * @param interfaceName the name of the interface
         * @param interfacePath the path to the interface
         * @param summary a small description about the interface
         * @param minValue the minimum possible/safe value for the interface
         * @param maxValue the maximum possible/safe value for the interface
         */
        public SeekBarKernelInterface(int ID, String interfaceName, String interfacePath,
                                      String summary, int minValue, int maxValue) {
            this(ID, interfaceName, interfacePath, summary, 1, minValue, maxValue);
        }
    }

    /**
     * Creates an EditText
     */
    public static class EditTextKernelInterface extends SelectableValue {

        /**
         * Creates an EditText interface with possible Steps.
         *
         * @param ID an unique ID
         * @param interfaceName the name of the interface
         * @param interfacePath the path to the interface
         * @param summary a small description about the interface
         * @param possibleStep the possible steps for the interface. Like only +/-25 steps
         * @param minValue the minimum possible/safe value for the interface
         * @param maxValue the maximum possible/safe value for the interface
         */
        public EditTextKernelInterface(int ID, String interfaceName, String interfacePath,
                                       String summary, int possibleStep, int minValue, int maxValue) {
            super(ID, interfaceName, interfacePath, summary, " ", " ", TYPE_EDITTEXT, possibleStep,
                    minValue, maxValue);
        }

        /**
         * Creates an EditText interface
         *
         * @param ID an unique ID
         * @param interfaceName the name of the interface
         * @param interfacePath the path to the interface
         * @param summary a small description about the interface
         * @param minValue the minimum possible/safe value for the interface
         * @param maxValue the maximum possible/safe value for the interface
         */
        public EditTextKernelInterface(int ID, String interfaceName, String interfacePath, String summary,
                                       int minValue, int maxValue) {
            this(ID, interfaceName, interfacePath, summary, 1, minValue, maxValue);
        }
    }

    /**
     * Creates an Switch
     */
    public static class SwitchKernelInterface extends KInterface {

        /**
         * Creates a Switch with a summary which toggles with the state.
         *
         * @param ID an unique ID
         * @param interfaceName the name of the interface
         * @param interfacePath the path to the interface
         * @param summary a small description about the interface
         * @param summaryOn small description about the interface in enabled state
         * @param summaryOff small description about the interface in disabled state
         */
        public SwitchKernelInterface(int ID, String interfaceName, String interfacePath,
                                     String summary, String summaryOn, String summaryOff) {
            super(ID, interfaceName, interfacePath, summary, summaryOn, summaryOff, TYPE_SWITCH);
        }

        /**
         * Creates s Switch with a static summary.
         *
         * @param ID an unique ID
         * @param interfaceName the name of the interface
         * @param interfacePath the path to the interface
         * @param summary a small description about the interface
         */
        public SwitchKernelInterface(int ID, String interfaceName, String interfacePath,
                                     String summary) {
            this(ID, interfaceName, interfacePath, summary, " ", " ");
        }

        /**
         * Creates a Switch without a summary. This isn't recommended at all.
         *
         * @param ID an unique ID
         * @param interfaceName the name of the interface
         * @param interfacePath the path to the interface
         */
        public SwitchKernelInterface(int ID, String interfaceName, String interfacePath) {
            this(ID, interfaceName, interfacePath, " ", " ", " ");
        }
    }

    /**
     * Creates a Spinner
     */
    public static class SpinnerInterface extends KInterface {
        public ArrayList<String> spinnerOptions = new ArrayList<String>();
        public ArrayList<String> spinnerValue = new ArrayList<String>();
        public String availableOptionsPath = " ";

        /**
         * Creates a spinner with a path with all available options.
         *
         * @param ID an unique ID
         * @param interfaceName the name of the interface
         * @param interfacePath the path to the current selected option
         * @param summary a small description about the interface
         * @param availableOptionsPath the path where all available options are located
         *                             The values needs to be separated with a simple space (" ").
         */
        public SpinnerInterface(int ID, String interfaceName, String interfacePath, String summary,
                       String availableOptionsPath) {
            super(ID, interfaceName, interfacePath, summary, " ", " ", TYPE_SPINNER);
            this.availableOptionsPath = availableOptionsPath;
        }

        /**
         * Creates a spinner with a fixed but unexposed number of options.
         *
         * @param ID an unique ID
         * @param interfaceName the name of the interface
         * @param interfacePath the path to the current selected option
         * @param summary a small description about the interface
         * @param spinnerOptions the list of available options. Must match the value of the option.
         */
        public SpinnerInterface(int ID, String interfaceName, String interfacePath, String summary,
                                ArrayList<String> spinnerOptions) {
            this(ID, interfaceName, interfacePath, summary, spinnerOptions, spinnerOptions);
        }

        /**
         * Creates a spinner with a fixed but unexposed number of options. Use this if the value of
         * the interface is cryptic and you want to add a description.
         *
         * @param ID an unique ID
         * @param interfaceName the name of the interface
         * @param interfacePath the path to the current selected option
         * @param summary a small description about the interface
         * @param spinnerOptions list of the descriptions
         * @param spinnerValues list of the values for each description
         */
        public SpinnerInterface(int ID, String interfaceName, String interfacePath, String summary,
                                ArrayList<String> spinnerOptions, ArrayList<String> spinnerValues) {
            super(ID, interfaceName, interfacePath, summary, " ", " ", TYPE_SPINNER);
            this.availableOptionsPath = " ";
            this.spinnerOptions = spinnerOptions;
            this.spinnerValue = spinnerValues;
        }

    }

    public static class Category extends Base {
        /**
         * Creates a category
         * @param ID an unique ID
         * @param name the name of the category
         */
        public Category(int ID, String name) {
            super(ID, name, TYPE_CATEGORY);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // PRIVATE METHODS
    ////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Nothing to see here
     */
    private static abstract class SelectableValue extends KInterface {
        public int possibleStep;
        public int minValue;
        public int maxValue;

        public SelectableValue(int ID, String interfaceName, String interfacePath, String summary,
                               String summaryOn, String summaryOff, int interfaceType, int possibleStep,
                               int minValue, int maxValue) {
            super(ID, interfaceName, interfacePath, summary, summaryOn, summaryOff, interfaceType);
            this.possibleStep = possibleStep;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }
    }

    /**
     * Nothing to see here
     */
    private static abstract class KInterface extends Base {
        public String interfacePath;
        public String summary;
        public String summaryOff;
        public String summaryOn;
        public int categoryID = Integer.MIN_VALUE;

        public KInterface(int ID, String interfaceName, String interfacePath, String summary,
                          String summaryOn, String summaryOff, int interfaceType) {
            super(ID, interfaceName, interfaceType);
            this.interfacePath = interfacePath;
            this.summary = summary;
            this.summaryOff = summaryOff;
            this.summaryOn = summaryOn;
        }

        /**
         * Set a category to the interface
         *
         * @param categoryID ID of the category the interface should belong to.
         */
        public KInterface setCategoryID(int categoryID) {
            this.categoryID = categoryID;
            return this;
        }
    }

    /**
     * Nothing to see here
     */
    public static abstract class Base {
        public String name;
        public int ID;
        public int interfaceType;

        /**
         * DON'T USE THIS! This is the just the base class. No use for plugin development.
         */
        public Base(int ID, String name, int interfaceType) {
            this.name = name;
            this.ID = ID;
            this.interfaceType = interfaceType;
        }
    }
}
