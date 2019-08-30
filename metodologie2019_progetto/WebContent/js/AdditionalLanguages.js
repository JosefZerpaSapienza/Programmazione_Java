/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var fabbricaSemantica;
(function (fabbricaSemantica) {
    var AdditionalLanguages;
    (function (AdditionalLanguages) {
        AdditionalLanguages[AdditionalLanguages["ENGLISH"] = 0] = "ENGLISH";
        AdditionalLanguages[AdditionalLanguages["ITALIAN"] = 1] = "ITALIAN";
    })(AdditionalLanguages = fabbricaSemantica.AdditionalLanguages || (fabbricaSemantica.AdditionalLanguages = {}));
    /** @ignore */
    class AdditionalLanguages_$WRAPPER {
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
    fabbricaSemantica.AdditionalLanguages_$WRAPPER = AdditionalLanguages_$WRAPPER;
    AdditionalLanguages["__class"] = "fabbricaSemantica.AdditionalLanguages";
    AdditionalLanguages["__interfaces"] = ["java.lang.Comparable", "java.io.Serializable"];
    AdditionalLanguages["_$wrappers"] = [new AdditionalLanguages_$WRAPPER(0, "ENGLISH", "englishAdditional", "English"), new AdditionalLanguages_$WRAPPER(1, "ITALIAN", "italianAdditional", "Italian")];
})(fabbricaSemantica || (fabbricaSemantica = {}));
