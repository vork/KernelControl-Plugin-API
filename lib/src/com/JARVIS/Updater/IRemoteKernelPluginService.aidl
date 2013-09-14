package com.JARVIS.Updater;

import com.JARVIS.Updater.PluginInterface;
import java.util.List;

interface IRemoteKernelPluginService {

    List<PluginInterface> getPluginInterfaces();
}
