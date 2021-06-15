export interface C4ApiCapacitorPlugin {
    echo(options: {
        value: string;
    }): Promise<{
        value: string;
    }>;
    /**
    * Gets RFID UHF reader firmware.
    *
    * @since 1.0.0
    */
    getFirmware(): Promise<{
        firmware: number[];
    }>;
    /**
    * Starts RFID UHF inventory.
    *
    * @since 1.0.0
    */
    startInventory(options: {
        value: string;
    }): Promise<{
        uhfData: string[];
    }>;
    /**
    * Stops RFID UHF inventory.
    *
    * @since 1.0.0
    */
    stopInventory(): Promise<boolean>;
    /**
    * Sets RFID UHF output power.
    *
    * @since 1.0.0
    */
    setOutputPower(options: {
        value: number;
    }): Promise<number>;
    /**
    * Starts scanning barcode with 1D Scanner.
    *
    * @since 1.0.0
    */
    scanBarcode(): Promise<{
        barcodeData: string;
    }>;
}
