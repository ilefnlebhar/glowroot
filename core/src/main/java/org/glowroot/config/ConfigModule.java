/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.glowroot.config;

import java.io.File;
import java.util.List;

import javax.annotation.Nullable;

public class ConfigModule {

    private final PluginCache pluginCache;
    private final ConfigService configService;

    public ConfigModule(File dataDir, @Nullable File glowrootJarFile, boolean viewerModeEnabled)
            throws Exception {
        pluginCache = PluginCache.create(glowrootJarFile, viewerModeEnabled);
        configService = new ConfigService(dataDir, pluginCache.pluginDescriptors());
    }

    public List<PluginDescriptor> getPluginDescriptors() {
        return pluginCache.pluginDescriptors();
    }

    public ConfigService getConfigService() {
        return configService;
    }

    public List<File> getPluginJars() {
        return pluginCache.pluginJars();
    }
}
