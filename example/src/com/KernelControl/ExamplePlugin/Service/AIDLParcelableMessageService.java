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

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;


public class AIDLParcelableMessageService extends Service {
    private static final String KERNEL_CONTROL_INTENT_ACTION_BIND_KERNEL_PLUGIN_SERVICE =
            "KernelControl.intent.action.bindKernelPluginService";

    //The Service which the KernelControl app binds to.
    @Override
    public IBinder onBind(Intent intent) {
        if (KERNEL_CONTROL_INTENT_ACTION_BIND_KERNEL_PLUGIN_SERVICE.equals(intent.getAction())) {
            return new KernelPluginInterfaces();
        }
        return null;
    }
}
