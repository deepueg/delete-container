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

import com.walmartlabs.electrode.reactnative.bridge.ElectrodeBridgeHolder;
import com.walmartlabs.electrode.reactnative.bridge.ElectrodeBridgeRequestHandler;
import com.walmartlabs.electrode.reactnative.bridge.ElectrodeBridgeResponseListener;
import com.walmartlabs.electrode.reactnative.bridge.None;
import com.walmartlabs.electrode.reactnative.bridge.RequestHandlerProcessor;
import com.walmartlabs.electrode.reactnative.bridge.RequestProcessor;
import java.util.*;


final class ColorPickerRequests implements ColorPickerApi.Requests {
    ColorPickerRequests() {}


    @Override
    public void registerGetSelectedColorRequestHandler(@NonNull final ElectrodeBridgeRequestHandler<None, String> handler) {
        new RequestHandlerProcessor<>(REQUEST_GET_SELECTED_COLOR, None.class, String.class, handler).execute();
    }

    //------------------------------------------------------------------------------------------------------------------------------------

    @Override
    public void getSelectedColor(@NonNull final ElectrodeBridgeResponseListener<String> responseListener) {
        new RequestProcessor<>(REQUEST_GET_SELECTED_COLOR, null, String.class, responseListener).execute();
    }
}