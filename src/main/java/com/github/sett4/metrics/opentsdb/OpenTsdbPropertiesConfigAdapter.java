/*
 * Copyright 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.sett4.metrics.opentsdb;


import org.springframework.boot.actuate.autoconfigure.metrics.export.properties.StepRegistryPropertiesConfigAdapter;

import io.micrometer.opentsdb.OpenTsdbConfig;

/**
 * Adapter to convert {@link OpenTsdbProperties} to an {@link OpenTsdbConfig}.
 *
 * @author Jon Schneider
 * @author Phillip Webb
 */
class OpenTsdbPropertiesConfigAdapter extends
                                    StepRegistryPropertiesConfigAdapter<OpenTsdbProperties> implements OpenTsdbConfig {

    OpenTsdbPropertiesConfigAdapter(OpenTsdbProperties properties) {
        super(properties);
    }

    @Override
    public String userName() {
        return get(OpenTsdbProperties::getUserName, OpenTsdbConfig.super::userName);
    }

    @Override
    public String password() {
        return get(OpenTsdbProperties::getPassword, OpenTsdbConfig.super::password);
    }

    @Override
    public String uri() {
        return get(OpenTsdbProperties::getUri, OpenTsdbConfig.super::uri);
    }

    @Override
    public boolean compressed() {
        return get(OpenTsdbProperties::isCompressed, OpenTsdbConfig.super::compressed);
    }
}
