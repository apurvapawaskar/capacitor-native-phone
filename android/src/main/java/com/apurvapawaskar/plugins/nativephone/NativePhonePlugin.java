package com.apurvapawaskar.plugins.nativephone;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;

import com.getcapacitor.JSObject;
import com.getcapacitor.PermissionState;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.annotation.Permission;
import com.getcapacitor.annotation.PermissionCallback;

@CapacitorPlugin(
    name = "NativePhone",
    permissions = {
        @Permission(
            alias = "phone",
            strings = { Manifest.permission.CALL_PHONE }
        )
    }
)
public class NativePhonePlugin extends Plugin {

    private NativePhone implementation = new NativePhone();

    @PluginMethod
    public void makeACall(PluginCall call) {
        if(getPermissionState("phone") != PermissionState.GRANTED){
            requestPermissionForAlias("phone", call, "phonePermsCallback");
        } else {
            String phone_number = call.getString("phone_number");

            if (!call.getData().has("phone_number")) {
                call.reject("Must provide a phone number");
                return;
            }

            if (phone_number.contains("+91")) {
                String pno = phone_number.strip().substring(3);
                if (pno.length() < 10) {
                    call.reject("Provide a valid phone number");
                    return;
                }
            } else {
                call.reject("Provide a valild phone number");
                return;
            }

            Intent phone_intent = new Intent(Intent.ACTION_CALL);

            // Set data of Intent through Uri by parsing phone number
            phone_intent.setData(Uri.parse("tel:" + phone_number));

            // start Intent
            getActivity().startActivity(phone_intent);

            call.resolve();
        }
    }

    @PermissionCallback
    private void phonePermsCallback(PluginCall call) {
        if(getPermissionState("phone") == PermissionState.GRANTED){
            makeACall(call);
        }else {
            call.reject("Permission is required to take a picture");
        }
    }
}
