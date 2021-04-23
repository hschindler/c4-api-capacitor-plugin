import { WebPlugin } from '@capacitor/core';
export class C4ApiCapacitorPluginWeb extends WebPlugin {
    async echo(options) {
        console.log('ECHO', options);
        return options;
    }
    async getFirmware() {
        // logic here
        this.throwUnimplementedError();
    }
    async startInventory() {
        // logic here
        this.throwUnimplementedError();
    }
    async stopInventory() {
        // logic here
        this.throwUnimplementedError();
    }
    async setOutputPower() {
        // logic here
        this.throwUnimplementedError();
    }
    async scanBarcode() {
        // logic here
        this.throwUnimplementedError();
    }
    throwUnimplementedError() {
        throw this.unimplemented('Not implemented on web.');
    }
}
//# sourceMappingURL=web.js.map