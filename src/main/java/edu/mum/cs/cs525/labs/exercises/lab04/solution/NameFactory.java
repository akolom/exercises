package edu.mum.cs.cs525.labs.exercises.lab04.solution;

class NameFactory {
	public Namer getNamer(String entry) {
		int i = entry.indexOf(",");
		if (i > 0)
			return new LastFirst(entry);
		else
			return new FirstLast(entry);
	}
}