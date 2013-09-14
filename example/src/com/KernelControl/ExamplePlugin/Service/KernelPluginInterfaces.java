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

package com.KernelControl.ExamplePlugin.Service;

import com.KernelControl.Plugin.KernelInterface;
import com.KernelControl.Plugin.Service.KernelInterfaceMessageService;

import java.util.ArrayList;


/**
 * The actual AIDL communication
 */
public class KernelPluginInterfaces extends KernelInterfaceMessageService {
    private static final String VM_BASE_PATH = "/proc/sys/vm/";

    //Easy way to create a unique ID
    private int mID = 0;

    @Override
    public void addInterfaces() {

        int vmTweaks = mID++; //Save the ID for the category so we can use it later with .setCategoryID()
        add(new KernelInterface.Category(vmTweaks, "VM Tweaks"));


        //Add SeekBar
        add(new KernelInterface.SeekBarKernelInterface(mID++, "Dirty Background Ratio",
                VM_BASE_PATH + "dirty_background_ratio", "Sets the dirty background ratio",
                0, 100).setCategoryID(vmTweaks));

        //Add EditText
        add(new KernelInterface.EditTextKernelInterface(mID++, "Dirty Ratio", VM_BASE_PATH + "dirty_ratio",
                "Sets the dirty ratio", 0, 100).setCategoryID(vmTweaks));

        //Add Switch
        add(new KernelInterface.SwitchKernelInterface(mID++, "OOM Kill Allocation Task",
                VM_BASE_PATH + "oom_kill_allocating_task", "Toggle for the oom behaviour",
                "Kill the task which caused the oom situation",
                "Scan through the task list and kill memory hogging tasks").setCategoryID(vmTweaks));

        //Setup the ArrayList for the Spinner
        ArrayList<String> spinnerOptions = new ArrayList<String>();
        ArrayList<String> spinnerValues = new ArrayList<String>();

        spinnerOptions.add("Heuristic overcommit handling (default)");
        spinnerValues.add("0");
        spinnerOptions.add("Always overcommit");
        spinnerValues.add("1");
        spinnerOptions.add("Don't overcommit");
        spinnerValues.add("2");

        //Add Spinner
        add(new KernelInterface.SpinnerInterface(mID++, "Overcommit memory", VM_BASE_PATH +
                "overcommit_memory", "This changes the way the system uses overcommited memory.",
                spinnerOptions, spinnerValues).setCategoryID(vmTweaks));

        for (int i = 0; i < 5; i++) {
            add(new KernelInterface.Category(mID++, String.valueOf(i) + ". Category"));
        }
    }
}
