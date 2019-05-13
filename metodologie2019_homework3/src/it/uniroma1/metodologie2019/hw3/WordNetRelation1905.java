package it.uniroma1.metodologie2019.hw3;

/**
 * Costanti enumerative relative ai tipi di WordNetRelation.
 * Aggiornato al 05/2019.
 * @author josef
 *
 */
public enum WordNetRelation1905 implements WordNetRelation
{
	/**
	 *  NOUNS
	 * !    Antonym 
     * @    Hypernym 
	 * @i    Instance Hypernym 
	 * ~    Hyponym 
	 * ~i    Instance Hyponym 
	 * #m    Member holonym 
	 * #s    Substance holonym 
	 * #p    Part holonym 
	 * %m    Member meronym 
	 * %s    Substance meronym 
	 * %p    Part meronym 
	 * =    Attribute 
	 * +    Derivationally related form         
	 * ;c    Domain of synset - TOPIC 
	 * -c    Member of this domain - TOPIC 
	 * ;r    Domain of synset - REGION 
	 * -r    Member of this domain - REGION 
	 * ;u    Domain of synset - USAGE 
	 * -u    Member of this domain - USAGE 
	 *
	 *	VERBS
	 *  !    Antonym 
	 *  @    Hypernym 
	 *  ~    Hyponym 
	 *  *    Entailment 
	 *  >    Cause 
	 *  ^    Also see 
	 *  $    Verb Group 
	 *  +    Derivationally related form         
	 *  ;c    Domain of synset - TOPIC 
	 *  ;r    Domain of synset - REGION 
	 *  ;u    Domain of synset - USAGE 
	 *
	 *	ADJECTIVES
	 *  !    Antonym 
	 *  &    Similar to 
	 *  <    Participle of verb 
	 *  \    Pertainym (pertains to noun) 
	 *  =    Attribute 
	 *  ^    Also see 
	 *  ;c    Domain of synset - TOPIC 
	 *  ;r    Domain of synset - REGION 
	 *  ;u    Domain of synset - USAGE 
	
	 *	ADVERBS
	 *  !    Antonym 
	 *  \    Derived from adjective 
	 *  ;c    Domain of synset - TOPIC 
	 *  ;r    Domain of synset - REGION 
	 *  ;u    Domain of synset - USAGE 
	 */
	ANTONYM,
	HYPERNYM, 
	I_HYPERNYM, 
	HYPONYM,
	I_HYPONYM,
	M_HOLONYM,
	S_HOLONYM, 
	P_HOLONY, 
	M_MERONYM, 
	S_MERONYM,
	P_MERONYM,
	ATTRIBUTE,
	D_R_FORM,
	DOS_TOPIC, 
	MOD_TOPIC, 
	DOS_REGION, 
	MOD_REGION, 
	DOS_USAGE, 
	MOD_USAGE, 
	ENTAILMENT,
	CAUSE,
	ALSO_SEE,
	VERB_GROUP, 
	SIMILAR_TO, 
	PARTICIPLE_OF_VERB,
	PERTAINYM;

}
