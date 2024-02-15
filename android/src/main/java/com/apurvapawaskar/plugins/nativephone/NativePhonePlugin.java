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

import java.util.Objects;

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

    private String PHONE_NUMBER = "phone_number";
    private String COUNTRY_CODE = "country_code";

    private NativePhone implementation = new NativePhone();

    @PluginMethod
    public void makeACall(PluginCall call) {
        if(getPermissionState("phone") != PermissionState.GRANTED){
            requestPermissionForAlias("phone", call, "phonePermsCallback");
        }
        else {
            String phone_number = call.getString(PHONE_NUMBER);
            String country_code = call.getString(COUNTRY_CODE);

            if (!call.getData().has(PHONE_NUMBER)) {
                call.reject("Must provide a phone number");
                return;
            }

            if (country_code != null && country_code.trim().equals("")) {
                call.reject("Provide a valid country code");
                return;
            }

            if (phone_number != null) {
                if(country_code!= null && country_code.equals("+91")){
                    if (phone_number.length() != 10) {
                        call.reject("Provide a valid phone number");
                        return;
                    }
                }
            }
            else {
                call.reject("Provide a valid phone number");
                return;
            }

            Intent phone_intent = new Intent(Intent.ACTION_CALL);

            String pno = "";

            if(country_code != null){
                pno += country_code;
            }

            pno += phone_number;

            // Set data of Intent through Uri by parsing phone number
            phone_intent.setData(Uri.parse("tel:" + pno));

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
            call.reject("Permission is required to place a call");
        }
    }
}
