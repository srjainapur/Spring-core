package com.spring.constr.di;

public class TextEditor {
	private SpellChecker spellChecker;
	
	public TextEditor(SpellChecker spellchecker) {
		this.spellChecker = spellchecker;
	}
	
	public void checkSpell() {
		spellChecker.checkSpelling();
	}
}
