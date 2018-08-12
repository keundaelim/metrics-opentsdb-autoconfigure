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

import org.springframework.boot.actuate.autoconfigure.metrics.export.properties.StepRegistryProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * {@link ConfigurationProperties} for configuring OpenTSDB metrics export.
 *
 * @author Jon Schneider
 * @author Stephane Nicoll
 */
@ConfigurationProperties(prefix = "management.metrics.export.opentsdb")
public class OpenTsdbProperties extends StepRegistryProperties {

    /**
     * Login user of the OpenTSDB server.
     */
    private String userName;

    /**
     * Login password of the OpenTSDB server.
     */
    private String password;

    /**
     * URI of the OpenTSDB server.
     */
    private String uri = "http://localhost:8086";

    /**
     * Whether to enable GZIP compression of metrics batches published to OpenTSDB.
     */
    private boolean compressed = true;

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getUri() {
        return this.uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public boolean isCompressed() {
        return this.compressed;
    }

    public void setCompressed(boolean compressed) {
        this.compressed = compressed;
    }
}
