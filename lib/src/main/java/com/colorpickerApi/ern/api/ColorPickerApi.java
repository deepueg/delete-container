/*
* Copyright 2017 WalmartLabs
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
* http://www.apache.org/licenses/LICENSE-2.0
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.colorpickerApi.ern.api;

import android.support.annotation.NonNull;

import com.walmartlabs.electrode.reactnative.bridge.ElectrodeBridgeEventListener;
import com.walmartlabs.electrode.reactnative.bridge.ElectrodeBridgeEvent;
import com.walmartlabs.electrode.reactnative.bridge.ElectrodeBridgeRequestHandler;
import com.walmartlabs.electrode.reactnative.bridge.ElectrodeBridgeResponseListener;
import com.walmartlabs.electrode.reactnative.bridge.None;
import java.util.*;
import java.util.UUID;


public final class ColorPickerApi {
    private static final Requests REQUESTS;
    private static final Events EVENTS;

    static {
        REQUESTS = new ColorPickerRequests();
        EVENTS = new ColorPickerEvents();
    }

    private ColorPickerApi() {
    }

    @NonNull
    public static Requests requests() {
        return REQUESTS;
    }

    @NonNull
    public static Events events() {
        return EVENTS;
    }

    public interface Events {
        String EVENT_COLOR_SELECTED = "com.colorpickerApi.ern.api.event.colorSelected";

        UUID addColorSelectedEventListener(@NonNull final ElectrodeBridgeEventListener<String> eventListener);

            ElectrodeBridgeEventListener<ElectrodeBridgeEvent> removeColorSelectedEventListener(@NonNull final UUID uuid);

        void emitColorSelected(@NonNull String selectedColor);

    }

    public interface Requests {
        String REQUEST_GET_SELECTED_COLOR = "com.colorpickerApi.ern.api.request.getSelectedColor";


        void registerGetSelectedColorRequestHandler(@NonNull final ElectrodeBridgeRequestHandler<None, String> handler);

        void getSelectedColor(@NonNull final ElectrodeBridgeResponseListener<String> responseListener);

    }
}