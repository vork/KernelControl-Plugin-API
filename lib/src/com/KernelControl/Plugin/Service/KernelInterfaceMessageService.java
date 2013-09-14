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

package com.KernelControl.Plugin.Service;

import android.os.RemoteException;

import com.JARVIS.Updater.IRemoteKernelPluginService;
import com.KernelControl.Plugin.KernelInterface;
import com.KernelControl.Plugin.KernelInterface.*;
import com.JARVIS.Updater.PluginInterface;

import java.util.ArrayList;
import java.util.List;

public abstract class KernelInterfaceMessageService extends IRemoteKernelPluginService.Stub {
    private ArrayList<PluginInterface> mPluginInterfaces;

    public KernelInterfaceMessageService() {
        mPluginInterfaces = new ArrayList<PluginInterface>();
        addInterfaces();
    }

    /**
     *
     * @return the interfaces
     * @throws RemoteException
     */
    @Override
    public List<PluginInterface> getPluginInterfaces() throws RemoteException {
        return mPluginInterfaces;
    }

    /**
     * Adds a new KernelInterface
     * @param base the interface to add
     */
    public void add(KernelInterface.Base base) {
        PluginInterface pluginInterface = new PluginInterface();

        int interfaceType = base.interfaceType;
        ArrayList<String> empty = new ArrayList<String>();

        if(interfaceType == KernelInterface.TYPE_SEEKBAR) {
            pluginInterface.setID(((SeekBarKernelInterface) base).ID);
            pluginInterface.setInterfaceType(KernelInterface.TYPE_SEEKBAR);
            pluginInterface.setName(((SeekBarKernelInterface) base).name);
            pluginInterface.setInterfacePath(((SeekBarKernelInterface) base).interfacePath);
            pluginInterface.setSummary(((SeekBarKernelInterface) base).summary);
            pluginInterface.setSummaryOn(" ");
            pluginInterface.setSummaryOff(" ");
            pluginInterface.setPossibleStep(((SeekBarKernelInterface) base).possibleStep);
            pluginInterface.setMinValue(((SeekBarKernelInterface) base).minValue);
            pluginInterface.setMaxValue(((SeekBarKernelInterface) base).maxValue);
            pluginInterface.setCategoryID(((SeekBarKernelInterface) base).categoryID);
            pluginInterface.setAvailableOptionsPath(" ");
            pluginInterface.setSpinnerOptions(empty);
            pluginInterface.setSpinnerValues(empty);
        } else if(interfaceType == KernelInterface.TYPE_SWITCH) {
            pluginInterface.setID(((SwitchKernelInterface) base).ID);
            pluginInterface.setInterfaceType(KernelInterface.TYPE_SWITCH);
            pluginInterface.setName(((SwitchKernelInterface) base).name);
            pluginInterface.setInterfacePath(((SwitchKernelInterface) base).interfacePath);
            pluginInterface.setSummary(((SwitchKernelInterface) base).summary);
            pluginInterface.setSummaryOn(((SwitchKernelInterface) base).summaryOn);
            pluginInterface.setSummaryOff(((SwitchKernelInterface) base).summaryOff);
            pluginInterface.setPossibleStep(Integer.MIN_VALUE);
            pluginInterface.setMinValue(Integer.MIN_VALUE);
            pluginInterface.setMaxValue(Integer.MIN_VALUE);
            pluginInterface.setCategoryID(((SwitchKernelInterface) base).categoryID);
            pluginInterface.setAvailableOptionsPath(" ");
            pluginInterface.setSpinnerOptions(empty);
            pluginInterface.setSpinnerValues(empty);
        } else if(interfaceType == KernelInterface.TYPE_EDITTEXT) {
            pluginInterface.setID(((EditTextKernelInterface) base).ID);
            pluginInterface.setInterfaceType(KernelInterface.TYPE_EDITTEXT);
            pluginInterface.setName(((EditTextKernelInterface) base).name);
            pluginInterface.setInterfacePath(((EditTextKernelInterface) base).interfacePath);
            pluginInterface.setSummary(((EditTextKernelInterface) base).summary);
            pluginInterface.setSummaryOn(" ");
            pluginInterface.setSummaryOff(" ");
            pluginInterface.setPossibleStep(((EditTextKernelInterface) base).possibleStep);
            pluginInterface.setMinValue(((EditTextKernelInterface) base).minValue);
            pluginInterface.setMaxValue(((EditTextKernelInterface) base).maxValue);
            pluginInterface.setCategoryID(((EditTextKernelInterface) base).categoryID);
            pluginInterface.setAvailableOptionsPath(" ");
            pluginInterface.setSpinnerOptions(empty);
            pluginInterface.setSpinnerValues(empty);
        } else if(interfaceType == KernelInterface.TYPE_SPINNER) {
            pluginInterface.setID(((SpinnerInterface) base).ID);
            pluginInterface.setInterfaceType(KernelInterface.TYPE_SPINNER);
            pluginInterface.setName(((SpinnerInterface) base).name);
            pluginInterface.setInterfacePath(((SpinnerInterface) base).interfacePath);
            pluginInterface.setSummary(((SpinnerInterface) base).summary);
            pluginInterface.setSummaryOn(" ");
            pluginInterface.setSummaryOff(" ");
            pluginInterface.setPossibleStep(Integer.MIN_VALUE);
            pluginInterface.setMinValue(Integer.MIN_VALUE);
            pluginInterface.setMaxValue(Integer.MIN_VALUE);
            pluginInterface.setCategoryID(((SpinnerInterface) base).categoryID);
            pluginInterface.setAvailableOptionsPath(((SpinnerInterface) base).availableOptionsPath);
            pluginInterface.setSpinnerOptions(((SpinnerInterface) base).spinnerOptions);
            pluginInterface.setSpinnerValues(((SpinnerInterface) base).spinnerValue);
        } else { //Category
            pluginInterface.setID(((Category) base).ID);
            pluginInterface.setInterfaceType(KernelInterface.TYPE_CATEGORY);
            pluginInterface.setName(((Category) base).name);
            pluginInterface.setInterfacePath(" ");
            pluginInterface.setSummary(" ");
            pluginInterface.setSummaryOn(" ");
            pluginInterface.setSummaryOff(" ");
            pluginInterface.setPossibleStep(Integer.MIN_VALUE);
            pluginInterface.setMinValue(Integer.MIN_VALUE);
            pluginInterface.setMaxValue(Integer.MIN_VALUE);
            pluginInterface.setCategoryID(Integer.MIN_VALUE);
            pluginInterface.setAvailableOptionsPath(" ");
            pluginInterface.setSpinnerOptions(empty);
            pluginInterface.setSpinnerValues(empty);
        }

        mPluginInterfaces.add(pluginInterface);
    }

    /**
     * You need to overwrite this and add all interfaces here.
     */
    public abstract void addInterfaces();
}
