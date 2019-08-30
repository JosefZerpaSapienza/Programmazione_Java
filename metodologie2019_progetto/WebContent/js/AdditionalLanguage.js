/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var fabbricaSemantica;
(function (fabbricaSemantica) {
    /**
     * Enumeration of languages available as "additional languages".
     * @author josef
     * @enum
     * @property {fabbricaSemantica.AdditionalLanguage} ENGLISH
     * @property {fabbricaSemantica.AdditionalLanguage} ITALIAN
     * @class
     */
    var AdditionalLanguage;
    (function (AdditionalLanguage) {
        AdditionalLanguage[AdditionalLanguage["ENGLISH"] = 0] = "ENGLISH";
        AdditionalLanguage[AdditionalLanguage["ITALIAN"] = 1] = "ITALIAN";
    })(AdditionalLanguage = fabbricaSemantica.AdditionalLanguage || (fabbricaSemantica.AdditionalLanguage = {}));
    /** @ignore */
    class AdditionalLanguage_$WRAPPER {
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
    fabbricaSemantica.AdditionalLanguage_$WRAPPER = AdditionalLanguage_$WRAPPER;
    AdditionalLanguage["__class"] = "fabbricaSemantica.AdditionalLanguage";
    AdditionalLanguage["__interfaces"] = ["java.lang.Comparable", "java.io.Serializable"];
    AdditionalLanguage["_$wrappers"] = [new AdditionalLanguage_$WRAPPER(0, "ENGLISH", "englishAdditional", "English"), new AdditionalLanguage_$WRAPPER(1, "ITALIAN", "italianAdditional", "Italian")];
})(fabbricaSemantica || (fabbricaSemantica = {}));
