/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var fabbricaSemantica;
(function (fabbricaSemantica) {
    var MotherTongues;
    (function (MotherTongues) {
        MotherTongues[MotherTongues["ENGLISH"] = 0] = "ENGLISH";
        MotherTongues[MotherTongues["ITALIAN"] = 1] = "ITALIAN";
    })(MotherTongues = fabbricaSemantica.MotherTongues || (fabbricaSemantica.MotherTongues = {}));
    /** @ignore */
    class MotherTongues_$WRAPPER {
        constructor(_$ordinal, _$name, name, string) {
            this._$ordinal = _$ordinal;
            this._$name = _$name;
            if (this.__name === undefined)
                this.__name = null;
            if (this.string === undefined)
                this.string = null;
            this.__name = name;
            this.string = string;
        }
        getName() {
            return this.__name;
        }
        getString() {
            return this.string;
        }
        name() { return this._$name; }
        ordinal() { return this._$ordinal; }
    }
    fabbricaSemantica.MotherTongues_$WRAPPER = MotherTongues_$WRAPPER;
    MotherTongues["__class"] = "fabbricaSemantica.MotherTongues";
    MotherTongues["__interfaces"] = ["java.lang.Comparable", "java.io.Serializable"];
    MotherTongues["_$wrappers"] = [new MotherTongues_$WRAPPER(0, "ENGLISH", "englishMother", "English"), new MotherTongues_$WRAPPER(1, "ITALIAN", "italianMother", "Italian")];
})(fabbricaSemantica || (fabbricaSemantica = {}));
