package de.schindlergmbh.plugins.capacitor.c4api;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;


// import com.handheld.Barcode1D.Barcode1DManager;
// import com.handheld.UHF.UhfManager;

// import cn.pda.serialport.SerialPort;
// import cn.pda.serialport.Tools;

import android.util.Log;

@CapacitorPlugin(name = "C4ApiCapacitorPlugin")
public class C4ApiCapacitorPlugin extends Plugin {

    private static final String TAG = C4ApiCapacitorPlugin.class.getName();


    // private UhfManager _uhfManager;
    // private Barcode1DManager _barcodeManager;

    private boolean _barcodeInitFlag = false;
    private boolean _initRuns = false;

    private ArrayList<String> _listepc = new ArrayList<String>();
    private ArrayList<String> _listTID = new ArrayList<String>();
    private ArrayList<EPC> _listEPCObject;

    private boolean startFlag = false;

    private String _errorLog;

    private int _uhfPort = 13;

    private int _barcodePort = 0;
    // private int _barcodePower = SerialPort.Power_Scaner;
    private int _barcodeBaudrate = 9600;

    private int _outputPower = 0;

    private Thread _scanThread;



    public String echo(String value) {
        return value;
    }

    @PluginMethod()
    public void getFirmware(PluginCall call) {
       
        Log.d(TAG, "getFirmware");

        final byte[] firmwareVersion = {1,2,3,4};

        // this.initializeUHFManager();

        // if (_uhfManager == null) {
        //     call.reject("UHF API not installed");
        //     return;
        // }

        // final byte[] firmwareVersion = _uhfManager.getFirmware();

        // this.disposeUHFManager();

        JSObject ret = new JSObject();
        ret.put("value", firmwareVersion);
        call.resolve(ret);
    }

    @PluginMethod()
    public void startInventory(PluginCall call) {
       
        Log.d(TAG, "startInventory");

        Boolean result = true;
        
        _listEPCObject = new ArrayList<EPC>();

        this.StartInventoryThread();

        

        saveCall(call);

        JSObject ret = new JSObject();
        ret.put("value", result);
        call.resolve(ret);
    }

    @PluginMethod()
    public void stopInventory(PluginCall call) {
       
        Boolean result = true;

        JSObject ret = new JSObject();
        ret.put("value", result);
        call.resolve(ret);
    }


    @PluginMethod()
    public void setOutputPower(PluginCall call) {

        Boolean result = true;       

        JSObject ret = new JSObject();
        ret.put("value", result);
        call.resolve(ret);
    }


    @PluginMethod()
    public void scanBarcode(PluginCall call) {
       
        Boolean result = true;

        JSObject ret = new JSObject();
        ret.put("value", result);
        call.resolve(ret);
    }




    private void initializeUHFManager() {

        Log.d(TAG, "initializeUHFManager C4ApiCordovaPlugin");

        // if (this._uhfManager == null) {
        //     UhfManager.Port = _uhfPort;
        //     UhfManager.BaudRate = 115200;
        //     UhfManager.Power = SerialPort.Power_Rfid;

        //     try {
        //         this._uhfManager = UhfManager.getInstance();

        //         if (this._outputPower > 0) {
        //             boolean result = _uhfManager.setOutputPower(this._outputPower);
        //         }

        //     } catch (Exception e) {
        //         _errorLog = e.getMessage();
        //         e.printStackTrace();
        //         // Log.d(TAG, "Error: " + e.getMessage());
        //     }
        // }
    }

    private void closeBarcodeManager() {
        // if (_barcodeManager != null) {
        //     Log.d(TAG, "closeBarcodeManager");

        //     try {
        //         _barcodeManager.Close();
        //     } catch (Exception e) {
        //         _errorLog = e.getMessage();
        //     }

        // }
    }

    private void disposeUHFManager() {

        // if (this._uhfManager != null) {
        //     Log.d(TAG, "disposeUHFManager");

        //     try {
        //         this._uhfManager.close();
        //     } catch (Exception e) {
        //         _errorLog = e.getMessage();
        //     }

        //     this._uhfManager = null;
        // }
    }

    private void StartInventoryThread() {

        Log.d(TAG, "StartInventoryThread");

        // // start inventory thread
        // startFlag = true;

        // if (this._scanThread == null || this._scanThread.getState() == Thread.State.TERMINATED) {
        //     Log.d(TAG, "StartInventoryThread - create new thread");
        //     this._scanThread = new InventoryThread();
        // }

        // Log.d(TAG, "StartInventoryThread - start thread");

        // if (this._scanThread.getState() == Thread.State.NEW) {
        //     this._scanThread.start();
        // }

    }

    private void StopInventoryThread() {
        // runFlag = false;
        startFlag = false;
    }

    private void PauseInventoryThread() {
        startFlag = false;
    }

    private JSONArray ConvertArrayList(ArrayList<String> list) {
        org.json.JSONArray jsonArray = new org.json.JSONArray();
        for (String value : list) {
            jsonArray.put(value);
        }

        return jsonArray;
    }

      // add TIDs to view
    private void returnCurrentTIDs(final ArrayList<String> tidList, PluginCall call) {
        if (call != null) {
            if (tidList != null || tidList.isEmpty() == false) {
                JSObject ret = new JSObject();
                ret.put("value", ConvertArrayList(tidList));
                call.resolve(ret);

                // PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, ConvertArrayList(tidList));
                // pluginResult.setKeepCallback(true);
                // _uhfCallBackContext.sendPluginResult(pluginResult);
            }

        }
    }


     /**
     * Inventory Thread
     */
    class InventoryThread extends Thread {
        private List<byte[]> epcList;
        private ArrayList<String> tidList;

        @Override
        public void run() {
            super.run();

            Log.d(TAG, "InventoryThread starting...");

            // PluginCall savedCall = getSavedCall();
            // if (savedCall == null) {
            //     Log.d("Test", "No stored plugin call for startInventory request result");
            //     return;
            // }

            // initializeUHFManager();

            // if (_uhfManager == null) {
            //     Log.d(TAG, "InventoryThread failed creating uhfManager");
            //     savedCall.reject("InventoryThread failed creating uhfManager");
            //     return;
            // }

            // Log.d(TAG, "InventoryThread startflag = " + String.valueOf(startFlag));

            // while (startFlag) {

            //     Log.d(TAG, "Waiting for timeout..");

            //     if (_uhfManager != null) {

            //         epcList = _uhfManager.inventoryRealTime(); // inventory real time

            //         if (epcList != null && !epcList.isEmpty()) {
            //             // play sound
            //             // Util.play(1, 0);
            //             tidList = new ArrayList<>();

            //             for (byte[] epc : epcList) {

            //                 if (SelectEPC(epc, savedCall)) {
            //                     byte[] tid = GetTID(savedCall);

            //                     if (tid != null) {
            //                         String tidStr = Tools.Bytes2HexString(tid, tid.length);
            //                         tidList.add(tidStr);
            //                     }
            //                 }
            //             }

            //             if (!tidList.isEmpty()) {
            //                     returnCurrentTIDs(tidList, savedCall);
            //                     startFlag = false;
            //             }

            //         }

            //     } else {
            //         // returnCurrentTIDs(null);
            //         savedCall.reject("UHFManager is not initialized!");
            //     }

            //     epcList = null;

            //     try {
            //         Thread.sleep(40);
            //     } catch (InterruptedException e) {
            //         // Thread.currentThread().interrupt();
            //         e.printStackTrace();
            //         // return;
            //     }

            //     // }
            // } // while

            // Log.d(TAG, "InventoryThread is closing...");

            // disposeUHFManager();


        } // run

        private boolean SelectEPC(byte[] epc, PluginCall call) {
            // try {
            //     if (_uhfManager != null) {
            //         _uhfManager.selectEPC(epc);
            //     }
            // } catch (Exception ex) {
            //     if (call != null) {
            //         call.reject("Fehler-SelectEPC: " + ex.getMessage());
            //     }

            //     return false;
            // }

             return true;
        }

        // first select tag by epc
        private byte[] GetTID(PluginCall call) {
            // // Parameters: int memBank store RESEVER zone 0, EPC District 1, TID District 2,
            // // USER District 3;
            // // int startAddr starting address (not too large, depending on the size of the
            // // data area);
            // // int length read data length, in units of word (1word = 2bytes); byte []
            // // accessPassword password 4 bytes
            // int tidLength = 6; // in word 1 word = 2 byte
            // // byte[] tid; // = new byte[tidLength*2];

            // if (_uhfManager == null) {
            //     return null;
            // }

            // Log.d(TAG, "GetTID");

            // try {
            //     byte[] pw = new byte[4];
            //     byte[] tid = _uhfManager.readFrom6C(2, 0, tidLength, pw);

            //     if (tid != null && tid.length > 1) {

            //         Log.d(TAG, "GetTID - " + tid);
            //         return tid;

            //     } else {
            //         if (tid != null) {
            //             // tid has error code

            //             // try again with small tid (8 byte)
            //             tidLength = 4;
            //             tid = _uhfManager.readFrom6C(2, 0, tidLength, pw);

            //             if (tid != null && tid.length > 1) {
            //                 return tid;
            //             } else {
            //                 // tid has error code
            //                 call.reject("Fehler-GetTID tid error code: " + Tools.Bytes2HexString(tid, tid.length));

            //                 return null;
            //             }
            //         }
            //         return null;
            //     }

            // } catch (Exception ex) {

            //     call.reject("Fehler-GetTID: " + ex.getMessage());

            // }

            return null;
        }
    } // end inventory thread class
}
