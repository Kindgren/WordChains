

class WordRec {
	private String word;
	private WordRec parent;

	public WordRec(String word_, WordRec parent_) {
		word = word_;
		parent = parent_;
	}

	
	public int chainLength() {
		int i = 0;
		for (WordRec x = this; x != null; x = x.parent) {
			i++;
		}
		return i;
	}

	private void printChainHelp() {
		if (parent != null) {
			parent.printChainHelp();
		}
		printWord();
		System.out.print(" -> ");
	}

	
	public void printChain() {
		if (parent != null) {
			parent.printChainHelp();
		}
		printWord();
		System.out.println();
	}


	public void printWord() {
		System.out.print(word);
	}


	public String getWord() {
		return word;
	}

	
	public WordRec getParent() {
		return parent;
	}

	public void reversePrint() {
		if (parent != null) {
			printWord();
			System.out.print(" -> ");
			parent.reversePrint();
		} else {
			printWord();
			System.out.println();
		}
	}

}
