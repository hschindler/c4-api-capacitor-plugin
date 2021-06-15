import { WebPlugin } from '@capacitor/core';
import type { C4ApiCapacitorPlugin } from './definitions';
export declare class C4ApiCapacitorPluginWeb extends WebPlugin implements C4ApiCapacitorPlugin {
    echo(options: {
        value: string;
    }): Promise<{
        value: string;
    }>;
    getFirmware(): Promise<{
        firmware: number[];
    }>;
    startInventory(): Promise<{
        uhfData: string[];
    }>;
    stopInventory(): Promise<boolean>;
    setOutputPower(): Promise<number>;
    scanBarcode(): Promise<{
        barcodeData: string;
    }>;
    private throwUnimplementedError;
}
