package piglatin

import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Title
import spock.lang.Unroll

@Title('English to Pig Latin translator')
@Narrative('''
Pig Latin is a made-up children's language that's intended to be confusing. 
It obeys a few simple rules, but when it's spoken quickly it's really 
difficult for non-children (and non-native speakers) to understand.
''')
@SuppressWarnings('SpellCheckingInspection')
class PigLatinTest extends Specification {

    @Unroll('should translate "#phrase" where #description')
    def 'should translate from English to Pig Latin'() {
        given:
        @Subject def translator = new PigLatin()

        expect:
        translator.translate(phrase) == translated

        where:
        phrase           | translated             | description
        'apple'          | 'appleay'              | 'ay is added to words that start with vowels'
        'ear'            | 'earay'                | 'ay is added to words that start with vowels'
        'igloo'          | 'iglooay'              | 'ay is added to words that start with vowels'
        'object'         | 'objectay'             | 'ay is added to words that start with vowels'
        'under'          | 'underay'              | 'ay is added to words that start with vowels'
        'equal'          | 'equalay'              | 'ay is added to words that start with vowels followed by qu'
        'pig'            | 'igpay'                | 'first letter and ay are moved to the end of words that start with consonants'
        'koala'          | 'oalakay'              | 'first letter and ay are moved to the end of words that start with consonants'
        'xenon'          | 'enonxay'              | 'first letter and ay are moved to the end of words that start with consonants'
        'qat'            | 'atqay'                | 'first letter and ay are moved to the end of words that start with consonants'
        'chair'          | 'airchay'              | 'ch is treated like a single consonant'
        'queen'          | 'eenquay'              | 'qu is treated like a single consonant'
        'square'         | 'aresquay'             | 'qu and a single preceding consonant are treated like a single consonant'
        'therapy'        | 'erapythay'            | 'th is treated like a single consonant'
        'thrush'         | 'ushthray'             | 'thr is treated like a single consonant'
        'school'         | 'oolschay'             | 'sch is treated like a single consonant'
        'yttria'         | 'yttriaay'             | 'yt is treated like a single vowel'
        'xray'           | 'xrayay'               | 'xr is treated like a single vowel'
        'yellow'         | 'ellowyay'             | 'y is treated like a consonant at the beginning of a word'
        'rhythm'         | 'ythmrhay'             | 'y is treated like a vowel at the end of a consonant cluster'
        'my'             | 'ymay'                 | 'y as second letter in two letter word'
        'quick fast run' | 'ickquay astfay unray' | 'phrases are translated'
    }
}
