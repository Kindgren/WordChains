
class LongestChain {

	private Queue q; // queue used in the BFS
	private String goalWord; // goal word of the BFS
	private int wordLength;
	private final char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
			'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	private int alphabetLength = alphabet.length;

	public LongestChain(int wordLength) {
		this.wordLength = wordLength;
		q = new Queue();
	}


	private boolean isGoal(String w) {
		return w.equals(goalWord);
	}


	private WordRec makeChildren(WordRec x) {

		char[] ogWord = x.getWord().toCharArray();
		for (int i = 0; i < wordLength; i++) {
			char[] tmp = x.getWord().toCharArray();
			for (int c = 0; c < alphabetLength; c++) {
				if (alphabet[c] != ogWord[i]) {
					tmp[i] = alphabet[c];
					String res = new String(tmp);
					res = WordList.contains(res);

					if (res != null && WordList.markAsUsedIfUnused(res)) {
						WordRec wr = new WordRec(res, x);
						if (isGoal(res)) {
							return wr;
						}

						q.enqueue(wr);
					}
				}
			}
		}

		return null;
	}


	public WordRec breadthFirst(String startWord, String endWord) {

		WordList.eraseUsed();
		WordRec start = new WordRec(startWord, null);
		WordList.markAsUsedIfUnused(startWord);
		goalWord = endWord;
		q.empty();
		q.enqueue(start);

		try {
			while (true) {
				WordRec tmp = (WordRec) q.dequeue();
				WordRec wr = makeChildren(tmp);
				if (wr != null) {
					return wr;
				} else if (q.isEmpty() && goalWord == null) {
					return tmp;

				}

			}

		} catch (Exception e) {
			return null;
		}

	}

	public void checkAllStartWords(String endWord) {

		WordRec x = breadthFirst(endWord, null);

		int len = 0;

		if (x != null) {
			len = x.chainLength();

			System.out.println(endWord + ": " + len + " ord");

			x.reversePrint();

			if (q.isEmpty()) {
				return;
			}

		}

	}

}
