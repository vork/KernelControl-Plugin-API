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

package com.JARVIS.Updater;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Nothing to see here. This is for the communication
 */
public class PluginInterface implements Parcelable {
    private int ID;
    private int interfaceType;
    private String name;
    private String interfacePath;
    private String summary;
    private String summaryOn;
    private String summaryOff;
    private int possibleStep;
    private int minValue;
    private int maxValue;
    private int categoryID;
    private List<String> spinnerOptions;
    private List<String> spinnerValues;
    private String availableOptionsPath;

    public int getID() {
        return ID;
    }

    public int getInterfaceType() {
        return interfaceType;
    }

    public String getInterfaceName() {
        return name;
    }

    public String getInterfacePath() {
        return interfacePath;
    }

    public String getSummary() {
        return summary;
    }

    public String getSummaryOn() {
        return summaryOn;
    }

    public String getSummaryOff() {
        return summaryOff;
    }

    public int getPossibleStep() {
        return possibleStep;
    }

    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public List<String> getSpinnerOptions() {
        return spinnerOptions;
    }

    public List<String> getSpinnerValues() {
        return spinnerValues;
    }

    public String getAvailableOptionsPath() {
        return availableOptionsPath;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setInterfaceType(int interfaceType) {
        this.interfaceType = interfaceType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInterfacePath(String interfacePath) {
        this.interfacePath = interfacePath;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setSummaryOn(String summaryOn) {
        this.summaryOn = summaryOn;
    }

    public void setSummaryOff(String summaryOff) {
        this.summaryOff = summaryOff;
    }

    public void setPossibleStep(int possibleStep) {
        this.possibleStep = possibleStep;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public void setSpinnerOptions(List<String> spinnerOptions) {
        this.spinnerOptions = spinnerOptions;
    }

    public void setSpinnerValues(List<String> spinnerValues) {
        this.spinnerValues = spinnerValues;
    }

    public void setAvailableOptionsPath(String availableOptionsPath) {
        this.availableOptionsPath = availableOptionsPath;
    }

    public static final Creator<PluginInterface> CREATOR = new
            Creator<PluginInterface>() {
                public PluginInterface createFromParcel(Parcel in) {
                    return new PluginInterface(in);
                }

                public PluginInterface[] newArray(int size) {
                    return new PluginInterface[size];
                }
            };

    public PluginInterface() {
        spinnerOptions = new ArrayList<String>();
        spinnerValues = new ArrayList<String>();
    }

    public PluginInterface(Parcel in) {
        this();
        ID = in.readInt();
        interfaceType = in.readInt();
        name = in.readString();
        interfacePath = in.readString();
        summary = in.readString();
        summaryOn = in.readString();
        summaryOff = in.readString();
        possibleStep = in.readInt();
        minValue = in.readInt();
        maxValue = in.readInt();
        categoryID = in.readInt();
        in.readStringList(spinnerOptions);
        in.readStringList(spinnerValues);
        availableOptionsPath = in.readString();
    }

    public PluginInterface(int ID, int interfaceType, String name, String interfacePath,
                           String summary, String summaryOn, String summaryOff, int possibleStep,
                           int minValue, int maxValue, int categoryID, List<String> spinnerOptions,
                           List<String> spinnerValues, String availableOptionsPath) {
        this.ID = ID;
        this.interfaceType = interfaceType;
        this.name = name;
        this.interfacePath = interfacePath;
        this.summary = summary;
        this.summaryOn = summaryOn;
        this.summaryOff = summaryOff;
        this.possibleStep = possibleStep;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.categoryID = categoryID;
        this.spinnerOptions = spinnerOptions;
        this.spinnerValues = spinnerValues;
        this.availableOptionsPath = availableOptionsPath;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ID);
        dest.writeInt(interfaceType);
        dest.writeString(name);
        dest.writeString(interfacePath);
        dest.writeString(summary);
        dest.writeString(summaryOn);
        dest.writeString(summaryOff);
        dest.writeInt(possibleStep);
        dest.writeInt(minValue);
        dest.writeInt(maxValue);
        dest.writeInt(categoryID);
        dest.writeStringList(spinnerOptions);
        dest.writeStringList(spinnerValues);
        dest.writeString(availableOptionsPath);
    }
}
