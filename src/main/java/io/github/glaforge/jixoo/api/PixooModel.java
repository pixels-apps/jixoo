/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.glaforge.jixoo.api;

/**
 * Divoom device models supported by the local HTTP API, with their transport endpoint.
 * <p>
 * Both models share the same command vocabulary, but differ in where the API is served
 * and in the response envelope:
 * <ul>
 *     <li>{@link #PIXOO_64}: {@code POST http://<ip>:80/post}, replies with {@code error_code}.</li>
 *     <li>{@link #PIXOO_64_II}: {@code POST http://<ip>:9000/divoom_api} (port 80 is closed),
 *     replies with {@code ReturnCode} / {@code ReturnMessage}.</li>
 * </ul>
 */
public enum PixooModel {
    /** Original Divoom Pixoo 64. */
    PIXOO_64(80, "/post"),
    /** Divoom Pixoo-64 II. */
    PIXOO_64_II(9000, "/divoom_api");

    private final int defaultPort;
    private final String apiPath;

    PixooModel(int defaultPort, String apiPath) {
        this.defaultPort = defaultPort;
        this.apiPath = apiPath;
    }

    /**
     * Gets the HTTP port the device serves its local API on.
     *
     * @return the default HTTP port
     */
    public int defaultPort() {
        return defaultPort;
    }

    /**
     * Gets the HTTP path of the local API endpoint.
     *
     * @return the API path, starting with a slash
     */
    public String apiPath() {
        return apiPath;
    }
}
