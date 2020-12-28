package com.wyu.pojo;

public class BookAll extends Book {
	private ClassificationBook ClassificationBook;
	private Publishhouse Publishhouse;
	private StatusBook StatusBook;
	private TypebookCf TypebookCf;
	private TypecirculationBook TypecirculationBook;
	public ClassificationBook getClassificationBook() {
		return ClassificationBook;
	}
	public void setClassificationBook(ClassificationBook classificationBook) {
		ClassificationBook = classificationBook;
	}
	public Publishhouse getPublishhouse() {
		return Publishhouse;
	}
	public void setPublishhouse(Publishhouse publishhouse) {
		Publishhouse = publishhouse;
	}
	public StatusBook getStatusBook() {
		return StatusBook;
	}
	public void setStatusBook(StatusBook statusBook) {
		StatusBook = statusBook;
	}
	public TypebookCf getTypebookCf() {
		return TypebookCf;
	}
	public void setTypebookCf(TypebookCf typebookCf) {
		TypebookCf = typebookCf;
	}
	public TypecirculationBook getTypecirculationBook() {
		return TypecirculationBook;
	}
	public void setTypecirculationBook(TypecirculationBook typecirculationBook) {
		TypecirculationBook = typecirculationBook;
	}
	@Override
	public String toString() {
		return "BookAll [ClassificationBook=" + ClassificationBook + ", Publishhouse=" + Publishhouse + ", StatusBook="
				+ StatusBook + ", TypebookCf=" + TypebookCf + ", TypecirculationBook=" + TypecirculationBook + "]";
	}
	
}

