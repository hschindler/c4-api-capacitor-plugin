'use strict';

Object.defineProperty(exports, '__esModule', { value: true });

var core = require('@capacitor/core');

const C4ApiCapacitor = core.registerPlugin('C4ApiCapacitorPlugin', {
    web: () => Promise.resolve().then(function () { return web; }).then(m => new m.C4ApiCapacitorPluginWeb()),
});

class C4ApiCapacitorPluginWeb extends core.WebPlugin {
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

var web = /*#__PURE__*/Object.freeze({
    __proto__: null,
    C4ApiCapacitorPluginWeb: C4ApiCapacitorPluginWeb
});

exports.C4ApiCapacitor = C4ApiCapacitor;
//# sourceMappingURL=plugin.cjs.js.map
