/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var fabbricaSemantica;
(function (fabbricaSemantica) {
    /**
     * Enumeration of languages available as "mother tongues".
     * @author josef
     * @enum
     * @property {fabbricaSemantica.MotherTongue} ENGLISH
     * @property {fabbricaSemantica.MotherTongue} ITALIAN
     * @class
     */
    var MotherTongue;
    (function (MotherTongue) {
        MotherTongue[MotherTongue["ENGLISH"] = 0] = "ENGLISH";
        MotherTongue[MotherTongue["ITALIAN"] = 1] = "ITALIAN";
    })(MotherTongue = fabbricaSemantica.MotherTongue || (fabbricaSemantica.MotherTongue = {}));
    /** @ignore */
    class MotherTongue_$WRAPPER {
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
        /**
         * Return the assigned name.
         * @return
         * @return {string}
         */
        getName() {
            return this.__name;
        }
        /**
         * Return the String representation of the language.
         * @return
         * @return {string}
         */
        getString() {
            return this.string;
        }
        name() { return this._$name; }
        ordinal() { return this._$ordinal; }
    }
    fabbricaSemantica.MotherTongue_$WRAPPER = MotherTongue_$WRAPPER;
    MotherTongue["__class"] = "fabbricaSemantica.MotherTongue";
    MotherTongue["__interfaces"] = ["java.lang.Comparable", "java.io.Serializable"];
    MotherTongue["_$wrappers"] = [new MotherTongue_$WRAPPER(0, "ENGLISH", "englishMother", "English"), new MotherTongue_$WRAPPER(1, "ITALIAN", "italianMother", "Italian")];
})(fabbricaSemantica || (fabbricaSemantica = {}));
