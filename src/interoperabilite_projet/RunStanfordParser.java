//package interoperabilite_projet;
//
//import java.io.BufferedReader;
//import java.io.DataInputStream;
//import java.io.FileInputStream;
//import java.io.InputStreamReader;
//import java.io.StringReader;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//import edu.stanford.nlp.ling.TaggedWord;
//import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
//import edu.stanford.nlp.process.PTBTokenizer;
//import edu.stanford.nlp.trees.GrammaticalStructure;
//import edu.stanford.nlp.trees.GrammaticalStructureFactory;
//import edu.stanford.nlp.trees.PennTreebankLanguagePack;
//import edu.stanford.nlp.trees.Tree;
//import edu.stanford.nlp.trees.TreebankLanguagePack;
//import edu.stanford.nlp.trees.WordStemmer;
//
//public class RunStanfordParser {
//	/**
//	 * 
//	 * @param args Arg1 - full path of the stanford parser input file (englishPCFG.ser.gz), Arg2 - file to parse
//	 * @throws Exception
//	 */
//	public static void main(String[] args) throws Exception {
//		// input format: data directory, and output directory
//		String parserFileOrUrl=args[0];
//		String fileToParse=args[1];
//		
//		LexicalizedParser lp = new LexicalizedParser("C:\Users\nour\workspace\interoperabilite_projet\New Microsoft Word Document.txt"); // Create new parser
//	    //lp.setOptionFlags(new String[]{"-maxLength", "80", "-retainTmpSubcategories"}); // set max sentence length if you want
//
//		// Call parser on files, and tokenize the contents
//		FileInputStream fstream = new FileInputStream(fileToParse);
//		DataInputStream in = new DataInputStream(fstream); // Get the object of DataInputStream
//	    BufferedReader br = new BufferedReader(new InputStreamReader(in));
//	    StringReader sr; // we need to re-read each line into its own reader because the tokenizer is over-complicated garbage
//	    PTBTokenizer tkzr; // tokenizer object
//	    WordStemmer ls = new WordStemmer(); // stemmer/lemmatizer object
//	    
//	    // Read File Line By Line
//	    String strLine;
//	    while ((strLine = br.readLine()) != null)   {
//	    	System.out.println ("Tokenizing and Parsing: "+strLine); // print current line to console
//	    	
//	    	// do all the standard java over-complication to use the stanford parser tokenizer
//	    	sr = new StringReader(strLine);
//	    	tkzr = PTBTokenizer.newPTBTokenizer(sr);
//	    	List toks = tkzr.tokenize();
//	    	System.out.println ("tokens: "+toks);
//	    	
//		    Tree parse = (Tree) lp.apply(toks); // finally, we actually get to parse something
//		    
//		 // Output Option 1: Printing out various data by accessing it programmatically
//	 	    
//	 	    // Get words, stemmed words and POS tags
//			ArrayList<String> words = new ArrayList();
//			ArrayList<String> stems = new ArrayList();
//			ArrayList<String> tags = new ArrayList();
//			
//			// Get words and Tags
//			for (TaggedWord tw : parse.taggedYield()){
//				words.add(tw.word());
//				tags.add(tw.tag());
//			}
//		 	
//			// Get stems
//		    ls.visitTree(parse); // apply the stemmer to the tree
//			for (TaggedWord tw : parse.taggedYield()){
//				stems.add(tw.word());
//			}
//		    
//			// Get dependency tree
//			TreebankLanguagePack tlp = new PennTreebankLanguagePack();
//	 	    GrammaticalStructureFactory gsf = tlp.grammaticalStructureFactory();
//	 	    GrammaticalStructure gs = gsf.newGrammaticalStructure(parse);
//	 	    Collection tdl = gs.typedDependenciesCollapsed();
//	 	    
//			// And print!
//		    System.out.println("words: "+words); 
//		    System.out.println("POStags: "+tags); 
//			System.out.println("stemmedWordsAndTags: "+stems); 
//			System.out.println("typedDependencies: "+tdl); 
//		 	    
//		 // Output Option 2: Printing out various data using TreePrint
//	 	    
//	 		// Various TreePrint options
//	 		//	    "penn", // constituency parse
//	 		//	    "oneline",
//	 		//	    rootLabelOnlyFormat,
//	 		//	    "words",
//	 		//	    "wordsAndTags", // unstemmed words and pos tags
//	 		//	    "dependencies", // unlabeled dependency parse
//	 		//	    "typedDependencies", // dependency parse
//	 		//	    "typedDependenciesCollapsed",
//	 		//	    "latexTree",
//	 		//	    "collocations",
//	 		//	    "semanticGraph"
//	 	    
//			// Print using TreePrint with various options
//	 	    //TreePrint tp = new TreePrint("wordsAndTags,typedDependencies");
//	 	    //tp.printTree(parse);
//			
//			System.out.println(); // separate output lines
//	    }
//
//	}
//	
//}